package Datos;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductoDAO {
    private String mensaje = "";
    
    public String agregarProducto(Connection con, Producto prod){
        PreparedStatement pst = null;
        
        String sql = "INSERT INTO PRODUCTOS (COD_PROD, DESCRIPCION, STOCK, PRECIO)"
                + "VALUES (?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, prod.getCodProd());
            pst.setString(2, prod.getDescripcion());
            pst.setInt(3, prod.getStock());
            pst.setDouble(4, prod.getPrecio());
            pst.execute();
            mensaje = "Agregado correctamente";
            pst.close();
        } catch (SQLException e) {
            mensaje="Error al ingresar un Nuevo Registro "+e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarProducto(Connection con, Producto prod){
        PreparedStatement pst = null;

        String sql = "UPDATE PRODUCTOS SET DESCRIPCION=?, STOCK=?, PRECIO=? WHERE COD_PROD=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, prod.getDescripcion());
            pst.setInt(2, prod.getStock());
            pst.setDouble(3, prod.getPrecio());
            pst.setString(4, prod.getCodProd());
            pst.execute();
            mensaje = "Actualizado Correctamente";
            pst.close();
        } catch (SQLException e) {
            mensaje="Error al actualizar el registro "+e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarProducto(Connection con, String cod_prod){
        PreparedStatement pst = null;
            String sql = "DELETE FROM PRODUCTOS WHERE COD_PROD=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cod_prod);
            mensaje = "Eliminado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje="Error al eliminar el registro "+e.getMessage();
        }
        return mensaje;
    }
    
    public void listarProducto(Connection cn, JTable tabla_pro){
        DefaultTableModel modelo;
        String[] columnas={"CODIGO","DESCRIPCION","STOCK","PRECIO"};
        modelo = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM PRODUCTOS";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String[] registro = new String[4];

                registro[0] = rs.getString("COD_PROD");
                registro[1] = rs.getString("DESCRIPCION");
                registro[2] = rs.getString("STOCK");
                registro[3] = rs.getString("PRECIO");
                
                modelo.addRow(registro);
            }
            rs.close();
            st.close();
            
            tabla_pro.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
}