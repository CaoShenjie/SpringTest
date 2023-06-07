package java8.stream;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamAPI {
    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> words = Arrays.asList("Java", "Lambdas", "In", "Action");

        List<Integer> nums = Arrays.asList(1, 2, 4, 5, 2, 3, 4);

        List<Integer> numsSec = Arrays.asList(7, 8, 6);

        /*Stream<Dish> s = menu.stream();
        s.forEach(System.out::println);//和迭代器类似，流只能遍历一次
        s.forEach(System.out::println);*/

        //列出前两道荤菜
        List<Dish> meatDish = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        for (Dish dish : meatDish) {
            System.out.println(dish.getName());
        }
        //列出所有菜的蔡菜名
        List<String> dishName = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishName);
        //列出每个单词的长度
        List<Integer> wordsLength = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordsLength);
        //列出每项菜名的长度
        List<Integer> dishNameLength = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNameLength);
        //列出每项单词不同的字母
        List<String> wordsDifferentList = words.stream()
                .map(d -> d.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(wordsDifferentList);
        //列出每个数字的的平方
        List<Integer> numsSqrt = nums.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(numsSqrt);
        //两个数字列表，返回所有的数对，并找出两数之和可以被3整除的数对
        List<int[]> pairs = nums.stream()
                .flatMap(i -> numsSec.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.stream()
                .map((int[] line) -> Arrays.stream(line)
                        .boxed()//装箱操作
                        .collect(Collectors.toList()))
                .forEach(System.out::print);
        System.out.println();
        System.out.println("=====================");
        List<int[]> pairsExactDivision = nums.stream()
                .flatMap(i -> numsSec.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.stream()
                .map((int[] line) -> Arrays.stream(line)
                        .boxed()//装箱操作
                        .collect(Collectors.toList()))
                .forEach(System.out::print);
        System.out.println();
        //查找是否含有素菜 返回：boolean
        System.out.println(menu.stream()
                .anyMatch(Dish::isVegetarian));
        Optional<Dish> dishOptional = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        //存在素菜，则打印菜名 不存在则什么都不操作
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));
        //依次相加数组中的值
        int numsSum = nums.stream().reduce(0, (a, b) -> a + b);//有初始值 会返回int类型 至少存在初始值
        int sum = nums.stream().reduce(0, Integer::sum);//方法引用 计算和 简洁
        Optional<Integer> numsSumOfOptional = nums.stream().reduce((a, b) -> a + b); //无初始值 则返回optional类型 因为可能存在没有值的情况
        System.out.println(numsSum + "-------" + sum + "-----" + numsSumOfOptional);
        //找出数组中最大值 和 最小值
        Optional<Integer> numsMax = nums.stream().reduce(Integer::max);
        Optional<Integer> numsMin = nums.stream().reduce(Integer::min);
        //用map和reduce方法数一数流中有多少个菜
        int dishSum = menu.stream().map(d -> 1).reduce(0, Integer::sum);
        //数一数菜单有多少种菜
        long numsOfDish = menu.stream().collect(counting());
        //long numsOfDish = menu.stream().count();
        System.out.println(numsOfDish);
        //找出菜单中热量最高的菜
        Optional<Dish> mostCalorieDish = menu.stream()
                .collect(maxBy(Comparator.comparing(Dish::getCalories)));
        Optional<Dish> mostCalorieDish2 =
                menu.stream().collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        //求出菜单列表的总热量
        int sumCalorieOfMenu = menu.stream()
                .collect(summingInt(Dish::getCalories));
        int totalCalories = menu.stream().collect(reducing(0,
                Dish::getCalories,
                Integer::sum));
        System.out.println(sumCalorieOfMenu + "----" + totalCalories);
        //计算数值的平均数
        Double avgCalorieOfMenu = menu.stream()
                .collect(averagingInt(Dish::getCalories));
        //使用summarizingInt工厂方法返回的收集器。
        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
        //连接字符串 菜肴名称列表：
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);
        //把菜单中的菜按照类型进行分类
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
        //把热量不到400卡路里的菜划分为“低热量”（diet），热量400到700卡路里的菜划为“普通”（normal），高于700卡路里的划为“高热量”（fat）。
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return
                            CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        System.out.println(dishesByCaloricLevel);
        //上面两组结合的 两级分组
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                })
                        )
                );
        System.out.println(dishesByTypeCaloricLevel);
        //菜单中每类菜有多少个
        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType,counting()));
        System.out.println(typesCount);
        //查找菜单中热量最高的菜肴 按照菜的类型分类
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(mostCaloricByType);
        Map<Dish.Type, Dish> mostCaloricByTypeDish = menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(Comparator.comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println(mostCaloricByTypeDish);

    }
}
