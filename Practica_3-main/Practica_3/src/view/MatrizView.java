package view;

import javax.swing.JOptionPane;
import controller.Matriz_controller;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloMatriz;

/**
 *
 * @author asus
 */
public class MatrizView extends javax.swing.JDialog {

    private Matriz_controller controller;
    private ModeloMatriz modelo;
    private JTable tabla;

    /**
     * Creates new form MatrizView
     */
    public MatrizView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modelo = new ModeloMatriz();
        tblMatriz.setModel(modelo);
    }

    private void botonMatriz() {
        try {
            int filas = Integer.parseInt(txtFilas.getText());
            int columnas = Integer.parseInt(txtColumnas.getText());

            controller = new Matriz_controller(filas, columnas);
            controller.llenarMatrizAleatorio();

            actualizarTabla(); // ✔ Usa método simple
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese valores válidos para filas y columnas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        modelo.actualizarDesdeEnteros(controller.getDatos()); // ✔ Modelo hace todo
    }

    private void botonEliminar() {
        if (controller == null) {
            JOptionPane.showMessageDialog(this, "Primero crea la matriz.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String numeroStr = txtNumeroaEliminar.getText();
        if (numeroStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int numeroAEliminar = Integer.parseInt(numeroStr);
            boolean eliminado = controller.eliminarNumero(numeroAEliminar, -1);

            if (eliminado) {
                actualizarTabla();
                JOptionPane.showMessageDialog(this, "Número eliminado y reemplazado con '*'.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                txtNumeroaEliminar.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Número no encontrado en la matriz.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void botonEliminarPrimos() {
        if (controller == null) {
            JOptionPane.showMessageDialog(this, "Primero crea la matriz.");
            return;
        }

        boolean eliminado = controller.eliminarPrimos(-1);

        if (eliminado) {
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Números primos eliminados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron primos.");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatriz = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFilas = new javax.swing.JTextField();
        txtColumnas = new javax.swing.JTextField();
        txtNumeroaEliminar = new javax.swing.JTextField();
        btnMatriz = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnPrimos = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        tblMatriz.setBackground(new java.awt.Color(153, 153, 153));
        tblMatriz.setForeground(new java.awt.Color(255, 255, 255));
        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMatriz);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero a Eliminar:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Columnas:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Filas:");

        txtFilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilasActionPerformed(evt);
            }
        });

        txtColumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColumnasActionPerformed(evt);
            }
        });

        txtNumeroaEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroaEliminarActionPerformed(evt);
            }
        });

        btnMatriz.setText("Crear Matriz");
        btnMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Numero");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnPrimos.setText("Eliminar primos");
        btnPrimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumeroaEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnPrimos, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMatriz))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumeroaEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrimos))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilasActionPerformed

    private void txtColumnasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColumnasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColumnasActionPerformed

    private void btnMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizActionPerformed
        // TODO add your handling code here:
        botonMatriz();

    }//GEN-LAST:event_btnMatrizActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        botonEliminar();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPrimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimosActionPerformed
        // TODO add your handling code here:
        botonEliminarPrimos();
    }//GEN-LAST:event_btnPrimosActionPerformed

    private void txtNumeroaEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroaEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroaEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(MatrizView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrizView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrizView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrizView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MatrizView dialog = new MatrizView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMatriz;
    private javax.swing.JButton btnPrimos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tblMatriz;
    private javax.swing.JTextField txtColumnas;
    private javax.swing.JTextField txtFilas;
    private javax.swing.JTextField txtNumeroaEliminar;
    // End of variables declaration//GEN-END:variables
}
