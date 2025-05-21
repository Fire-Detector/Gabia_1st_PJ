package frame;

import database.ProductDAO;
import database.UserDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Frame_MyPage extends javax.swing.JFrame {
    public Frame_MyPage() {
        System.out.println("init Frame_MyPage, loginUser : " + Frame_Login.loginUser);
        initComponents();
    }

    private void initComponents() {
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Btn_Selec = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();  // 삭제 버튼 추가

        jLabel5.setText(Frame_Login.loginUser.getUser_id());
        jLabel7.setText(Frame_Login.loginUser.getUser_phone());
        jLabel8.setText(Frame_Login.loginUser.getUser_gender());

        jLabel6.setText("jLabel5");

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 24));
        jLabel1.setText("마이페이지");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 24));
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 24));
        jLabel3.setText("전화번호:");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 0, 24));
        jLabel4.setText("성별:");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 0, 24));
        jLabel7.setFont(new java.awt.Font("맑은 고딕", 0, 24));
        jLabel8.setFont(new java.awt.Font("맑은 고딕", 0, 24));

        Btn_Selec.setText("선택화면으로 돌아가기");
        Btn_Selec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SelecActionPerformed(evt);
            }
        });

        Btn_Delete.setText("회원 탈퇴");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Btn_DeleteActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)))
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_Selec, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(Btn_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(34, 34, 34)
                .addComponent(Btn_Selec, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }

    private void Btn_SelecActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Select next = new Frame_Select();
        dispose();
        next.setVisible(true);
    }

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        int confirm = JOptionPane.showConfirmDialog(this, "정말 회원 탈퇴 하시겠습니까?", "회원 탈퇴 확인", JOptionPane.YES_NO_OPTION);
        ProductDAO connection = new ProductDAO();
        if (confirm == JOptionPane.YES_OPTION) {
            UserDAO dao = new UserDAO();
			String userId = Frame_Login.loginUser.getUser_id();
            System.out.println(userId);
			boolean result = dao.deleteUser(userId);
			if (result) {
			    JOptionPane.showMessageDialog(this, "회원 탈퇴가 완료되었습니다.");
			    this.dispose();
			    new Frame_Login().setVisible(true);
			} else {
			    JOptionPane.showMessageDialog(this, "회원 탈퇴에 실패했습니다.");
			}
        }
    }

    // Variables declaration
    private javax.swing.JButton Btn_Selec;
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
}
