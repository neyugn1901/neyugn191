/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author nguye
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class check {

    public static void main(String[] args) {
        if (isInternetAvailable()) {
            System.out.println("Kết nối Internet đang hoạt động.");
        } else {
            System.out.println("Không thể kết nối Internet.");
        }
    }

    public static boolean isInternetAvailable() {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.google.com");
            return inetAddress.isReachable(5000); // 5 giây timeout
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

}
