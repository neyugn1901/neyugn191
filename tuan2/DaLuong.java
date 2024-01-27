/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN2;

/**
 *
 * @author nguye
 */
public class DaLuong {
    public static void main(String[] args){
        //goi cac luong
        //tao va goi luong1
        Thread t1=new Thread(new MyRunable("Luong 1"));
        t1.start();
        //tao va goi luong2
        Thread t2=new Thread(new MyRunable("Luong 2"));
        t2.start();
    }
    
}
 class MyRunable implements Runnable {
     private String threadName;
     public MyRunable(String name) //ham khoi tao
     {
         this.threadName=name;
     }
     //Ham run se thuc hien ham start duoc goi
     @Override
     public void run() {
         System.out.println("Bat dau thuc hien cong viec trong" + threadName);
         //thuc hien cong viec
         for(int i = 0; i<=5;i++){
             System.out.println(threadName+"buoc"+i);
             try {
                 Thread.sleep(2000);
             } catch (Exception e) {
             }
         }
                  System.out.println("Bat dau thuc hien cong viec trong" + threadName);
     }
 }

