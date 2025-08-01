package bdffr_rentsys;

/**
 *
 * @author prayo
 */
import database.koneksidb;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import database.resultsettable;
import bdffr_rentsys.HashUtil;
import static bdffr_rentsys.menu_home.lb_hak;

public class menu_user extends javax.swing.JFrame {
     ResultSet rs;
     koneksidb con;
     String hak;
     /**
     * Creates new form menu_home
     */
    public menu_user() {
        con = new koneksidb(new database.parameter().HOST_DB, 
              new database.parameter().USERNAME_DB, 
              new database.parameter().PASSWORD_DB);
     
        initComponents();
        loadTabel(); 
        setLocationRelativeTo(null);

        tf_user.requestFocus();
        //setExtendedState(MAXIMIZED_BOTH);       
    }
    
       private void loadTabel() {
       String namaKolom[] = {"id","username","password","role"};
       rs=con.querySelect(namaKolom,"user");
       tabeluser.setModel(new resultsettable(rs));
       clear();    
    }
    
    public void cekHak(){
        hak = lb_hak.getText();
         if (hak != null) {

          this.setVisible(false);
          if (hak.equals("admin")) {
           menu_home h = new menu_home();
           h.setVisible(true);
           h.admin();
          } 
          else {
           menu_home h = new menu_home();
           h.setVisible(true);
           h.user();
          }
         } 
    }    
    
    private void create() {
        try {
            if( 
//                    !tf_nama.getText().isEmpty() 
                !tf_user.getText().isEmpty() 
                && !tf_pass.getText().isEmpty()){
                String kolom[] = {"username","password","role"};
                String isi[] = { 
                                 tf_user.getText(),
                                 HashUtil.hashPassword(tf_pass.getText()),
                                 cb_hakakses.getSelectedItem().toString(),
                               };
                System.out.println( con.queryInsert("user",kolom,isi));
                JOptionPane.showMessageDialog(this, "Penambahan User Berhasil");
            }else{
                JOptionPane.showMessageDialog(this, "Data Pengisian Ada Yang Kosong");
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Input");
            System.out.println("Salah");
        }
        loadTabel();
        clear();
    }
    
    private void clear() { 
//        tf_nama.setText("");
        tf_user.setText("");
        tf_pass.setText("");
        cb_hakakses.setSelectedItem("Admin");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bt_tambahmobil = new javax.swing.JButton();
        bt_sewamobil = new javax.swing.JButton();
        bt_kembalikanmobil = new javax.swing.JButton();
        bt_logout = new javax.swing.JButton();
        bt_dash = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_user = new javax.swing.JTextField();
        cb_hakakses = new javax.swing.JComboBox<String>();
        tf_pass = new javax.swing.JPasswordField();
        cb_show = new javax.swing.JCheckBox();
        bt_add = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeluser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-user.png"))); // NOI18N
        jLabel1.setText("BDFFR RentSys | Tambah User");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENU", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        bt_tambahmobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-car.png"))); // NOI18N
        bt_tambahmobil.setText(" Tambah Mobil");
        bt_tambahmobil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_tambahmobil.setBorderPainted(false);
        bt_tambahmobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahmobilActionPerformed(evt);
            }
        });

        bt_sewamobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rental-car.png"))); // NOI18N
        bt_sewamobil.setText("Transaksi");
        bt_sewamobil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_sewamobil.setBorderPainted(false);
        bt_sewamobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sewamobilActionPerformed(evt);
            }
        });

        bt_kembalikanmobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/return-car.png"))); // NOI18N
        bt_kembalikanmobil.setText(" Kembalikan Mobil");
        bt_kembalikanmobil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_kembalikanmobil.setBorderPainted(false);
        bt_kembalikanmobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kembalikanmobilActionPerformed(evt);
            }
        });

        bt_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        bt_logout.setText("Log Out");
        bt_logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_logout.setBorderPainted(false);
        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });

        bt_dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LOGO (50).png"))); // NOI18N
        bt_dash.setText("Dashboard");
        bt_dash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_dashActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt_tambahmobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_sewamobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_kembalikanmobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_dash, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(bt_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_dash, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_tambahmobil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_sewamobil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_kembalikanmobil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(bt_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N

        lb_user.setBackground(new java.awt.Color(204, 204, 204));
        lb_user.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Tambah User", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel4.setText("Username");

        jLabel7.setText("Password");

        jLabel8.setText("Role");

        cb_hakakses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "petugas", " " }));

        cb_show.setText("Show Password");
        cb_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_showMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_hakakses, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_show)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_user)
                        .addComponent(tf_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_show)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_hakakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        bt_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dbadds.png"))); // NOI18N
        bt_add.setText("Add");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });

        bt_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dbdelete.png"))); // NOI18N
        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dbedit.png"))); // NOI18N
        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dbrefresh.png"))); // NOI18N
        bt_refresh.setText("Refresh");
        bt_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_refreshActionPerformed(evt);
            }
        });

        tabeluser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID User", "Nama", "Username", "Role"
            }
        ));
        tabeluser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeluserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeluser);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bt_add)
                                .addGap(12, 12, 12)
                                .addComponent(bt_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_refresh))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_add)
                            .addComponent(bt_delete)
                            .addComponent(bt_update)
                            .addComponent(bt_refresh))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_tambahmobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahmobilActionPerformed
       this.setVisible(false);
       
       menu_tambahmobil rm = new menu_tambahmobil();
       rm.setVisible(true);
    }//GEN-LAST:event_bt_tambahmobilActionPerformed

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        int jawab = JOptionPane.showConfirmDialog(this,"Yakin?","Log Out",JOptionPane.YES_NO_OPTION);
        switch(jawab){
            case JOptionPane.YES_OPTION:
                dispose();
                login rm = new login();
                rm.setVisible(true);
            break;
            case JOptionPane.NO_OPTION:
                bt_logout.requestFocus();
            break;
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void bt_dashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_dashActionPerformed
      cekHak();
    }//GEN-LAST:event_bt_dashActionPerformed

    private void tabeluserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeluserMouseClicked
//        tf_nama.setText(String.valueOf(tabeluser.getValueAt(tabeluser.getSelectedRow(),1)));
        tf_user.setText(String.valueOf(tabeluser.getValueAt(tabeluser.getSelectedRow(),1)));
        tf_pass.setText(String.valueOf(tabeluser.getValueAt(tabeluser.getSelectedRow(),2)));
        cb_hakakses.setSelectedItem(String.valueOf(tabeluser.getValueAt(tabeluser.getSelectedRow(),3)));
    }//GEN-LAST:event_tabeluserMouseClicked

    private void bt_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_refreshActionPerformed
        loadTabel();
        clear();
        tf_user.requestFocus();
    }//GEN-LAST:event_bt_refreshActionPerformed

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        create();
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
     try {
      String id=String.valueOf(tabeluser.getValueAt(tabeluser.getSelectedRow(),0));
      
      if (JOptionPane.showConfirmDialog(this, "Yakin Hapus", "Peringatan", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) 
      {
        con.queryDelete("user","id="+id);
        JOptionPane.showMessageDialog(this, "Penghapusan User Berhasil");
      }
      else{
        return;
      }
      } catch (Exception e) {
       JOptionPane.showMessageDialog(this, "Pilih ID!");
      }
     loadTabel();
     clear();
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        try {
           if( 
               !tf_user.getText().isEmpty() 
               && !tf_pass.getText().isEmpty()){
               String kolom[] = {"username","password","hak_akses"};
               String isi[] = { 
                                tf_user.getText(),
                                HashUtil.hashPassword(tf_pass.getText()),
                                cb_hakakses.getSelectedItem().toString()
                               };
               con.queryUpdate("user", kolom, isi,"id='"
                                +String.valueOf(tabeluser.getValueAt(tabeluser.getSelectedRow(),0))+"'");
               JOptionPane.showMessageDialog(this, "Update User Berhasil");
           }else{
                JOptionPane.showMessageDialog(this, "Data Pengisian Ada Yang Kosong");
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Update");
        }
        loadTabel();
        clear();
    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_sewamobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sewamobilActionPerformed
        this.setVisible(false);
        
        menu_peminjam rm = new menu_peminjam();
        rm.setVisible(true);
    }//GEN-LAST:event_bt_sewamobilActionPerformed

    private void bt_kembalikanmobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kembalikanmobilActionPerformed
        this.setVisible(false);

        menu_pengembalian rm = new menu_pengembalian();
        rm.setVisible(true);
    }//GEN-LAST:event_bt_kembalikanmobilActionPerformed

    private void cb_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_showMouseClicked
        if(cb_show.getText().equals("Show Password")){
            cb_show.setText("Hide Password");
            tf_pass.setEchoChar((char)0);
        }
        else{
            cb_show.setText("Show Password");
            tf_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_cb_showMouseClicked

    //SYNTAX AJA
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
            java.util.logging.Logger.getLogger(menu_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new menu_home().setVisible(true);
                new menu_user().show();
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_dash;
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_kembalikanmobil;
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_refresh;
    private javax.swing.JButton bt_sewamobil;
    private javax.swing.JButton bt_tambahmobil;
    private javax.swing.JButton bt_update;
    private javax.swing.JComboBox<String> cb_hakakses;
    private javax.swing.JCheckBox cb_show;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JLabel lb_user = new javax.swing.JLabel();
    private javax.swing.JTable tabeluser;
    private javax.swing.JPasswordField tf_pass;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables
}

