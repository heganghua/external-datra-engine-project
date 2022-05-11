package com.jxzj.external.data.reflectTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.jxzj.external.data.designmode.filterchain.FilterFactory;

public class ResouceTest {

    private static List<String> classPaths = new ArrayList<>();
    private static List<File> pathList = new ArrayList<>();

    public static void main(String[] args) {

        String packageName = "com.jxzj.external.data.reflectTest";
        String path = FilterFactory.class.getResource("/").getPath();
        String replace = packageName.replace(".", File.separator);

        String paths = path + replace;
        System.out.println(paths);
    }

}
