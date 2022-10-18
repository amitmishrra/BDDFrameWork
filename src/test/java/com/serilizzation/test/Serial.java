package com.serilizzation.test;

import java.io.*;

class Test implements Serializable{
    int i = 10;
}
public class Serial {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Test t1 = new Test();
        //Serialization
        FileOutputStream fos = new FileOutputStream("text.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t1);

        //Deserialization
        FileInputStream fis = new FileInputStream("text.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println("hello world");
        Test t2  = (Test) ois.readObject();
        System.out.println(t2.i);
    }
}
