/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN3;

/**
 *
 * @author nguye
 */
public class VDD3 {
    private int count=0;
    public synchronized void demTang(){//phuong thuc 1 dong bo hoa 
        count++;
    }
    public synchronized void demGiam() //Phuong thuc 2 dong bo hoa
    {
        count-=2;
    }
    public int getCount() //phuong thuc khong dong bo hoa
    {
        return count;
    }
    public static void main(String[] args) {
        VDD3   c=new VDD3();
        Thread inTh=new Thread(()->{ //tao luong tang
        for(int i=0; i<1000;i++) {
            c.demTang(); //goi ham dong bo hoa
        }
    });
        Thread deTh=new Thread(()->{ //tao luong giam
        for(int i=0; i<1000;i++) {
            c.demGiam(); //goi ham dong bo hoa
        }
    });
        inTh.start();
        deTh.start();
        try {
            inTh.join();
            deTh.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //In ra ket qua cuoi cung
        System.out.println("Ket qua cuoi cung: "
        +c.getCount());
}
}