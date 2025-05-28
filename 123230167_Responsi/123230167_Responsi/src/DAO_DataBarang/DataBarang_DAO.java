/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_DataBarang;
import DAO_Implement.DataBarang_Implement;
import java.sql.*;
import java.util.*;
import koneksi.Connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lab Informatika
 */
public class DataBarang_DAO implements DataBarang_Implement {
    Connection connection;
    
    final String query_select = "SELECT * FROM barang";
    final String query_create = "INSERT INTO barang (nama_customer, barang, harga_barang, cicilan, bunga_per_bulan, angsuran, total_pembayaran) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String query_edit = "UPDATE barang SET (nama_customer=?, barang=?, harga_barang=?, cicilan=?, bunga_per_bulan=?, angsuran=?, total_pembayaran=? WHERE id_customer=?)";
    final String query_delete = "DELETE FROM barang WHERE id_customer=?";
    
    public DataBarang_DAO() {
        connection = Connector.connection();
    }

    @Override
    public void create(DataBarang barang) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(query_create, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, barang.getNama_customer());
            statement.setString(2, barang.getBarang());
            statement.setDouble(3, barang.getHarga_barang());
            statement.setInt(4, barang.getCicilan());
            statement.setDouble(5, barang.getBunga_per_bulan());
            statement.setDouble(6, barang.getAngsuran());
            statement.setDouble(7, barang.getTotal_pembayaran());
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()) {
                barang.setId_customer(rs.getInt(1));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void edit(DataBarang barang) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(query_edit);
            statement.setString(1, barang.getNama_customer());
            statement.setString(2, barang.getBarang());
            statement.setDouble(3, barang.getHarga_barang());
            statement.setInt(4, barang.getCicilan());
            statement.setDouble(5, barang.getBunga_per_bulan());
            statement.setDouble(6, barang.getAngsuran());
            statement.setDouble(7, barang.getTotal_pembayaran());
            statement.setInt(8, barang.getId_customer());
            statement.executeUpdate();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id_customer) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(query_delete);
            
            statement.setInt(1, id_customer);
            statement.executeUpdate();
        } catch(SQLException ex) {
           ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataBarang> getAll() {
        List<DataBarang> data = null;
        
        try {
            data = new ArrayList<DataBarang>();
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(query_select);
            while(rs.next()) {
                DataBarang barang = new DataBarang();
                
                barang.setId_customer(rs.getInt("id_customer"));
                barang.setNama_customer(rs.getString("nama_customer"));
                barang.setBarang(rs.getString("barang"));
                barang.setHarga_barang(rs.getDouble("harga_barang"));
                barang.setCicilan(rs.getInt("cicilan"));
                barang.setBunga_per_bulan(rs.getDouble("bunga_per_bulan"));
                barang.setAngsuran(rs.getDouble("angsuran"));
                barang.setTotal_pembayaran(rs.getDouble("total_pembayaran"));
                
                data.add(barang);
            }
        } catch(SQLException ex) {
            Logger.getLogger(DataBarang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
