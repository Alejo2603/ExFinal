
package pack_clases;

public class Cliente {
    String Codigo;
    String Nombre;
    String Apellido;
    String Sexo;
    String DNI;
    public Cliente() {
    }
    public Cliente(String Codigo, String Nombre, String Apellido, String Sexo, String DNI) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Sexo = Sexo;
        this.DNI = DNI;
    }
    public String getCodigo() {
        return Codigo;
    }
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
}
