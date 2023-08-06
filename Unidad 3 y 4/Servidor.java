package chats3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;

public class cliente extends javax.swing.JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:33065/socket";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    
//socket es un puente para enviar y recibir informacion
//el servidor pide la peticion y cliente la recibe
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dount;
    
    public cliente() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        msg_send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        msg_send.setText("Enviar");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        msg_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_textActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(181, 181, 181))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(msg_send)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msg_send))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>                        

    private void msg_textActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         try {
            String msgout = "";
            msgout = msg_text.getText().trim();

            // Crear la conexión a la base de datos y guardar el mensaje
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String insertQuery = "INSERT INTO mensajes (cliente, tiempo) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setString(1, msgout);
                preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            dount.writeUTF(msgout);
            msg_area.setText(msg_area.getText().trim() + "\nTú: " + msgout);
            msg_text.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                        

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
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            cliente cliente = new cliente();
            cliente.setVisible(true);
            cliente.retrieveAndDisplayMessages();
       
        });
        try {
            s = new Socket("localhost",1201);
            din = new DataInputStream(s.getInputStream());
            dount = new DataOutputStream(s.getOutputStream());
            String msgin="";
            
            while (!msgin.equals("exit")){
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim()+"/nCLIENTE: "+msgin);
            }
            
            
        } catch (Exception e) {
        }
    }
    
    private void retrieveAndDisplayMessages() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String selectQuery = "SELECT * FROM mensajes WHERE cliente IS NOT NULL";
            String select = "SELECT * FROM mensajes WHERE servidor IS NOT NULL";
            
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            
            PreparedStatement prepared = conn.prepareStatement(select);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ResultSet result = prepared.executeQuery();
            
            while (result.next() && resultSet.next()) {
                String message = resultSet.getString("cliente");
                String messag = result.getString("servidor");

                msg_area.setText(msg_area.getText().trim() + "\nTU: " + message);
                msg_area.setText(msg_area.getText().trim() + "\nSERVIDOR: " + messag);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration                   
}
