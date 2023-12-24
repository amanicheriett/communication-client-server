package client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMANI CHERIETT
 */
public class fenetre extends javax.swing.JFrame {

    public fenetre() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtextAreachatc = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtextAreamsgc = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLIENT");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        jtextAreachatc.setColumns(20);
        jtextAreachatc.setRows(5);
        jScrollPane1.setViewportView(jtextAreachatc);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout(10, 10));

        jtextAreamsgc.setColumns(20);
        jtextAreamsgc.setRows(5);
        jScrollPane2.setViewportView(jtextAreamsgc);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButton1.setText("envoyer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String msg = jtextAreamsgc.getText();
        sortie.println(msg + "/n");
        jtextAreachatc.append("client : " + msg + "\n");
        jtextAreamsgc.setText(" ");
        //  sortie.flush();//
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            socket = new Socket("127.0.0.1", 2013);
            sortie = new PrintWriter(socket.getOutputStream(), true);
            entree = new Scanner(socket.getInputStream());
            
//fenetre f=new fenetre();//
            // f.setVisible(true);//
            //f.sortie=sortie;//

            // ydir run l 2 programs en meme temps ra7nasta3l thread here 
            Thread mythread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        
                        String message = entree.nextLine();
                        jtextAreachatc.append("server : " + message + "\n");
                        setTitle("client1");
                        
                    }

                }
            });
            mythread.start();
        } catch (IOException ex) {
            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtextAreachatc;
    private javax.swing.JTextArea jtextAreamsgc;
    // End of variables declaration//GEN-END:variables
private Socket socket;
    PrintWriter sortie;
    Scanner entree;

}
