package com.jxzj.external.data.reflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static Object copy(Object object) throws InstantiationException, IllegalAccessException,
        IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

        Class<? extends Object> classType = object.getClass();
        System.out.println(classType.getName());

        // 通过默认构造方法创建一个新的对象
        Object newInstance = classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
        // Class<?> forName = Class.forName("com.jxzj.external.data.reflectTest.Customer");

        // 获取对象的所有属性
        Field[] fields = classType.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            String fieldName = field.getName();
            // 拿到属性名称的首字母并转换为大写字母
            String upperCase = fieldName.substring(0, 1).toUpperCase();
            // 获得属性对应的get方法的名称
            String getMethodName = "get" + upperCase + fieldName.substring(1);
            // 同理，获得对应的set方法的名称
            String setMethodName = "set" + upperCase + fieldName.substring(1);
            System.out.println(getMethodName);

            // 获得get方法
            Method getMethod = classType.getMethod(getMethodName, new Class[] {});
            // 获得set方法
            Method setMethod = classType.getMethod(setMethodName, new Class[] {field.getType()});

            // 调用原对象的get方法
            Object invoke = getMethod.invoke(object, new Object[] {});
            System.out.println(fieldName + ": " + invoke);
            // 调用拷贝对象的set方法，并且设置值
            setMethod.invoke(newInstance, new Object[] {invoke});
        }

        return newInstance;
    }

    public void newInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
        NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> forName = Class.forName("com.jxzj.external.data.reflectTest.Customer");

        Constructor<?> constructor = forName.getConstructor(new Class[] {});
        Object newInstance2 = constructor.newInstance();

        Object newInstance = forName.newInstance();
        Customer customer = (Customer)newInstance;
        customer.setAddr("str");

    }

    public static void main(String[] args) {

        try {
            Customer customer = new Customer();
            // customer.setAddr("长沙");
            // customer.setAge(20);
            // customer.setId(1L);
            // customer.setName("Lisa");
            Customer copy = (Customer)ReflectDemo.copy(customer);
            // System.out.println(copy.getAge());
            //
            // System.out.println(customer == copy);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
            | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

}
