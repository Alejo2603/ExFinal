
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
import pack_clases.Proveedor;

public class frmProveedor extends javax.swing.JFrame {
    String Ruta="C:\\Users\\GLADYS TAES\\Desktop\\Proveedor.txt";
    public void Llenar_Combo_Proveedor(){
    cmbTipo_proveedor.addItem("Seleccione");
    cmbTipo_proveedor.addItem("Productos");
    cmbTipo_proveedor.addItem("Servicios");
    }

    DefaultTableModel modelo = new DefaultTableModel();
        private void ColumnasTablaCliente(){
        modelo.addColumn("Empresa");
        modelo.addColumn("RUC");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Tipo de Proveedor");
        modelo.addColumn("Tipo");
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
                    String empresa = st.nextToken().trim();
                    String RUC = st.nextToken().trim();
                    String direccion = st.nextToken().trim();
                    String telefono = st.nextToken().trim();
                    String tipo_proveedor = st.nextToken().trim();
                    String tipo = st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                      empresa,RUC,direccion,telefono,tipo_proveedor,tipo 
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
            Proveedor obj = new Proveedor();
            obj.setEmpresa(txtEmpresa.getText());
            obj.setRUC(Integer.parseInt(txtRUC.getText()));
            obj.setDireccion(txtDireccion.getText());
            obj.setTelefono((txtTelefono.getText()));
            obj.setTipo_de_Proveedor(cmbTipo_proveedor.getSelectedItem().toString());
            obj.setTipo(cmbtipo.getSelectedItem().toString());
            pw.println(obj.getEmpresa()+ ";" + 
                    obj.getRUC()+ ";" + 
                    obj.getDireccion()+ ";" +
                    obj.getTelefono()+ ";" +
                    obj.getTipo_de_Proveedor()+";"+
                    obj.getTipo()
                    );
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
    if(txtDireccion.getText().length()==0 || txtEmpresa.getText().length()==0 || txtRUC.getText().length()==0 || txtTelefono.getText().length()==0 ||
            cmbTipo_proveedor.getSelectedItem() == "Seleccione"||cmbtipo.getSelectedItem() == "Seleccione")return 0;
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
    txtEmpresa.setEnabled(true);
    txtRUC.setEnabled(true);
    txtDireccion.setEnabled(true);
    txtTelefono.setEnabled(true);
    cmbTipo_proveedor.setEnabled(true);
    cmbtipo.setEnabled(true);
    }
    private void Deshabilitar_Textos(){
    txtEmpresa.setEnabled(false);
    txtRUC.setEnabled(false);
    txtDireccion.setEnabled(false);
    txtTelefono.setEnabled(false);
    cmbTipo_proveedor.setEnabled(false);
    cmbtipo.setEnabled(false);
    }
    private void Limpiar(){
    txtEmpresa.setText(null);
    txtRUC.setText(null);
    txtDireccion.setText(null);
    txtTelefono.setText(null);
    cmbTipo_proveedor.setSelectedIndex(0);
    cmbtipo.setSelectedIndex(0);
    }
    public frmProveedor() {
    initComponents();
    Llenar_Combo_Proveedor();
            Deshabilitar_Textos();
        Deshabilitar_Botones();
        ColumnasTablaCliente();
        llenarTabla();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimiento = new javax.swing.JTable();
        cmbTipo_proveedor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbtipo = new javax.swing.JComboBox<>();
        txtRUC = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Empresa:");

        jLabel2.setText("R.U.C");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Telefono:");

        jLabel5.setText("Tipo de proveedor");

        txtEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaActionPerformed(evt);
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

        cmbTipo_proveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipo_proveedorItemStateChanged(evt);
            }
        });

        jLabel6.setText("Seleccione Tipo de Proveedor");

        cmbtipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtipoItemStateChanged(evt);
            }
        });

        txtRUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRUCActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbtipo, 0, 203, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(txtRUC, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(txtEmpresa)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(cmbTipo_proveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
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
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTipo_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGrabar)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipo_proveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipo_proveedorItemStateChanged
     if(cmbTipo_proveedor.getSelectedItem()=="Seleccione"){
          jLabel6.setText("Seleccione Tipo de Proveedor");
          cmbtipo.removeAllItems();
          cmbtipo.addItem("Seleccione Tipo de Proveedor");
     }
     else if(cmbTipo_proveedor.getSelectedItem()=="Servicios"){
         jLabel6.setText("Tipo de Servicio");
         cmbtipo.removeAllItems();
         cmbtipo.addItem("Servicio A");
         cmbtipo.addItem("Servicio B");
         cmbtipo.addItem("Servicio C");
         cmbtipo.addItem("Servicio D");
     }
     else{
        jLabel6.setText("Tipo de Producto");
        cmbtipo.removeAllItems();
         cmbtipo.addItem("Producto A");
         cmbtipo.addItem("Producto B");
         cmbtipo.addItem("Producto C");
         cmbtipo.addItem("Producto D");
     }
    }//GEN-LAST:event_cmbTipo_proveedorItemStateChanged

    private void txtEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaActionPerformed

    private void txtRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRUCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRUCActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int z=Comprobar_datos();
        if(z==1){
            int a=tbMantenimiento.getSelectedRow();
            tbMantenimiento.setValueAt(txtEmpresa.getText(), a, 0);
            tbMantenimiento.setValueAt(txtRUC.getText(), a, 1);
            tbMantenimiento.setValueAt(txtDireccion.getText(), a, 2);
            tbMantenimiento.setValueAt(txtTelefono.getText(), a, 3);
            tbMantenimiento.setValueAt(cmbTipo_proveedor.getSelectedItem(), a, 4);
            tbMantenimiento.setValueAt(cmbtipo.getSelectedItem(), a, 5);
        }
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Deshabilitar_Textos();
        Deshabilitar_Botones();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
    String f = (String) tbMantenimiento.getModel().getValueAt(a, 4);
    String g = (String) tbMantenimiento.getModel().getValueAt(a, 5);
    txtEmpresa.setText(b);
    txtRUC.setText(c);
    txtDireccion.setText(d);
    txtTelefono.setText(e);
    cmbTipo_proveedor.setSelectedItem(f);
    cmbtipo.setSelectedItem(g);}
    }//GEN-LAST:event_tbMantenimientoMouseClicked

    private void cmbtipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtipoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtipoItemStateChanged

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbTipo_proveedor;
    private javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMantenimiento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
