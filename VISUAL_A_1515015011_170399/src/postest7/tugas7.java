package postest7;

import java.awt.Color; // ini merupakan javak warna 
import java.sql.*; // //Mengimpor Class untuk mendukung akses dan pengolahan data dalam database
import javax.swing.JOptionPane; // ini merupakan memuculkan pesan
import javax.swing.table.DefaultTableModel; 


public class tugas7 extends javax.swing.JFrame {
    private DefaultTableModel model; //untuk membuat model pada data
    private Connection con = koneksi.getConnection();//untuk mengambil koneksi 
    private Statement stt; //untuk eksekusi query database
    private ResultSet rss; // untuk penampung dari database
    private int baris;  // mendeklrasikan suatu baris
    private boolean data=true; //membuat pilihan saat validasi data
  
    public tugas7() {
        initComponents();
        
    }
       private void InitTable(){ // membuat table secara manual  
        model = new DefaultTableModel(); //class model dari DefaultTableModel
        model.addColumn("ID"); // membuat kolom id dalam class model
        model.addColumn("JUDUL"); // membuat kolom judul dalam class model
        model.addColumn("PENULIS"); // membuat kolom penulis dalam class model
        model.addColumn("HARGA"); // membuat kolom harga dalam class model
        
        jTable1.setModel(model); // //mengeset instance of class model ke table
    }
    
    private void tampilData(){ // method untuk menampilkan data dari database
        try{
            String sql = "SELECT * FROM buku"; // ini merupakan query dari database untuk melihat tabel buku
            stt = con.createStatement();
            rss = stt.executeQuery(sql); 
            while(rss.next()){
                Object[] o = new Object[4];//membuat suatu Objek
                o[0] = rss.getString("id"); //objek 0 ini untuk menampung data id
                o[1] = rss.getString("judul");//objek 1 ini untuk menampung data judul
                o[2] = rss.getString("penulis");//objek 2 ini untuk menampung data penulis
                o[3] = rss.getInt("harga");//objek 3 ini untuk menampung data harga
                model.addRow(o);//baris pada suatu model
            }
        }catch(SQLException e){ //menampilkan kesalahan pada program
            System.out.println(e.getMessage());
        }
    }
                
    private void TambahData(String judul, String penulis, String harga){ // method untuk menambah data ke dalam database
        try{
            String sql =
                    "INSERT INTO buku VALUES (NULL, '"+judul+"','"+penulis+"',"+harga+")"; //query ini untuk menambah tabel buku dan menambah kolom judul,penulis dan harga
            stt = con.createStatement();
            stt.executeUpdate(sql);
           
        }catch(SQLException e){//menampilkan kesalahan pada program
            System.out.println(e.getMessage());
        }
    }
    
   private boolean UbahData( String id, String judul, String penulis, String harga){ // method untuk mengubah data ke dalam database
        try{
            String sql = "UPDATE buku SET judul='"+judul+"',"+"penulis='"+penulis+"',harga='"+harga+"'where id='"+id+"'";//query ini untuk mengganti suatu di dalam tabel buku pada kolom nya tersebut
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){//menampilkan kesalahan pada program
            System.out.println(e.getMessage());
            return false;
        }
    }
   
     private boolean HapusData( String id){ // method untuk mengahapus data di dalam database
        try{
            String sql = "DELETE from buku where id='"+id+"'";//query ini untuk menghapus yang ada di dalam tabel buku dan memilih kolom yang terdapat pada isinya apa yang mau di hapus
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){//menampilkan kesalahan pada program
            System.out.println(e.getMessage());
            return false;
        }
    }
     
   private void CariData(String By, String cari){ // method mencari id
        try{
            String sql = "SELECT*from buku where "+By+" LIKE  '%"+cari+"%'"; //query untuk melihat like dari database yang ada
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   // membuat suatu objeck
              o[0] = rss.getInt("id"); // objek 0 ini untuk menampung data id
              o[1] = rss.getString("judul");//objek 1 untuk menampung data judul
              o[2] = rss.getString("penulis");//objek 2 menampung data penulis
              o[3] = rss.getString("harga");//objek 3 menampung data harga
              model.addRow(o);//baris pada suatu model
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
   
  private void ValidasiData(String judul, String penulis, String harga){  //method untuk mencari id data
        try{
            String sql = "SELECT*from buku ";//query ini untuk melihat isi tabel buku di database
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[2];//membuat suatu Objek
              o[0] = rss.getString("judul").toLowerCase();//objek 0 ini untuk menampung data id
              o[1] = rss.getString("penulis").toLowerCase();//objek 1 ini untuk menampung data judul
              
              if(o[0].equals(judul.toLowerCase())&& o[1].equals(penulis.toLowerCase())){ //jika sudah ada data judul dan penulis
                  JOptionPane.showMessageDialog(null, "Data SUDAH ADA!!!!");//untuk tampilan bahwa data sudah ada
                  data = false ;                                                            
                  break;//proses berhenti
              }
            }
            if(data==true){//jika data belum ada
                TambahData(judul,penulis,harga); //memasukkan method TambahData untuk mengisi judul, penulis, dan harga
            }
        }catch(SQLException e){//menampilkan kesalahan pada program
            System.out.println(e.getMessage());
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

        jp1 = new javax.swing.JPanel();
        jp2 = new javax.swing.JPanel();
        fdb = new javax.swing.JLabel();
        jp3 = new javax.swing.JPanel();
        jd = new javax.swing.JLabel();
        jd2 = new javax.swing.JTextField();
        p = new javax.swing.JLabel();
        jc = new javax.swing.JComboBox();
        h = new javax.swing.JLabel();
        h2 = new javax.swing.JTextField();
        scr = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        save = new javax.swing.JButton();
        change = new javax.swing.JButton();
        del = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        sr = new javax.swing.JLabel();
        sr2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jc2 = new javax.swing.JComboBox();
        fnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jp1.setBackground(new java.awt.Color(153, 255, 255));

        jp2.setBackground(new java.awt.Color(51, 153, 255));

        fdb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fdb.setForeground(new java.awt.Color(255, 255, 255));
        fdb.setText("Form Data Buku");

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(fdb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(fdb)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jp3.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jp3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jp3ComponentShown(evt);
            }
        });

        jd.setForeground(new java.awt.Color(255, 255, 255));
        jd.setText("Judul");

        jd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jd2ActionPerformed(evt);
            }
        });

        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setText("Penulis");

        jc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bruh Jit", "Bruh Fu", "Ah Jit", "Ah Fu", "Bazaar" }));

        h.setForeground(new java.awt.Color(255, 255, 255));
        h.setText("Harga");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "JUDUL", "PENULIS", "HARGA"
            }
        ));
        scr.setViewportView(jTable1);

        save.setText("SIMPAN");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        change.setText("UBAH");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        del.setText("HAPUS");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        exit.setText("KELUAR");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        sr.setForeground(new java.awt.Color(255, 255, 255));
        sr.setText("Search");

        sr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sr2ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("By");

        jc2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Judul", "Penulis", "Harga" }));
        jc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc2ActionPerformed(evt);
            }
        });

        fnd.setText("Cari");
        fnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jp3Layout);
        jp3Layout.setHorizontalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jp3Layout.createSequentialGroup()
                                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jd)
                                    .addComponent(p)
                                    .addComponent(h))
                                .addGap(104, 104, 104)
                                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jd2)
                                    .addComponent(jc, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(h2, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
                            .addGroup(jp3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jp3Layout.createSequentialGroup()
                                        .addComponent(save)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                        .addComponent(change)
                                        .addGap(47, 47, 47)
                                        .addComponent(del)
                                        .addGap(43, 43, 43)
                                        .addComponent(exit))))))
                    .addGroup(jp3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(sr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sr2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jc2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(fnd)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jp3Layout.setVerticalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jd)
                    .addComponent(jd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p)
                    .addComponent(jc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(h)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(save)
                        .addComponent(change)
                        .addComponent(del)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sr)
                    .addComponent(sr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fnd))
                .addGap(18, 18, 18)
                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83))
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jd2ActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow(); // mengambil nilai bari yang sudah ditetapkan
      
        String id = jTable1.getValueAt(baris, 0).toString(); // untuk mengambil nilai baris yang sudah diubah
        String judul = jd2.getText();// untuk mengambil nilai baris yang sudah diubah
        String penulis = jc.getSelectedItem().toString();// untuk mengambil nilai baris yang sudah diubah
        String harga = h2.getText();// untuk mengambil nilai baris yang sudah diubah
        if(UbahData(id, judul, penulis, harga))
            JOptionPane.showMessageDialog(null, "Berhasil Ubah Data"); //pemberitahuan jika sudah mengubah data
        else
            JOptionPane.showMessageDialog(null, "Gagal Ubah Data"); //pemberitahuan jika data gagal diubah
       InitTable();
       tampilData();
       
    }//GEN-LAST:event_changeActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed

        int baris = jTable1.getSelectedRow(); // memilih baris yang diinginkan
        String id = jTable1.getValueAt(baris, 0).toString();
        if(HapusData(id))
            JOptionPane.showMessageDialog(null, "Berhasil Hapus Data"); //pemberitahuan jika sudah menghapus data
        else
            JOptionPane.showConfirmDialog(null, "Gagal Hapus Data"); //pemberitahuan jika data gagal dihapus
       InitTable();
       tampilData();    
    }//GEN-LAST:event_delActionPerformed

    private void jp3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jp3ComponentShown
       
    }//GEN-LAST:event_jp3ComponentShown

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        if(jd2.getText().equals("")||h2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi Data ini Harus!!!!");
            jd2.requestFocus();
        }
        
        String judul = jd2.getText(); //untuk mengambil nilai yang ada di komponen jTextField1
        String penulis = jc.getSelectedItem().toString(); //untuk mengambil nilai yang ada di komponen jComboBox1
        String harga = h2.getText();//untuk mengambil nilai yang ada di komponen jTextField2
        ValidasiData(judul, penulis, harga); //pemanggilan method 
        InitTable();
        tampilData();
    }//GEN-LAST:event_saveActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        InitTable(); // sintax ini untuk memunculkan pada saat aplikasi dijalankan
        tampilData(); // sintax ini untuk memunculkan pada saat aplikasi dijalankan
    }//GEN-LAST:event_formComponentShown

    private void sr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sr2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sr2ActionPerformed

    private void fndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fndActionPerformed
        
        if(sr2.getText().equals("")){ //ini merupakan pencarian jika kosong
            JOptionPane.showMessageDialog(null,"Harus Diisi");
        }
            else{
            model.getDataVector().removeAllElements(); //menghapus elemen yang ada di jTable1
            model.fireTableDataChanged();
            CariData(jc2.getSelectedItem().toString(),sr2.getText());  
        }
    }//GEN-LAST:event_fndActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0); // ini merupakan sintax keluar dari program i
    }//GEN-LAST:event_exitActionPerformed

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        // TODO add your handling code here:
        save.setBackground(Color.red); ////untuk menampilkan entered ketika mouse masuk akan berwarna merah
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
        // TODO add your handling code here:
        save.setBackground(Color.yellow); //untuk menampilkan exit ketika mouse keluar akan berwarna kuning
    }//GEN-LAST:event_saveMouseExited

    private void jc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc2ActionPerformed

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
            java.util.logging.Logger.getLogger(tugas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tugas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tugas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tugas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tugas7().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change;
    private javax.swing.JButton del;
    private javax.swing.JButton exit;
    private javax.swing.JLabel fdb;
    private javax.swing.JButton fnd;
    private javax.swing.JLabel h;
    private javax.swing.JTextField h2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox jc;
    private javax.swing.JComboBox jc2;
    private javax.swing.JLabel jd;
    private javax.swing.JTextField jd2;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JLabel p;
    private javax.swing.JButton save;
    private javax.swing.JScrollPane scr;
    private javax.swing.JLabel sr;
    private javax.swing.JTextField sr2;
    // End of variables declaration//GEN-END:variables

    }
