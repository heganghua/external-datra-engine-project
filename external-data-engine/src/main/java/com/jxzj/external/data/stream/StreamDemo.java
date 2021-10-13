package com.jxzj.external.data.stream;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(new User("张三", 24, "man", "changsha"), new User("李四", 25, "man", "changsha"),
            new User("诸葛亮", 24, "man", "changsha"), new User("令狐孤独", 30, "man", "changsha"),
            new User("左右逢源", 20, "man", "changsha"), new User("霸王花", 24, "man", "changsha"));

        List<User> as = users;

        System.out.println(users.hashCode());
        System.out.println(as.hashCode());

        System.out.println(users == as);
        System.out.println(users.equals(as));

        // List<Integer> ls = Arrays.asList(2, 3, 4, 5, 44, 2, 33, 4, 8, 6, 5, 8, 9);
        // IntSummaryStatistics summaryStatistics = ls.stream().mapToInt((x) -> x).summaryStatistics();
        // List<Integer> collect = ls.stream().distinct().collect(Collectors.toList());
        // System.out.println(collect.toString());
        // System.out.println(summaryStatistics.getMax());
        // System.out.println(summaryStatistics.getMin());
        // System.out.println(summaryStatistics.getSum());
        // System.out.println(summaryStatistics.getCount());

        // List<User> collect = users.stream().filter(u -> u.getAge() > 24).collect(Collectors.toList());
        // System.out.println(collect.toString());

    }

}
