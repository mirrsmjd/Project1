package manager.view;
// 이덕만
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import manager.model.MemberDao;
import manager.model.MemberVO;
import manager.model.OrderDao;
import manager.model.OrderVO;
import manager.model.ProdDao;
import manager.model.ProdVO;
import manager.model.ShopDao;
import manager.model.ShopVO;

public class OrderDetail extends JFrame implements KeyListener, ActionListener,
	MouseListener {

	//필드
	private JPanel     pane_1, pane_2, pane_3, pane_4;
	private JTextField orderCode;
	private JLabel     lblOrder, orderQuan, orderDate;
	private JButton    btnFind, btnMem, btnShop, btnProd;
	private JLabel     userCode, userId, userName, userPhone, userAddr;
	private JLabel     shopCode, shopName, shopPhone, shopAddr;
	private JLabel     prodCode, prodName, prodPrice, prodSize;

	String             ordercode   = "";
	OrderDetail        orderDetail = null;

	// 생성자
	public OrderDetail() {
		initComponent();
	}
	public OrderDetail(String inOrderCode) {
		this.ordercode = inOrderCode;
		initComponent();
		orderCode.setText(inOrderCode);
	}

	private void initComponent() {
		setTitle("주문상세조회");
		getContentPane().setLayout(null);

		pane_1 = new JPanel();
		pane_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pane_1.setBounds(30, 10, 566, 82);
		pane_1.setLayout(null);

		JLabel lblOrderCode = new JLabel("주문코드:");
		lblOrderCode.setBounds(12, 8, 54, 15);
		lblOrderCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_1.add(lblOrderCode);

		lblOrder = new JLabel("ORDER-");
		lblOrder.setBounds(78, 7, 42, 17);
		lblOrder.setFont(new Font("굴림체", Font.PLAIN, 14));
		pane_1.add(lblOrder);

		orderCode = new JTextField();
		orderCode.setBounds(128, 5, 116, 21);
		orderCode.setColumns(10);
		pane_1.add(orderCode);

		btnFind = new JButton("조회");
		btnFind.setBounds(444, 4, 97, 23);
		pane_1.add(btnFind);

		JLabel lblOrderQuan = new JLabel("주문수량:");
		lblOrderQuan.setBounds(78, 45, 54, 15);
		lblOrderQuan.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_1.add(lblOrderQuan);

		orderQuan = new JLabel();
		orderQuan.setBounds(141, 42, 97, 20);
		orderQuan.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_1.add(orderQuan);

		JLabel lblOrderDate = new JLabel("주문일:");
		lblOrderDate.setBounds(244, 45, 42, 15);
		lblOrderDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_1.add(lblOrderDate);

		orderDate = new JLabel();
		orderDate.setBounds(296, 43, 245, 20);
		orderDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_1.add(orderDate);

		getContentPane().add(pane_1);

		pane_2 = new JPanel();
		pane_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pane_2.setBounds(30, 105, 566, 89);
		pane_2.setLayout(null);

		btnMem = new JButton("구매회원");
		btnMem.setBounds(12, 5, 104, 25);
		btnMem.setFont(new Font("굴림체", Font.PLAIN, 14));
		pane_2.add(btnMem);

		JLabel lblUserCode = new JLabel("회원코드:");
		lblUserCode.setBounds(128, 10, 54, 15);
		lblUserCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_2.add(lblUserCode);

		userCode = new JLabel();
		userCode.setBounds(191, 5, 76, 25);
		userCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_2.add(userCode);

		JLabel lblUserId = new JLabel("회원아이디:");
		lblUserId.setBounds(279, 10, 66, 15);
		lblUserId.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_2.add(lblUserId);

		userId = new JLabel();
		userId.setBounds(350, 5, 76, 25);
		userId.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_2.add(userId);

		JLabel lblUserPhone = new JLabel("회원전화:");
		lblUserPhone.setBounds(36, 53, 54, 15);
		lblUserPhone.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_2.add(lblUserPhone);

		userPhone = new JLabel();
		userPhone.setBounds(94, 47, 104, 25);
		userPhone.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_2.add(userPhone);

		JLabel lblUserAddr = new JLabel("회원주소:");
		lblUserAddr.setBounds(207, 53, 54, 15);
		lblUserAddr.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_2.add(lblUserAddr);

		userAddr = new JLabel();
		userAddr.setBounds(268, 47, 286, 25);
		userAddr.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_2.add(userAddr);

		getContentPane().add(pane_2);

		JLabel lblUserName = new JLabel("회원이름:");
		lblUserName.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblUserName.setBounds(431, 10, 57, 15);
		pane_2.add(lblUserName);

		userName = new JLabel();
		userName.setFont(new Font("굴림체", Font.PLAIN, 12));
		userName.setBounds(500, 10, 57, 15);
		pane_2.add(userName);

		pane_3 = new JPanel();
		pane_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pane_3.setBounds(30, 204, 566, 89);
		pane_3.setLayout(null);

		btnShop = new JButton("판매상호");
		btnShop.setBounds(12, 5, 102, 25);
		btnShop.setFont(new Font("굴림체", Font.PLAIN, 14));
		pane_3.add(btnShop);

		JLabel lblShopCode = new JLabel("상호코드:");
		lblShopCode.setBounds(126, 10, 54, 15);
		lblShopCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_3.add(lblShopCode);

		shopCode = new JLabel();
		shopCode.setBounds(182, 5, 90, 25);
		shopCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_3.add(shopCode);

		JLabel lblShopName = new JLabel("상호명:");
		lblShopName.setBounds(284, 10, 42, 15);
		lblShopName.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_3.add(lblShopName);

		shopName = new JLabel();
		shopName.setBounds(333, 5, 189, 25);
		shopName.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_3.add(shopName);

		JLabel lblShopPhone = new JLabel("상호전화:");
		lblShopPhone.setBounds(36, 52, 54, 15);
		lblShopPhone.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_3.add(lblShopPhone);

		shopPhone = new JLabel();
		shopPhone.setBounds(94, 48, 111, 25);
		shopPhone.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_3.add(shopPhone);

		JLabel lblShopAddr = new JLabel("상호주소:");
		lblShopAddr.setBounds(210, 52, 54, 15);
		lblShopAddr.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_3.add(lblShopAddr);

		shopAddr = new JLabel();
		shopAddr.setBounds(268, 40, 286, 39);
		shopAddr.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_3.add(shopAddr);

		getContentPane().add(pane_3);

		pane_4 = new JPanel();
		pane_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pane_4.setBounds(30, 303, 566, 89);
		pane_4.setLayout(null);

		btnProd = new JButton("판매상품");
		btnProd.setBounds(12, 5, 101, 25);
		btnProd.setFont(new Font("굴림체", Font.PLAIN, 14));
		pane_4.add(btnProd);

		JLabel lblProdCode = new JLabel("상품코드:");
		lblProdCode.setBounds(125, 10, 54, 15);
		lblProdCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_4.add(lblProdCode);

		prodCode = new JLabel();
		prodCode.setBounds(181, 5, 93, 25);
		prodCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_4.add(prodCode);

		JLabel lblProdName = new JLabel("상품명:");
		lblProdName.setBounds(286, 10, 42, 15);
		lblProdName.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_4.add(lblProdName);

		prodName = new JLabel();
		prodName.setBounds(335, 5, 192, 25);
		prodName.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_4.add(prodName);

		JLabel lblProdPrice = new JLabel("상품가격:");
		lblProdPrice.setBounds(40, 53, 54, 15);
		lblProdPrice.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_4.add(lblProdPrice);

		prodPrice = new JLabel();
		prodPrice.setBounds(96, 50, 103, 20);
		prodPrice.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_4.add(prodPrice);

		JLabel lblProdSize = new JLabel("상품사이즈:");
		lblProdSize.setBounds(210, 53, 66, 15);
		lblProdSize.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_4.add(lblProdSize);

		prodSize = new JLabel();
		prodSize.setBounds(285, 50, 157, 20);
		prodSize.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane_4.add(prodSize);

		getContentPane().add(pane_4);

		// 기능
		orderCode.addKeyListener(this);
		btnFind.addActionListener(this);
		orderCode.addMouseListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(642, 441);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// 키보드 기능
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			btnFind.doClick();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { }
	// 버튼 액션 기능
	@Override
	public void actionPerformed(ActionEvent e) {
		OrderDao  orderDao = new OrderDao();
		String inOrdercode = lblOrder.getText() + orderCode.getText();
		if(!orderCode.getText().equals("")) {
			if(orderDao.checkOrderCode(inOrdercode)) {
				OrderVO orderVO = orderDao.getCode(inOrdercode);
				orderDetail = new OrderDetail(orderCode.getText());
				orderDetail.setViewData(orderVO);
			} else {
				JOptionPane.showMessageDialog(null, "없는 코드 입니다");
			}
		} else {
			JOptionPane.showMessageDialog(null, "코드번호를 입력하세요");
		}
		if(orderDetail != null) setVisible(false);
	}
	// 마우스 기능
	@Override
	public void mouseClicked(MouseEvent e) {
		this.orderCode.setText("");
	}
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) {	}
	// 구매자 정보 화면에 뿌리기
	private void setViewData(OrderVO orderVO) {
		String[] ordercode = orderVO.getOrderCode().split("-");
		String   orderquan = String.valueOf(orderVO.getOrderQuan());
		String   orderdate = orderVO.getOrderDate();
		String   usercode  = orderVO.getUserCode();
		String   prodcode  = orderVO.getProdCode();

		this.orderCode.setText(ordercode[1]);
		this.orderQuan.setText(orderquan);
		this.orderDate.setText(orderdate);
		MemberDao memDao = new MemberDao();
		if(memDao.checkUserCode(usercode) ) {
			MemberVO memVO   = memDao.getMember(usercode);
			String   usid    = memVO.getUserid();
			String   usname  = memVO.getUsername();
			String   usphone = memVO.getPhone();
			String   usaddr  = memVO.getAddr();
			this.userCode.setText(usercode);
			this.userId.setText(usid);
			this.userName.setText(usname);
			this.userPhone.setText(usphone);
			this.userAddr.setText(usaddr);
		} else if(memDao.checkOUserCode(usercode)) {
			MemberVO memVO   = memDao.getOutMember(usercode);
			String   usname  = memVO.getUsername();
			String   usphone = memVO.getPhone();
			this.userCode.setText(usercode);
			this.userName.setText(usname);
			this.userPhone.setText(usphone);
			this.btnMem.setText("탈퇴회원");
			this.btnMem.setForeground(new Color(255, 0, 0));
		}
		ProdDao prodDao = new ProdDao();
		String  shcode = "";
		if(prodDao.checkProdCode(prodcode)) {
			ProdVO prodVO  = prodDao.getProd(prodcode);
			String prname  = prodVO.getProdName();
			String prprice = String.valueOf(prodVO.getProdPrice());
			String prsize  = prodVO.getProdSize();
			this.prodCode.setText(prodcode);
			this.prodName.setText(prname);
			this.prodPrice.setText(prprice);
			this.prodSize.setText(prsize);
			ShopDao shopDao = new ShopDao();
			shcode = prodVO.getShopCode();
			if(shopDao.checkShopCode(shcode) ) {
				ShopVO shopVO  = shopDao.getShop(shcode);
				String shname  = shopVO.getShopName();
				String shphone = shopVO.getShopPhone();
				String shaddr  = shopVO.getShopAddr();
				this.shopCode.setText(shcode);
				this.shopName.setText(shname);
				this.shopPhone.setText(shphone);
				this.shopAddr.setText(shaddr);
			} else if(shopDao.checkOShopCode(shcode)) {
				ShopVO shopVO  = shopDao.getOutShop(shcode);
				String shname  = shopVO.getShopName();
				String shphone = shopVO.getShopPhone();
				String shaddr  = shopVO.getShopAddr();
				this.shopCode.setText(shcode);
				this.shopName.setText(shname);
				this.shopPhone.setText(shphone);
				this.shopAddr.setText(shaddr);
				this.btnShop.setText("폐업상호");
				this.btnShop.setForeground(new Color(255, 0, 0));
			}
		} else if(prodDao.checkOProdCode(prodcode) ) {
			ProdVO prodVO  = prodDao.getOutProd(prodcode);
			String prname  = prodVO.getProdName();
			String prprice = String.valueOf(prodVO.getProdPrice());
			String prsize  = prodVO.getProdSize();
			this.prodCode.setText(prodcode);
			this.prodName.setText(prname);
			this.prodPrice.setText(prprice);
			this.prodSize.setText(prsize);
			this.btnProd.setText("단종상품");
			this.btnProd.setForeground(new Color(255, 0, 0));
			ShopDao shopDao = new ShopDao();
			shcode = prodVO.getShopCode();
			if(shopDao.checkShopCode(shcode) ) {
				ShopVO shopVO  = shopDao.getShop(shcode);
				String shname  = shopVO.getShopName();
				String shphone = shopVO.getShopPhone();
				String shaddr  = shopVO.getShopAddr();
				this.shopCode.setText(shcode);
				this.shopName.setText(shname);
				this.shopPhone.setText(shphone);
				this.shopAddr.setText(shaddr);
			} else if(shopDao.checkOShopCode(shcode)) {
				ShopVO shopVO  = shopDao.getOutShop(shcode);
				String shname  = shopVO.getShopName();
				String shphone = shopVO.getShopPhone();
				String shaddr  = shopVO.getShopAddr();
				this.shopCode.setText(shcode);
				this.shopName.setText(shname);
				this.shopPhone.setText(shphone);
				this.shopAddr.setText(shaddr);
				this.btnShop.setText("폐업상호");
				this.btnShop.setForeground(new Color(255, 0, 0));
			}
		}
	}
	
	public static void main(String[] args) {
		new OrderDetail();
	}
}
