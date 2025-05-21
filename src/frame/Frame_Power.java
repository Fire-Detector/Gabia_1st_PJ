/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/*
    아이템 보여주고 1번째는 아이템 번호, 2번째는 아이템 이름 
*/

package frame;

import java.awt.*;
import java.util.* ;
import java.util.List;

import javax.swing.*;

import database.ProductDAO;
import database.ProductDTO;

/**
 *
 * @author 솔데스크
 */
public class Frame_Power extends javax.swing.JFrame {

    public Frame_Power() {
        initComponents();
    }

    List<ProductDTO> powerList = null;

    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Lbl_Power1 = new javax.swing.JLabel();
        Lbl_Power2 = new javax.swing.JLabel();
        Lbl_Power3 = new javax.swing.JLabel();
        Lbl_Name1 = new javax.swing.JLabel();
        Lbl_Name2 = new javax.swing.JLabel();
        Lbl_Name3 = new javax.swing.JLabel();
        Lbl_Price1 = new javax.swing.JLabel();
        Lbl_Price2 = new javax.swing.JLabel();
        Lbl_Price3 = new javax.swing.JLabel();
        Lbl_Info2 = new javax.swing.JLabel();
        Lbl_Info3 = new javax.swing.JLabel();
        Lbl_Info1 = new javax.swing.JLabel();
        Lbl_Exam1 = new javax.swing.JLabel();
        Lbl_Exam3 = new javax.swing.JLabel();
        Lbl_Exam2 = new javax.swing.JLabel();
        Button_Next = new javax.swing.JButton();
        Btn_Selec1 = new javax.swing.JButton();
        Btn_Selec2 = new javax.swing.JButton();
        Btn_Selec3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Btn_MoveSelect = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 550));

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setText("Power");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 3, 18)); // NOI18N
        // jLabel2.setText("아이템 추가는 소스에서 추가 가능");

        Lbl_Name1.setText("제조사:");

        Lbl_Name2.setText("제조사:");

        Lbl_Name3.setText("제조사:");

        Lbl_Price1.setText("제품명:");

        Lbl_Price2.setText("제품명:");

        Lbl_Price3.setText("제품명:");

        Lbl_Info2.setText("출시일:");

        Lbl_Info3.setText("출시일:");

        Lbl_Info1.setText("출시일:");

        Lbl_Exam1.setText("판매가:");

        Lbl_Exam3.setText("판매가:");

        Lbl_Exam2.setText("판매가:");

        Button_Next.setLabel("다음 페이지");
        Button_Next.setPreferredSize(new java.awt.Dimension(100, 30));
        Button_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NextActionPerformed(evt);
            }
        });

        powerList = new ArrayList();
        for (ProductDTO product : Frame_Select.productList) {
            if (product.getCategoryId() == 6)
                powerList.add(product);
        }


        ImageIcon cpuImg1 = new ImageIcon("src\\etc\\img\\Power\\power1.png");
        Image scaled1 = cpuImg1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Lbl_Power1.setIcon(new ImageIcon(scaled1));

        ImageIcon cpuImg2 = new ImageIcon("src\\etc\\img\\Power\\power2.png");
        Image scaled2 = cpuImg2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Lbl_Power2.setIcon(new ImageIcon(scaled2));

        ImageIcon cpuImg3 = new ImageIcon("src\\etc\\img\\Power\\power3.png");
        Image scaled3 = cpuImg3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Lbl_Power3.setIcon(new ImageIcon(scaled3));


        System.out.println("In Power: "+powerList);
        ProductDAO productDAO = new ProductDAO();
        ProductDTO showProduct = powerList.remove(0);
        jLabel3.setText(showProduct.getProductName());      // product_name
        jLabel4.setText(showProduct.getManufacturer());     // manufacturer
        jLabel5.setText(showProduct.getReleaseDate());      // release_date
        jLabel8.setText(String.valueOf(showProduct.getPrice()));    // price
        ProductDTO finalShowProduct1 = showProduct;
        Btn_Selec1.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, productDAO.addCart(finalShowProduct1.getProductId()) ?
                "카트에 제품 추가" : "카트에 해당 상품이 이미 담겨 있습니다");
        });
        Btn_Selec1.setText("추가");

        showProduct = powerList.remove(0);
        jLabel10.setText(showProduct.getManufacturer());      // product_name
        jLabel11.setText(showProduct.getProductName());     // manufacturer
        jLabel12.setText(showProduct.getReleaseDate());      // release_date
        jLabel13.setText(String.valueOf(showProduct.getPrice()));    // price
        ProductDTO finalShowProduct2 = showProduct;
        Btn_Selec2.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, productDAO.addCart(finalShowProduct2.getProductId()) ?
                "카트에 제품 추가" : "카트에 해당 상품이 이미 담겨 있습니다");
        });
        Btn_Selec2.setText("추가");

        showProduct = powerList.remove(0);
        jLabel14.setText(showProduct.getManufacturer());      // product_name
        jLabel16.setText(showProduct.getProductName());     // manufacturer
        jLabel18.setText(showProduct.getReleaseDate());      // release_date
        jLabel19.setText(String.valueOf(showProduct.getPrice()));    // price
        ProductDTO finalShowProduct3 = showProduct;
        Btn_Selec3.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, productDAO.addCart(finalShowProduct3.getProductId()) ?
                "카트에 제품 추가" : "카트에 해당 상품이 이미 담겨 있습니다");
        });
        Btn_Selec3.setText("추가");

        Btn_MoveSelect.setText("초기화면");
        Btn_MoveSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MoveSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Lbl_Power3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lbl_Price3)
                                .addComponent(Lbl_Name3)
                                .addComponent(Lbl_Info3)
                                .addComponent(Lbl_Exam3)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Lbl_Power2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lbl_Name2)
                                .addComponent(Lbl_Info2)
                                .addComponent(Lbl_Exam2)
                                .addComponent(Lbl_Price2)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Lbl_Power1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lbl_Name1)
                                .addComponent(Lbl_Exam1)
                                .addComponent(Lbl_Price1)
                                .addComponent(Lbl_Info1))))
                    .addComponent(Btn_MoveSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_Selec3)
                            .addComponent(Btn_Selec2)
                            .addComponent(Btn_Selec1)))
                    .addComponent(Button_Next, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lbl_Power1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_Power2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Lbl_Name2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lbl_Price2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lbl_Info2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lbl_Exam2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_Power3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Lbl_Name3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lbl_Price3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lbl_Info3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lbl_Exam3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_MoveSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button_Next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Lbl_Name1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Lbl_Price1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Lbl_Info1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Lbl_Exam1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Btn_Selec1)
                                    .addGap(95, 95, 95)
                                    .addComponent(Btn_Selec2)
                                    .addGap(95, 95, 95)
                                    .addComponent(Btn_Selec3))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(236, 236, 236)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel19))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>                        

    private void Button_NextActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Frame_PowerNext next = new Frame_PowerNext(powerList);
        Point location = this.getLocation();
        next.setLocation(location);
        next.setVisible(true);
        dispose();
    }                                           

    private void Btn_Selec3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Btn_Selec2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Btn_Selec1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Btn_MoveSelectActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

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
            java.util.logging.Logger.getLogger(Frame_Power.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Power.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Power.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Power.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Power().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Btn_MoveSelect;
    private javax.swing.JButton Btn_Selec1;
    private javax.swing.JButton Btn_Selec2;
    private javax.swing.JButton Btn_Selec3;
    private javax.swing.JButton Button_Next;
    private javax.swing.JLabel Lbl_Exam1;
    private javax.swing.JLabel Lbl_Exam2;
    private javax.swing.JLabel Lbl_Exam3;
    private javax.swing.JLabel Lbl_Info1;
    private javax.swing.JLabel Lbl_Info2;
    private javax.swing.JLabel Lbl_Info3;
    private javax.swing.JLabel Lbl_Name1;
    private javax.swing.JLabel Lbl_Name2;
    private javax.swing.JLabel Lbl_Name3;
    private javax.swing.JLabel Lbl_Power1;
    private javax.swing.JLabel Lbl_Power2;
    private javax.swing.JLabel Lbl_Power3;
    private javax.swing.JLabel Lbl_Price1;
    private javax.swing.JLabel Lbl_Price2;
    private javax.swing.JLabel Lbl_Price3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration                   
}
