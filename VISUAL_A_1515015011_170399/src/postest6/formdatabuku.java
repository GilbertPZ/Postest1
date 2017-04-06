/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postest6;
import postest6.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Acer E5-475G
 */
public class formdatabuku extends javax.swing.JFrame {

    private DefaultTableModel model;
    private final Connection con = koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;
    
    private int baris;
    private boolean kebenaran;
    /**
     * Creates new form fromdatabuku
     */
    public formdatabuku() {
        initComponents();
    }
    
    private void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("JUDUL");
        model.addColumn("PENULIS");
        model.addColumn("HARGA");
        
        tb.setModel(model);
    }
    
    private void TampilData(){
        try {
            String sql = "SELECT * FROM buku";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getInt("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    private void TambahData(String judul, String penulis, String harga){
        try {
            String sql = 
                    "INSERT INTO buku VALUES (NULL,'"+judul+"','"+penulis+"',"+harga+")";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            model.addRow(new Object[]{judul,penulis,harga});
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void HapusData(String id,int baris){
        try {
            
            String sqldelete = 
                    "DELETE FROM buku WHERE id='"+id+"'";
            stt = con.createStatement();
            stt.executeUpdate(sqldelete);
            model.removeRow(baris);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     private void UbahData(String judul,String penulis, String harga, String id){
        try {
            
            String sql = "UPDATE buku SET "
                         + "judul='"+judul+"',"
                         + "penulis='"+penulis+"',"
                         + "harga='"+harga+"'"
                         + "WHERE id='"+id+"'";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    private void validasi (String judul, String penulis, String harga){
        try {
            String sql = "SELECT * FROM judul";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[2];
                o[0] = rss.getString("judul").toLowerCase();
                o[1] = rss.getString("penulis").toLowerCase();
                
                if( o[0].equals(judul.toLowerCase()) && o[1].equals(penulis.toLowerCase())){
                    JOptionPane.showMessageDialog(null,"Data telah ada");
                    kebenaran=false;
                    break;
                }
            }
            if(kebenaran==true){
                TambahData(judul, penulis, harga);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
  
    }
    private void CariId(){
        try{
            String sql = "SELECT*from buku where id='"+src.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   
              o[0] = rss.getInt("id");
              o[1] = rss.getString("judul");
              o[2] = rss.getString("penulis");
              o[3] = rss.getString("harga");
              model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariJudul(){
        try{
            String sql = "SELECT*from buku where judul='"+src.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   
              o[0] = rss.getInt("id");
              o[1] = rss.getString("judul");
              o[2] = rss.getString("penulis");
              o[3] = rss.getString("harga");
              model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariPenulis(){
        try{
            String sql = "SELECT*from buku where penulis='"+src.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   
              o[0] = rss.getInt("id");
              o[1] = rss.getString("judul");
              o[2] = rss.getString("penulis");
              o[3] = rss.getString("harga");
              model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariHarga(){
        try{
            String sql = "SELECT*from buku where harga='"+src.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   
              o[0] = rss.getInt("id");
              o[1] = rss.getString("judul");
              o[2] = rss.getString("penulis");
              o[3] = rss.getString("harga");
              model.addRow(o);
            }
        }catch(SQLException e){
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

        jSpinner1 = new javax.swing.JSpinner();
        JP1 = new javax.swing.JPanel();
        JP2 = new javax.swing.JPanel();
        JP3 = new javax.swing.JPanel();
        JL1 = new javax.swing.JLabel();
        JP4 = new javax.swing.JPanel();
        JL2 = new javax.swing.JLabel();
        JL3 = new javax.swing.JLabel();
        JL4 = new javax.swing.JLabel();
        jdl = new javax.swing.JTextField();
        hrg = new javax.swing.JTextField();
        pls = new javax.swing.JComboBox();
        JP5 = new javax.swing.JPanel();
        JL5 = new javax.swing.JLabel();
        src = new javax.swing.JTextField();
        JP6 = new javax.swing.JPanel();
        ca = new javax.swing.JButton();
        kb = new javax.swing.JButton();
        id = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        sv = new javax.swing.JButton();
        cn = new javax.swing.JButton();
        dl = new javax.swing.JButton();
        ex = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        JP1.setBackground(new java.awt.Color(46, 156, 156));
        JP1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                JP1ComponentShown(evt);
            }
        });

        JP2.setBackground(new java.awt.Color(157, 199, 197));

        JP3.setBackground(new java.awt.Color(153, 176, 210));

        JL1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        JL1.setForeground(new java.awt.Color(51, 51, 255));
        JL1.setText("FORM DATA BUKU");

        javax.swing.GroupLayout JP3Layout = new javax.swing.GroupLayout(JP3);
        JP3.setLayout(JP3Layout);
        JP3Layout.setHorizontalGroup(
            JP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(JL1)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        JP3Layout.setVerticalGroup(
            JP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JP2Layout = new javax.swing.GroupLayout(JP2);
        JP2.setLayout(JP2Layout);
        JP2Layout.setHorizontalGroup(
            JP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(JP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP2Layout.setVerticalGroup(
            JP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(JP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        JP4.setBackground(new java.awt.Color(157, 192, 197));

        JL2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JL2.setText("Judul");

        JL3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JL3.setText("Penulis");

        JL4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JL4.setText("Harga");

        pls.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        pls.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORTRED", "MAGINA", "ILLIDAN", "STARK" }));
        pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP4Layout = new javax.swing.GroupLayout(JP4);
        JP4.setLayout(JP4Layout);
        JP4Layout.setHorizontalGroup(
            JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL3)
                    .addComponent(JL2)
                    .addComponent(JL4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hrg)
                    .addComponent(jdl)
                    .addComponent(pls, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP4Layout.setVerticalGroup(
            JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL2)
                    .addComponent(jdl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL3)
                    .addComponent(pls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL4)
                    .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JP5.setBackground(new java.awt.Color(153, 192, 197));

        JL5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JL5.setText("Search");

        JP6.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        ca.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ca.setText("Cari");
        ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caActionPerformed(evt);
            }
        });
        JP6.add(ca);

        kb.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        kb.setText("Kembali");
        kb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbActionPerformed(evt);
            }
        });
        JP6.add(kb);

        id.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Judul", "Penulis", "Harga" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("By  :");

        javax.swing.GroupLayout JP5Layout = new javax.swing.GroupLayout(JP5);
        JP5.setLayout(JP5Layout);
        JP5Layout.setHorizontalGroup(
            JP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JP6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP5Layout.setVerticalGroup(
            JP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JP6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JL5)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        sv.setBackground(new java.awt.Color(157, 192, 197));
        sv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        sv.setText("SAVE");
        sv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svActionPerformed(evt);
            }
        });

        cn.setBackground(new java.awt.Color(153, 192, 197));
        cn.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cn.setText("CHANGE");
        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });

        dl.setBackground(new java.awt.Color(153, 192, 197));
        dl.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        dl.setText("DELETE");
        dl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlActionPerformed(evt);
            }
        });

        ex.setBackground(new java.awt.Color(153, 192, 197));
        ex.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ex.setText("EXIT");
        ex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exMouseClicked(evt);
            }
        });
        ex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exActionPerformed(evt);
            }
        });

        tb.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Judul", "Penulis", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        javax.swing.GroupLayout JP1Layout = new javax.swing.GroupLayout(JP1);
        JP1.setLayout(JP1Layout);
        JP1Layout.setHorizontalGroup(
            JP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JP1Layout.createSequentialGroup()
                        .addComponent(sv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ex, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP1Layout.setVerticalGroup(
            JP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ex, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plsActionPerformed

    private void JP1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_JP1ComponentShown
        // TODO add your handling code here:
         InitTable();
        TampilData();
    }//GEN-LAST:event_JP1ComponentShown

    private void svActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svActionPerformed
        // TODO add your handling code here:
        if(jdl.getText().equals("") && hrg.getText().equals(""))
     {
           JOptionPane.showMessageDialog(null, "Data Belum Lengkap","Warning !!!!",JOptionPane.INFORMATION_MESSAGE);
           jdl.requestFocus();
     } else{
        String judul = jdl.getText();
        String penulis = pls.getSelectedItem().toString();
        String harga = hrg.getText();
        TambahData(judul,penulis,harga);
        validasi(judul, penulis, harga);
        
        InitTable();
        TampilData();
    }//GEN-LAST:event_svActionPerformed
    }
    private void exMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exMouseClicked
        // TODO add your handling code here:
         System.exit(0); 
    }//GEN-LAST:event_exMouseClicked

    private void dlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlActionPerformed
        // TODO add your handling code here:
        String id = tb.getValueAt(baris, 0).toString();
        HapusData( id, baris);
    }//GEN-LAST:event_dlActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        // TODO add your handling code here:
        int baris = tb.getSelectedRow();
        
        String judul=tb.getValueAt(baris,1).toString();
        String penulis=tb.getValueAt(baris,2).toString();
        String harga=tb.getValueAt(baris,3).toString();
        String id=tb.getValueAt(baris,0).toString();
        
        
        jdl.setText(judul);
        pls.setSelectedItem(penulis);
        hrg.setText(harga);
    }//GEN-LAST:event_tbMouseClicked

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
        int baris = tb.getSelectedRow();
        
        
        tb.setValueAt(jdl.getText(),baris,1);
        tb.setValueAt(pls.getSelectedItem(),baris,2);
        tb.setValueAt(hrg.getText(),baris,3); 
        
        String judul=tb.getValueAt(baris,1).toString();
        String penulis=tb.getValueAt(baris,2).toString();
        String harga=tb.getValueAt(baris,3).toString();
        String id=tb.getValueAt(baris,0).toString();
        
        
        jdl.setText(judul);
        pls.setSelectedItem(penulis);
        hrg.setText(harga);
        
        UbahData(judul,penulis,harga,id);
    }//GEN-LAST:event_cnActionPerformed

    private void caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caActionPerformed
        // TODO add your handling code here:
       if(src.getText().equals("")){
            JOptionPane.showMessageDialog(null,"ISI DULU GAN!!!");
        }
        else{
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            if(id.getSelectedItem().equals("Id")){
             CariId();  
            }
            else if(id.getSelectedItem().equals("Judul")){
             CariJudul();
            }
            else if(id.getSelectedItem().equals("Penulis")){
             CariPenulis();
            }
            else if(id.getSelectedItem().equals("Harga")){
             CariHarga();
             }
        }
    }//GEN-LAST:event_caActionPerformed

    private void kbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbActionPerformed
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_kbActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
       InitTable();
       TampilData(); 
    }//GEN-LAST:event_formComponentShown

    private void exActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exActionPerformed

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
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formdatabuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL1;
    private javax.swing.JLabel JL2;
    private javax.swing.JLabel JL3;
    private javax.swing.JLabel JL4;
    private javax.swing.JLabel JL5;
    private javax.swing.JPanel JP1;
    private javax.swing.JPanel JP2;
    private javax.swing.JPanel JP3;
    private javax.swing.JPanel JP4;
    private javax.swing.JPanel JP5;
    private javax.swing.JPanel JP6;
    private javax.swing.JButton ca;
    private javax.swing.JButton cn;
    private javax.swing.JButton dl;
    private javax.swing.JButton ex;
    private javax.swing.JTextField hrg;
    private javax.swing.JComboBox id;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jdl;
    private javax.swing.JButton kb;
    private javax.swing.JComboBox pls;
    private javax.swing.JTextField src;
    private javax.swing.JButton sv;
    private javax.swing.JTable tb;
    // End of variables declaration//GEN-END:variables

   
}
