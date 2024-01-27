/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN2;

/**
 *
 * @author nguye
 */
public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Luong bat dau chay");
    }
    public static void main(String[] args){
        //Tao luong
        MyThread myThead=new MyThread();
        //Bat dau luong
        myThead.start();
    }
    
}

