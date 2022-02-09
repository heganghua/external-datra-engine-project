package com.jxzj.external.data.designmode.templatemethod;

import java.util.function.Consumer;

import org.apache.commons.lang3.RandomUtils;

import com.jxzj.external.data.stream.User;

public class AbstractBusinessHandler2 {

    /**
     * 存钱
     * 
     * @param amount
     */
    public void save(Long amount) {

        execute(a -> {
            // 具体存钱业务逻辑
            System.out.println("save " + amount);
            System.out.println("--------------" + a);
        });
    }

    private void execute(Consumer<User> consumer) {
        getNumber();
        consumer.accept(null);
        judge();
    }

    private void judge() {
        System.out.println("give a praised");
    }

    private void getNumber() {
        System.out.println("number-00" + RandomUtils.nextInt());
    }
}
