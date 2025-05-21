/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
// 패키지 경로에 맞춰 수정


/*
    아이템 보여주고 1번째는 아이템 번호, 2번째는 아이템 이름 
*/
package frame;

import database.ProductDAO;
import database.ProductDTO;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


/**
 * @author 솔데스크
 */
public class Frame_Cpu extends javax.swing.JFrame {
    
    // Variables declaration - do not modify
    private javax.swing.JButton Btn_MoveSelect;
    private javax.swing.JButton Btn_Selec1;
    private javax.swing.JButton Btn_Selec2;
    private javax.swing.JButton Btn_Selec3;
    private javax.swing.JButton Button_Next;
    private javax.swing.JLabel Lbl_Cpu1;
    private javax.swing.JLabel Lbl_Cpu2;
    private javax.swing.JLabel Lbl_Cpu3;
    private javax.swing.JLabel Lbl_Exam1;
    private javax.swing.JLabel Lbl_Exam2;
    private javax.swing.JLabel Lbl_Exam3;
    private javax.swing.JLabel Lbl_Info1;
    private javax.swing.JLabel Lbl_Info2;
    private javax.swing.JLabel Lbl_Info3;
    private javax.swing.JLabel Lbl_Name1;
    private javax.swing.JLabel Lbl_Name2;
    private javax.swing.JLabel Lbl_Name3;
    private javax.swing.JLabel Lbl_Price1;
    private javax.swing.JLabel Lbl_Price2;
    private javax.swing.JLabel Lbl_Price3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    
    
    private List<ProductDTO> cpuList;
    public Frame_Cpu() {
        initComponents();
    }

    private void initComponents() {
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Lbl_Cpu1 = new javax.swing.JLabel();
        Lbl_Cpu2 = new javax.swing.JLabel();
        Lbl_Cpu3 = new javax.swing.JLabel();
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
        
        setPreferredSize(new java.awt.Dimension(450, 480));
        
        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setText("CPU");
        
        jLabel2.setFont(new java.awt.Font("맑은 고딕", 3, 18)); // NOI18N
        jLabel2.setText("아이템 추가는 소스에서 추가 가능");
        
        ImageIcon cpuImg1 = new ImageIcon("src\\etc\\img\\CPU\\cpu1.png");
        Image scaled1 = cpuImg1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Lbl_Cpu1.setIcon(new ImageIcon(scaled1));
        Lbl_Cpu1.setText("");
        ImageIcon cpuImg2 = new ImageIcon("src\\etc\\img\\CPU\\cpu2.png");
        Image scaled2 = cpuImg2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Lbl_Cpu2.setIcon(new ImageIcon(scaled2));
        Lbl_Cpu2.setText("");
        ImageIcon cpuImg3 = new ImageIcon("src\\etc\\img\\CPU\\cpu3.png");
        Image scaled3 = cpuImg3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Lbl_Cpu3.setIcon(new ImageIcon(scaled3));
        Lbl_Cpu3.setText("");
        
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
        
        
        cpuList = new ArrayList<>();
        for (ProductDTO product : Frame_Select.productList) {
            if (product.getCategoryId() == 1) cpuList.add(product);
        }
        
        ProductDAO productDAO = new ProductDAO();
        ProductDTO showProduct = cpuList.remove(0);
        jLabel3.setText(showProduct.getProductName());      // product_name
        jLabel4.setText(showProduct.getManufacturer());     // manufacturer
        jLabel5.setText(showProduct.getReleaseDate());      // release_date
        jLabel8.setText(String.valueOf(showProduct.getPrice()));    // price
        ProductDTO finalShowProduct1 = showProduct;
        Btn_Selec1.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, productDAO.addCart(finalShowProduct1.getProductId()) ? "카트에 제품 추가" : "카트에 해당 상품이 이미 담겨 있습니다");
        });
        Btn_Selec1.setText("추가");
        
        showProduct = cpuList.remove(0);
        jLabel10.setText(showProduct.getProductName());      // product_name
        jLabel11.setText(showProduct.getManufacturer());     // manufacturer
        jLabel12.setText(showProduct.getReleaseDate());      // release_date
        jLabel13.setText(String.valueOf(showProduct.getPrice()));    // price
        ProductDTO finalShowProduct2 = showProduct;
        Btn_Selec2.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, productDAO.addCart(finalShowProduct2.getProductId()) ? "카트에 제품 추가" : "카트에 해당 상품이 이미 담겨 있습니다");
        });
        Btn_Selec2.setText("추가");
        
        showProduct = cpuList.remove(0);
        jLabel14.setText(showProduct.getProductName());      // product_name
        jLabel16.setText(showProduct.getManufacturer());     // manufacturer
        jLabel18.setText(showProduct.getReleaseDate());      // release_date
        jLabel19.setText(String.valueOf(showProduct.getPrice()));    // price
        ProductDTO finalShowProduct3 = showProduct;
        Btn_Selec3.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, productDAO.addCart(finalShowProduct3.getProductId()) ? "카트에 제품 추가" : "카트에 해당 상품이 이미 담겨 있습니다");
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(Lbl_Cpu3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(Lbl_Price3)
                                                                .addComponent(Lbl_Name3)
                                                                .addComponent(Lbl_Info3)
                                                                .addComponent(Lbl_Exam3)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(Lbl_Cpu2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(Lbl_Name2)
                                                                .addComponent(Lbl_Info2)
                                                                .addComponent(Lbl_Exam2)
                                                                .addComponent(Lbl_Price2)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(Lbl_Cpu1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(Lbl_Name1)
                                                                .addComponent(Lbl_Exam1)
                                                                .addComponent(Lbl_Price1)
                                                                .addComponent(Lbl_Info1))))
                                        .addComponent(Btn_MoveSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
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
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(Button_Next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                                .addComponent(Lbl_Cpu1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Lbl_Cpu2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                        .addComponent(Lbl_Cpu3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel14)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel16)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel18)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel19))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(Lbl_Name3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(Lbl_Price3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(Lbl_Info3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(Lbl_Exam3)))))
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
                                                .addComponent(jLabel8)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Button_Next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_MoveSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        
        jLabel1.getAccessibleContext().setAccessibleName("");
        
        pack();
    }// </editor-fold>

    private void Button_NextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Frame_CpuNext next = new Frame_CpuNext(cpuList);
        dispose();
        next.setVisible(true);
    }

    private void Btn_Selec1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Btn_Selec2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Btn_Selec3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Btn_MoveSelectActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Frame_Select next = new Frame_Select();
        dispose();
        next.setVisible(true);
    }
    // End of variables declaration                   
}
