/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN4;

/**
 *
 * @author nguye
 */
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class VD3 {
    public static void main(String[] args) {
        try {
            // Tạo đối tượng lấy địa chỉ
            URL url = new URL("http://www.google.com");
            // Mở kết nối
            URLConnection urlConnection = url.openConnection();
            // Đọc dữ liệu từ kết nối
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            // Tạo đối tượng ghi file
            FileWriter fileWriter = new FileWriter("tuan4.html");
            // Đọc từng dòng và ghi vào file
            String line;
            while ((line = reader.readLine()) != null) {
                fileWriter.write(line + "\n");
            }
            // Đóng luồng
            reader.close();
            // Đóng file
            fileWriter.close();
            System.out.println("Download completed successfully.");
        } catch (Exception e) {
            // In thông báo lỗi (có thể cải tiến để xử lý lỗi một cách chính xác hơn)
            e.printStackTrace();
        }
    }
}
