package pack_clases;

import javax.swing.JOptionPane;
import pack_mantenimiento.frm_Login;
import pack_mantenimiento.frm_Principal;

public class Login {
    frm_Login login = new frm_Login();
    String res;
    public void Validar_Usuario(String usuarios[],String user,String pwd,int intentos){
    boolean encontrado = false;
    for (int i=0;i<usuarios.length;i++){
    if(usuarios[i].equalsIgnoreCase(user)&&usuarios[i+1].equals(pwd)){
    res = "bienvenido "+user;
    encontrado=true;

        JOptionPane.showMessageDialog(null, res, "Inicio de sesion", JOptionPane.INFORMATION_MESSAGE);
        
       new frm_Principal().setVisible(true);
       intentos = 0;
       break;
    }
    }
    if(encontrado==false){
    res="Clave y/o usuario incorrecto(s) van "+intentos+" intentos fallidos";
    JOptionPane.showMessageDialog(null, res, "Inicio de sesion", JOptionPane.ERROR_MESSAGE);
    }
    if(intentos>2){
    JOptionPane.showMessageDialog(null, "3 intentos fallidos, el programa se cerrara", "Inicio de sesion", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
    }
    }
}
