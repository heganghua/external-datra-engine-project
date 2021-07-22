package com.jxzj.external.data.designmode.filterchain.rule;

import com.jxzj.external.data.designmode.filterchain.Alarm;
import com.jxzj.external.data.designmode.filterchain.EnableFilter;
import com.jxzj.external.data.designmode.filterchain.Filter;
import com.jxzj.external.data.designmode.filterchain.FilterChain;

@EnableFilter
public class Rule1 implements Filter {

    @Override
    public void execute(Alarm alarm, FilterChain chain) {
        // 规则内容： 如果是政府发生告警，告警等级为最高
        if (alarm.getAlarmAddress().contains("政府")) {
            alarm.setAlarmLevel(4);
            System.out.println("规则内容： 如果是政府发生告警，告警等级为最高");
        }
        // 回调，让FilterChain继续处理下一个Filter（过滤器）
        chain.doFilter(alarm, chain);
    }

}
