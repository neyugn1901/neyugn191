/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen
 */
import java.net.InetAddress;

public class check {
    public static void main(String[] args) {
        try {
            // In địa chỉ IP
            // Lấy địa chỉ IP của www.google.com
            InetAddress inet = InetAddress.getByName("www.facebook.com");
            // In địa chỉ IP
            System.err.println("Dia chi IP cua Facebook la : " + inet.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
