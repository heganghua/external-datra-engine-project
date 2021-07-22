package com.jxzj.external.data.designmode.filterchain;

public interface Filter {
    void execute(Alarm alarm, FilterChain chain);
}
