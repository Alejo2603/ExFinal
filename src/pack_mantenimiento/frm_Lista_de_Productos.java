
package pack_mantenimiento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pack_mantenimiento.frmExportar;

public class frm_Lista_de_Productos extends javax.swing.JFrame {
String Ruta="C:\\Users\\GLADYS TAES\\Desktop\\Productos.txt";
    DefaultTableModel modelo = new DefaultTableModel();
    private void ColumnasTablaListadeProveedores(){
        modelo.addColumn("Producto");
        tbMantenimiento.setModel(modelo);        
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
                    String producto = st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                      producto
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
    public frm_Lista_de_Productos() {
        initComponents();
                ColumnasTablaListadeProveedores();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimiento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMantenimientoMouseClicked
    int y = tbMantenimiento.getSelectedRow();
    String z = tbMantenimiento.getValueAt(y, 0).toString();
    frmExportar.btnProducto.setText(z);
    dispose();
    }//GEN-LAST:event_tbMantenimientoMouseClicked

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
            java.util.logging.Logger.getLogger(frm_Lista_de_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Lista_de_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Lista_de_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Lista_de_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Lista_de_Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMantenimiento;
    // End of variables declaration//GEN-END:variables
}
