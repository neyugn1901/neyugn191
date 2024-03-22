/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN9.VD1;

/**
 *
 * @author nguye
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote{
    String sayHello() throws RemoteException;
}