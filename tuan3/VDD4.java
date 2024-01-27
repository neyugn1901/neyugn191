/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN3;

/**
 *
 * @author nguye
 */
public class VDD4 {

    private final Object lc = new Object();
    public synchronized void pt1() //phuong thuc dong bo hoa
    {
        
    }
    public synchronized void pt2() //phuong thuc dong bo hoa
    {
        synchronized (lc) {
            
        }
    }
    public static void main(String args[]) {
        Thread th = new Thread(()->{
        
        });
        th.start();
        try {
            // phuong thuc 1 tien trinh khoa
        } catch (Exception e) {
            
        }
    }
}
