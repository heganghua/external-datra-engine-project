package com.jxzj.external.data.designmode.filterchain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

/**
 * 扫描注解修饰的类， 并将这些实例对象返回
 * 
 * @author heganghua
 * @date 2021/07/17
 */
public class FilterFactory {
    public static List<Filter> getFileters(String packages) {
        ArrayList<Filter> filterList = new ArrayList<>();
        // 通过注解扫描制定的包
        Reflections reflections = new Reflections(packages);
        // 如果该包下面有被EnableFilter注解修饰的类，那么该类的实例加入到列表中，最终返回。
        Set<Class<?>> filters = reflections.getTypesAnnotatedWith(EnableFilter.class);
        for (Class<?> filter : filters) {
            try {
                filterList.add((Filter)filter.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return filterList;
    }
}
