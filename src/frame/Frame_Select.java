/*
    Action Perform 까지 진행 완료하였으며 디자인 보정 필요
    현재 카테고리는 6개로 확인
    눌렀을 경우 이동하는 경우는 Action Perform에서 메소드 호출 방식
*/
package frame;

import database.ProductDAO;
import database.ProductDTO;

import java.sql.SQLException;
import java.util.List;

public class Frame_Select extends javax.swing.JFrame {
    
    protected static List<ProductDTO> productList;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cpu;
    private javax.swing.JButton Btn_Disk;
    private javax.swing.JButton Btn_Gpu;
    private javax.swing.JButton Btn_MainBoard;
    private javax.swing.JButton Btn_Power;
    private javax.swing.JButton Btn_Ram;
    private javax.swing.JButton jButton7;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    
    public Frame_Select() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        Btn_Ram = new javax.swing.JButton();
        Btn_Cpu = new javax.swing.JButton();
        Btn_MainBoard = new javax.swing.JButton();
        Btn_Gpu = new javax.swing.JButton();
        Btn_Power = new javax.swing.JButton();
        Btn_Disk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1.setViewportView(jEditorPane1);
        
        ProductDAO productDAO = new ProductDAO();
        productList = productDAO.selectAllProducts();
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        Btn_Ram.setText("RAM");
        Btn_Ram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Ram(evt);
            }
        });
        
        Btn_Cpu.setText("CPU");
        Btn_Cpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Cpu(evt);
            }
        });
        
        Btn_MainBoard.setText("M/B");
        Btn_MainBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MainBoard(evt);
            }
        });
        
        Btn_Gpu.setText("GPU");
        Btn_Gpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Gpu(evt);
            }
        });
        
        Btn_Power.setText("Power");
        Btn_Power.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Power(evt);
            }
        });
        
        Btn_Disk.setText("Disk");
        Btn_Disk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Disk(evt);
            }
        });
        
        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setText("아래 디자인좀....");
        
        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel3.setText("하기 내용 선택");
        
        jButton7.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jButton7.setText("정보");
        jButton7.addActionListener(evt -> {
            try {
                Btn_MyPage(evt);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Btn_Gpu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_Power, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_Disk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Btn_Cpu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_MainBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_Ram, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel1)))
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel3)
                                        .addContainerGap(239, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_Cpu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_MainBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_Ram, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Btn_Gpu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_Power, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_Disk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(57, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel3)
                                        .addContainerGap(251, Short.MAX_VALUE)))
        );
        
        pack();
    }

    private void Btn_MainBoard(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MainBoard
        Frame_MainBoard main = new Frame_MainBoard();
        main.setVisible(true);
    }//GEN-LAST:event_Btn_MainBoard

    private void Btn_Cpu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Cpu
        // TODO add your handling code here:
        Frame_Cpu main = new Frame_Cpu();
        dispose();
        main.setVisible(true);
    }//GEN-LAST:event_Btn_Cpu

    private void Btn_Ram(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Ram
        // TODO add your handling code here:
        Frame_Ram main = new Frame_Ram();
        main.setVisible(true);
    }//GEN-LAST:event_Btn_Ram

    private void Btn_Gpu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Gpu
        // TODO add your handling code here:
        Frame_Gpu main = new Frame_Gpu();
        main.setVisible(true);
    }//GEN-LAST:event_Btn_Gpu

    private void Btn_Power(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Power
        // TODO add your handling code here:
        Frame_Power main = new Frame_Power();
        main.setVisible(true);
    }//GEN-LAST:event_Btn_Power

    private void Btn_Disk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Disk
        // TODO add your handling code here:
        Frame_Disk main = new Frame_Disk();
        main.setVisible(true);
    }//GEN-LAST:event_Btn_Disk

    private void Btn_MyPage(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_Btn_MyPage
        // TODO add your handling code here:
        System.out.println("MyPage btn clicked: "+ Frame_Login.loginUser);
        Frame_MyPage main = new Frame_MyPage();
        main.setVisible(true);
    }//GEN-LAST:event_Btn_MyPage
    // End of variables declaration//GEN-END:variables
}
