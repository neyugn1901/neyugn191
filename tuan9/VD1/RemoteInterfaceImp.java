/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN9.VD1;

/**
 *
 * @author nguye
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteInterfaceImp extends UnicastRemoteObject 
        implements RemoteInterface{
    //ham khoi tao
    public RemoteInterfaceImp() throws RemoteException{
        super();
    }
    
    //ghi de phuong thuc truu tuong
    @Override
    public String sayHello() throws RemoteException {
        return "Xin chao, toi la Server";
    }
     
}