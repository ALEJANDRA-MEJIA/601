/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;
import Clases.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Servidor extends javax.swing.JFrame {
Calendar fecha_actual= new GregorianCalendar();
    
    /**
     * Creates new form Servidor
     */
    public Servidor() {
        initComponents();
        this.setLocationRelativeTo(null);
        Mostrartabla_2("");
        Salir();
        Borrar();
    }
    void Borrar(){
        txt_send2.setText("");
    }
    void Mostrartabla_2(String valor){
        DefaultTableModel modelo1=new DefaultTableModel();
        modelo1.addColumn("MSJ2");
        tabla_2.setModel(modelo1);
        String sql="Select * from mensaje2 WHERE CONCAT (MSJ2) LIKE '%"+valor+"%'";
        String datos[]=new String[1];
        Statement st;
        
        try {
            st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(2);
                modelo1.addRow(datos);
            }
            tabla_2.setModel(modelo1);
            
        } catch (SQLException e) {
            System.err.println("Error en el llenado del mensaje... "+e);
            JOptionPane.showMessageDialog(null, "Error en el llenado del mensaje... ");
        }
        Fecha2();
    }
    
    void Salir(){
        int opc = JOptionPane.showConfirmDialog(null, "En verdad deseas salir?");
        if(opc==0){
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_2 = new javax.swing.JTable();
        txt_send2 = new javax.swing.JTextField();
        btn_Enviar = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();

        jMenuItem1.setText("ver fecha");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("SERVIDOR");

        tabla_2.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_2.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabla_2);

        txt_send2.setBorder(javax.swing.BorderFactory.createTitledBorder("Escribe aquì"));
        txt_send2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_send2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_send2ActionPerformed(evt);
            }
        });

        btn_Enviar.setText("Enviar");
        btn_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnviarActionPerformed(evt);
            }
        });

        btn_Borrar.setText("Borrar");
        btn_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BorrarActionPerformed(evt);
            }
        });

        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_Enviar)
                                .addGap(74, 74, 74)
                                .addComponent(btn_Borrar)
                                .addGap(28, 28, 28)
                                .addComponent(btn_actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Salir))
                            .addComponent(txt_send2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_send2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Enviar)
                    .addComponent(btn_Borrar)
                    .addComponent(btn_Salir)
                    .addComponent(btn_actualizar))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_send2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_send2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_send2ActionPerformed

    private void btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnviarActionPerformed
        try {
            PreparedStatement ps=cn.prepareStatement("INSERT INTO mensaje1 (MSJ1) VALUE (?)");
            ps.setString(1, txt_send2.getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mensaje enviado... ");
            Borrar();
            Mostrartabla_2("");
        } 
        catch (SQLException e) {
            System.err.println("Error al enviar... "+e);
            JOptionPane.showMessageDialog(null, "Error al enviar... ");
        }
        Fecha2();
    }//GEN-LAST:event_btn_EnviarActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        Borrar();
    }//GEN-LAST:event_btn_BorrarActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        Salir();
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        Actualizar();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        MostrarFecha2();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Enviar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_2;
    private javax.swing.JTextField txt_send2;
    // End of variables declaration//GEN-END:variables
Conectar con=new Conectar();
Connection cn=con.conexion();

void Fecha2(){
        String SQL="INSERT INTO mensaje1 (Fecha1) VALUE (?)";;
        try{
            PreparedStatement st=cn.prepareStatement(SQL);
            st.setString(3, SQL);
            st.execute();
        }catch (Exception e){
            System.err.println("Error al enviar... "+e);
        }
    }
void MostrarFecha2(){
        Statement st;
        ResultSet rs;
        try{
        st=cn.createStatement();
        rs=st.executeQuery("Select * from mensaje2 WHERE CONCAT (Fecha2)");
            while(rs.next()){
                String fecha=rs.getString(3);
                System.out.println("Mensaje recibido el " + fecha);
                JOptionPane.showMessageDialog(null, "Mensaje recibido el " + fecha);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Mensaje no seleccionado");
        }
    }
void Actualizar(){
        Cliente abrir1=new Cliente();
        abrir1.setVisible(true);
    }
}
