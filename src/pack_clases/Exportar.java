
package pack_clases;

public class Exportar {
    String Empleado;
    String Empresa;
    String Producto;
    String Fecha;

    public Exportar() {
    }

    public Exportar(String Empleado, String Empresa, String Producto, String Fecha) {
        this.Empleado = Empleado;
        this.Empresa = Empresa;
        this.Producto = Producto;
        this.Fecha = Fecha;
    }

    public String getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(String Empleado) {
        this.Empleado = Empleado;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
}
