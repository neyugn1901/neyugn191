/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN4;

/**
 *
 * @author nguye
 */
import java.net.InetAddress;
import java.net.URL;

public class VD1 {
    public static void main(String[] args) {
        try {
            //Tao doi tuong inetadress bang ten may chu
            InetAddress dcByName=InetAddress.getByName("www.google.com");
            System.out.print("Lay Dia chi tu name:"
            +dcByName.getHostAddress());
            //Tao doi tuong inetaddress bang dia chi Ip
            InetAddress dcByID=InetAddress.getByName("216.239.38.120");
            System.out.print("\nDia chi tu ip:"
            +dcByID);
            InetAddress dcByName1
                    =InetAddress.getByName("www.vnexpress.net");
            System.out.println("\nHost Name:"+
                    dcByName1.getHostName());
            System.out.println("\nDc IP:"+
                    dcByName1.getHostAddress());
            
            InetAddress dcByName2
                    =InetAddress.getByName("www.vnexpress.net");
            //Kiem tra xem dia chi Ip co phai IP4 khong
            boolean isIP4=dcByName2 instanceof java.net.Inet4Address;
            System.out.println("Co phai IP4 khong?:" +isIP4);
            //Kiem tra dia chi IP co phai IP6 khong?
            boolean isIP6=dcByName2 instanceof java.net.Inet6Address;
            System.out.println("Co phai IP6 khong?"+isIP6);
            //-------------------------------------------
            URL url=
                    new URL("https://example.com/landing-page?utm_source=company-x&utm_medium=newsletter&utm_campaign=march_01&project-id=123");
            //Phantich thong tin tu URL
            System.out.println("Protocol: " +url.getProtocol());
            System.out.println("Host:"+url.getHost());
            System.out.println("Port:"+url.getPort());
            System.out.println("Path:"+url.getPath());
            System.out.println("Tham chieu:"+url.getRef());            
            System.out.println("Truy van"+url.getQuery());            
        } catch (Exception e) {
            
        }
    }
}