package com.jxzj.external.data.io;

import java.math.BigDecimal;

public class IOTest {

    public static void main(String[] args) {

        // System.out.println("7AFCA2B2E8A2C6E1FE73EF37D6F1CF3B".length());

        BigDecimal bigDecimal = new BigDecimal("123.125");
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));

    }

}
