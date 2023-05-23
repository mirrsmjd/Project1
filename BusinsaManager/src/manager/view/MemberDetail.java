package manager.view;
// 이덕만
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import manager.model.MemberDao;
import manager.model.MemberVO;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class MemberDetail extends JFrame implements KeyListener, ActionListener,
	MouseListener {

	// 필드
	private JPanel      topPane;
	private JLabel      lblTxtUserName, lblCode, lblTxtUserName1; 
	private JTextField  userCode, userId, email;
	private JLabel      passwd, phone, addr, joinDate, secesDate;
	private JButton     btnFind, btnClear, btnDelete;  
	private JTable      jTable;
	private JScrollPane jSpane;

	String              usercode = "";
	MemberDetail        memDetail  = null;
	OrderDetail         orderDetail  = null;

	// 생성자
	public MemberDetail() {
		initComponent();
	}
	public MemberDetail(String inUserCode) {
		this.usercode = inUserCode;
		initComponent();
		userCode.setText(inUserCode);
	}

	// 화면 배치
	private void initComponent() {
		setTitle("회원상세조회");
		getContentPane().setLayout(null);

		topPane    = new JPanel();
		topPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		topPane.setBounds(0, 0, 825, 273);
		topPane.setLayout(null);

		lblTxtUserName = new JLabel();
		lblTxtUserName.setBounds(12, 17, 176, 28);
		lblTxtUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTxtUserName.setFont(new Font("굴림체", Font.BOLD, 16));
		topPane.add(lblTxtUserName);

		JLabel lblText = new JLabel("님의 정보");
		lblText.setBounds(194, 17, 63, 28);
		lblText.setFont(new Font("굴림체", Font.PLAIN, 12));
		topPane.add(lblText);

		JLabel lblUserCode = new JLabel("회원코드:");
		lblUserCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserCode.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblUserCode.setBounds(64, 61, 57, 15);
		topPane.add(lblUserCode);
		
		lblCode = new JLabel("M-");
		lblCode.setFont(new Font("굴림체", Font.PLAIN, 14));
		lblCode.setBounds(137, 57, 21, 23);
		topPane.add(lblCode);

		userCode = new JTextField();
		userCode.setBounds(157, 55, 57, 25);
		topPane.add(userCode);

		JLabel lblUserId = new JLabel("회원아이디:");
		lblUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserId.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblUserId.setBounds(279, 61, 68, 15);
		topPane.add(lblUserId);

		userId = new JTextField();
		userId.setBounds(359, 55, 116, 28);
		topPane.add(userId);

		JLabel lblPasswd = new JLabel("패스워드:");
		lblPasswd.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswd.setBounds(514, 61, 57, 15);
		topPane.add(lblPasswd);

		passwd = new JLabel();
		passwd.setBounds(583, 55, 116, 28);
		topPane.add(passwd);

		JLabel lblPhone = new JLabel("PHONE:");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblPhone.setBounds(64, 103, 57, 15);
		topPane.add(lblPhone);

		phone = new JLabel();
		phone.setBounds(133, 97, 116, 28);
		topPane.add(phone);

		JLabel lblAddr = new JLabel("주소:");
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddr.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblAddr.setBounds(290, 103, 57, 15);
		topPane.add(lblAddr);

		addr = new JLabel();
		addr.setBounds(359, 97, 340, 28);
		topPane.add(addr);

		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblEmail.setBounds(64, 147, 57, 15);
		topPane.add(lblEmail);

		email = new JTextField();
		email.setBounds(133, 141, 342, 28);
		topPane.add(email);

		JLabel lblJoinDate = new JLabel("가입일:");
		lblJoinDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJoinDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblJoinDate.setBounds(64, 192, 57, 23);
		topPane.add(lblJoinDate);

		joinDate = new JLabel();
		joinDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		joinDate.setBounds(133, 186, 192, 34);
		topPane.add(joinDate);

		JLabel lblSecesDate = new JLabel("탈퇴일:");
		lblSecesDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecesDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblSecesDate.setBounds(359, 192, 57, 23);
		topPane.add(lblSecesDate);

		secesDate = new JLabel();
		secesDate.setForeground(new Color(255, 0, 0));
		secesDate.setFont(new Font("굴림체", Font.PLAIN, 12));
		secesDate.setBounds(428, 186, 192, 34);
		topPane.add(secesDate);

		lblTxtUserName1 = new JLabel();
		lblTxtUserName1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTxtUserName1.setFont(new Font("굴림체", Font.BOLD, 16));
		lblTxtUserName1.setBounds(12, 242, 170, 28);
		topPane.add(lblTxtUserName1);

		JLabel lblOrderList = new JLabel("님의 구매목록");
		lblOrderList.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblOrderList.setBounds(194, 248, 80, 15);
		topPane.add(lblOrderList);

		btnFind = new JButton("조회");
		btnFind.setBounds(548, 103, 97, 76);
		topPane.add(btnFind);

		btnClear = new JButton("클리어");
		btnClear.setBounds(548, 217, 97, 23);
		topPane.add(btnClear);

		btnDelete = new JButton("탈퇴");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(685, 217, 97, 23);
		topPane.add(btnDelete);

		getContentPane().add(topPane);

		jTable = new JTable();
		jTable.setFont(new Font("굴림체", Font.PLAIN, 12));
		jSpane = new JScrollPane(jTable);
		jSpane.setBounds(0, 274, 825, 152);
		getContentPane().add(jSpane);
		
		jTable.setModel(
				new DefaultTableModel(getOrderList(usercode), getOrderColumnList()) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				}
				);
		resizeColumnWidth(jTable);
		// 기능
		userCode.addKeyListener(this);
		userId.addKeyListener(this);
		email.addKeyListener(this);
		btnFind.addActionListener(this);
		btnClear.addActionListener(this);
		btnDelete.addActionListener(this);
		jTable.addMouseListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(841, 463);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// 키보드 기능
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(memDetail != null) memDetail.dispose();
			btnFind.doClick();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { }
	// 버튼 액션 기능
	@Override
	public void actionPerformed(ActionEvent e) {
		if(memDetail  != null) memDetail.dispose();
		switch(e.getActionCommand()) {  
		case "조회" : 
			if(!userCode.getText().equals("")) {
				codeFind();
			} else if(!userId.getText().equals("")) {
				idFind();
			} else if(!email.getText().equals("")) {
				emailFind();
			} else {
				JOptionPane.showMessageDialog(null, "검색 값을 입력하세요");
			}
			break;
		case "클리어" :
			viewClear();
			break;
		case "탈퇴" :
			if(!userCode.getText().equals("")) {
				memDelete();
				viewClear();
			}
			break;
		}
	}
	// 마우스 기능
	@Override
	public void mouseClicked(MouseEvent e) {
		if(memDetail != null) memDetail.dispose();
		if(orderDetail != null) orderDetail.dispose();
		int row = jTable.getSelectedRow();
		String code = (String) jTable.getValueAt(row, 1);
		String[] byCode = code.trim().split("-");
		orderDetail = new OrderDetail(byCode[1]);
	}
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }
	// 코드로 찾기
	private void codeFind() {
		MemberDao memDao = new MemberDao();
		String inUserCode =(lblCode.getText()+userCode.getText());
		if(!inUserCode.equals("")) { 
			if(memDao.checkUserCode(inUserCode)) {
				MemberVO memVo = memDao.getMember(inUserCode);
				memDetail = new MemberDetail(inUserCode);
				memDetail.setViewData(memVo);
			} else if(memDao.checkOUserCode(inUserCode)){
				MemberVO memVo = memDao.getOutMember(inUserCode);
				memDetail = new MemberDetail(inUserCode);
				memDetail.setViewData(memVo);
			} else {
				JOptionPane.showMessageDialog(null, "없는 코드 입니다");
			}
		} 
		if(memDetail != null) setVisible(false);
	}
	// 아이디로 찾기
	private void idFind() {
		MemberDao memDao = new MemberDao();
		if(!userId.getText().equals("")) { 
			String inUserId = userId.getText();
			if(memDao.checkUserId(inUserId)) {
				MemberVO memVo = memDao.getMember(inUserId);
				String   usercode = memVo.getUsercode();
				memDetail = new MemberDetail(usercode);
				memDetail.setViewData(memVo);
			} else {
				JOptionPane.showMessageDialog(null, "없는 아이디 이거나 탈퇴한회원 입니다"
						+ "\n탈퇴회원은 이메일로 검색하세요" );
			}
		} 
		if(memDetail != null) setVisible(false);
	}
	// 이메일로 찾기
	private void emailFind() {
		MemberDao memDao = new MemberDao();
		if(!email.getText().equals("")) { 
			String inUserEmail = email.getText();
			if(memDao.checkUserEmail(inUserEmail)) {
				MemberVO memVo = memDao.getMember(inUserEmail);
				String   usercode = memVo.getUsercode();
				memDetail = new MemberDetail(usercode);
				memDetail.setViewData(memVo);
			} else if(memDao.checkOUserEmail(inUserEmail)){
				MemberVO memVo = memDao.getOutMember(inUserEmail);
				String   usercode = memVo.getUsercode();
				memDetail = new MemberDetail(usercode);
				memDetail.setViewData(memVo);
			} else {
				JOptionPane.showMessageDialog(null, "없는 이메일 입니다");
			}
		}
		if(memDetail != null) setVisible(false);
	}
	// 회원정보 화면에 뿌리기
	public void setViewData(MemberVO memVo) {
		String   userName  = memVo.getUsername();
		String[] userCode  = memVo.getUsercode().trim().split("-");
		String   userid    = memVo.getUserid();
		String   passwd    = memVo.getPasswd();
		String   phone     = memVo.getPhone();
		String   addr      = memVo.getAddr();
		String   email     = memVo.getEmail();
		String   joinDate  = memVo.getJoindate();
		String   secesDate = memVo.getSecesdate();

		this.lblTxtUserName.setText(userName);
		this.userCode.setText(userCode[1]);
		this.userId.setText(userid);
		this.passwd.setText(passwd);
		this.phone.setText(phone);
		this.addr.setText(addr);
		this.email.setText(email);
		this.joinDate.setText(joinDate);
		this.secesDate.setText(secesDate);
		this.lblTxtUserName1.setText(userName);
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
	// 구매 목록 가져오기 
	private Vector<Vector> getOrderList(String usercode) {
		MemberDao memDao = new MemberDao();
		Vector<Vector> orderList = memDao.getmemOrderList(usercode);
		return orderList;
	}
	private Vector<String> getOrderColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("순번");
		cols.add("주문코드");
		cols.add("상호명");
		cols.add("상호주소");
		cols.add("상품명");
		cols.add("가격");
		cols.add("사이즈");
		cols.add("주문량");
		cols.add("주문일");
		cols.add("상호코드");
		cols.add("상품코드");
		return cols;
	}
	// 화면 클리어
	private void viewClear() {
		lblTxtUserName.setText("");
		lblTxtUserName1.setText(""); 
		userCode.setText("");
		userId.setText("");
		email.setText("");
		passwd.setText("");
		phone.setText("");
		addr.setText("");
		joinDate.setText("");
		secesDate.setText("");
		usercode = "";
		jTable.setModel(
				new DefaultTableModel(getOrderList(""), getOrderColumnList()) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				}
				);
		resizeColumnWidth(jTable);
		jTable.repaint();
	}
	// 회원삭제
	private void memDelete() {
		String inUserCode = "M-"+userCode.getText();
		if(inUserCode.trim().equals("")) return;
		MemberDao memDao = new MemberDao();
		if(!inUserCode.equals("")) {
			if(memDao.checkUserCode(inUserCode)) {
				int choice = JOptionPane.showConfirmDialog(null, 
						userId.getText() + "를 삭제하시겠습니까?", "삭제확인",
						JOptionPane.OK_CANCEL_OPTION);
				String msg = "";
				if(choice == 0) {
					int aftcnt = memDao.delete1(inUserCode);
					memDao.delete2(inUserCode);
					memDao.delete3(inUserCode); 
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
			} else if(memDao.checkOUserCode(inUserCode)) {
				JOptionPane.showMessageDialog(null, "이미 탈퇴한 회원입니다");
			}
		}
	}

	public static void main(String[] args) {
		new MemberDetail();
	}
}

