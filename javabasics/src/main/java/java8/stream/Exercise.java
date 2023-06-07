package java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise {
    public static void main(String[] args) {
        /*(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        (2) 交易员都在哪些不同的城市工作过？
        (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        (5) 有没有交易员是在米兰工作的？
        (6) 打印生活在剑桥的交易员的所有交易额。
        (7) 所有交易中，最高的交易额是多少？
        (8) 找到交易额最小的交易。*/
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。------.reversed()是从高到低
        List<Transaction> transListN1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("(1):" + transListN1);
        //(2) 交易员都在哪些不同的城市工作过？-----distinct 去重 也可以toSet转换为去重集合
        List<String> traderCity = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        Set<String> traderCityOfSet = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println("(2):" + traderCity + "-----Set:" + traderCityOfSet);
        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。----注意去重
        List<Trader> traderCityOfCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)//原：.map(t -> t.getTrader())
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("(3):" + traderCityOfCambridge);
        //(4) 返回所有交易员的姓名字符串，按字母顺序排序。
        String traderName = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println("(4):" + traderName);
        //(5) 有没有交易员是在米兰工作的？---问题在于存在与否 用boolean返回即可 用anymatch查找
        /*List<Trader> tradersOfMilan = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Milan"))
                .map(Transaction::getTrader)
                .distinct()
                .collect(Collectors.toList());*/
        Boolean tradersOfMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("(5):" + tradersOfMilan);
        //(6) 打印生活在剑桥的交易员的所有交易额。----题目要求直接打印 不需要转换
        List<Integer> valueOfCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        System.out.println("(6):" + valueOfCambridge);
        /*transactions.stream()                     //此处注释掉正确的是为了 方便展示
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);*/
        //(7) 所有交易中，最高的交易额是多少？
        Integer valueOfMax = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println("(7):" + valueOfMax);
        // (8) 找到交易额最小的交易、
        //第一种方法 先排序 然后找出第一个
        Optional<Transaction> transactionsOfValueForMin1 = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst();
        //第二种方法 流支持min和max 方法 直接调用
        Optional<Transaction> transactionsOfValueForMin2 = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        //第三种方法 直接依次比较
        Optional<Transaction> transactionsOfValueForMin3 = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println("(8):" + transactionsOfValueForMin1 + "----" + transactionsOfValueForMin2 + "------" + transactionsOfValueForMin3);
    }
}
