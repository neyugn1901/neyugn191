package com.mycompany.baitap.TUAN8;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running......");
            // Lang nghe
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                // Tao 1 doi tuong student
                Student student = new Student("Nguyen Manh Nguyen 1502", 22);
                // Ghi doi tuong qua mang
                oos.writeObject(student);
                oos.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
