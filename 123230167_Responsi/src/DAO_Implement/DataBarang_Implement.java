/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Implement;
import java.util.List;
import model.*;
/**
 *
 * @author Lab Informatika
 */
public interface DataBarang_Implement {
    public void create(DataBarang barang);
    public void edit(DataBarang barang);
    public void delete(int id_customer);
    public List<DataBarang> getAll();
}
