package com.jxzj.external.data.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    private String root;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] loadClassData = loadClassData(name);
        if (null == loadClassData) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, loadClassData, 0, loadClassData.length);
    }

    private byte[] loadClassData(String className) {

        String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        System.out.println("fileName: " + fileName);

        try {
            FileInputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            final int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        myClassLoader.setRoot("F:\\eclipse-workspace");

        Class<?> testClass = null;

        try {
            testClass = myClassLoader.loadClass("BaseData");
            Object object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
