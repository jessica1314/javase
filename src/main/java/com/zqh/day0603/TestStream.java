package com.zqh.day0603;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestStream {
    private static BigInteger number = new BigInteger("0");
    private static List<BigInteger> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //流处理 lambda表达式 应用在流处理中；stream api
        //java.util.stream
        //不是io流，代表任意对象的序列
        //顺序输出任意的java对象实例，内存计算和业务逻辑
        //可能内存中未分配，实时计算  惰性计算
        //普通List 是内存中已存在的java对象
        //全体自然数 无数个  list放不下
        Stream.generate(new Fibonacci()).limit(10).forEach(System.out::println);
        System.out.println(2^1^2);
        // a^b^b =a & | ^   异或  不同为1 相同为0   自己和自己异或为0 0和任何数异或就是它本身？
        // a b  a=a^b; b=a^b; a=a^b;

//        new TestStream().handle();
//        //中间的map和limit操作是不计算，计算发生在最后的输出
//        //files的lines方法把一个文件变成一个stream，每个元素都是一行内容
//        //src下的路径开始算，项目路径可以忽略？
//        try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/1.txt"))) {
//            lines.forEach(System.out::println);
//        }
//
//        final Pattern p = Pattern.compile("\\s+");
//        p.splitAsStream("ni hao ya  peng  \t you chi fn le mei ne ").forEach(System.out::println);
//        final LongStream longStream = Stream.of("1", "3", "4", "5").mapToLong(Long::parseLong);
//        final PrimitiveIterator.OfLong iterator = longStream.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.nextLong());
//        }

    }

    private static BigInteger apply2(BigInteger n) {
        return n.multiply(n);
    }

    private void handle() {
        Stream<BigInteger> naturals = Stream.generate(new NatualSupplier());
        //返回一个新的流对象,不修改原本的流对象
        //流的转换只保存了转换规则
        //支持函数式编程和链式操作，表示无线序列，大部分都是惰性求值的
        //注意：无线序列需要变成有限数列才能打印！
        naturals.map(TestStream::apply2).limit(10).forEach(System.out::println);
    }

    private static Stream<BigInteger> createNaturalStream() {
        number = number.add(new BigInteger("1"));
        arr.add(number);
        return arr.stream();
    }

    private static BigInteger apply(BigInteger n) {
        return n.multiply(n);
    }


    class NatualSupplier implements Supplier<BigInteger> {
        BigInteger n = new BigInteger("0");

        @Override
        public BigInteger get() {
            n = n.add(new BigInteger("1"));
            return n;
        }

    }

    static class Fibonacci implements Supplier<Integer> {
        Integer a = 0;
        Integer b = 1;  // 每次输出？ 0 1 变为 1 1 变为 1 2 变为 2 3 变为 3 5 变为 5 8

        @Override
        public Integer get() {
//            int c = a;
//            a = b;  //返回b的值？
//            b = a + c;//替换b的内容为两个数的和？
//            return a;
            int sum = b;
            int c = a;
            a = b;
            b = c + a;
            return sum;
        }
    }
}
