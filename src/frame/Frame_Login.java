package frame;
import static database.SimpleConnectionPool.connectionPool;

import database.UserDAO;
import database.UserDTO;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Frame_Login extends javax.swing.JFrame {
    
    public static UserDTO loginUser = null;

    public Frame_Login() {

        setContentPane(new BackgroundPanel("src\\etc\\img\\General\\/GearTop.png"));
        initComponents();
    }

    private void initComponents() {

        System.out.println("Frame_Login initComponents");
        setTitle("Module_Collect");
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("ID:");
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setText("Password:");
        jPasswordField1 = new javax.swing.JPasswordField();
        Btn_Login = new javax.swing.JButton();
        Btn_Login.addActionListener(evt -> Btn_LoginActionPerformed(evt));
        Btn_Login.setText("로그인");
        Btn_Register = new javax.swing.JButton();
        Btn_Register.addActionListener(evt -> Btn_RegisterActionPerformed(evt));
        Btn_Register.setText("회원가입");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(70, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                        .addComponent(jPasswordField1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(Btn_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Btn_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(121, Short.MAX_VALUE))
        );
        pack();
    }

    private void Btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {

        String user_id = jTextField1.getText();
        String user_password = new String(jPasswordField1.getPassword());
        
        UserDAO userDAO = new UserDAO();
        UserDTO user = new UserDTO(user_id, user_password, "", "");
        System.out.println("Login btn clicked: "+user);
        
        if ((loginUser = userDAO.login(user)) != null) {
            JOptionPane.showMessageDialog(this, "로그인 성공");
            dispose();
            new Frame_Select().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
        }
    }                                         

    private void Btn_RegisterActionPerformed(java.awt.event.ActionEvent evt) {

        Frame_Register main = new Frame_Register();
        dispose();
        main.setVisible(true);
    }

    private javax.swing.JButton Btn_Login;
    private javax.swing.JButton Btn_Register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
}
