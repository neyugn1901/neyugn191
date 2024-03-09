/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.ChatApplication;

/**
 *
 * @author nguye
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.nio.file.Files;

public class ClientGUI extends JFrame {
    private JTextField messageField;
    private JTextArea chatArea;
    private PrintWriter out;
    private Socket socket;

    private String studentID = "1571020191"; 

    public ClientGUI() {
        setTitle("Chat Application - Client");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());
        chatPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        chatPanel.add(scrollPane, BorderLayout.CENTER);

        panel.add(chatPanel, BorderLayout.WEST);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        messageField = new JTextField();
        inputPanel.add(messageField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));

        JButton sendButton = new JButton("Send Message");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        buttonPanel.add(sendButton);

        JButton sendImageButton = new JButton("Send Image");
        sendImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendImage();
            }
        });
        buttonPanel.add(sendImageButton);

        JButton sendFileButton = new JButton("Send File");
        sendFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendFile();
            }
        });
        buttonPanel.add(sendFileButton);

        inputPanel.add(buttonPanel, BorderLayout.EAST);

        panel.add(inputPanel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);

        try {
            socket = new Socket("localhost", 12345);
            chatArea.append("Connected to server.\n");
            out = new PrintWriter(socket.getOutputStream(), true);

            Thread readThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String message;
                        while ((message = in.readLine()) != null) {
                            if (message.startsWith("FILE:")) {
                                receiveFile();
                            } else {
                                chatArea.append("Server: " + message + " (Student ID: " + studentID + ")\n");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            readThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = messageField.getText();
        chatArea.append("You: " + message + " (Student ID: " + studentID + ")\n");
        out.println(message + " (Student ID: " + studentID + ")");
        messageField.setText("");
    }

    private void sendImage() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            chatArea.append("You sent an image: " + selectedFile.getName() + " (Student ID: " + studentID + ")\n");
            out.println("IMAGE:");

            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(selectedFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            chatArea.append("You sent a file: " + selectedFile.getName() + " (Student ID: " + studentID + ")\n");
            out.println("FILE:" + selectedFile.getName());

            try {
                FileInputStream fileInputStream = new FileInputStream(selectedFile);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                }
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void receiveFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fileName = bufferedReader.readLine();
            chatArea.append("Server sent a file: " + fileName + "\n");

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save File");
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File saveFile = fileChooser.getSelectedFile();
                FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                fileOutputStream.close();
                JOptionPane.showMessageDialog(this, "File downloaded successfully!", "Download Status", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI();
            }
        });
    }
}
