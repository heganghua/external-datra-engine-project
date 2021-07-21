package com.jxzj.external.data.temp.chain;

public interface Filter {
    void execute(Alarm alarm, FilterChain chain);
}
