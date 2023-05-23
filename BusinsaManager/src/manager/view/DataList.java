package manager.view;
// 이덕만
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import manager.model.MemberDao;
import manager.model.OrderDao;
import manager.model.ProdDao;
import manager.model.ShopDao;

import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DataList extends JFrame implements ActionListener, MouseListener {

	// 필드
	private JPanel      topPane;
	private JLabel      lblListnum, lblNum, lblNUmber;
	private JButton     memberList, shopList, prodList, orderList;
	private JTable      jTable;
	private JScrollPane jSpane;

	private int  num         = 0;
	DataList     dataList    = null;    
	MemberDetail memDetail   = null;
	ShopDetail   shopDetail  = null;
	ProdDetail   prodDetail  = null;
	OrderDetail  orderDetail = null;

	// 생성자
	public DataList() {
		initComponent();
	}

	// 화면 배치
	private void initComponent() {
		setTitle("DATA목록");
		getContentPane().setLayout(null);

		topPane    = new JPanel();
		topPane.setBounds(0, 0, 1079, 41);
		topPane.setLayout(null);

		lblListnum = new JLabel("목록수:");
		lblListnum.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblListnum.setBounds(23, 14, 48, 15);
		topPane.add(lblListnum);

		lblNum = new JLabel("");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum.setFont(new Font("굴림체", Font.PLAIN, 14));
		lblNum.setBounds(69, 10, 79, 23);
		topPane.add(lblNum);

		lblNUmber = new JLabel("개");
		lblNUmber.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblNUmber.setBounds(119, 14, 57, 15);
		topPane.add(lblNUmber);

		memberList = new JButton("회원목록");
		memberList.setBounds(331, 10, 91, 23);
		memberList.setFont(new Font("굴림체", Font.PLAIN, 12));
		topPane.add(memberList);

		shopList   = new JButton("상호목록");
		shopList.setBounds(476, 10, 91, 23);
		shopList.setFont(new Font("굴림체", Font.PLAIN, 12));
		topPane.add(shopList);

		prodList   = new JButton("상품목록");
		prodList.setBounds(618, 10, 91, 23);
		prodList.setFont(new Font("굴림체", Font.PLAIN, 12));
		topPane.add(prodList);

		orderList  = new JButton("구매목록");
		orderList.setBounds(769, 10, 91, 23);
		orderList.setFont(new Font("굴림체", Font.PLAIN, 12));
		topPane.add(orderList);

		getContentPane().add(topPane);

		jTable = new JTable();
		jTable.setFont(new Font("굴림체", Font.PLAIN, 12));
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jSpane = new JScrollPane(jTable);
		jSpane.setBounds(1, 42, 1078, 419);
		getContentPane().add(jSpane);
		// 기능
		memberList.addActionListener(this);
		shopList.addActionListener(this);
		prodList.addActionListener(this);
		orderList.addActionListener(this);
		jTable.addMouseListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1095, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// 버튼 기능 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {  
		case "회원목록" : 
			if(dataList != null) dataList.dispose();
			if(memDetail != null) memDetail.dispose();
			jTable.setModel(
					new DefaultTableModel(getmemDataList(), getmemColumnList()) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					}
					);
			resizeColumnWidth(jTable);
			break;
		case "상호목록" :
			if(dataList != null) dataList.dispose();
			if(shopDetail != null) shopDetail.dispose();
			jTable.setModel(
					new DefaultTableModel(getshopDataList(), getshopColumnList()) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					}
					);
			resizeColumnWidth(jTable);
			break;
		case "상품목록" :
			if(dataList != null) dataList.dispose();
			if(prodDetail != null) prodDetail.dispose();
			jTable.setModel(
					new DefaultTableModel(getprodDataList(), getprodColumnList()) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					}
					);
			resizeColumnWidth(jTable);
			break;
		case "구매목록" :
			if(dataList != null) dataList.dispose();
			if(orderDetail != null) orderDetail.dispose();
			jTable.setModel(
					new DefaultTableModel(getorderDataList(), getorderColumnList()) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					}
					);
			resizeColumnWidth(jTable);
			break;
		}
	}
	// 마우스 기능
	@Override
	public void mouseClicked(MouseEvent e) {
		if(memDetail != null) memDetail.dispose();
		if(shopDetail != null) shopDetail.dispose();
		if(prodDetail != null) prodDetail.dispose();
		if(orderDetail != null) orderDetail.dispose();
		int row = jTable.getSelectedRow();
		String code = (String) jTable.getValueAt(row, 1);
		String code1 = (String) jTable.getValueAt(row, 7);
		String[] byCode = code.trim().split("-");
		switch(byCode[0]) {
		case "M" :
			memDetail = new MemberDetail(byCode[1]);
			break;
		case "B" :
			shopDetail = new ShopDetail(byCode[0], byCode[1]);
			break;
		case "P" :
			shopDetail = new ShopDetail(byCode[0], byCode[1]);
			break;
		case "V" :
			shopDetail = new ShopDetail(byCode[0], byCode[1]);
			break;
		case "PROD" :
			prodDetail = new ProdDetail(byCode[1]);
			break;
		case "ORDER" :
			orderDetail = new OrderDetail(byCode[1]);
			break;
		}
	}
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }
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
	//----------------------------------------------------------------------------------
	// 가입된 회원목록 DB에서 가져오기
	private Vector<Vector> getmemDataList() {
		MemberDao memDao = new MemberDao();
		Vector<Vector> list = memDao.getMemberList();
		num = list.size();
		lblNum.setText(String.valueOf(num));
		return list;
	}
	private Vector<String> getmemColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("순번");
		cols.add("회원코드");
		cols.add("아이디");
		cols.add("암호");
		cols.add("이름");
		cols.add("핸드폰");
		cols.add("주소");
		cols.add("이메일");
		cols.add("가입일");
		return cols;
	}
	// 등록된 상호목록 data 가져오기
	private Vector<Vector> getshopDataList() {
		ShopDao shopDao = new ShopDao();
		Vector<Vector> list = shopDao.getShopList();
		num = list.size();
		lblNum.setText(String.valueOf(num));
		return list;
	}
	private Vector<String> getshopColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("순번");
		cols.add("상호코드");
		cols.add("상호명");
		cols.add("암호");
		cols.add("전화");
		cols.add("주소");
		cols.add("영업시간");
		cols.add("사장이름");
		cols.add("등록일");
		return cols;
	}
	// 등록된 상품목록 DB에서 가져오기
	private Vector<Vector> getprodDataList() {
		ProdDao prodDao = new ProdDao();
		Vector<Vector> list = prodDao.getProdpList();
		num = list.size();
		lblNum.setText(String.valueOf(num));
		return list;
	}
	private Vector<String> getprodColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("순번");
		cols.add("상품코드");
		cols.add("상품명");
		cols.add("가격");
		cols.add("사이즈");
		cols.add("재고량");
		cols.add("등록일");
		cols.add("상호코드");
		return cols;
	}
	// 주문목록 data 가져오기
	private Vector<Vector> getorderDataList() {
		OrderDao orderDao = new OrderDao();
		Vector<Vector> list = orderDao.getOrderList();
		num = list.size();
		lblNum.setText(String.valueOf(num));
		return list;
	}
	private Vector<String> getorderColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("순번");
		cols.add("주문코드");
		cols.add("구매자");
		cols.add("상호명");
		cols.add("상호주소");
		cols.add("상품명");
		cols.add("가격");
		cols.add("사이즈");
		cols.add("주문량");
		cols.add("주문일");
		cols.add("회원코드");
		cols.add("상품코드");
		return cols;
	}
	//--------------------------------------------------------------------------------
	public static void main(String[] args) {
		new DataList();
	}
}


