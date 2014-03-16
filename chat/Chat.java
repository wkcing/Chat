package chat;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Chat extends javax.swing.JFrame {

    Client cliente;
    Visor visor;
    int i = 1;
    File clientdata = new File("clientdata");

    public Chat() {
        initComponents();
        // mapea enter a un valor inexistente en el cuadro de escribir 
        //(interfería el mapeo de serie con la funcion de enviar con intro)
        InputMap mapeo = txtescribir.getInputMap();
        KeyStroke enter = KeyStroke.getKeyStroke("ENTER");
        mapeo.put(enter, "----");
        this.setTitle("Chat");
        this.setResizable(false);
        DefaultCaret caret = (DefaultCaret) txtvisor.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }
    //CODIGO GENERADO POR NETBEANS (Hasta linea 256). Formatea GUI, con parámetros diseñados con el editor gráfico.
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtvisor = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtescribir = new javax.swing.JTextArea();
        btnenviar = new javax.swing.JButton();
        btnservidor = new javax.swing.JButton();
        btncliente = new javax.swing.JButton();
        labpuerto = new javax.swing.JLabel();
        txtpuerto = new javax.swing.JTextField();
        txthost = new javax.swing.JTextField();
        labhost = new javax.swing.JLabel();
        btncolores = new javax.swing.JButton();
        btnemoticonos = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        txtcontra = new javax.swing.JTextField();
        labhost1 = new javax.swing.JLabel();
        labhost2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuarchivo = new javax.swing.JMenu();
        menuitemabrir = new javax.swing.JMenuItem();
        menuitemcerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtvisor.setEditable(false);
        txtvisor.setColumns(20);
        txtvisor.setRows(5);
        txtvisor.setText("1. Elegir Puerto.\n\n(Opcional: Cambiar archivo con usuarios/contraseña en Archivo -> Abrir...)\n\n2. Si no hay, crear Servidor -> Botón Servidor...\n\n3. Elegir host/IP del Servidor.\n\n4. Escribir usuario y contraseña.\n\n5. Ejecutar cliente -> Botón Cliente...\n\n6. Escribir mensajes.\n\nColores: Circula los colores de letra con cada pulsación.\n\nEmoticonos: Activa o Desactiva Emoticonos ASCII.\n\n");
        jScrollPane1.setViewportView(txtvisor);

        txtescribir.setColumns(20);
        txtescribir.setLineWrap(true);
        txtescribir.setRows(1);
        txtescribir.setText("Escribir Mensaje...");
        txtescribir.setWrapStyleWord(true);
        txtescribir.setCaretPosition(0);
        txtescribir.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtescribir.setEnabled(false);
        txtescribir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtescribirMouseClicked(evt);
            }
        });
        txtescribir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtescribirKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtescribir);

        btnenviar.setText("Enviar");
        btnenviar.setEnabled(false);
        btnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenviarActionPerformed(evt);
            }
        });

        btnservidor.setText("Servidor...");
        btnservidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnservidorActionPerformed(evt);
            }
        });

        btncliente.setText("Cliente...");
        btncliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclienteActionPerformed(evt);
            }
        });

        labpuerto.setText("Puerto*:");

        txtpuerto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpuerto.setText("8080");
        txtpuerto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpuertoMouseClicked(evt);
            }
        });

        txthost.setText("localhost");
        txthost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txthostMouseClicked(evt);
            }
        });

        labhost.setText("Host/IP*:");

        btncolores.setText("Colores");
        btncolores.setEnabled(false);
        btncolores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncoloresActionPerformed(evt);
            }
        });

        btnemoticonos.setText("Emoticonos OFF");
        btnemoticonos.setEnabled(false);
        btnemoticonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnemoticonosActionPerformed(evt);
            }
        });

        txtusuario.setText("dani");
        txtusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusuarioMouseClicked(evt);
            }
        });

        txtcontra.setText("1234");
        txtcontra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcontraMouseClicked(evt);
            }
        });

        labhost1.setText("Nombre de Usuario:");

        labhost2.setText("Contraseña:");

        jLabel1.setText("*(Campo Obligatorio)");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labhost2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                            .addComponent(labpuerto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtpuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnenviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcontra)
                        .addComponent(txtusuario)
                        .addComponent(txthost)
                        .addComponent(btncolores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnemoticonos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btncliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnservidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labhost)
                    .addComponent(labhost1)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(btnservidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labpuerto)
                            .addComponent(txtpuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labhost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labhost1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labhost2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncolores, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnemoticonos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnenviar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        menuarchivo.setText("Archivo");

        menuitemabrir.setText("Abrir archivo de login de clientes...");
        menuitemabrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemabrirActionPerformed(evt);
            }
        });
        menuarchivo.add(menuitemabrir);

        menuitemcerrar.setText("Cerrar");
        menuitemcerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemcerrarActionPerformed(evt);
            }
        });
        menuarchivo.add(menuitemcerrar);

        jMenuBar1.add(menuarchivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CODIGO de eventos en GUI (elaboracion propia con eventos generados con editor gráfico).
    //al hacer click sobre el cuadro de escribir, borra el mensaje predeterminado.
    private void txtescribirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtescribirMouseClicked
        if (txtescribir.getText().equals("Escribir Mensaje...")) {
            txtescribir.setText("");
        }
    }//GEN-LAST:event_txtescribirMouseClicked
    //instancia un hilo multiservidor y no permite modificar el puerto deshabilitando el su cuadro de texto (solo daría errores).
    private void btnservidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnservidorActionPerformed

        try {
            Multiserver mserver = new Multiserver(Integer.parseInt(txtpuerto.getText()), clientdata);
            mserver.probar();
            mserver.start();
            btnservidor.setEnabled(false);
            txtpuerto.setEnabled(false);
            menuitemabrir.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar servidor (puerto ocupado por otro servidor en ejecucion/puerto incorrecto)");
        }


    }//GEN-LAST:event_btnservidorActionPerformed
    //instancia hilo visor y cliente.
    private void btnclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclienteActionPerformed
        if (!txtpuerto.getText().isEmpty() && !txthost.getText().isEmpty()) {

            try {
                visor = new Visor(Integer.parseInt(txtpuerto.getText()), txtvisor);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al instanciar visor");
            }
            try {
                cliente = new Client(txthost.getText(), Integer.parseInt(txtpuerto.getText()), txtvisor);
                cliente.configurarIO();
                visor.start();
                //cambia los valores del nombre de usuario y contraseña de su cliente.
                cliente.clientenombre = txtusuario.getText();
                cliente.clientecontra = txtcontra.getText();
                //inicia sesion con estos datos (que se envian en client al servidor para su comprobacion)
                txtvisor.setText("");
                cliente.loginusuario();
                //habilita la zona de escritura y se deshabilita el boton y campos usuario/contraseña/host/colores/emoticonos.                
                btncliente.setEnabled(false);
                btnenviar.setEnabled(true);
                txtescribir.setEnabled(true);
                cliente.emoticonos = false;
                txthost.setEnabled(false);
                txtusuario.setEnabled(false);
                txtcontra.setEnabled(false);
                btnemoticonos.setEnabled(true);
                btncolores.setEnabled(true);
                btnservidor.setEnabled(false);
                txtpuerto.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al iniciar cliente (puerto/host incorrecto)");
            }


        } else {
            JOptionPane.showMessageDialog(null, "Requerido: Puerto y Host");
        }
    }//GEN-LAST:event_btnclienteActionPerformed
    //al pulsar el boton enviar, envia el texto del cuadro y resetea el mismo.
    private void btnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenviarActionPerformed
        if (!txtescribir.getText().isEmpty() && !txtescribir.getText().equals("Escribir Mensaje...")) {
            cliente.enviar(txtescribir.getText());
            txtescribir.setText("");
        }


    }//GEN-LAST:event_btnenviarActionPerformed
    //en archivo->cerrar, cierra el programa
    private void menuitemcerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemcerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuitemcerrarActionPerformed
    //si se pulsa intro en el cuadro de escribir tiene el mismo efecto que pulsar enviar.
    private void txtescribirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtescribirKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txtescribir.getText().isEmpty()) {
            cliente.enviar(txtescribir.getText());
            txtescribir.setText("");
        }
    }//GEN-LAST:event_txtescribirKeyReleased
    //en los campos de texto al hacer click se selecciona el texto para edicion rápida.
    private void txtusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuarioMouseClicked
        txtusuario.selectAll();
    }//GEN-LAST:event_txtusuarioMouseClicked

    private void txtcontraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcontraMouseClicked
        txtcontra.selectAll();
    }//GEN-LAST:event_txtcontraMouseClicked

    private void txthostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txthostMouseClicked
        txthost.selectAll();
    }//GEN-LAST:event_txthostMouseClicked

    private void btncoloresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncoloresActionPerformed
        Color color = Color.BLACK;

        txtvisor.setBackground(Color.WHITE);
        txtescribir.setBackground(Color.WHITE);

        switch (i) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.BLUE;
                break;
            case 2:
                color = Color.CYAN;
                break;
            case 3:
                color = Color.DARK_GRAY;
                break;
            case 4:
                color = Color.GRAY;
                break;
            case 5:
                color = Color.GREEN;
                break;
            case 6:
                color = Color.LIGHT_GRAY;
                break;
            case 7:
                color = Color.MAGENTA;
                break;
            case 8:
                color = Color.ORANGE;
                break;
            case 9:
                color = Color.PINK;
                break;
            case 10:
                color = Color.RED;
                break;
            case 11:
                color = Color.YELLOW;
                break;
            case 12:
                color = Color.WHITE;
                break;
        }
        if (i == 12) {
            i = 0;
            txtvisor.setBackground(Color.BLACK);
            txtescribir.setBackground(Color.BLACK);
        } else {
            i++;
        }
        txtvisor.setForeground(color);
        txtescribir.setForeground(color);

    }//GEN-LAST:event_btncoloresActionPerformed

    private void txtpuertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpuertoMouseClicked
        txtpuerto.selectAll();
    }//GEN-LAST:event_txtpuertoMouseClicked

    private void btnemoticonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnemoticonosActionPerformed
        if (cliente.emoticonos) {
            cliente.emoticonos = false;
            btnemoticonos.setText("Emoticonos OFF");
        } else {
            cliente.emoticonos = true;
            btnemoticonos.setText("Emoticonos ON");
        }
    }//GEN-LAST:event_btnemoticonosActionPerformed

    private void menuitemabrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemabrirActionPerformed
        JFileChooser archivo = new JFileChooser();

        archivo.showOpenDialog(this);
        if (archivo.getSelectedFile() != null) {
            clientdata = archivo.getSelectedFile();
        }


    }//GEN-LAST:event_menuitemabrirActionPerformed

    //CODIGO GENERADO POR NETBEANS. Da estilo a la GUI. La 'abre'. Declara las variables de la GUI.
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Chat().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncliente;
    private javax.swing.JButton btncolores;
    private javax.swing.JButton btnemoticonos;
    private javax.swing.JButton btnenviar;
    private javax.swing.JButton btnservidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labhost;
    private javax.swing.JLabel labhost1;
    private javax.swing.JLabel labhost2;
    private javax.swing.JLabel labpuerto;
    private javax.swing.JMenu menuarchivo;
    private javax.swing.JMenuItem menuitemabrir;
    private javax.swing.JMenuItem menuitemcerrar;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtcontra;
    private javax.swing.JTextArea txtescribir;
    private javax.swing.JTextField txthost;
    private javax.swing.JTextField txtpuerto;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JTextArea txtvisor;
    // End of variables declaration//GEN-END:variables
}
