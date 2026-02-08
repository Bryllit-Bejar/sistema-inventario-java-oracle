package Negocio;

import Datos.Producto;
import Datos.ProductoDAO;
import conexion.Conexion;
import java.sql.Connection;
import javax.swing.*;

public class Producto_Neg {
    private String resultado="";
    private ProductoDAO pro_dao=new ProductoDAO();
    
    public String agregarProducto(Producto pro){
        Connection con = Conexion.establecerConexion();
        try {
            resultado = pro_dao.agregarProducto(con, pro);
        } catch (Exception e) {
            resultado = resultado + " " + e.getMessage();
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                resultado = resultado + " " + e.getMessage();
            }
        }
        return resultado;
    }
    
    public String modificarProducto(Producto pro){
        Connection con = Conexion.establecerConexion();
        try {
            resultado = pro_dao.modificarProducto(con, pro);
        } catch (Exception e) {
            resultado = resultado + " " + e.getMessage();
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                resultado = resultado + " " + e.getMessage();
            }
        }
        return resultado;
    }
    
    public String eliminarProducto(String cod_prod){
        Connection con = Conexion.establecerConexion();
        try {
            resultado = pro_dao.eliminarProducto(con, cod_prod);
        } catch (Exception e) {
            resultado = resultado + " " + e.getMessage();
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                resultado = resultado + " " + e.getMessage();
            }
        }
        return resultado;
    }
    
    public void listarProducto(JTable tabla){
        Connection con = Conexion.establecerConexion();
        pro_dao.listarProducto(con, tabla);
        try {
            con.close();
        } catch (Exception e) {
        }
    }
}