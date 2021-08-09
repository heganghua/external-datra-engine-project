package com.jxzj.external.data.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(new User("张三", 24, "man", "changsha"), new User("李四", 25, "man", "changsha"),
            new User("诸葛亮", 24, "man", "changsha"), new User("令狐孤独", 30, "man", "changsha"),
            new User("左右逢源", 20, "man", "changsha"), new User("霸王花", 24, "man", "changsha"));

        List<User> collect = users.stream().filter(u -> u.getAge() > 24).collect(Collectors.toList());
        System.out.println(collect.toString());

    }

}
