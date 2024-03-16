/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap.TUAN8;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author nguye
 */
public class Main {
    public static void main(String[] args) {
        //tao doi tuong student
        Student student=new Student("Nguyen Manh Nguyen", 22);
        //thuc hien tuan tu va ghi vao file
        try {
            FileOutputStream fileOut=
                    new FileOutputStream("student.txt");
            ObjectOutputStream out=
                    new ObjectOutputStream(fileOut); 
            out.writeObject(student);//luu object vao file
            fileOut.close();
            System.out.println("Da tuan tu hoa va luu ghi file");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //doc doi tuong tu file va giao tuan tu hoa
        try {
            FileInputStream fileIn=new FileInputStream("student.txt");
            ObjectInputStream in=new ObjectInputStream(fileIn);
            //Ep kieu sang student
            Student sttFromFile=(Student)in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Da doc doi tuong tu file");
            System.out.println("Ten: "+sttFromFile.getName());
            System.out.println("Tuoi:"+sttFromFile.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
