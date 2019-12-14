
package pack_mantenimiento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pack_clases.Importar;
import static pack_mantenimiento.frmExportar.btnEmpleado;
import static pack_mantenimiento.frmExportar.btnEmpresa;
import static pack_mantenimiento.frmExportar.btnProducto;
public class frmImportar extends javax.swing.JFrame {
String Ruta="C:\\Users\\GLADYS TAES\\Desktop\\Importar.txt";
    DefaultTableModel modelo = new DefaultTableModel();
private void Columnas_Exportar(){
   modelo.addColumn("Empleado");
   modelo.addColumn("Empresa");
   modelo.addColumn("Producto");
   modelo.addColumn("Fecha");
   tbMantenimiento.setModel(modelo);
}
private void vaciar_archivo(){
        try{
            File archivo = new File(Ruta);
            if (archivo.exists()){
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("");
                bw.close();
            }else{
                JOptionPane.showMessageDialog(null, 
                        "Ruta no valida del archivo");
            }                                              
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, 
                    "Error Leer Fichero: " + ex.getMessage());
        }
        }
        private void guardaTabla(){
        try {

            File archivo = new File(Ruta);
            BufferedWriter bfw = new BufferedWriter(new FileWriter(archivo));

            for (int i = 0 ; i < tbMantenimiento.getRowCount(); i++) 
            {
                for(int j = 0 ; j < tbMantenimiento.getColumnCount();j++) 
                {
                    bfw.write((String)(tbMantenimiento.getValueAt(i,j)));
                    if (j < tbMantenimiento.getColumnCount() -1) { 
                        bfw.write(";");
                    }
                }
                bfw.newLine(); //inserta nueva linea.
            }

            bfw.close(); //cierra archivo!
            System.out.println("El archivo fue salvado correctamente!");
        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
        }
    }
        private void llenarTabla(){
        try{
            File archivo = new File(Ruta);
            if (archivo.exists()){
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                
                while((linea=br.readLine())!=null){
                    StringTokenizer st = new StringTokenizer(linea, ";");
                    String Empleado = st.nextToken().trim();
                    String Empresa = st.nextToken().trim();
                    String Producto = st.nextToken().trim();
                    String Fecha = st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                      Empleado,Empresa,Producto,Fecha 
                    };
                    modelo.addRow(obj);
                 }
                 //liberar recursos
                 br.close();
                                               
            }else{
                JOptionPane.showMessageDialog(null, 
                        "Ruta no valida del archivo");
            }
                                              
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, 
                    "Error Leer Fichero: " + ex.getMessage());
        }
    }
        private void enviarFichero(){
        /*atrapar posibles errores*/
        try{
            FileWriter fw;
            PrintWriter pw;
            
            //crear el archivo
            fw = new FileWriter(Ruta, true);
            //escribir el archivo
            pw = new PrintWriter(fw);
            //enviar datos al archivo
            Importar obj = new Importar();

            obj.setEmpleado(btnEmpleado.getText());
            obj.setEmpresa(btnEmpresa.getText());
            obj.setProducto(btnProducto.getText());
            obj.setFecha(txtFecha.getText());
            pw.println(
                    obj.getEmpleado()+ ";" + 
                    obj.getEmpresa()+ ";" + 
                    obj.getProducto()+ ";" +
                    obj.getFecha());
            //liberar buffer
            pw.close();
            //envia mensaje de exito
            JOptionPane.showMessageDialog(null, "Empleado Registrado");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error Fichero:\n" +
                    ex.getMessage() );
        }
    }
    private int Comprobar_datos(){
    if(btnEmpleado.getText()== "Seleccione" || btnEmpresa.getText()== "Seleccione" || btnProducto.getText()== "Seleccione" || txtFecha.getText().length()==0)return 0;
    else return 1;
    } 
    private void Habilitar_Botones(){
    btnNuevo.setEnabled(false);
    btnGrabar.setEnabled(true);
    btnCancelar.setEnabled(true);
    btnActualizar.setEnabled(false);
    btnEliminar.setEnabled(false);
    btnCerrar.setEnabled(false);
    }
    private void Deshabilitar_Botones(){
    btnNuevo.setEnabled(true);
    btnGrabar.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnActualizar.setEnabled(true);
    btnEliminar.setEnabled(true);
    btnCerrar.setEnabled(true);
    }
    private void Habiliar_Textos(){
    btnEmpleado.setEnabled(true);
    btnEmpresa.setEnabled(true);
    btnProducto.setEnabled(true);
    txtFecha.setEnabled(true);
    }
    private void Deshabilitar_Textos(){
    btnEmpleado.setEnabled(false);
    btnEmpresa.setEnabled(false);
    btnProducto.setEnabled(false);
    txtFecha.setEnabled(false);
    }
    private void Limpiar(){
    btnEmpleado.setEnabled(true);
    btnEmpresa.setEnabled(true);
    btnProducto.setEnabled(true);
    txtFecha.setText(null);
    btnEmpleado.requestFocus();
    }
    public frmImportar() {
        initComponents();
                Columnas_Exportar();
        Deshabilitar_Textos();
        Deshabilitar_Botones();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProducto = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimiento = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnGrabar = new javax.swing.JButton();
        btnEmpleado = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEmpresa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProducto.setText("Seleccione");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        tbMantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMantenimientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMantenimiento);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Empleado");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setText("Empresa");

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Producto ");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha");

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnEmpleado.setText("Seleccione");
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEmpresa.setText("Seleccione");
        btnEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFecha)
                                    .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGrabar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCerrar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpleado)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpresa)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProducto)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGrabar)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        frm_Lista_de_Productos_02 obj = new frm_Lista_de_Productos_02();
        obj.setVisible(true);
    }//GEN-LAST:event_btnProductoActionPerformed

    private void tbMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMantenimientoMouseClicked
        if(btnGrabar.isEnabled())
        {btnActualizar.setEnabled(false);}
        else
        {
            Habiliar_Textos();
            int a=tbMantenimiento.getSelectedRow();
            String b = (String) tbMantenimiento.getModel().getValueAt(a, 0);
            String c = (String) tbMantenimiento.getModel().getValueAt(a, 1);
            String d = (String) tbMantenimiento.getModel().getValueAt(a, 2);
            String e = (String) tbMantenimiento.getModel().getValueAt(a, 3);
            btnEmpleado.setText(b);
            btnEmpresa.setText(c);
            btnProducto.setText(d);
            txtFecha.setText(e);
        }
    }//GEN-LAST:event_tbMantenimientoMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int z=Comprobar_datos();
        if(z==1){
            int a=tbMantenimiento.getSelectedRow();
            tbMantenimiento.setValueAt(btnEmpleado.getText(), a, 0);
            tbMantenimiento.setValueAt(btnEmpresa.getText(), a, 1);
            tbMantenimiento.setValueAt(btnProducto.getText(), a, 2);
            tbMantenimiento.setValueAt(txtFecha.getText(), a, 3);}
        else JOptionPane.showMessageDialog(null, "Compuebe Datos");
        vaciar_archivo();
        guardaTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tbMantenimiento.getModel(); //TableProducto es el nombre de mi tabla ;)
        dtm.removeRow(tbMantenimiento.getSelectedRow());
        vaciar_archivo();
        guardaTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Desea cerrar la ventana actual?");
        if(a==0)dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Habiliar_Textos();
        Habilitar_Botones();
        Limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        int a=Comprobar_datos();
        if(a==1){
            enviarFichero();
            Deshabilitar_Textos();
            Deshabilitar_Botones();
            modelo.setRowCount(0);
            llenarTabla();}
        else JOptionPane.showMessageDialog(null, "Compuebe Datos");
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        frm_Lista_de_Empleados_02 obj = new frm_Lista_de_Empleados_02();
        obj.setVisible(true);
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Deshabilitar_Textos();
        Deshabilitar_Botones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaActionPerformed
        frm_Lista_Proveedores_03 obj = new frm_Lista_Proveedores_03();
        obj.setVisible(true);
    }//GEN-LAST:event_btnEmpresaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmImportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmImportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmImportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmImportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmImportar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnEmpleado;
    public static javax.swing.JButton btnEmpresa;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMantenimiento;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
