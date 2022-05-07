package com.jxzj.external.data.designmode.filterchain;

import java.util.Date;

/**
 * 责任链模式
 * 
 * @author hgh
 * @date 2022/04/11
 */
public class Client {

    public final static String RULE_PACKAGE_PATH = "com.jxzj.external.data.temp.chain.rule";

    public static void main(String[] args) {

        // 构造告警事件
        Alarm alarm = new Alarm(1, 10, "光功率衰耗", "23号楼", 1, 1, 1, new Date(), "割接");

        FilterChain filterChain = new FilterChain();
        filterChain.addFileters(FilterFactory.getFileters(RULE_PACKAGE_PATH));
        filterChain.doFilter(alarm, filterChain);

        System.out.println(alarm);
    }
}
