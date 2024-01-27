/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN3;

/**
 *
 * @author nguye
 */
public class VDD6 {
    private final Object monitor = new Object();
    private boolean isDataReady = false;

    public void productData() throws InterruptedException {
        synchronized (monitor) {
            // Dam bao chi co 1 tien trinh duoc thuc hien
            // neu du lieu da san sang
            while (isDataReady) {
                monitor.wait();
            }

            System.out.println("San xuat du lieu...");
            Thread.sleep(2000);
            // Sau khi san xuat du lieu xong -> du lieu da san sang
            isDataReady = true;

            if (isDataReady) {
                monitor.notify();
            }
        }
    }

    public void useData() throws InterruptedException {
        synchronized (monitor) {
            while (!isDataReady) {
                monitor.wait();
            }

            System.out.println("Su dung du lieu");
            Thread.sleep(3000);
            isDataReady = false;
            monitor.notify();
        }
    }

    public static void main(String[] args) {
        VDD6 ex = new VDD6();
        Thread thSanXuat = new Thread(() -> {
            try {
                while (true) {
                    ex.productData();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread thSuDung = new Thread(() -> {
            try {
                while (true) {
                    ex.useData();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thSanXuat.start();
        thSuDung.start();
    }
}
