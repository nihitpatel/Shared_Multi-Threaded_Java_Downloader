/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectpassing;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.exit;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author NAVIN
 */
public class mainserver extends javax.swing.JFrame {

    /**
     * Creates new form mainserver
     */
    public mainserver() {
        initComponents();
    }
    
     static int s = 0;
        static int e = 0;
        static int lpu = 0; 
    
       public class outputstream extends Thread{
      
        Socket conn ;
        int i;
        outputstream(Socket s,int i)
        {
            conn = s;
            this.i = i;
        }
        public void run(){
            
             ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(conn.getOutputStream());
                data d = new data(lpu*(i-1),lpu*(i)-1,i);
          
               
                oos.writeObject(d);
               
                
         //       System.out.println("\nD sent");
        //        oos.close();
            } catch (IOException ex) {
               System.out.println("Cannot open outputstream 1");
            } 
        }
    }
       
 public static ArrayList al = new ArrayList();
    public static int n = 0;
    public class server extends Thread{

       
       ServerSocket serversocket;
       Socket conn;
       outputstream os;
        
        public void run() {
    
           try {
               serversocket = new ServerSocket(12345);
           } catch (IOException ex) {
               Logger.getLogger(mainserver.class.getName()).log(Level.SEVERE, null, ex);
           }
            
   while(true)
 {
       try {
           
           System.out.println("\nServer is in listening mode....");
           conn = serversocket.accept();
           System.out.println("\nConnected to " + conn.getLocalAddress());
           
           al.add(conn);
           
//           os = new outputstream(conn);
//           os.start();
//           conn = null;
       } catch (IOException ex) {
           System.out.println("Cannot Start Server");
       }
   }
        
       
       
    }
    }
    
 
    public void calc(int l,int u)
    {
        lpu = l/u;
      
    }
    
    String geturl()
    {
     //   return url.getText();
   //    return "http://7-zip.org/a/7z1604-x64.exe";
      //  return "https://gradcollege.okstate.edu/sites/default/files/PDF_linking.pdf";
        return "http://r1---sn-5uaeznz7.googlevideo.com/videoplayback?ratebypass=yes&expire=1498941321&ei=KbNXWfbXKMOjqQWZ4oaQBg&key=yt6&itag=43&mm=31&ipbits=0&dur=0.000&mn=sn-5uaeznz7&id=o-AMlqfSwXVEjNxRiatflqAxYtJvUc_C_tqiYQPeNSz4Ia&pl=24&source=youtube&sparams=dur%2Cei%2Cid%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Csource%2Cexpire&mv=u&mime=video%2Fwebm&signature=CB295476BE6F1C5CA14B939553868CB355042DD3.809BA0BE68301F8C7F6DDEF69ACDEACD6C5868DD&ms=au&ip=173.208.91.188&mt=1498919522&lmt=1432300135925409&title=Warren+Buffett%27s+Top+10+Rules+For+Success+%28%40WarrenBuffett%29";
        
//  return "http://dl2.filehippo.com/c39d474f362d49918f991f556a76b2f7/vlc-2.2.4-win64.exe?ttl=1488719925&token=a3cb68bae540684934fd907b5aa392e5";
      
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        noc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        start = new javax.swing.JTextField();
        end = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        url = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(noc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 110, -1));

        jLabel1.setText("Number of Clients : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jButton2.setText("Generate ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));
        getContentPane().add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 80, -1));
        getContentPane().add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 80, -1));

        jLabel2.setText("Start :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jLabel3.setText("End :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setText("  Server");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 50, -1));
        getContentPane().add(url, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 300, -1));

        jButton1.setText("Start Download");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        jButton3.setText("Start Server");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
String u = geturl();
int len = 0;
        downloader d = new downloader();
        try {
           len =  d.getfilesize(u);
        } catch (IOException ex) {
            System.out.println("Unable to Retrive Length 1");
            exit (0);
        }

       
        System.out.println("Size of Arraylist is : " + al.size());
        noc.setText(""+al.size());
         calc(len,al.size()+1);
          outputstream os;
        for(int i=0;i<al.size();i++)
        {
            os = new outputstream((Socket) al.get(i),i+1);
            os.start();
        }
        
        start.setText(""+lpu*al.size());
        end.setText(""+len);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

   String u = geturl();
   int st = Integer.parseInt(start.getText());
      int en = Integer.parseInt(end.getText());
        downloader d = new downloader(u,st,en,al.size()+1);
//        d.seturl(u);
        d.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      server s = new server();
        s.start();
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(mainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainserver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField end;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField noc;
    private javax.swing.JTextField start;
    private javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables
}