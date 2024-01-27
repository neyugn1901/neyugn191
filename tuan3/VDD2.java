/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN3;


/**
 *
 * @author nguye
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VDD2 {
    private int count = 0;
    private Lock lc = new ReentrantLock(); // tao khoa kiem soat

    public void demTang() {
        lc.lock();
        try {
            count++;
        } catch (Exception e) {
            // Handle exceptions if necessary
        } finally {
            lc.unlock();
        }
    }

    public static void main(String[] args) {
        VDD2 vdd2 = new VDD2();

        // Call the demTang method to increment the count
        vdd2.demTang();

        // Print the updated count
        System.out.println("Count: " + vdd2.getCount());
    }

    public int getCount() {
        return count;
    }
}
