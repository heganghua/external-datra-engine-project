package com.jxzj.external.data.java8;

public class Student {

    private String name;
    private Integer score;

    public void setNameAndScore(String name, Integer score) {
        this.name = name;
        this.score = score;
        System.out.println("Student: " + name + "  score: " + score);
    }

    public static void main(String[] args) {
        TestInterface tf = Student::setNameAndScore;
        tf.set(new Student(), "张三", 11);

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

            }
        }).start();

    }

    @FunctionalInterface
    interface TestInterface {
        public void set(Student d, String name, Integer s);
    }

}
