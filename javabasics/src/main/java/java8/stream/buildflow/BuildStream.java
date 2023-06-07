package java8.stream.buildflow;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildStream {
    public static void main(String[] args) {
        //显式创建流 Stream.of
        Stream<String> stringStream = Stream.of("java", "8", "Stream", "exercise");
        stringStream.forEach(System.out::println);
        Stream<String> emptyString = Stream.empty();//创建空流

        //创建数组流 求和得到int
        int [] ints = {1,3,4,5};
        int intStream =  Arrays.stream(ints).sum();

        //文件 生成流
        long uniqueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        }
        catch(IOException e){

        }

       /* 斐波纳契元组序列
        斐波纳契数列是著名的经典编程练习。下面这个数列就是斐波纳契数列的一部分：0, 1, 1,2, 3, 5, 8, 13, 21, 34, 55…数列中开始的两个数字是0和1，
        后续的每个数字都是前两个数字之和。斐波纳契元组序列与此类似，是数列中数字和其后续数字组成的元组构成的序列：(0, 1),
        (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21) …
        你的任务是用iterate方法生成斐波纳契元组序列中的前20个元素。*/
        Stream.iterate(new int[]{0, 1},
                        t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

    }
}
