/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lab Informatika
 */
public class DataBarang {
    private int id_customer;
    private String nama_customer;
    private String barang;
    private double harga_barang;
    private int cicilan;
    private double bunga_per_bulan;
    private double angsuran;
    private double total_pembayaran;

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public double getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(double harga_barang) {
        this.harga_barang = harga_barang;
    }

    public int getCicilan() {
        return cicilan;
    }

    public void setCicilan(int cicilan) {
        this.cicilan = cicilan;
    }

    public double getBunga_per_bulan() {
        return bunga_per_bulan;
    }

    public void setBunga_per_bulan(double bunga_per_bulan) {
        this.bunga_per_bulan = bunga_per_bulan;
    }

    public double getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(double angsuran) {
        this.angsuran = angsuran;
    }

    public double getTotal_pembayaran() {
        return total_pembayaran;
    }

    public void setTotal_pembayaran(double total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }
}
