package manager.view;
// 이덕만
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import manager.model.ShopDao;
import manager.model.ShopVO;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ShopDetail extends JFrame implements KeyListener, ActionListener,
MouseListener {

	// 필드
	private JPanel      topPane;
	private JLabel      lblTxtByshopList; 
	private JTextField  byShop, shopCode, shopName, shopPhone, shopAddr, shopTime, shopCeo;
	private JLabel      shopPasw, regiDate, outDate;
	private JButton     btnFind, btnRegi, btnClear, btnDelete;  
	private JTable      jTable;
	private JScrollPane jSpane;

	String              shopcode   = "";
	ShopDetail          shopDetail = null;

	// 생성자
	public ShopDetail() {
		initComponent();
	}
	public ShopDetail(String bycode, String code) {
		this.shopcode = bycode;
		initComponent();
		switch(bycode) {
		case "B" : 
			this.lblTxtByshopList.setText("보세샵");
			this.byShop.setText(bycode);		
			break;
		case "P" :
			this.lblTxtByshopList.setText("편집샵");
			this.byShop.setText(bycode);	
			break;
		case "V" : 
			this.lblTxtByshopList.setText("빈티지샵"); 
			this.byShop.setText(bycode);	
			break;
		}
		shopCode.setText(code);
	}

	// 화면 배치
	private void initComponent() {
		setTitle("상호상세조회");
		getContentPane().setLayout(null);

		topPane    = new JPanel();
		topPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		topPane.setBounds(0, 0, 800, 214);
		topPane.setLayout(null);

		JLabel lblShopCode = new JLabel("상호코드:");
		lblShopCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopCode.setBounds(41, 17, 57, 15);
		topPane.add(lblShopCode);

		byShop = new JTextField();
		byShop.setFont(new Font("굴림체", Font.PLAIN, 14));
		byShop.setBounds(99, 8, 29, 34);
		topPane.add(byShop);

		JLabel lblBar = new JLabel("-");
		lblBar.setFont(new Font("굴림", Font.PLAIN, 14));
		lblBar.setBounds(129, 7, 19, 35);
		topPane.add(lblBar);

		shopCode = new JTextField();
		shopCode.setFont(new Font("굴림체", Font.PLAIN, 14));
		shopCode.setBounds(140, 8, 74, 34);
		topPane.add(shopCode);

		JLabel lblShopName = new JLabel("상호명:");
		lblShopName.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopName.setBounds(259, 10, 43, 28);
		topPane.add(lblShopName);

		shopName = new JTextField();
		shopName.setBounds(303, 8, 183, 34);
		topPane.add(shopName);

		JLabel lblShopPasw = new JLabel("패스워드:");
		lblShopPasw.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopPasw.setBounds(516, 17, 57, 15);
		topPane.add(lblShopPasw);

		shopPasw = new JLabel();
		shopPasw.setBounds(577, 8, 130, 34);
		topPane.add(shopPasw);

		JLabel lblShopPhone = new JLabel("PHONE:");
		lblShopPhone.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopPhone.setBounds(530, 65, 43, 15);
		topPane.add(lblShopPhone);

		shopPhone = new JTextField();
		shopPhone.setBounds(577, 56, 147, 34);
		topPane.add(shopPhone);

		JLabel lblShopAddr = new JLabel("주소:");
		lblShopAddr.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopAddr.setBounds(64, 61, 32, 15);
		topPane.add(lblShopAddr);

		shopAddr = new JTextField();
		shopAddr.setBounds(98, 52, 379, 34);
		topPane.add(shopAddr);

		JLabel lblShopTime = new JLabel("영업시간:");
		lblShopTime.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopTime.setBounds(245, 111, 57, 15);
		topPane.add(lblShopTime);

		shopTime = new JTextField();
		shopTime.setBounds(303, 103, 143, 32);
		topPane.add(shopTime);

		JLabel lblShopCeo = new JLabel("대표자:");
		lblShopCeo.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblShopCeo.setBounds(50, 106, 43, 23);
		topPane.add(lblShopCeo);

		shopCeo = new JTextField();
		shopCeo.setFont(new Font("굴림체", Font.PLAIN, 14));
		shopCeo.setBounds(98, 101, 116, 34);
		topPane.add(shopCeo);

		JLabel lblRegiDate = new JLabel("등록일:");
		lblRegiDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblRegiDate.setBounds(48, 146, 62, 23);
		topPane.add(lblRegiDate);

		regiDate = new JLabel();
		regiDate.setBounds(98, 145, 130, 28);
		topPane.add(regiDate);

		JLabel lblOutDate = new JLabel("폐업일:");
		lblOutDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblOutDate.setBounds(259, 146, 57, 23);
		topPane.add(lblOutDate);

		outDate = new JLabel();
		outDate.setForeground(new Color(255, 0, 0));
		outDate.setBounds(303, 145, 168, 28);
		topPane.add(outDate);

		lblTxtByshopList = new JLabel();
		lblTxtByshopList.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTxtByshopList.setFont(new Font("굴림체", Font.BOLD, 16));
		lblTxtByshopList.setBounds(12, 179, 182, 28);
		topPane.add(lblTxtByshopList);

		JLabel lbltext1 = new JLabel("목록");
		lbltext1.setFont(new Font("굴림체", Font.PLAIN, 12));
		lbltext1.setBounds(206, 179, 43, 28);
		topPane.add(lbltext1);

		btnFind = new JButton("조회");
		btnFind.setBounds(470, 159, 139, 28);
		topPane.add(btnFind);

		btnRegi = new JButton("등록");
		btnRegi.setBackground(new Color(0, 255, 0));
		btnRegi.setBounds(669, 159, 97, 28);
		topPane.add(btnRegi);

		btnClear = new JButton("클리어");
		btnClear.setBounds(516, 107, 97, 28);
		topPane.add(btnClear);

		btnDelete = new JButton("폐업등록");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(669, 107, 97, 28);
		topPane.add(btnDelete);

		getContentPane().add(topPane);

		jTable = new JTable();
		jTable.setFont(new Font("굴림체", Font.PLAIN, 12));
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jSpane = new JScrollPane(jTable);
		jSpane.setBounds(0, 215, 800, 346);
		getContentPane().add(jSpane);

		jTable.setModel(
				new DefaultTableModel(getByShopList(shopcode), getByShopColumnList()) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				}
				);
		resizeColumnWidth(jTable);
		// 기능
		byShop.addKeyListener(this);
		shopCode.addKeyListener(this);
		btnFind.addActionListener(this);
		btnRegi.addActionListener(this);
		btnClear.addActionListener(this);
		btnDelete.addActionListener(this);
		jTable.addMouseListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(816, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// 키보드 기능
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(shopDetail != null) shopDetail.dispose();
			btnFind.doClick();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { }
	// 버튼 액션 기능
	@Override
	public void actionPerformed(ActionEvent e) {
		if(shopDetail != null) shopDetail.dispose();
		switch(e.getActionCommand()) {  
		case "조회" : 
			shopCodeFind();
			break;
		case "등록" :
			shopregi();
			break;
		case "클리어" :
			viewClear();
			break;
		case "폐업등록" :
			if(!(byShop.getText() + shopCode.getText()).equals("")) {
				shopDelete();
				viewClear();
			}
			break;
		}
	}
	// 마우스 기능
	@Override
	public void mouseClicked(MouseEvent e) {
		if(shopDetail != null) shopDetail.dispose();
		ShopDao shopDao = new ShopDao();
		int row         = jTable.getSelectedRow();
		String shcode   = (String) jTable.getValueAt(row, 1);
		String[] bycode = shcode.trim().split("-");
		this.byShop.setText(bycode[0]);
		this.shopCode.setText(bycode[1]);
	}
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) {	}
	// 상호 코드로 찾기
	private void shopCodeFind() {
		ShopDao shopDao  = new ShopDao();
		String  byshop   = byShop.getText().toUpperCase();
		String  shopcode = shopCode.getText();
		String  shcode   = byshop + "-" + shopcode;
		if(!byshop.equals("")) {
			if(byshop.equals("B") || byshop.equals("P") || byshop.equals("V")) {
				if(shopcode.equals("")) {
					shopDetail = new ShopDetail(byshop, shopcode) ;
				} else if(!shopcode.equals("")) {
					if(shopDao.checkShopCode(shcode)) {
						ShopVO shopVo = shopDao.getShop(shcode);
						shopDetail = new ShopDetail(byshop, shopcode) ;
						shopDetail.setViewShopData(shopVo);
					} else if(shopDao.checkOShopCode(shcode)) {
						ShopVO shopVo = shopDao.getOutShop(shcode);
						shopDetail = new ShopDetail(byshop, shopcode);
						shopDetail.setViewShopData(shopVo);
					} else {
						JOptionPane.showMessageDialog(null, "없는 상호코드 입니다");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "없는 상호분류코드 입니다");
			}
		} else {
			JOptionPane.showMessageDialog(null, "상호분류코드를 입력하세요");
		}
		if(shopDetail != null) setVisible(false);
	}
	// 상호정보 화면에 뿌리기
	public void setViewShopData(ShopVO shopVo) {
		String[] shopCode = shopVo.getShopCode().trim().split("-");
		String shopName   = shopVo.getShopName();
		String shopPasw   = shopVo.getShopPasw();
		String shopPhone  = shopVo.getShopPhone();
		String shopAddr   = shopVo.getShopAddr();
		String shopTime   = shopVo.getShopTime();
		String shopCeo    = shopVo.getShopCeo();
		String regiDate   = shopVo.getRegiDate();
		String outDate    = shopVo.getOutDate();

		this.shopName.setText(shopName);
		this.byShop.setText(shopCode[0]);
		this.shopCode.setText(shopCode[1]);
		this.shopPasw.setText(shopPasw);
		this.shopPhone.setText(shopPhone);
		this.shopAddr.setText(shopAddr);
		this.shopTime.setText(shopTime);
		this.shopCeo.setText(shopCeo);
		this.regiDate.setText(regiDate);
		this.outDate.setText(outDate);
		switch(shopCode[0]) {
		case "B" : this.lblTxtByshopList.setText("보세샵"); break;
		case "P" : this.lblTxtByshopList.setText("편집샵"); break;
		case "V" : this.lblTxtByshopList.setText("빈티지샵"); break;
		}
	}
	// JTable 폭 자동 조절
	private void resizeColumnWidth(JTable table) {
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
	// 업종별 목록 가져오기 
	private Vector<Vector> getByShopList(String shopcode) {
		String   byshop = shopcode.toUpperCase();
		ShopDao shopDao = new ShopDao();
		Vector<Vector> shopList = shopDao.getByShopList(byshop);
		return shopList;
	}
	private Vector<String> getByShopColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("순번");
		cols.add("상호코드");
		cols.add("등록일");
		cols.add("폐업일");
		cols.add("상호명");
		cols.add("패스워드");
		cols.add("전화");
		cols.add("주소");
		cols.add("영업시간");
		cols.add("대표자");
		return cols;
	}
	// 신규상호 DB에 등록
	private void shopregi() {
		ShopDao shopDao = new ShopDao();
		String  byshop   = byShop.getText().toUpperCase();
		String  shopcode = shopCode.getText();
		String  shcode   = byshop + "-" + shopcode;
		if(shopDao.checkShopCode(shcode)) {
			JOptionPane.showMessageDialog(null, "등록된 코드입니다");
		} else if(shopDao.checkOShopCode(shcode))  {
			JOptionPane.showMessageDialog(null, "폐업된 코드입니다");
		} else {
			if(!shopName.getText().equals("")) {
				ShopVO  shopVO  = getViewShopData();
				int choice = JOptionPane.showConfirmDialog(null, 
						shopName.getText() + "상호등록을 하시겠습니까?",
						"등록확인", JOptionPane.OK_CANCEL_OPTION);
				String msg = "";
				if(choice == 0) {
					int aftcnt = shopDao.insertShop(shopVO);
					if(aftcnt > 0) {
						msg = shopName.getText() + "등록되었습니다";
					} else {
						msg = "등록되지 않았습니다";
					}
				} else {
					msg = "취소를 클릭하였습니다";
				}
				JOptionPane.showMessageDialog(null, msg,
						"등록", JOptionPane.OK_OPTION);
			} else {
				JOptionPane.showMessageDialog(null, "값을 입력하세요");
			}
		}
	}
	// 화면에 있는 상호정보를 ShopVO에 담기
	private ShopVO getViewShopData() {
		String shopCode  = this.byShop.getText().toUpperCase();
		String shopName  = this.shopName.getText(); 
		String shopAddr  = this.shopAddr.getText();
		String shopPhone = this.shopPhone.getText();
		String shopCeo   = this.shopCeo.getText();
		String shopTime  = this.shopTime.getText();

		ShopVO shopVO = new ShopVO(shopCode, shopName, shopPhone, 
				shopAddr, shopTime, shopCeo);
		return shopVO;
	}
	// 화면 클리어
	private void viewClear() {
		byShop.setText("");
		shopCode.setText("");
		shopName.setText(""); 
		shopPasw.setText("");
		shopAddr.setText("");
		shopPhone.setText("");
		shopCeo.setText("");
		shopTime.setText("");
		regiDate.setText("");
		outDate.setText("");
		jTable.setModel(
				new DefaultTableModel(getByShopList(""), getByShopColumnList()) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				}
				);
		resizeColumnWidth(jTable);
	}
	// 상호폐업
	private void shopDelete() {
		String inShopCode = byShop.getText() + "-" + shopCode.getText();
		if(inShopCode.trim().equals("")) return;
		ShopDao shopDao = new ShopDao();
		if(!shopCode.getText().equals("")) {
			if(shopDao.checkShopCode(inShopCode)) {
				int choice = JOptionPane.showConfirmDialog(null, 
						shopName.getText() + "를 삭제하시겠습니까?", "삭제확인",
						JOptionPane.OK_CANCEL_OPTION);
				String msg = "";
				if(choice == 0) {
					int aftcnt = shopDao.delete1(inShopCode);
					Vector<String> prodList = new Vector<>();
					ProdDao prodDao = new ProdDao();
					prodList = prodDao.getprodList(inShopCode);
					if(prodList != null) {
						for( int i = 0; i < prodList.size(); i++ ) {
							prodDao.delete1(prodList.get(i));
							prodDao.delete2(prodList.get(i));
							prodDao.delete3(prodList.get(i));
						}
					}
					shopDao.delete2(inShopCode);
					shopDao.delete3(inShopCode); 
					if(aftcnt > 0) {
						msg = aftcnt + "건 삭제되었습니다";
					} else {
						msg = "삭제 되지 않았습니다";
					}
				} else {
					msg = "취소를 클릭하였습니다";
				}
				JOptionPane.showMessageDialog(null, msg,
						"삭제", JOptionPane.OK_OPTION);
			} else if(shopDao.checkOShopCode(inShopCode)) {
				JOptionPane.showMessageDialog(null, "이미 폐업한 상호입니다");
			} 
		} 
	}

	public static void main(String[] args) {
		new ShopDetail();
	} 
}
