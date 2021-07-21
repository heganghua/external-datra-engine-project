package com.jxzj.external.data.temp.other;

import java.io.IOException;

public class FilExample {

    public static void main(String[] args) throws IOException {

        Son son = new Son();
        son.sayHelloHi();
        son.sayHelloWorld();
        son.sayHello();

        // InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("./img/pingan.cookies.txt"));
        // int ch = 0;
        // while ((ch = inputStreamReader.read()) != -1) {
        // System.out.print((char)ch);
        // }
        // inputStreamReader.close();
        //
        // FileReader fileReader = new FileReader("./img/pingan.cookies.txt");
        // BufferedReader bufferedReader = new BufferedReader(fileReader);
        // String temp = null;
        // while ((temp = bufferedReader.readLine()) != null) {
        // System.out.println(temp);
        // }
        //
        // char[] buffer = new char[1024];
        // int i = 0;
        // while ((ch = fileReader.read()) != -1) {
        // buffer[i] = (char)ch;
        // i++;
        // }
        // for (char c : buffer) {
        // System.out.print(c);
        // }
        // bufferedReader.close();
        //
        // BufferedReader bufferedReader2 =
        // new BufferedReader(new InputStreamReader(new FileInputStream("./img/pingan.cookies.txt")));
        // String data = null;
        // while ((data = bufferedReader2.readLine()) != null) {
        // System.out.println(data);
        // }
        //
        // bufferedReader2.close();

        // Set<Object> hashSet = new HashSet<>();
        // hashSet.add("123");
        // hashSet.add(32424);
        // Iterator<Object> iterator = hashSet.iterator();
        // while (iterator.hasNext()) {
        // Object next = iterator.next();
        // System.out.println(next.toString());
        // }

    }

}
