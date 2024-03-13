/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN7;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class T7UDPSend {
    public static void main(String[] args) {
        try {
            //tao doi tuong
            DatagramSocket socket=new DatagramSocket();
            //chuan bi du lieu gui
            byte[] data="Xin chao cac ban".getBytes();
            //xac dinh may nhan
            InetAddress address=InetAddress.getByName("localhost");
            int port=12345;
            //tao goi du lieu UDP
            DatagramPacket packet=new DatagramPacket(data, data.length, address, port);
            //gui
            socket.send(packet);
            //dong ket noi
            socket.close();
        } catch (Exception e) {
        }
    }
}