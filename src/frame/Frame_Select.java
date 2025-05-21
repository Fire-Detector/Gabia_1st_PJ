package frame;

import database.CartDAO;
import database.ProductDAO;
import database.ProductDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class Frame_Select extends javax.swing.JFrame {

    protected static List<ProductDTO> productList;

    private javax.swing.JButton Btn_Cpu;
    private javax.swing.JButton Btn_Disk;
    private javax.swing.JButton Btn_Gpu;
    private javax.swing.JButton Btn_MainBoard;
    private javax.swing.JButton Btn_Power;
    private javax.swing.JButton Btn_Ram;
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton jButton7;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private JLabel lblCart;
    private JTable productTable;
    private DefaultTableModel tableModel;

    public Frame_Select() {
        initComponents();
        loadCartData();
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
        Btn_Delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1.setViewportView(jEditorPane1);

        if (productList == null) {
            ProductDAO productDAO = new ProductDAO();
            productList = productDAO.selectAllProducts();
        }

        CartDAO cartDAO = new CartDAO();
        List<ProductDTO> cartItems = cartDAO.getCartProducts();

        lblCart = new JLabel("장바구니");
        lblCart.setFont(new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 18));

        String[] columns = {
                "상품ID", "상품명", "제조사",
                "스펙", "출시일", "가격", "카테고리"
        };

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        productTable = new JTable(tableModel);
        productTable.setRowHeight(25);
        productTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(productTable);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_Ram.setText("RAM");
        Btn_Ram.addActionListener(evt -> Btn_Ram(evt));

        Btn_Cpu.setText("CPU");
        Btn_Cpu.addActionListener(evt -> Btn_Cpu(evt));

        Btn_MainBoard.setText("M/B");
        Btn_MainBoard.addActionListener(evt -> Btn_MainBoard(evt));

        Btn_Gpu.setText("GPU");
        Btn_Gpu.addActionListener(evt -> Btn_Gpu(evt));

        Btn_Power.setText("Power");
        Btn_Power.addActionListener(evt -> Btn_Power(evt));

        Btn_Disk.setText("Disk");
        Btn_Disk.addActionListener(evt -> Btn_Disk(evt));

        Btn_Delete.setText("상품 삭제");
        Btn_Delete.setFont(new java.awt.Font("맑은 고딕", 0, 16));
        Btn_Delete.addActionListener(evt -> Btn_DeleteActionPerformed(evt));

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18));
        jLabel1.setText("");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 18));
        jLabel3.setText("");

        jButton7.setFont(new java.awt.Font("맑은 고딕", 0, 18));
        jButton7.setText("정보");
        jButton7.addActionListener(evt -> {
            try {
                Btn_MyPage(evt);
            } catch (SQLException e) {
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
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblCart)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                                                .addContainerGap()))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCart)
                                        .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10)
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addContainerGap()
                                .addContainerGap(57, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel3)
                                        .addContainerGap(251, Short.MAX_VALUE)))
        );

        pack();
    }

    private void loadCartData() {
        tableModel.setRowCount(0); // 🧹 기존 데이터 초기화

        CartDAO cartDAO = new CartDAO();
        List<ProductDTO> cartItems = cartDAO.getCartProducts();

        if (cartItems != null && !cartItems.isEmpty()) {
            for (ProductDTO product : cartItems) {
                Object[] rowData = {
                        product.getProductId(),
                        product.getProductName(),
                        product.getManufacturer(),
                        product.getSpec(),
                        product.getReleaseDate(),
                        String.format("%,d 원", product.getPrice()),
                        product.getCategoryId()
                };
                tableModel.addRow(rowData);
            }
        }
    }

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = productTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 상품을 선택하세요.");
            return;
        }

        int modelRow = productTable.convertRowIndexToModel(selectedRow);
        int productId = (int) tableModel.getValueAt(modelRow, 0);

        CartDAO cartDAO = new CartDAO();
        boolean success = cartDAO.deleteProductFromCart(productId);

        if (success) {
            loadCartData(); // ✅ 삭제 후 데이터 새로고침
            JOptionPane.showMessageDialog(this, "상품이 장바구니에서 삭제되었습니다.");
        } else {
            JOptionPane.showMessageDialog(this, "삭제에 실패했습니다.");
        }
    }

    private void Btn_MainBoard(java.awt.event.ActionEvent evt) {
        Frame_MainBoard main = new Frame_MainBoard();
        this.setVisible(false);
        main.setVisible(true);
    }

    private void Btn_Cpu(java.awt.event.ActionEvent evt) {
        Frame_Cpu main = new Frame_Cpu();
        this.setVisible(false);
        main.setVisible(true);
    }

    private void Btn_Ram(java.awt.event.ActionEvent evt) {
        Frame_Ram main = new Frame_Ram();
        this.setVisible(false);
        main.setVisible(true);
    }

    private void Btn_Gpu(java.awt.event.ActionEvent evt) {
        Frame_Gpu main = new Frame_Gpu();
        main.setVisible(true);
        this.setVisible(false);
    }

    private void Btn_Power(java.awt.event.ActionEvent evt) {
        Frame_Power main = new Frame_Power();
        main.setVisible(true);
        this.setVisible(false);
    }

    private void Btn_Disk(java.awt.event.ActionEvent evt) {
        Frame_Disk main = new Frame_Disk();
        main.setVisible(true);
        this.setVisible(false);
    }

    private void Btn_MyPage(java.awt.event.ActionEvent evt) throws SQLException {
        System.out.println("MyPage btn clicked: " + Frame_Login.loginUser);
        Frame_MyPage main = new Frame_MyPage();
        this.setVisible(false);
        main.setVisible(true);
    }
}
