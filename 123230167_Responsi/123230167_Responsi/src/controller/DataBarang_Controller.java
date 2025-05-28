/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAO_DataBarang.DataBarang_DAO;
import DAO_Implement.DataBarang_Implement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.*;
import view.MainView;
/**
 *
 * @author Lab Informatika
 */
public class DataBarang_Controller {
    MainView form;
    DataBarang_Implement implement_dataBarang;
    List<DataBarang> data;
    
    private int selectedId = -1;
    
    public DataBarang_Controller(MainView form) {
        this.form = form;
        implement_dataBarang = new DataBarang_DAO();
        data = implement_dataBarang.getAll();
    }
    
    public void isiTabel() {
        data = implement_dataBarang.getAll();
        ModelTabelDataBarang modelTable = new ModelTabelDataBarang(data);
        form.getTableData().setModel(modelTable);
    }
    
    public void create() {
        DataBarang barang = new DataBarang();
        
        barang.setNama_customer(form.getjTextNama().getText());
        
        // Nama Barang
        String namaBarang = (String) form.getjComboBoxBarang().getSelectedItem();
        barang.setBarang(namaBarang);
        
        // Harga Barang
        if("Kulkas".equals(barang.getBarang())) {
            barang.setHarga_barang(4800000);
        } if("TV".equals(barang.getBarang())) {
            barang.setHarga_barang(6000000);
        } else {
            barang.setHarga_barang(4800000);
        }
        
        // Cicilan
        if(form.getJ3bulan().isSelected()) {
            barang.setCicilan(3);
        } if(form.getJ6bulan().isSelected()) {
            barang.setCicilan(6);
        } else {
            barang.setCicilan(12);
        }
        
        double bunga = ((double) (1.5 / 100) * hargaBarang);
        double bungaPerbulan = ((double) (bunga / 100) * hargaBarang);
        double angsuran = ((double) (hargaBarang / cicilan) + bungaPerbulan);
        double totalPembayaran = ((double) angsuran * cicilan);
        
        barang.setBunga_per_bulan(bungaPerbulan);
        barang.setAngsuran(angsuran);
        barang.setTotal_pembayaran(totalPembayaran);
        
        implement_dataBarang.create(barang);
    }
    
    public void edit() {
        DataBarang barang = new DataBarang();
        
        barang.setNama_customer(form.getjTextNama().getText());
        
        // Nama Barang
        String namaBarang = (String) form.getjComboBoxBarang().getSelectedItem();
        barang.setBarang(namaBarang);
        
        // Harga Barang
        if("Kulkas".equals(barang.getBarang())) {
            barang.setHarga_barang(4800000);
        } if("TV".equals(barang.getBarang())) {
            barang.setHarga_barang(6000000);
        } else {
            barang.setHarga_barang(4800000);
        }
        
        // Cicilan
        if(form.getJ3bulan().isSelected()) {
            barang.setCicilan(3);
        } if(form.getJ6bulan().isSelected()) {
            barang.setCicilan(6);
        } else {
            barang.setCicilan(12);
        }
        
        double bunga = ((double) (1.5 / 100) * hargaBarang);
        double bungaPerbulan = ((double) (bunga / 100) * hargaBarang);
        double angsuran = ((double) (hargaBarang / cicilan) + bungaPerbulan);
        double totalPembayaran = ((double) angsuran * cicilan);
        
        barang.setBunga_per_bulan(bungaPerbulan);
        barang.setAngsuran(angsuran);
        barang.setTotal_pembayaran(totalPembayaran);
        
        barang.setId_customer(selectedId);
        
        implement_dataBarang.edit(barang);
    }
    
    public void delete() {
        int selectedRow = form.getTableData().getSelectedRow();
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(form, "Tolong Pilih Data yang Ingin Dihapus!");
            return;
        } else {
            ModelTabelDataBarang model = (ModelTabelDataBarang) form.getTableData().getModel();
            DataBarang barang = model.getData().get(selectedRow);
            int id = barang.getId_customer();
            
            int confirm = JOptionPane.showConfirmDialog(form, "Yakin Ingin Menghapus Data Ini?");
            if(confirm == JOptionPane.YES_OPTION) {
                implement_dataBarang.delete(id);
                JOptionPane.showMessageDialog(form, "Data Berhasil Dihapus");
            }
        }
    }
    
    public void selectData() {
        int selectedRow = form.getTableData().getSelectedRow();
        ModelTabelDataBarang model = (ModelTabelDataBarang) form.getTableData().getModel();
        if(selectedRow != -1) {
            DataBarang barang = model.getData().get(selectedRow);
            
            selectedId = barang.getId_customer();
            
            form.getjTextNama().setText(barang.getNama_customer());
            form.getjComboBoxBarang().setSelectedItem(barang.getBarang());
        }
    }
}
