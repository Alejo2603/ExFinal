package pack_clases;

public class Producto {
    String Tipo;
    String Producto;
    String Precio_Unitario;
    String Cantidad;
    String Proveedor;
    public Producto() {
    }

    public Producto(String Tipo, String Producto, String Precio_Unitario, String Cantidad, String Proveedor) {
        this.Tipo = Tipo;
        this.Producto = Producto;
        this.Precio_Unitario = Precio_Unitario;
        this.Cantidad = Cantidad;
        this.Proveedor = Proveedor;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getPrecio_Unitario() {
        return Precio_Unitario;
    }

    public void setPrecio_Unitario(String Precio_Unitario) {
        this.Precio_Unitario = Precio_Unitario;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }
    
}
