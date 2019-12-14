package pack_mantenimiento;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pack_clases.Cliente;
public class frm_mante_Empleados extends javax.swing.JFrame {
    String Ruta="C:\\Users\\GLADYS TAES\\Desktop\\Empleados.txt";
    DefaultTableModel modelo = new DefaultTableModel();
        private void ColumnasTablaCliente(){
        modelo.addColumn("codigo");
        modelo.addColumn("nombre");
        modelo.addColumn("apellido");
        modelo.addColumn("dni");
        modelo.addColumn("sexo");
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
                    String cod = st.nextToken().trim();
                    String nom = st.nextToken().trim();
                    String ape = st.nextToken().trim();
                    String dni = st.nextToken().trim();
                    String sex = st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                      cod, nom, ape, dni, sex  
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
            Cliente obj = new Cliente();
            obj.setCodigo(txtCodigo.getText());
            obj.setNombre(txtNombre.getText());
            obj.setApellido(txtApellido.getText());
            obj.setSexo(cboSexo.getSelectedItem().toString());
            obj.setDNI((txtDNI.getText()));
            pw.println(obj.getNombre() + ";" + 
                    obj.getApellido() + ";" + 
                    obj.getDNI() + ";" +
                    obj.getCodigo() + ";" +
                    obj.getSexo() );
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
    if(txtNombre.getText().length()==0 || txtApellido.getText().length()==0 || txtCodigo.getText().length()==0 || txtDNI.getText().length()==0 ||
            cboSexo.getSelectedItem() == "Seleccione")return 0;
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
    txtCodigo.setEnabled(true);
    txtNombre.setEnabled(true);
    txtApellido.setEnabled(true);
    txtDNI.setEnabled(true);
    cboSexo.setEnabled(true);
    }
    private void Deshabilitar_Textos(){
    txtCodigo.setEnabled(false);
    txtNombre.setEnabled(false);
    txtApellido.setEnabled(false);
    txtDNI.setEnabled(false);
    cboSexo.setEnabled(false);
    }
    private void Limpiar(){
    txtCodigo.setText(null);
    txtNombre.setText(null);
    txtApellido.setText(null);
    txtDNI.setText(null);
    cboSexo.setSelectedIndex(0);
    txtNombre.requestFocus();
    }
    public void Sexo(){
    cboSexo.addItem("Seleccione");
    cboSexo.addItem("Masculino");
    cboSexo.addItem("Femenino");
    }
    public frm_mante_Empleados() {
        initComponents();
        Sexo();
        Deshabilitar_Textos();
        Deshabilitar_Botones();
        ColumnasTablaCliente();
        llenarTabla();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboSexo = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimiento = new javax.swing.JTable();
        btnPDF = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("DNI");

        jLabel4.setText("Codigo");

        jLabel5.setText("Sexo");

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

        btnPDF.setText("Exportar PDF");

        btnExcel.setText("Exportar Excel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtApellido)
                                            .addComponent(txtDNI)
                                            .addComponent(cboSexo, 0, 399, Short.MAX_VALUE)
                                            .addComponent(txtNombre)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
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
                                .addGap(0, 274, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGrabar)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPDF)
                    .addComponent(btnExcel))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        else{
    Habiliar_Textos();
    int a=tbMantenimiento.getSelectedRow();
    String b = (String) tbMantenimiento.getModel().getValueAt(a, 0);
    String c = (String) tbMantenimiento.getModel().getValueAt(a, 1);
    String d = (String) tbMantenimiento.getModel().getValueAt(a, 2);
    String e = (String) tbMantenimiento.getModel().getValueAt(a, 3);
    String f = (String) tbMantenimiento.getModel().getValueAt(a, 4);
    txtNombre.setText(b);
    txtApellido.setText(c);
    txtDNI.setText(d);
    txtCodigo.setText(e);
    cboSexo.setSelectedItem(f);}
    }//GEN-LAST:event_tbMantenimientoMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    int z=Comprobar_datos();
    if(z==1){
    int a=tbMantenimiento.getSelectedRow();
    tbMantenimiento.setValueAt(txtNombre.getText(), a, 0);
    tbMantenimiento.setValueAt(txtApellido.getText(), a, 1);
    tbMantenimiento.setValueAt(txtDNI.getText(), a, 2);
    tbMantenimiento.setValueAt(txtCodigo.getText(), a, 3);
    tbMantenimiento.setValueAt(cboSexo.getSelectedItem(), a, 4);}
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
            java.util.logging.Logger.getLogger(frm_mante_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_mante_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_mante_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_mante_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_mante_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPDF;
    private javax.swing.JComboBox<String> cboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMantenimiento;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
