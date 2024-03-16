/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap.TUAN8;
import java.io.*;
import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Student implements Serializable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student() {
        
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
