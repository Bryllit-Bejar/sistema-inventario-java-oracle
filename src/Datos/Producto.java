package Datos;

public class Producto {
    private String cod_prod;
    private String descripcion;
    private int stock;
    private double precio;
    
    public Producto() {
    }
    
    public Producto(String cod_prod, String descripcion, int stock, double precio) {
        this.cod_prod=cod_prod;
        this.descripcion=descripcion;
        this.stock=stock;
        this.precio=precio;
    }
    
    public String getCodProd(){
        return cod_prod;
    }
    
    public void setCodProd(String cod_prod){
        this.cod_prod=cod_prod;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    public int getStock(){
        return stock;
    }
    
    public void setStock(int stock){
        this.stock=stock;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public void setPrecio(double precio){
        this.precio=precio;
    }
    
    @Override
    public String toString(){
        return "PRODUCTOS{" +
                ", cod_prod=" + cod_prod +
                ", descripcion=" + descripcion +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
}