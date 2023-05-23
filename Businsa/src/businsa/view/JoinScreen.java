package businsa.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businsa.model.MemberDao;
import businsa.model.MemberVO;


//회원가입
public class JoinScreen extends JFrame {

	// 필드
	private JPanel         contentPane;
	private JTextField     userid;
	private JButton        btnCheckButton;
	private JTextField     passwd;
	private JTextField     pwdRe;
	private JTextField     username;
	private JTextField     phone;
	private JTextField     addr;
	private JTextField     email;
	private JButton        btnJoinButton;

	// 기본생성자
	public JoinScreen() {
		initComponent();
	}

	// 화면 배치
	private void initComponent() {
		setTitle("회원가입");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.white);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("BUSINSA");
		lblNewLabel.setBounds(180, 0, 300, 47);
		lblNewLabel.setForeground(new Color(0,0,0));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("무신사", Font.BOLD, 25));
		
		JLabel lblNewLabel1 = new JLabel("  회원가입");
		lblNewLabel1.setBounds(190, 23, 300, 47);
		lblNewLabel1.setForeground(new Color(0,0,0));
		panel.add(lblNewLabel1);
		lblNewLabel1.setFont(new Font("세방고딕", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(53, 87, 36, 25);
		panel.add(lblNewLabel_1); 

		userid =new JTextField();
		userid.setBounds(101, 77, 282, 45);
		panel.add(userid);
		userid.setFont(new Font("세방고딕", Font.PLAIN, 12));
		userid.setColumns(15);
		
		JLabel lblNewLabel_10 = new JLabel("(영문,한글,숫자 2~15자리)");
		lblNewLabel_10.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(101, 132, 157, 25);
		panel.add(lblNewLabel_10);

		btnCheckButton = new JButton("아이디중복확인");
		btnCheckButton.setBackground(new Color(0, 0, 0));
		btnCheckButton.setForeground(new Color(255, 255, 255));
		btnCheckButton.setFont(new Font("세방고딕", Font.PLAIN, 12));
		btnCheckButton.setBounds(258, 132, 125, 25);
		panel.add(btnCheckButton);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(41, 176, 48, 25);
		panel.add(lblNewLabel_2);

		//passwd = new JPasswordField();
		passwd = new JTextField(); // 임시
		passwd.setFont(new Font("세방고딕", Font.PLAIN, 12));
		passwd.setBounds(101, 166, 282, 45);
		panel.add(passwd);
		passwd.setColumns(20);

		JLabel lblNewLabel_3 = new JLabel("(숫자,영문,특수문자 최소 1개 포함 8~20자)");
		lblNewLabel_3.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(101, 221, 282, 15);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(" 비밀번호재입력");
		lblNewLabel_4.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(13, 261, 96, 15);
		panel.add(lblNewLabel_4);

		//pwdRe = new JPasswordField();
		pwdRe = new JTextField();
		pwdRe.setFont(new Font("세방고딕", Font.PLAIN, 12));
		pwdRe.setBounds(101, 246, 282, 45);
		panel.add(pwdRe);
		pwdRe.setColumns(20);

		JLabel lblNewLabel_5 = new JLabel("이름");
		lblNewLabel_5.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(65, 311, 24, 25);
		panel.add(lblNewLabel_5);

		username = new JTextField();
		username.setBounds(101, 301, 282, 46);
		username.setFont(new Font("세방고딕", Font.PLAIN, 12));
		panel.add(username);
		username.setColumns(50);

		JLabel lblNewLabel_6 = new JLabel("핸드폰");
		lblNewLabel_6.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(53, 367, 36, 25);
		panel.add(lblNewLabel_6);

		phone = new JTextField();
		phone.setBounds(101, 357, 283, 45);
		phone.setFont(new Font("세방고딕", Font.PLAIN, 12));
		panel.add(phone);
		phone.setColumns(20);

		JLabel lblNewLabel_7 = new JLabel("주소");
		lblNewLabel_7.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(65, 423, 24, 25);
		panel.add(lblNewLabel_7);

		addr = new JTextField();
		addr.setBounds(101, 412, 282, 47);
		addr.setFont(new Font("세방고딕", Font.PLAIN, 12));
		panel.add(addr);
		addr.setColumns(300);

		JLabel lblNewLabel_8 = new JLabel("이메일");
		lblNewLabel_8.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(53, 479, 36, 25);
		panel.add(lblNewLabel_8);

		email = new JTextField();
		email.setBounds(101, 469, 282, 45);
		email.setFont(new Font("세방고딕", Font.PLAIN, 12));
		panel.add(email);
		email.setColumns(320);

		JLabel lblNewLabel_9 = new JLabel("계정 분실 시 본인인증 정보로 활용됩니다.");
		lblNewLabel_9.setFont(new Font("세방고딕", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(101, 513, 274, 25);
		panel.add(lblNewLabel_9);

		btnJoinButton = new JButton("가입 완료");
		btnJoinButton.setBackground(new Color(0, 0, 0));
		btnJoinButton.setForeground(Color.WHITE);
		btnJoinButton.setFont(new Font("세방고딕", Font.PLAIN, 14));
		btnJoinButton.setBounds(181, 548, 114, 35);
		panel.add(btnJoinButton);
		
		//-------------------------------------------------------------------
		// 기능구현
		// 중복버튼 기능
		btnCheckButton.addActionListener(new ActionListener() {
			MemberDao mDao = new MemberDao();
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!checkId(userid.getText())) {
					JOptionPane.showMessageDialog(null, "영문,한글,숫자 2~15자리 기입하세요");
					userid.setText("");
				} else {	
					System.out.println("아이디 중복 체크");
					Object ob = e.getSource();
					if(ob == btnCheckButton) {
						if(mDao.findExistId(userid.getText())){
							JOptionPane.showMessageDialog(null, "사용중인 아이디 입니다");
							userid.setText("");
							return;
						} else {
							JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
							passwd.grabFocus();
						}
					}
				}
			}
		});
		// 패스워드 검사
		passwd.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(!checkPasswd(passwd.getText())) {
						JOptionPane.showMessageDialog(null,
								"숫자,영문,특수문자 최소 1개 포함 8~20자 기입하세요");
						passwd.setText("");
					} else {
						pwdRe.grabFocus();
					}
				}
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		// 패스워드 재확인
		pwdRe.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(passwd.getText().equals(pwdRe.getText())) {
						username.grabFocus();
					} else {
						JOptionPane.showMessageDialog(null,
								"비밀번호가 일치하지 않습니다");
						pwdRe.setText("");
						pwdRe.grabFocus();
					} 
				} 
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		// 이름 기능
		username.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {	}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { phone.grabFocus(); }
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		// 핸드폰 검사
		phone.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(!checkPhone(phone.getText())) {
						JOptionPane.showMessageDialog(null,
								"잘못입력되었습니다");
						phone.setText("");
					} else {
						addr.grabFocus();
					}
				}
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		// 주소 기능
		addr.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {	}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { email.grabFocus(); }
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		//아이디 검사 기능
		btnJoinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!checkId(userid.getText())) {
					JOptionPane.showMessageDialog(null,
							"아이디를 다시 입력해주세요");
					userid.setText("");
					userid.grabFocus();
				}
				}
		});
		// 이메일 검사 및 가입 기능
		btnJoinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!checkEmail(email.getText())) {
					JOptionPane.showMessageDialog(null,
							"이메일을 다시 입력해주세요");
					email.setText("");
					email.grabFocus();
				} else {
					System.out.println("가입완료 클릭");
					joinMember();
					new Home();
				}
				
			}
		});
		//---------------------------------------------------------------------
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(480, 650);
		setLocation(700, 200);
		setVisible(true);
	}

	// 유효성 검사
	protected boolean checkId(String userid) {
		return Pattern.matches("^[a-zA-Z0-9가-힣]{2,15}$", userid);
	}

	protected boolean checkPasswd(String passwd) {
		return Pattern.matches("^(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,20}$", passwd);
	}

	protected boolean checkPhone(String phone) {
		return Pattern.matches("(01)\\d{1}\\d{3,4}\\d{4}", phone);
	}
	protected boolean checkEmail(String email) {
		return Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
	}

	// DB에 회원정보 넣기
	protected void joinMember() {
		MemberDao mDao   = new MemberDao();
		MemberVO  vo     = getViewData();
		mDao.insertMember(vo);
		JOptionPane.showMessageDialog(null, "가입이 완료되었습니다",
				"추가", JOptionPane.OK_OPTION);
		setVisible(false);
		// 다음 페이지
	}
	
	// 화면에 있는 회원정보를  MemberVO에 담기
	protected MemberVO getViewData() {
		String userid   = this.userid.getText();
		String passwd   = this.passwd.getText(); 
		String username = this.username.getText();
		String phone    = this.phone.getText();
		String addr     = this.addr.getText();
		String email    = this.email.getText();

		MemberVO vo = new MemberVO(userid, passwd, username, phone, addr, email);
		return vo;
	}

	public static void main(String[] args) {
		new Home();
	}
}
