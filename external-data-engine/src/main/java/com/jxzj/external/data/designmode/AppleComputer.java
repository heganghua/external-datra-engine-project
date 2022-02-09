package com.jxzj.external.data.designmode;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppleComputer {

    private String name;

    private Long stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    AppleComputer() {}

    AppleComputer(ItemBuilder builder) {
        this.name = builder.name;
        this.stock = builder.stock;
    }

    public static void main(String[] args) throws JsonProcessingException {

        AppleComputer build = new AppleComputer.ItemBuilder().setName("copyItem").build();
        System.out.println(new ObjectMapper().writeValueAsString(build));
        AppleComputer build2 = new AppleComputer.ItemBuilder().setName("扩大解放").setStock(999999L).build();
        System.out.println(new ObjectMapper().writeValueAsString(build2));
    }

    public static class ItemBuilder {
        private static final Long DEFAULT_STOCK = 0L;
        private String name;
        private Long stock = DEFAULT_STOCK;

        public AppleComputer build() {
            return new AppleComputer(this);
        }

        @Transactional
        public ItemBuilder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }

        public ItemBuilder setStock(Long stock) {
            if (stock > 9999999999L) {
                throw new IllegalArgumentException("库存数量错误");
            }
            return this;
        }
    }

}
