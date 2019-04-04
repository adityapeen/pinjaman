/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinjaman;

import java.text.DecimalFormat;

/**
 *
 * @author adityapeen
 */
public class TestRule {
    
    private static String format(double desimal){
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(desimal);
    }
    private static double des(double desimal){
        return Double.valueOf(format(desimal));
    }
    private static double smallest(double[] data){
        double x=data[0];
        for(int i=1;i<3;i++){
            if(data[i]<x) x=data[i];
        }
        return x; 
    }
        
    public static void main(String args[]){
        Rule rule = new Rule();
        

        double pendapatan, pinjaman, waktu;
        double y = 0, atas = 0, bawah = 0;
        pendapatan = 4;
        pinjaman = 9;
        waktu = 9;
        
        
        double[][][] derajat = //Pendpatan-Pinjaman-Waktu
        {
            {
            {0, 0},
            {0, 0}
            },
            {
            {0, 0},
            {0, 0}
            }
        };
        double[][] komposisi = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        double[] pdt={0,0},  pjm={0,0},  wkt={0,0}, temp={0,0,0}, w={50,75,90};
        
        System.out.println("------Input------");
        System.out.println("Pendapatan = "+pendapatan+" juta ");
        System.out.println("Pinjaman = "+pinjaman+" juta");
        System.out.println("Waktu = "+waktu+" bulan");
        
        System.out.println("------Nilai Fuzzy------");
        
        if(pendapatan<=rule.GetPdptKB()){
            y=rule.PdptKecil(pendapatan);
            pdt[0]=des(y);
            System.out.print("- "+pdt[0]+" ");
            System.out.println("Pendapatan Kecil");
            
        }
        if(pendapatan>rule.GetPdptBB()){
            y=rule.PdptBesar(pendapatan);
            pdt[1]=des(y);
            System.out.print("- "+pdt[1]+" ");
            System.out.println("Pendapatan Besar");
        }
        if(pinjaman<=rule.GetPjmKB()){
            y=rule.PjmSedikit(pinjaman);
            pjm[0]=des(y);
            System.out.print("- "+pjm[0]+" ");
            System.out.println("Pinjaman Sedikit");
        }
        if(pinjaman>rule.GetPjmBB()){
            y=rule.PjmBanyak(pinjaman);
            pjm[1]=des(y);
            System.out.print("- "+pjm[1]+" ");
            System.out.println("Pinjaman Banyak");
        }
        if(waktu<=rule.GetWktKB()){
            y=rule.WktSebentar(waktu);
            wkt[0]=des(y);
            System.out.print("- "+wkt[0]+" ");
            System.out.println("Waktu Sebentar");
        }
        if(waktu>rule.GetWktBB()){
            y=rule.WktLama(waktu);
            wkt[1]=des(y);
            System.out.print("- "+wkt[1]+" ");
            System.out.println("Waktu Lama");
        }
        
        System.out.println("------Conjunction & Disjunction------");
        
        int i, j, k;
        for(i=0;i<2;i++){
            for(j=0; j<2;j++){
                for(k=0;k<2;k++){
                    //System.out.print("i="+i+" j="+j+" k="+k+" Kelayakan ");
                    if(i==0 && j==0 && k==0) {
                        temp[0]=pdt[0];
                        temp[1]=pjm[0];
                        temp[2]=wkt[0];
                        derajat[i][j][k]=smallest(temp);
                        System.out.println(derajat[i][j][k]+" Kelayakan Sedang");
                        komposisi[0][0] = derajat[i][j][k];
                        komposisi[0][1] = 2;
                    }
                    if(i==0 && j==0 && k==1) {
                        temp[0]=pdt[0];
                        temp[1]=pjm[0];
                        temp[2]=wkt[1];
                        derajat[i][j][k]=smallest(temp);
                        System.out.println(derajat[i][j][k]+" Kelayakan Tinggi");
                        komposisi[1][0] = derajat[i][j][k];
                        komposisi[1][1] = 3;
                    }
                    if(i==0 && j==1 && k==0) {
                        temp[0]=pdt[0];
                        temp[1]=pjm[1];
                        temp[2]=wkt[0];
                        derajat[i][j][k]=smallest(temp);
                        System.out.println(derajat[i][j][k]+" Kelayakan Rendah");
                        komposisi[2][0] = derajat[i][j][k];
                        komposisi[2][1] = 1;
                    }
                    if(i==0 && j==1 && k==1) {
                        temp[0]=pdt[0];
                        temp[1]=pjm[1];
                        temp[2]=wkt[1];
                        derajat[i][j][k]=smallest(temp);
                        System.out.println(derajat[i][j][k]+" Kelayakan Sedang");
                        komposisi[3][0] = derajat[i][j][k];
                        komposisi[3][1] = 2;
                    }
                    if(i==1 && j==0 && k==0) {
                        temp[0]=pdt[1];
                        temp[1]=pjm[0];
                        temp[2]=wkt[0];
                        derajat[i][j][k]=smallest(temp);
                        System.out.println(derajat[i][j][k]+" Kelayakan Tinggi");
                        komposisi[4][0] = derajat[i][j][k];
                        komposisi[4][1] = 3;
                    }
                    if(i==1 && j==0 && k==1) {
                        temp[0]=pdt[1];
                        temp[1]=pjm[0];
                        temp[2]=wkt[1];
                        derajat[i][j][k]=smallest(temp);
                        System.out.println(derajat[i][j][k]+" Kelayakan Tinggi");
                        komposisi[5][0] = derajat[i][j][k];
                        komposisi[5][1] = 3;
                    }
                    if(i==1 && j==1 && k==0) {
                        temp[0]=pdt[1];
                        temp[1]=pjm[1];
                        temp[2]=wkt[0];
                        derajat[i][j][k]=smallest(temp);
                        System.out.println(derajat[i][j][k]+" Kelayakan Sedang");
                        komposisi[6][0] = derajat[i][j][k];
                        komposisi[6][1] = 2;
                    }
                    if(i==1 && j==1 && k==1) {
                        temp[0]=pdt[1];
                        temp[1]=pjm[1];
                        temp[2]=wkt[1];
                        derajat[i][j][k]=smallest(temp);
                        System.out.println(derajat[i][j][k]+" Kelayakan Tinggi");
                        komposisi[7][0] = derajat[i][j][k];
                        komposisi[7][1] = 3;
                    } 
                }
            }
        }
        
        System.out.println("------Composition------");
        //Versi semua
//        for(i=0;i<8;i++){
//            for(j=0; j<2; j++){
//                System.out.print("["+i+" "+j+"] "+komposisi[i][j]+" - ");
//                if(komposisi[i][j]==3.0) w=90;
//                else if(komposisi[i][j]==2.0) w=75;
//                else if(komposisi[i][j]==1.0) w=50;
//            }
//            System.out.print("[w="+w+"]");
//            atas += komposisi[i][0]*w;
//            bawah += komposisi[i][0];
//            //System.out.print(" atas= "+atas+" bawah="+bawah);
//            System.out.println("");
//        }
        
        //Versi terbesar
        temp[0] = temp[1] = temp[2] = 0;
        for(i=0;i<8;i++){
            if(komposisi[i][1]==1.0){
                if(komposisi[i][0]>temp[0]) temp[0]=komposisi[i][0];
            }
            else if(komposisi[i][1]==2.0){
                if(komposisi[i][0]>temp[1]) temp[1]=komposisi[i][0];
            }
            else {
                if(komposisi[i][0]>temp[2]) temp[2]=komposisi[i][0];
            }
        }
        
        System.out.println(temp[0]+" Rendah\n"+temp[1]+" Sedang\n"+temp[2]+" Tinggi");
        
        for(i=0;i<temp.length;i++){
            if(i==0) atas+=temp[i]*w[i];
            else if(i==1) atas+=temp[i]*w[i];
            else atas+=temp[i]*w[i];
            bawah += temp[i];
        }
                
        System.out.println("------Weighted Average------");
        System.out.println("y = "+atas+"/"+bawah);
        y=atas/bawah;
        System.out.println("Weighted Average = "+des(y));
           
    }
    
}
