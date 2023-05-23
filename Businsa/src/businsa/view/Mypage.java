package businsa.view;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import businsa.model.MemberDao;
import businsa.model.MemberDao2;
import businsa.model.MemberVO;

public class Mypage extends JFrame implements KeyListener, ActionListener {

	// 필드
	private JPanel      contentPane,pa;
	private JTextField  userCode;
	private JLabel 		a,b,c,d,e;
	private JLabel      lblTxtUserName;
	private JLabel      phone, addr, email, joinDate, userId;
	private JButton     btnNewButton,btnNewButton2,btnNewButton3;
	private static String      userid;

	Mypage        memDetail = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mypage frame = new Mypage(userid);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Mypage(String userid) {
		
		
		this.userid = userid;
		
		MemberDao memDao = new MemberDao();
		
		setTitle("MyPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 661, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder
		(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "회원정보 상세보기",TitledBorder.LEADING, TitledBorder.TOP,null, new Color(0, 0, 0)));
		panel.setBounds(6, 10, 633, 57);
		panel.setFont(new Font("세방고딕", Font.BOLD, 12));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel pa = new JPanel();
		pa.setBorder(new LineBorder(new Color(160, 160, 160)));
		pa.setBounds(10, 78, 625, 120);
		pa.setBackground(new Color(204,204,204));
		pa.setLayout(null);
		contentPane.add(pa);

		JLabel lblNewLabel = new JLabel("아이디 : ");
		lblNewLabel.setBounds(15, 22, 100, 15);
		lblNewLabel.setFont(new Font("세방고딕", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		userId = new JLabel(userid);
		userId.setBounds(60, 22, 100, 15);
		userId.setFont(new Font("세방고딕", Font.PLAIN, 12));
		panel.add(userId);
		
		userCode = new JTextField();
		
		a = new JLabel("이름 :");
		a.setBounds(10, 0, 100, 30);
		a.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(a);
		lblTxtUserName = new JLabel();
		lblTxtUserName.setBounds(100, 0, 100, 30);
		lblTxtUserName.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(lblTxtUserName);
		
		
		b = new JLabel("전화번호 :");
		b.setBounds(10, 20, 100, 30);
		b.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(b);
		phone = new JLabel();
		phone.setBounds(100, 20, 100, 30);
		phone.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(phone);
		
		
		c = new JLabel("주소 :");
		c.setBounds(10, 40, 100, 30);
		c.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(c);
		addr = new JLabel();
		addr.setBounds(100, 40, 400, 30);
		addr.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(addr);
		
		d = new JLabel("이메일 :");
		d.setBounds(10, 60, 200, 30);
		d.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(d);
		email = new JLabel();
		email.setBounds(100, 60, 300, 30);
		email.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(email);
		
		e = new JLabel("가입일 :");
		e.setBounds(10, 80, 100, 30);
		e.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(e);
		joinDate = new JLabel();
		joinDate.setBounds(100, 80, 500, 30);
		joinDate.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pa.add(joinDate);

		JButton btnNewButton = new JButton("상세정보");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(525, 18, 97, 23);
		btnNewButton.setFont(new Font("세방고딕", Font.PLAIN, 12));
		btnNewButton.setFocusPainted(false);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("주문목록");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(425, 18, 97, 23);
		btnNewButton_1.setFont(new Font("세방고딕", Font.PLAIN, 12));
		btnNewButton_1.setFocusPainted(false);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton2 = new JButton("HOME");
		btnNewButton2.setBounds(10, 210, 100, 23);
		btnNewButton2.setBackground(new Color(0, 0, 0));
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setFont(new Font("세방고딕", Font.PLAIN, 12));
		add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("회원탈퇴");
		btnNewButton3.setBackground(new Color(0, 0, 0));
		btnNewButton3.setForeground(new Color(255, 255, 255));
		btnNewButton3.setBounds(532, 210, 100, 23);
		btnNewButton3.setFont(new Font("세방고딕", Font.PLAIN, 12));
		add(btnNewButton3);

		// 기능
		userCode.addKeyListener(this);
		userId.addKeyListener(this);
		btnNewButton.addActionListener(this);
		btnNewButton3.addActionListener(this);
		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		btnNewButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home2(userid);
				setVisible(false);
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Buylist(userid);
				setVisible(false);
				
			}
		});
	}
	
	 

	private Color Color(Color color) {
		// TODO Auto-generated method stub
		return null;
	}
	// 키보드 기능
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(memDetail != null) setVisible(false);
			btnNewButton.doClick();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { }
	// 버튼 액션 기능
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {  
		case "상세정보" : 
			if(!userId.getText().equals("")) {
				idFind();
			} 
			break;
		case "회원탈퇴" :
			if(!userCode.getText().equals("")) {
				memDelete();
				viewClear();
				
			}
			break;
		}
	}

	// 아이디로 찾기
	private void idFind() {
		MemberDao2 memDao = new MemberDao2();
		if(!userId.getText().equals("")) { 
			String inUserId = userId.getText();
			if(memDao.checkUserId(inUserId)) {
				MemberVO memVo = memDao.getMember(inUserId);
				String   usercode = memVo.getUsercode();
				memDetail = new Mypage(userid);
				memDetail.setViewData(memVo);

			} else {
				JOptionPane.showMessageDialog(null, "없는 아이디 입니다");
			}
		}
		if(memDetail != null) setVisible(false);
	}
	// 회원정보 화면에 뿌리기
	public void setViewData(MemberVO memVo) {
		String userName  = memVo.getUsername();
		String userCode  = memVo.getUsercode();
		String userid    = memVo.getUserid();
		String phone     = memVo.getPhone();
		String addr      = memVo.getAddr();
		String email     = memVo.getEmail();
		String joinDate  = memVo.getJoindate();


		this.userId.setText(userid);
		this.userCode.setText(userCode);
		this.lblTxtUserName.setText(userName);
		this.phone.setText(phone);
		this.addr.setText(addr);
		this.email.setText(email);
		this.joinDate.setText(joinDate);

	}
	
	// 구매 목록 가져오기 
	private Vector<Vector> getOrderList(String usercode) {
		MemberDao2 memDao = new MemberDao2();
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
		userCode.setText("");
		email.setText("");
		phone.setText("");
		addr.setText("");
		joinDate.setText("");

		userid = "";
		
	}
	// 회원삭제
	private void memDelete() {
		String inUserCode = userCode.getText();
		if(inUserCode.trim().equals("")) return;
		MemberDao2 memDao = new MemberDao2();
		if(!userCode.getText().equals("")) {
			if(memDao.checkUserCode(inUserCode)) {
				int choice = JOptionPane.showConfirmDialog(null, 
						userId.getText() + "님 탈퇴를 진행하시겠습니까?", "삭제확인",
						JOptionPane.OK_CANCEL_OPTION);
				String msg = "";
				if(choice == 0) {
					int aftcnt = memDao.clear1(inUserCode);
					memDao.clear2(inUserCode);
					memDao.clear3(inUserCode); 
					if(aftcnt > 0) {
						msg = "회원탈퇴 되었습니다";
						setVisible(false);
						new Home();
					} else {
						msg = "탈퇴 되지 않았습니다";
					}
				} else {
					msg = "취소를 클릭하였습니다";
				}
				JOptionPane.showMessageDialog(null, msg,
						"회원탈퇴", JOptionPane.OK_OPTION);
			} else if(memDao.checkOUserCode(inUserCode)) {
				JOptionPane.showMessageDialog(null, "이미 탈퇴한 회원입니다");
			}
		}
	}
	}

