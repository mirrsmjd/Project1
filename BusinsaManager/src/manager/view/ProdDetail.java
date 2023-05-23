package manager.view;
// 이덕만
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import manager.model.ProdDao;
import manager.model.ProdVO;
import manager.model.ShopDao;
import manager.model.ShopVO;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ProdDetail extends JFrame implements KeyListener, ActionListener {
	// 필드
	private JPanel      topPane;
	private JLabel      lblTxtShopName, lblTxtProdList; 
	private JTextField  prodCode;
	private JLabel      shopCode, shopAddr, shopPhone, shopCeo, lblCodeName, prodName;
	private JLabel      prodPrice, prodSize, prodInven, prodRegiDate, prodOutDate;
	private JButton     btnFind, btnClear, btnDelete;  
	private JTable      jTable;
	private JScrollPane jSpane;

	String              prodcode   = "";
	String              shopcode   = "";
	ShopDetail          shopDetail = null;
	ProdDetail          prodDetail = null;

	// 생성자
	public ProdDetail() {
		initComponent();
	}
	public ProdDetail(String inprodcode) {
		this.prodcode = inprodcode;
		initComponent();
		prodCode.setText(inprodcode);
	}
	public ProdDetail(String inshopcode, String inprodcode) {
		this.shopcode = inshopcode;
		this.prodcode = inprodcode;
		initComponent();
		shopCode.setText(inshopcode);
		prodCode.setText(inprodcode);
	}

	// 화면 배치
	private void initComponent() {
		setTitle("상품상세조회");
		getContentPane().setLayout(null);

		topPane    = new JPanel();
		topPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		topPane.setBounds(0, 0, 601, 323);
		topPane.setLayout(null);

		lblTxtShopName = new JLabel("");
		lblTxtShopName.setFont(new Font("굴림체", Font.BOLD, 16));
		lblTxtShopName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTxtShopName.setBounds(12, 8, 198, 24);
		topPane.add(lblTxtShopName);

		JLabel lblTxtProd = new JLabel("상호 정보 및 상품정보");
		lblTxtProd.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblTxtProd.setBounds(222, 10, 130, 22);
		topPane.add(lblTxtProd);

		JLabel lblShopCode = new JLabel("상호코드:");
		lblShopCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopCode.setBounds(26, 50, 57, 15);
		topPane.add(lblShopCode);

		shopCode = new JLabel();
		shopCode.setFont(new Font("굴림체", Font.PLAIN, 14));
		shopCode.setBounds(91, 41, 86, 34);
		topPane.add(shopCode);

		JLabel lblShopAddr = new JLabel("상호주소:");
		lblShopAddr.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopAddr.setBounds(219, 43, 57, 28);
		topPane.add(lblShopAddr);

		shopAddr = new JLabel();
		shopAddr.setFont(new Font("굴림체", Font.PLAIN, 12));
		shopAddr.setBounds(277, 41, 275, 34);
		topPane.add(shopAddr);

		JLabel lblShopPhone = new JLabel("상호전화:");
		lblShopPhone.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopPhone.setBounds(26, 100, 57, 15);
		topPane.add(lblShopPhone);

		shopPhone = new JLabel();
		shopPhone.setFont(new Font("굴림체", Font.PLAIN, 12));
		shopPhone.setBounds(91, 87, 130, 34);
		topPane.add(shopPhone);

		JLabel lblShopCeo = new JLabel("대표자:");
		lblShopCeo.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopCeo.setBounds(233, 100, 43, 15);
		topPane.add(lblShopCeo);

		shopCeo = new JLabel();
		shopCeo.setFont(new Font("굴림체", Font.PLAIN, 12));
		shopCeo.setBounds(277, 87, 147, 34);
		topPane.add(shopCeo);

		JLabel lblProdCode = new JLabel("상품코드:");
		lblProdCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblProdCode.setBounds(26, 150, 57, 15);
		topPane.add(lblProdCode);

		lblCodeName = new JLabel("PROD-");
		lblCodeName.setFont(new Font("굴림체", Font.PLAIN, 14));
		lblCodeName.setBounds(87, 150, 43, 15);
		topPane.add(lblCodeName);

		prodCode = new JTextField();
		prodCode.setBounds(133, 141, 70, 34);
		topPane.add(prodCode);

		JLabel lblProdName = new JLabel("상품명:");
		lblProdName.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblProdName.setBounds(233, 150, 43, 15);
		topPane.add(lblProdName);

		prodName = new JLabel();
		prodName.setFont(new Font("굴림체", Font.PLAIN, 12));
		prodName.setBounds(277, 143, 143, 28);
		topPane.add(prodName);

		JLabel lblProdPrice = new JLabel("상품가격:");
		lblProdPrice.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblProdPrice.setBounds(26, 199, 57, 23);
		topPane.add(lblProdPrice);

		prodPrice = new JLabel();
		prodPrice.setFont(new Font("굴림체", Font.PLAIN, 12));
		prodPrice.setBounds(91, 199, 116, 19);
		topPane.add(prodPrice);

		JLabel lblProdSize = new JLabel("상품사이즈:");
		lblProdSize.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblProdSize.setBounds(214, 199, 70, 23);
		topPane.add(lblProdSize);

		prodSize = new JLabel();
		prodSize.setFont(new Font("굴림체", Font.PLAIN, 12));
		prodSize.setBounds(292, 199, 43, 19);
		topPane.add(prodSize);

		JLabel lblProdInven = new JLabel("재고량:");
		lblProdInven.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblProdInven.setBounds(358, 199, 43, 23);
		topPane.add(lblProdInven);

		prodInven = new JLabel();
		prodInven.setFont(new Font("굴림체", Font.PLAIN, 12));
		prodInven.setBounds(404, 199, 57, 19);
		topPane.add(prodInven);

		JLabel lblProdRegiDate = new JLabel("상품등록일:");
		lblProdRegiDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblProdRegiDate.setBounds(14, 249, 69, 24);
		topPane.add(lblProdRegiDate);

		prodRegiDate = new JLabel();
		prodRegiDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		prodRegiDate.setBounds(87, 245, 123, 28);
		topPane.add(prodRegiDate);

		JLabel lblProdOutDate = new JLabel("상품단종일:");
		lblProdOutDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblProdOutDate.setBounds(214, 254, 78, 15);
		topPane.add(lblProdOutDate);

		prodOutDate = new JLabel();
		prodOutDate.setForeground(new Color(255, 0, 0));
		prodOutDate.setBounds(277, 249, 113, 24);
		topPane.add(prodOutDate);

		lblTxtProdList = new JLabel();
		lblTxtProdList.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTxtProdList.setFont(new Font("굴림체", Font.BOLD, 16));
		lblTxtProdList.setBounds(26, 289, 195, 34);
		topPane.add(lblTxtProdList);

		JLabel lblProdList = new JLabel("의 제품목록");
		lblProdList.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblProdList.setBounds(222, 292, 75, 22);
		topPane.add(lblProdList);

		btnFind = new JButton("조회");
		btnFind.setBounds(424, 286, 139, 28);
		topPane.add(btnFind);

		btnClear = new JButton("클리어");
		btnClear.setBounds(486, 243, 97, 28);
		topPane.add(btnClear);

		btnDelete = new JButton("상품삭제");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(486, 196, 97, 28);
		topPane.add(btnDelete);

		getContentPane().add(topPane);

		jTable = new JTable();
		jTable.setFont(new Font("굴림체", Font.PLAIN, 12));
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jSpane = new JScrollPane(jTable);
		jSpane.setBounds(0, 324, 601, 237);
		getContentPane().add(jSpane);

		jTable.setModel(
				new DefaultTableModel(getProdList(shopcode), getProdColumnList()) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				}
				);
		resizeColumnWidth(jTable);
		// 기능
		prodCode.addKeyListener(this);
		btnFind.addActionListener(this);
		btnClear.addActionListener(this);
		btnDelete.addActionListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(617, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// 키보드 기능
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(prodDetail  != null) prodDetail.dispose();
			btnFind.doClick();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { }
	// 버튼 액션 기능
	@Override
	public void actionPerformed(ActionEvent e) {
		if(prodDetail != null) prodDetail.dispose();
		switch(e.getActionCommand()) {  
		case "조회" : 
			codeFind();
			break;
		case "클리어" :
			viewClear();
			break;
		case "상품삭제" :
			if(!prodCode.getText().equals("")) {
				prodDelete();
				viewClear();
			}
			break;
		}
	}
	// 상품 코드로 찾기
	private void codeFind() {
		ShopDao shopDao = new ShopDao();
		ProdDao prodDao = new ProdDao();
		String  prcode  = (lblCodeName.getText() + prodCode.getText()).toUpperCase();
		if(!prodCode.getText().equals("")) {
			if(prodDao.checkProdCode(prcode)) {
				ProdVO prodVO = prodDao.getProd(prcode);
				String shcode = prodVO.getShopCode();
				ShopVO shopVO = shopDao.getShop(shcode);
				prodDetail = new ProdDetail(shcode, prcode);
				prodDetail.setViewProdData(shopVO, prodVO);
			} else if(prodDao.checkOProdCode(prcode)) {
				ProdVO prodVO = prodDao.getOutProd(prcode);
				String shcode = prodVO.getShopCode();
				if(shopDao.checkShopCode(shcode)) {
					ShopVO shopVO = shopDao.getShop(shcode);
					prodDetail = new ProdDetail(shcode, prcode);
					prodDetail.setViewProdData(shopVO, prodVO);
				} else if(shopDao.checkOShopCode(shcode)) {
					ShopVO shopVO = shopDao.getOutShop(shcode);
					prodDetail = new ProdDetail(shcode, prcode);
					prodDetail.setViewProdData(shopVO, prodVO);
				} 
			} else {
				JOptionPane.showMessageDialog(null, "없는 상품코드 입니다");
			}
		} else {
			JOptionPane.showMessageDialog(null, "상품번호를 입력하세요");
		}
		if(prodDetail != null) setVisible(false);
	}
	// 상품 정보 화면에 뿌리기
	private void setViewProdData(ShopVO shopVO, ProdVO prodVO) {
		String shopcode     = shopVO.getShopCode();
		String shopname     = shopVO.getShopName();
		String shopaddr     = shopVO.getShopAddr();
		String shopphone    = shopVO.getShopPhone();
		String shopceo      = shopVO.getShopCeo();
		String[] prodcode   = prodVO.getProdCode().trim().split("-");
		String prodname     = prodVO.getProdName();
		int    prodprice    = prodVO.getProdPrice();
		String prodsize     = prodVO.getProdSize();
		int    prodinven    = prodVO.getProdInven();
		String prodregidate = prodVO.getProdRegiDate();
		String prodoutdate  = prodVO.getProdOutDate();

		this.shopCode.setText(shopcode);
		this.lblTxtShopName.setText(shopname);
		this.shopAddr.setText(shopaddr);
		this.shopPhone.setText(shopphone);
		this.shopCeo.setText(shopceo);
		this.prodCode.setText(prodcode[1]);
		this.prodName.setText(prodname);
		this.prodPrice.setText(String.valueOf(prodprice));
		this.prodSize.setText(prodsize);
		this.prodInven.setText(String.valueOf(prodinven));
		this.prodRegiDate.setText(prodregidate);
		this.prodOutDate.setText(prodoutdate);
		this.shopCode.setText(shopcode);
		this.lblTxtProdList.setText(shopname);
	}
	// JTable 컬럼 넓이 자동 조절
	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 50; 
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width +1 , width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
	// 상호에 등록된 상품 목록 가져오기 
	private Vector<Vector> getProdList(String shopcode) {
		ProdDao prodDao = new ProdDao();
		Vector<Vector> prodList = prodDao.getProdList(shopcode);
		return prodList;
	}
	private Vector<String> getProdColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("순번");
		cols.add("상품코드");
		cols.add("상품명");
		cols.add("상품가격");
		cols.add("상품사이즈");
		cols.add("상품재고량");
		cols.add("상품등록일");
		cols.add("상품단종일");
		cols.add("상호코드");
		return cols;
	}
	// 화면 클리어
	private void viewClear() {
		lblTxtShopName.setText("");
		shopCode.setText("");
		shopAddr.setText("");
		shopPhone.setText("");
		shopCeo.setText("");
		prodCode.setText("");
		prodName.setText("");
		prodPrice.setText("");
		prodSize.setText("");
		prodInven.setText("");
		prodRegiDate.setText("");
		prodOutDate.setText("");
		lblTxtProdList.setText("");
		jTable.setModel(
				new DefaultTableModel(getProdList(""), getProdColumnList()) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				}
				);
		resizeColumnWidth(jTable);
	}
	// 상품삭제
	private void prodDelete() {
		String inProdCode = "PROD-" + prodCode.getText();
		if(inProdCode.trim().equals("")) return;
		ProdDao prodDao = new ProdDao();
		if(!inProdCode.equals("")) {
			if(prodDao.checkProdCode(inProdCode)) {
				int choice = JOptionPane.showConfirmDialog(null,
						prodName.getText() + "를 삭제하시겠습니까?", "삭제확인",
						JOptionPane.OK_CANCEL_OPTION);
				String msg = "";
				if(choice == 0) {
					int aftcnt = prodDao.delete1(inProdCode);
					prodDao.delete2(inProdCode);
					prodDao.delete3(inProdCode);
					if(aftcnt > 0) {
						msg = "삭제되었습니다";
					} else {
						msg = "삭제되지 않았습니다";
					}
				} else {
					msg = "취소를 클릭하였습니다";
				}
				JOptionPane.showMessageDialog(null, msg,
						"삭제", JOptionPane.OK_OPTION);

			} else if(prodDao.checkOProdCode(inProdCode)) {
				JOptionPane.showMessageDialog(null, "이미 단종된 제품입니다");
			}
		}
	}

	public static void main(String[] args) {
		new ProdDetail();
	}
}
