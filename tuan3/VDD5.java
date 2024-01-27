/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN3;

/**
 *
 * @author nguye
 */
public class VDD5 {

    private final Object monitor = new Object();
    public void doi() throws InterruptedException
    {
        monitor.wait(); //doi
    }
    public void danhThuc()
    {
        synchronized (monitor)
        {
            monitor.notify(); //danh thuc
        }
    }
}
