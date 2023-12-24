package m1tp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class fenetreS extends javax.swing.JFrame {

    public fenetreS() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtextAreaChat = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtextAreamsg = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SERVER");
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

        jtextAreaChat.setColumns(20);
        jtextAreaChat.setRows(5);
        jScrollPane1.setViewportView(jtextAreaChat);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout(10, 10));

        jtextAreamsg.setColumns(20);
        jtextAreamsg.setRows(5);
        jScrollPane2.setViewportView(jtextAreamsg);

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            // bah awl mattfta7 formulaire tassra l'attente de message de client

            servsoc = new ServerSocket(2013);
            socket = servsoc.accept();
            //  OutputStreamWriter sortie = new OutputStreamWriter(socket.getOutputStream());
            sortie = new PrintWriter(socket.getOutputStream(), true);//zdt true 3la 5atr ya9dr yb3T fi blasst flush() hadik
            // BufferedReader entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));//           
            entree = new Scanner(socket.getInputStream());
            // list.add(sortie);//
            //th t = new th();//
            //t.in = entree;//
            //t.l = list;//
            //t.start();//

            Thread mythread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        String msg = entree.nextLine();//bah nsta9bl le message li ytktb

                        jtextAreaChat.append("client : " + msg);//zdt la boucle w i w list}
                    }
                }
            });
            mythread.start();
        } catch (IOException ex) {
            Logger.getLogger(fenetreS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String message = jtextAreamsg.getText();//bah nhz wch faha 
        sortie.println(message);
        jtextAreaChat.append("server : " + message + "\n");
        jtextAreamsg.setText(" ");//bah nfragha w twli vide 


    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtextAreaChat;
    private javax.swing.JTextArea jtextAreamsg;
    // End of variables declaration//GEN-END:variables
private ServerSocket servsoc;
    private Socket socket;
    private PrintWriter sortie;// hadi fi blasst buffer ta outputstream whriter
    private Scanner entree;//hadi fi blasst buffereader
    Vector< Scanner> l = new Vector< Scanner>();//

}
