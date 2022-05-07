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
        doPath(new File(paths));
        System.out.println(paths);
    }

    private static void doPath(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File f1 : listFiles) {
                if (f1.isDirectory()) {
                    pathList.add(f1);
                } else {
                    if (file.getName().endsWith(".class")) {
                        classPaths.add(file.getPath());
                    }
                }
            }
        }

        while (true) {
            if (pathList.isEmpty() || pathList.size() == 0) {
                break;
            }
            for (File f1 : pathList) {
                String[] list = f1.list();
                for (String string : list) {

                }
                if (f1.isDirectory()) {
                    pathList.add(f1);
                } else {
                    if (file.getName().endsWith(".class")) {
                        classPaths.add(file.getPath());
                    }
                }
            }
        }

    }

}
