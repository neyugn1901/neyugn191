/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.baitap.TUAN2;

/**
 *
 * @author nguye
 */
public class TinhTong {
    public static void main(String[] args){
        //Mang cac so nguyen
        int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        //so luong thread
        int numThreads=2;
        //Mang cac luong
        Thread[] ths=new Thread[numThreads];//Tao cac luong
        //Tao 2 doi tuong cho luong
        LopTinhTong[] cal=new LopTinhTong[numThreads];//
        for(int i=0;i<numThreads;i++){
            cal[i]=new LopTinhTong(array, i, numThreads); //gan DT cho luong
            ths[i]=new Thread(cal[i]);
            ths[i].start();//bat dau luong
        }
        //doi cho cac luong hoan thanh
        for(int i=0;i<numThreads;i++){
            try {
                ths[i].join();
            } catch (Exception e){
                
            }
        }
        //Cong don
        int tong=0;
        for(LopTinhTong c: cal)
        {
            tong += c.getTongTungPhan();
        }
        //In ket qua ra man hinh
        System.out.println("Tong la "+tong);
    }
}
class LopTinhTong implements Runnable{
    private int[] array;
    private int startIndex;
    private int buocNhay;
    private int tongTungPhan;

    public LopTinhTong(int[] array, int startIndex, int buocNhay) {
        this.array = array;
        this.startIndex = startIndex;
        this.buocNhay = buocNhay;
        this.tongTungPhan=0;//chua dem
    }
    @Override
    public void run(){
        for(int i=startIndex;i<array.length;i+=buocNhay)
    {
            tongTungPhan +=array[i];
    }
}
    public int getTongTungPhan() {
        return tongTungPhan;
}
}
