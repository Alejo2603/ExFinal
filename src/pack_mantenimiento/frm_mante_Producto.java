
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
import pack_clases.Producto;

public class frm_mante_Producto extends javax.swing.JFrame {
    String Ruta="C:\\Users\\GLADYS TAES\\Desktop\\Productos.txt";
    DefaultTableModel modelo = new DefaultTableModel();
        private void ColumnasTablaCliente(){
        modelo.addColumn("Producto");
        modelo.addColumn("Tipo");
        modelo.addColumn("PrecioUnitario");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");
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

                    String Producto = st.nextToken().trim();
                    String Tipo = st.nextToken().trim();
                    String Precio_Uni = st.nextToken().trim();
                    String Cantidad = st.nextToken().trim();
                    String Proveedor = st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                      Producto,Tipo,Precio_Uni,Cantidad,Proveedor  
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
            Producto obj = new Producto();

            obj.setProducto(cmbProducto.getSelectedItem().toString());
            obj.setTipo(cmbTipo.getSelectedItem().toString());            
            obj.setPrecio_Unitario(txtPrecio_Unitario.getText());
            obj.setCantidad(txtCantidad.getText());
            obj.setProveedor(btnProveedor.getText());
            pw.println(
                    obj.getProducto()+ ";" + 
                            obj.getTipo()+ ";" + 
                    obj.getPrecio_Unitario()+ ";" +
                    obj.getCantidad()+ ";" +
                    obj.getProveedor());
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
    if(cmbProducto.getSelectedItem() == "Seleccione" || cmbTipo.getSelectedItem() == "Seleccione" || txtCantidad.getText().length()==0 || txtPrecio_Unitario.getText().length()==0 ||
            btnProveedor.getText()== "Añadir")return 0;
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
    cmbTipo.setEnabled(true);
    cmbProducto.setEnabled(true);
    txtCantidad.setEnabled(true);
    txtPrecio_Unitario.setEnabled(true);
    btnProveedor.setEnabled(true);
    }
    private void Deshabilitar_Textos(){
    cmbTipo.setEnabled(false);
    cmbProducto.setEnabled(false);
    txtCantidad.setEnabled(false);
    txtPrecio_Unitario.setEnabled(false);
    btnProveedor.setEnabled(false);
    }
    private void Limpiar(){
    cmbTipo.setSelectedIndex(0);
    cmbProducto.setSelectedIndex(0);
    txtCantidad.setText(null);
    txtPrecio_Unitario.setText(null);
    btnProveedor.setEnabled(true);
    cmbTipo.requestFocus();
    }
    public void Llenar_cmb_Tipo_de_Producto(){
    cmbTipo.addItem("Seleccione");    
    cmbTipo.addItem("Tipo A");
    cmbTipo.addItem("Tipo B");
    cmbTipo.addItem("Tipo C");
    cmbTipo.addItem("Tipo D");
    cmbTipo.addItem("Tipo E");
    }
    public frm_mante_Producto() {
        initComponents();
        Llenar_cmb_Tipo_de_Producto();
        Deshabilitar_Textos();
        Deshabilitar_Botones();
        ColumnasTablaCliente();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        cmbProducto = new javax.swing.JComboBox<>();
        txtPrecio_Unitario = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnProveedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimiento = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo");

        jLabel2.setText("Producto");

        jLabel3.setText("Precio Unitario");

        jLabel4.setText("Cantidad");

        jLabel5.setText("Proveedor");

        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });

        cmbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductoItemStateChanged(evt);
            }
        });

        btnProveedor.setText("Añadir");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGrabar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnActualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(63, 63, 63)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPrecio_Unitario)
                                            .addComponent(txtCantidad)
                                            .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCerrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbProducto, 0, 190, Short.MAX_VALUE)
                                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio_Unitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnProveedor))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGrabar)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
    fmr_Lista_Proveedores obj = new fmr_Lista_Proveedores();
    obj.setVisible(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void cmbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductoItemStateChanged
    
    }//GEN-LAST:event_cmbProductoItemStateChanged

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
    if(cmbTipo.getSelectedItem()=="Tipo A"){
    jLabel2.removeAll();
    jLabel2.setText("Tipo de Producto A");
    cmbProducto.removeAllItems();
    cmbProducto.addItem("Seleccione");
    cmbProducto.addItem("A - Tipo A");
    cmbProducto.addItem("A - Tipo B");
    cmbProducto.addItem("A - Tipo C");
    cmbProducto.addItem("A - Tipo D");
    cmbProducto.addItem("A - Tipo E");
    }
    else if(cmbTipo.getSelectedItem()=="Tipo B"){
    jLabel2.removeAll();
    jLabel2.setText("Tipo de Producto B");
    cmbProducto.removeAllItems();
    cmbProducto.addItem("Seleccione");
    cmbProducto.addItem("B - Tipo A");
    cmbProducto.addItem("B - Tipo B");
    cmbProducto.addItem("B - Tipo C");
    cmbProducto.addItem("B - Tipo D");
    cmbProducto.addItem("B - Tipo E");
    }
    else if(cmbTipo.getSelectedItem()=="Tipo C"){
    jLabel2.removeAll();
    jLabel2.setText("Tipo de Producto C");
    cmbProducto.removeAllItems();
    cmbProducto.addItem("Seleccione");
    cmbProducto.addItem("C - Tipo A");
    cmbProducto.addItem("C - Tipo B");
    cmbProducto.addItem("C - Tipo C");
    cmbProducto.addItem("C - Tipo D");
    cmbProducto.addItem("C - Tipo E");
    }
        else if(cmbTipo.getSelectedItem()=="Tipo D"){
    jLabel2.removeAll();
    jLabel2.setText("Tipo de Producto D");
    cmbProducto.removeAllItems();
    cmbProducto.addItem("Seleccione");
    cmbProducto.addItem("D - Tipo A");
    cmbProducto.addItem("D - Tipo B");
    cmbProducto.addItem("D - Tipo C");
    cmbProducto.addItem("D - Tipo D");
    cmbProducto.addItem("D - Tipo E");
    }
    else if(cmbTipo.getSelectedItem()=="Tipo E"){
    jLabel2.removeAll();
    jLabel2.setText("Tipo de Producto E");
    cmbProducto.removeAllItems();
    cmbProducto.addItem("Seleccione");
    cmbProducto.addItem("E - Tipo A");
    cmbProducto.addItem("E - Tipo B");
    cmbProducto.addItem("E - Tipo C");
    cmbProducto.addItem("E - Tipo D");
    cmbProducto.addItem("E - Tipo E");
    }
    else {
    jLabel2.removeAll();
    jLabel2.setText("Seleccione");
    cmbProducto.removeAllItems();
    cmbProducto.addItem("Seleccione");
    }
    }//GEN-LAST:event_cmbTipoItemStateChanged

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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int z=Comprobar_datos();
        if(z==1){
            int a=tbMantenimiento.getSelectedRow();
            tbMantenimiento.setValueAt(cmbTipo.getSelectedItem(), a, 0);
            tbMantenimiento.setValueAt(cmbProducto.getSelectedItem(), a, 1);
            tbMantenimiento.setValueAt(txtPrecio_Unitario.getText(), a, 2);
            tbMantenimiento.setValueAt(txtCantidad.getText(), a, 3);
            tbMantenimiento.setValueAt(btnProveedor.getText(), a, 4);}
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
    cmbTipo.setSelectedItem(b);
    cmbProducto.setSelectedItem(c);
    txtPrecio_Unitario.setText(d);
    txtCantidad.setText(e);
    btnProveedor.setText("Seleccione");
     }
    }//GEN-LAST:event_tbMantenimientoMouseClicked

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
            java.util.logging.Logger.getLogger(frm_mante_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_mante_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_mante_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_mante_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_mante_Producto().setVisible(true);
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
    public static javax.swing.JButton btnProveedor;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMantenimiento;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio_Unitario;
    // End of variables declaration//GEN-END:variables
}
