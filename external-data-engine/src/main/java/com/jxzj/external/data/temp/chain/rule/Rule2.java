package com.jxzj.external.data.temp.chain.rule;

import com.jxzj.external.data.temp.chain.Alarm;
import com.jxzj.external.data.temp.chain.EnableFilter;
import com.jxzj.external.data.temp.chain.Filter;
import com.jxzj.external.data.temp.chain.FilterChain;

@EnableFilter
public class Rule2 implements Filter {

    @Override
    public void execute(Alarm alarm, FilterChain chain) {
        // 规则内容：告警名称为：光功率衰耗，描述信息为:割接 则该告警变为确认状态
        if (alarm.getAlarmName().contains("光功率衰耗") && alarm.getDesc().contains("割接")) {
            alarm.setAlarmAck(0);
            System.out.println("规则内容：告警名称为：光功率衰耗，描述信息为:割接 则该告警变为确认状态");
        }

        // 注意回调FilterChain的doFilter方法，让FilterChain继续执行下一个Filter
        chain.doFilter(alarm, chain);
    }

}
