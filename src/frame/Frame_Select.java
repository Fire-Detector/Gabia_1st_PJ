package frame;

import database.CartDAO;
import database.ProductDAO;
import database.ProductDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;

public class Frame_Select extends javax.swing.JFrame {

	protected static List<ProductDTO> productList;
	private static DefaultTableModel tableModel;
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
	private javax.swing.JButton Btn_Buy;
	private javax.swing.JScrollPane jScrollPane1;
	private JLabel lblCart;
	private JTable productTable;

	public Frame_Select() {
		initComponents();
		loadCartData();
	}

	public static void loadCartData() {
		SwingUtilities.invokeLater(() -> {
			tableModel.setRowCount(0); // EDT 내에서 실행 보장

			CartDAO cartDAO = new CartDAO();
			List<ProductDTO> cartItems = cartDAO.getCartProducts();

			if (cartItems != null && !cartItems.isEmpty()) {
				for (ProductDTO product : cartItems) {
					Object[] rowData = {
						product.getProductName(),
						product.getManufacturer(),
						product.getSpec(),
						product.getReleaseDate(),
						String.format("%,d 원", product.getPrice()),
						product.getCategoryName(),
						product.getProductId()
					};
					tableModel.addRow(rowData);
				}
			}
			// 3. 테이블 갱신
			tableModel.fireTableDataChanged();
		});
	}

	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JEditorPane();
		Btn_Ram = new ShadowButton("RAM");
		Btn_Cpu = new ShadowButton("RAM");
		Btn_MainBoard = new ShadowButton("RAM");
		Btn_Gpu = new ShadowButton("RAM");
		Btn_Power = new ShadowButton("RAM");
		Btn_Disk = new ShadowButton("RAM");
		Btn_Delete = new ShadowButton("RAM");
		Btn_Buy = new ShadowButton("RAM");
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButton7 = new ShadowButton("정보");
		jScrollPane1.setViewportView(jEditorPane1);

		if (productList == null) {
			ProductDAO productDAO = new ProductDAO();
			productList = productDAO.selectAllProducts();
		}

		CartDAO cartDAO = new CartDAO();
		setContentPane(new BackgroundPanel(getClass().getResource("/images/General/GearTop.png")));

		lblCart = new JLabel("장바구니");
		lblCart.setFont(new java.awt.Font("바탕", 0, 18));

		String[] columns = {
			"상품명", "제조사", "스펙",
			"출시일", "가격", "카테고리",
			"상품ID"
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
		Btn_Delete.addActionListener(evt -> Btn_DeleteActionPerformed(evt));

		Btn_Buy.setText("상품 구매");
		Btn_Buy.addActionListener(evt -> {
			int totalPrice = cartDAO.getCartProducts().stream().mapToInt(ProductDTO::getPrice).sum();
			System.out.println("총 가격: " + totalPrice);
			System.out.println();

			if (totalPrice == 0) {
				JOptionPane.showMessageDialog(this, "장바구니에 물건이 없습니다.");
			} else {
				NumberFormat formatter = NumberFormat.getInstance();
				String formattedPrice = formatter.format(totalPrice);

				int answer = JOptionPane.showConfirmDialog(this,
					"총 가격은 : " + formattedPrice + "원입니다.\n구매하시겠습니까?",
					"구매 확인", JOptionPane.YES_NO_OPTION);
				if (answer == 0) {
					try {
						cartDAO.cartBuying(Frame_Login.loginUser.getUser_id());
						loadCartData();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});

		jLabel1.setFont(new java.awt.Font("HY헤드라인M", 1, 18));
		jLabel1.setText("");

		jLabel3.setFont(new java.awt.Font("HY헤드라인M", 1, 18));
		jLabel3.setText("");

		jButton7.addActionListener(evt -> {
			try {
				Btn_MyPage(evt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		setPreferredSize(new java.awt.Dimension(750, 650));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(31, 31, 31)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(Btn_Gpu, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
								javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addComponent(Btn_Power, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
								javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addComponent(Btn_Disk, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(Btn_Cpu, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
								javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addComponent(Btn_MainBoard, javax.swing.GroupLayout.PREFERRED_SIZE,
								150,
								javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addComponent(Btn_Ram, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(8, 8, 8)
							.addComponent(jLabel1))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCart)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
								javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(Btn_Buy, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 776,
								Short.MAX_VALUE)
							.addContainerGap()))
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addGap(41, 41, 41)
						.addComponent(jLabel3)
						.addContainerGap(239, Short.MAX_VALUE))));
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(21, 21, 21)
					.addComponent(jLabel1)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(Btn_Cpu, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(Btn_MainBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(Btn_Ram, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(Btn_Gpu, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(Btn_Power, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(Btn_Disk, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblCart)
						.addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(Btn_Buy, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addContainerGap()
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addGap(43, 43, 43)
						.addComponent(jLabel3)
						.addContainerGap(251, Short.MAX_VALUE))));

		pack();
	}

	static class ShadowButton extends JButton {
		public ShadowButton(String text) {
			super(text);
			setContentAreaFilled(false);
			setFocusPainted(false);
			setBorderPainted(false);
			setForeground(new Color(27, 38, 54));
			setFont(new Font("바탕", Font.BOLD , 18));
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

	private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedRow = productTable.getSelectedRow();

		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "삭제할 상품을 선택하세요.");
			return;
		}

		int modelRow = productTable.convertRowIndexToModel(selectedRow);
		int productId = (int)tableModel.getValueAt(modelRow, 6);

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
		Frame_MainBoard next = new Frame_MainBoard();
		Point location = this.getLocation();
		next.setLocation(location);
		next.setVisible(true);
	}

	private void Btn_Cpu(java.awt.event.ActionEvent evt) {
		Frame_Cpu next = new Frame_Cpu();
		Point location = this.getLocation();
		next.setLocation(location);
		next.setVisible(true);
	}

	private void Btn_Ram(java.awt.event.ActionEvent evt) {
		Frame_Ram next = new Frame_Ram();
		Point location = this.getLocation();
		next.setLocation(location);
		next.setVisible(true);
	}

	private void Btn_Gpu(java.awt.event.ActionEvent evt) {
		Frame_Gpu next = new Frame_Gpu();
		Point location = this.getLocation();
		next.setLocation(location);
		next.setVisible(true);
	}

	private void Btn_Power(java.awt.event.ActionEvent evt) {
		Frame_Power next = new Frame_Power();
		Point location = this.getLocation();
		next.setLocation(location);
		next.setVisible(true);
	}

	private void Btn_Disk(java.awt.event.ActionEvent evt) {
		Frame_Disk next = new Frame_Disk();
		Point location = this.getLocation();
		next.setLocation(location);
		next.setVisible(true);
	}

	private void Btn_MyPage(java.awt.event.ActionEvent evt) throws SQLException {
		System.out.println("MyPage btn clicked: " + Frame_Login.loginUser);
		Frame_MyPage next = new Frame_MyPage(this);
		Point location = this.getLocation();
		next.setLocation(location);
		next.setVisible(true);
	}
}
