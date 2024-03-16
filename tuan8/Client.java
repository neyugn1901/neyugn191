/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap.TUAN8;
import java.io.*;
import java.net.*;
/**
 *
 * @author nguye
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",12345);
            ObjectInputStream ois=
                    new ObjectInputStream(socket.getInputStream());
            //doc doi tuong tu inputstream
            Student s=(Student)ois.readObject();
            System.out.println("Da nhan doi tuong: "+s.getName()+ "-" +s.getAge());
            ois.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
