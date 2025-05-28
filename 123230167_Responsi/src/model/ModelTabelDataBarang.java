/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Lab Informatika
 */
public class ModelTabelDataBarang extends AbstractTableModel{
    List<DataBarang> data;
    
    private final String[] columnNames = {
        "Nama Customer",
        "Barang",
        "Harga Barang",
        "Cicilan",
        "Bunga Perbulan",
        "Angsuran Perbulan",
        "Total Pembayaran"
    };
    
    public ModelTabelDataBarang(List<DataBarang> data) {
        this.data = data;
    }
    
    public List<DataBarang> getData() {
        return data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Nama Customer";
            case 1:
                return "Barang";
            case 2:
                return "Harga Barang";
            case 3:
                return "Cicilan";
            case 4:
                return "Bunga Perbulan";
            case 5:
                return "Angsuran Perbulan";
            case 6:
                return "Total Pembayaran";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return data.get(row).getNama_customer();
            case 1:
                return data.get(row).getBarang();
            case 2:
                return data.get(row).getHarga_barang();
            case 3:
                return String.format("%% bulan", data.get(row).getCicilan());
            case 4:
                return data.get(row).getBunga_per_bulan();
            case 5:
                return data.get(row).getAngsuran();
            case 6:
                return data.get(row).getTotal_pembayaran();
            default:
                return null;
        }
    }
}
