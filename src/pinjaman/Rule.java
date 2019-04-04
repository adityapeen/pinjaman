/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinjaman;

/**
 *
 * @author adityapeen
 */
public class Rule {
    private double PdptKecilAtas, PdptKecilBawah, PdptBesarAtas, PdptBesarBawah;
    private double PjmSedikitAtas, PjmSedikitBawah, PjmBanyakAtas, PjmBanyakBawah;
    private double WktSebentarAtas, WktSebentarBawah, WktLamaAtas, WktLamaBawah;
    private double BobotRendah, BobotSedang, BobotTinggi;
    
    public Rule(){
        this.PdptKecilAtas=1;
        this.PdptKecilBawah=3;
        this.PdptBesarAtas=5;
        this.PdptBesarBawah=2;
        this.PjmSedikitAtas=5;
        this.PjmSedikitBawah=11;
        this.PjmBanyakAtas=13;
        this.PjmBanyakBawah=8;
        this.WktSebentarAtas=6;
        this.WktSebentarBawah=12;
        this.WktLamaAtas=24;
        this.WktLamaBawah=10;
        this.BobotRendah=50;
        this.BobotSedang=75;
        this.BobotTinggi=90;
    }
    public double GetPdptKA(){
        return this.PdptKecilAtas;
    }
    public double GetPdptKB(){
        return this.PdptKecilBawah;
    }
    public double GetPdptBA(){
        return this.PdptBesarAtas;
    }
    public double GetPdptBB(){
        return this.PdptBesarBawah;
    }
    public double GetPjmKA(){
        return this.PjmSedikitAtas;
    }
    public double GetPjmKB(){
        return this.PjmSedikitBawah;
    }
    public double GetPjmBA(){
        return this.PjmBanyakAtas;
    }
    public double GetPjmBB(){
        return this.PjmBanyakBawah;
    }
    public double GetWktKA(){
        return this.WktSebentarAtas;
    }
    public double GetWktKB(){
        return this.WktSebentarBawah;
    }
    public double GetWktBA(){
        return this.WktLamaAtas;
    }
    public double GetWktBB(){
        return this.WktLamaBawah;
    }
    
    public void setPdptKA(double x){
        this.PdptKecilAtas = x;
    }
    public void setPdptKB(double x){
        this.PdptKecilBawah = x;
    }
    public void setPdptBA(double x){
        this.PdptBesarAtas = x;
    }
    public void setPdptBB(double x){
        this.PdptBesarBawah = x;
    }
    public void setPjmKA(double x){
        this.PjmSedikitAtas = x;
    }
    public void setPjmKB(double x){
        this.PjmSedikitBawah = x;
    }
    public void setPjmBA(double x){
        this.PjmBanyakAtas = x;
    }
    public void setPjmBB(double x){
        this.PjmBanyakBawah = x;
    }
    public void setWktKA(double x){
        this.WktSebentarAtas = x;
    }
    public void setWktKB(double x){
        this.WktSebentarBawah = x;
    }
    public void setWktBA(double x){
        this.WktLamaAtas = x;
    }
    public void setWktBB(double x){
        this.WktLamaBawah = x;
    }
    
    public double GetRendah(){
        return this.BobotRendah;
    }
    public double GetSedang(){
        return this.BobotSedang;
    }
    public double GetTinggi(){
        return this.BobotTinggi;
    }
    public void setRendah(double x){
        this.BobotRendah = x;
    }
    public void setSedang(double x){
        this.BobotSedang = x;
    }
    public void setTinggi(double x){
        this.BobotTinggi = x;
    }
    
    public double PdptKecil(double x){
        double y;
        y = HitungBawah(x,this.PdptKecilBawah,this.PdptKecilAtas);
    return y;
    }
    
    public double PdptBesar(double x){
        double y;
        y = HitungAtas(x,this.PdptBesarBawah,this.PdptBesarAtas);
    return y;
    }
    
    public double PjmSedikit(double x){
        double y;
        y = HitungBawah(x,this.PjmSedikitBawah,this.PjmSedikitAtas);
    return y;
    }
    
    public double PjmBanyak(double x){
        double y;
        y = HitungAtas(x,this.PjmBanyakBawah,this.PjmBanyakAtas);
    return y;
    }
    
    public double WktSebentar(double x){
        double y;
        y = HitungBawah(x,this.WktSebentarBawah,this.WktSebentarAtas);
    return y;
    }
    
    public double WktLama(double x){
        double y;
        y = HitungAtas(x,this.WktLamaBawah,this.WktLamaAtas);
    return y;
    }
    
    private double HitungBawah(double x, double BatasBawah, double BatasAtas){
        double y;
            if(x<BatasAtas) y = 1;
            else if (x>BatasBawah) y = 0;
            else y = (BatasBawah-x)/(BatasBawah-BatasAtas);
        return y;
    }
    
    private double HitungAtas(double x, double BatasBawah, double BatasAtas){
        double y;
            if(x>BatasAtas) y = 1;
            else if(x<BatasBawah) y = 0;
            else y = (x-BatasBawah)/(BatasAtas-BatasBawah);
        return y;
    }
}


