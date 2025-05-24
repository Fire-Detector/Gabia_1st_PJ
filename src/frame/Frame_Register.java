package frame;

import database.UserDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Frame_Register extends javax.swing.JFrame {

	boolean a = true;
    UserDAO userDAO = new UserDAO();
    public Frame_Register() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("아이디:");
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setText("비밀번호:");
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setText("전화번호:");
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setText("성별:");
        Radio_Male = new javax.swing.JRadioButton();
        Radio_Male.setText("남자");
        Radio_Female = new javax.swing.JRadioButton();
        Radio_Female.setText("여자");
        Register_Id = new javax.swing.JTextField();
        Regsiter_Phone = new javax.swing.JTextField();
        Register_Password = new javax.swing.JPasswordField();
        Register_Btn = new javax.swing.JButton();
        Register_Btn.setText("회원가입");
        Register_Btn.addActionListener(evt -> Register_BtnActionPerformed(evt));
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setText("회원가입창");
        Register_Check = new javax.swing.JButton();
        Register_Check.setText("중복확인");
        Register_Check.addActionListener(evt -> Register_CheckActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(Register_Id)
                                                                        .addComponent(Regsiter_Phone)
                                                                        .addComponent(Register_Password,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Register_Check))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(Radio_Male)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Radio_Female))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(162, 162, 162)
                                                .addComponent(Register_Btn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel5)))
                                .addContainerGap(14, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel5)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(Register_Id, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Register_Check))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(Register_Password, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(Regsiter_Phone, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(Radio_Male)
                                        .addComponent(Radio_Female))
                                .addGap(27, 27, 27)
                                .addComponent(Register_Btn)
                                .addContainerGap(29, Short.MAX_VALUE)));
        pack();
    }

    private void Register_CheckActionPerformed(java.awt.event.ActionEvent evt) {

        this.a = userDAO.IdCheck1(Register_Id.getText());
    }


    private void Register_BtnActionPerformed(java.awt.event.ActionEvent evt) {

        // 1. 입력값 꺼내기
        String user_id = Register_Id.getText();
        String user_password = new String(Register_Password.getPassword());
        String user_phone = Regsiter_Phone.getText();
        boolean isMale = Radio_Male.isSelected();
        boolean isFemale = Radio_Female.isSelected();
        String user_gender = isMale ? "M":"F";
        Pattern phonePattern = Pattern.compile("^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$");

        boolean isValidID = userDAO.isValidPassword(user_password);
        boolean isValidPhone = phonePattern.matcher(user_phone).matches();
        boolean isValidGender = isMale != isFemale;
        boolean isValid = isValidID && isValidPhone && isValidGender;
        String dialogMsg = "";
        if (a){dialogMsg+="아이디 중복체크를 진행해주세요.\n";}
        if (!isValidGender){dialogMsg+="하나의 성별을 선택해주세요.\n";}
        if (!isValidID){dialogMsg+="비밀번호는 8자 이상, 영문자/숫자/특수문자를 포함해야 합니다.\n";}
        if (!isValidPhone){dialogMsg+="전화번호를 000-0000-0000 형식으로 입력해주세요.";}
        if (isValid) {
            if(userDAO.register(user_id, user_password, user_phone, user_gender)){
                dialogMsg = "회원가입 성공";   
            } else {
                dialogMsg = "회원가입 실패";
                
            }
            dispose();
        }
        JOptionPane.showMessageDialog(this, dialogMsg);
    }// GEN-LAST:event_Register_BtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_Register.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Register.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Register.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Register.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JRadioButton Radio_Female;
    private javax.swing.JRadioButton Radio_Male;
    private javax.swing.JButton Register_Btn;
    private javax.swing.JButton Register_Check;
    private javax.swing.JTextField Register_Id;
    private javax.swing.JPasswordField Register_Password;
    private javax.swing.JTextField Regsiter_Phone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration
}
