package pack_clases;

public class Proveedor {
    String Empresa;
    int RUC;
    String Direccion;
    String Telefono;
    String Tipo_de_Proveedor;
    String Tipo;

    public Proveedor() {
    }

    public Proveedor(String Empresa, int RUC, String Direccion, String Telefono, String Tipo_de_Proveedor, String Tipo) {
        this.Empresa = Empresa;
        this.RUC = RUC;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Tipo_de_Proveedor = Tipo_de_Proveedor;
        this.Tipo = Tipo;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public int getRUC() {
        return RUC;
    }

    public void setRUC(int RUC) {
        this.RUC = RUC;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTipo_de_Proveedor() {
        return Tipo_de_Proveedor;
    }

    public void setTipo_de_Proveedor(String Tipo_de_Proveedor) {
        this.Tipo_de_Proveedor = Tipo_de_Proveedor;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
       
}
