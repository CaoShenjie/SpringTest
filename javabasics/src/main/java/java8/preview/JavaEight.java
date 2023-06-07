package java8.preview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class JavaEight {
    public static void main(String[] args) {

        System.out.println("----------------");
        //Lambda表达式引用的局部变量必须是最终的（final）或事实上最终的
        final int per = 11223;
        int finalPer = per;
        Runnable runnable = ()-> System.out.println(per);

        Function<String, Integer> stringToInteger =
                (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInt =
                (Integer::parseInt);

        BiPredicate<List<String>, String> contains =
                (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> cont = (List::contains);

        List<Apple> appleList = Arrays.asList(
                new Apple("yellow", 151),
                new Apple("green", 154),
                new Apple("green", 124)
        );

        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        appleList.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())); //lambda表达式语法
        appleList.sort(comparing((apple) -> apple.getWeight()));//Lambda 表达式
        appleList.sort(comparing(Apple::getWeight)); //方法引用
        appleList.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        System.out.println(appleList);
        prettyPrintApple(appleList, new ComplexApplePrint());
        prettyPrintApple(appleList, new SimpleApplePrint());
        prettyPrintApple(appleList, new AppleFormatter() {
            @Override
            public String accept(Apple apple) {
                return apple.getColor() + "----" + apple.getWeight();
            }
        });
    }

    public static void prettyPrintApple(List<Apple> appleList, AppleFormatter appleFormatter) {
        for (Apple apple : appleList) {
            String a = appleFormatter.accept(apple);
            System.out.println(a);
        }
    }
}
