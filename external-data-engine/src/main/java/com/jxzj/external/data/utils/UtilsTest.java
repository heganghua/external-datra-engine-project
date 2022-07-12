package com.jxzj.external.data.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.SerializationUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jxzj.external.data.designmode.buildmode.User;

public class UtilsTest {

    public static void main(String[] args) {
        // UtilsTest.collections();
        // UtilsTest.apacheCollectionUtilsTest();
        // UtilsTest.listsTest();
        // UtilsTest.objectsTest();
        // UtilsTest.stringUtils();
        // UtilsTest.asertTest();
        try {
            UtilsTest.ioUtilTest();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void collections() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        // 排序
        Collections.sort(list);
        // 倒序
        Collections.reverse(list);
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println(min);

        List<Integer> synchronizedList = Collections.synchronizedList(list);
        List<Integer> emptyList = Collections.emptyList();
        List emptyList2 = Collections.EMPTY_LIST;
        System.out.println(list instanceof Map);
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, 3));
    }

    public static void apacheCollectionUtilsTest() {

        ArrayList<Object> list = new ArrayList<>();

        list.add(3);
        list.add(2);
        list.add(4);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        System.out.println(CollectionUtils.isEmpty(list));
        System.out.println(CollectionUtils.isNotEmpty(list));

        System.out.println(CollectionUtils.union(list, list2));
        System.out.println(CollectionUtils.intersection(list, list2));
        System.out.println(CollectionUtils.disjunction(list, list2));
        System.out.println(CollectionUtils.subtract(list2, list));

    }

    public static void listsTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(4, 5);

        // 笛卡尔积
        List<List<Integer>> product = Lists.cartesianProduct(list, list2);
        System.out.println(product);

        List<List<Integer>> partition = Lists.partition(list, 2);
        System.out.println(partition);

    }

    public static void objectsTest() {
        Integer integer = new Integer(123);
        User user = new User();

        System.out.println(Objects.requireNonNull(integer));
        System.out.println(Objects.requireNonNull(user, "参数不能为空"));
        System.out.println(Objects.requireNonNull(user, () -> "参数不能为空"));
    }

    public static void stringUtils() {
        String str1 = null;
        String str2 = "";
        String str3 = " ";
        String str4 = "abc";

        System.out.println(StringUtils.isEmpty(str1));
        System.out.println(StringUtils.isEmpty(str2));
        System.out.println(StringUtils.isEmpty(str3));
        System.out.println(StringUtils.isEmpty(str4));

        System.out.println(StringUtils.isNotEmpty(str1));
        System.out.println(StringUtils.isNotEmpty(str2));
        System.out.println(StringUtils.isNotEmpty(str3));
        System.out.println(StringUtils.isNotEmpty(str4));

        String str5 = "12334556";
        System.out.println(StringUtils.isBlank(str5));
    }

    public static void asertTest() {
        String str = null;
        // Assert.isNull(str, "str必须为空");
        // Assert.isNull(str, () -> "str必须为空");
        // System.out.println("=========");
        // Assert.notNull(str, () -> "str不能为空");

        List<String> strs = null;
        Map<String, String> map = null;
        Assert.notEmpty(strs, "集合不能为空");
        Assert.notEmpty(map, "集合不能为空");

    }

    public static void ioUtilTest() throws FileNotFoundException, IOException {

        String string = IOUtils.toString(new FileInputStream("./img/pingan.cookies.txt"), StandardCharsets.UTF_8);
        System.out.println(string);
        IOUtils.write(string, new FileOutputStream("./img/new.txt"), StandardCharsets.UTF_8);
        System.out.println(DigestUtils.md5Hex("123"));

        Map<String, String> map = Maps.newHashMap();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        byte[] serialize = SerializationUtils.serialize(map);
        Object deserialize = SerializationUtils.deserialize(serialize);
        System.out.println(deserialize);

    }

}
