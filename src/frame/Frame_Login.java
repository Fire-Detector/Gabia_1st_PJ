package frame;


import java.awt.*;

import database.UserDAO;
import database.UserDTO;

import javax.swing.*;

public class Frame_Login extends javax.swing.JFrame {

    public static UserDTO loginUser = null;

    public Frame_Login() {

        System.out.println("isResource?: "+getClass().getResource("/images/CPU/cpu5.jpg"));
        System.out.println("BG: "+getClass().getResource("/images/General/GearTop.png").toString());
        setContentPane(new BackgroundPanel(getClass().getResource("/images/General/GearTop.png")));
        initComponents();
    }

    private void initComponents() {

        System.out.println("Frame_Login initComponents");
        setTitle("Module_Collect");
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("사용자 ID:");
        jLabel1.setFont(new Font("바탕", Font.BOLD , 14));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setText("사용자 PW:");
        jLabel2.setFont(new Font("바탕", Font.BOLD , 14));
        jPasswordField1 = new javax.swing.JPasswordField();
        Btn_Login = new ShadowButton("로그인");
        Btn_Login.addActionListener(evt -> Btn_LoginActionPerformed(evt));
        Btn_Register = new ShadowButton("회원가입");
        Btn_Register.addActionListener(evt -> Btn_RegisterActionPerformed(evt));

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
                                                .addComponent(Btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(Btn_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    static class ShadowButton extends JButton {
        public ShadowButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setForeground(new Color(27, 38, 54));
            setFont(new Font("바탕", Font.BOLD , 14));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setMargin(new Insets(10, 20, 10, 20));
        }

        @Override
        protected void paintComponent(Graphics g) {
            int arc = 10; // 5px radius
            int shadowSpread = 10; // 그림자 번짐 정도(픽셀)
            int shadowAlpha = 120; // 그림자 불투명도(0~255, 높을수록 진함)
            Color shadowColor = new Color(0, 0, 0, shadowAlpha);

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 그림자 여러 겹으로 번짐 효과
            for (int i = shadowSpread; i > 0; i--) {
                int alpha = (int) (shadowAlpha * ((float) i / shadowSpread) * 0.6); // 점점 연해지게
                g2.setColor(new Color(0, 0, 0, alpha));
                g2.fillRoundRect(
                    i, i,
                    getWidth() - i * 2,
                    getHeight() - i * 2,
                    arc + i, arc + i
                );
            }

            // 버튼 배경
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, getWidth() - shadowSpread / 2, getHeight() - shadowSpread / 2, arc, arc);

            // 버튼 텍스트
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        public void paintBorder(Graphics g) {
            // 테두리 없음
        }
    }

    private void Btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {

        String user_id = jTextField1.getText();
        String user_password = new String(jPasswordField1.getPassword());

        UserDAO userDAO = new UserDAO();
        UserDTO user = new UserDTO(user_id, user_password, "", "");
        System.out.println("Login btn clicked: "+user);

        if ((loginUser = userDAO.login(user)) != null) {
            JOptionPane.showMessageDialog(this, "로그인 성공");

            Point location = this.getLocation();
            Frame_Select next = new Frame_Select();
            next.setLocationRelativeTo(null);
            next.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
        }
    }

    private void Btn_RegisterActionPerformed(java.awt.event.ActionEvent evt) {

        Frame_Register next = new Frame_Register();
        Point location = this.getLocation();
        next.setLocation(location);
        next.setVisible(true);
    }

    private javax.swing.JButton Btn_Login;
    private javax.swing.JButton Btn_Register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
}
