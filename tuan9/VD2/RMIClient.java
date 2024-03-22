/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN9.VD2;



/**
 *
 * @author nguye
 */
import java.rmi.Naming;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        try {
            //tim doi tuong
            StudentService obj=(StudentService)
                    Naming.lookup("//localhost:1097/StudentService");
            //goi cac phuong thuc tu xa
            obj.addStudent("Nguyen Manh Nguyen", 22);
            obj.addStudent("Nguyen Khanh Linh", 18);
            List<Student> students=obj.getAllStudents();
            //in ra ket qua
            System.out.println("List sinh vien");
            for(Student std:students)
            {
                System.out.println("Name: "+std.getName()+
                        " - Age: "+std.getAge());
            }
            //xoa ket qua
            System.out.println("Xoa ket qua");
            obj.removeStudent("Nguyen Khanh Linh");
            System.out.println("Sau khi xoa");
            for(Student std:students)
            {
                System.out.println("Name: "+std.getName()+
                        " - Age: "+std.getAge());
            }
        } catch (Exception e) {
            System.err.println("Loi: "+e.toString());
            e.printStackTrace();
        }
    }
}
