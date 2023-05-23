package manager.view;
// 이덕만
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import manager.model.ManagerDao;

public class ManagerLogin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	// 필드
	private JTextField managerCode;
	private JTextField managerPwd;
	private JButton    managerLogin;

	// 기본생성자
	public ManagerLogin() {
		initComponent();
	}

	// 화면 배치
	private void initComponent() {
		setTitle("관리자 로그인");

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 517, 208);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("관리자코드");
		lblNewLabel.setBounds(61, 71, 60, 15);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림체", Font.PLAIN, 12));

		JLabel lblNewLabel_1 = new JLabel("패스워드");
		lblNewLabel_1.setBounds(73, 121, 48, 15);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("굴림체", Font.PLAIN, 12));

		managerCode = new JTextField();
		managerCode.setBounds(133, 68, 281, 21);
		panel.add(managerCode);
		managerCode.setColumns(50);

		managerPwd = new JTextField();
		managerPwd.setBounds(133, 118, 281, 21);
		panel.add(managerPwd);
		managerPwd.setColumns(20);

		// 엔터 기능 구현
		managerPwd.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					managerLogin.doClick();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});

		managerLogin = new JButton("로그인");
		managerLogin.setFont(new Font("굴림체", Font.PLAIN, 12));
		managerLogin.setBounds(211, 159, 104, 30);
		panel.add(managerLogin);
		// 매니저코드, 패스워드 체크 기능
		managerLogin.addActionListener(new ActionListener() {
			ManagerDao manaDao = new ManagerDao();
			@Override
			public void actionPerformed(ActionEvent e) {
				String inmanaCode = managerCode.getText();
				String inmanaPwd  = managerPwd.getText();
				if(inmanaCode.equals("")) {
					JOptionPane.showMessageDialog(null, "코드를 입력하세요");
				} else if(!manaDao.checkManaCode(inmanaCode)){
					System.out.print(manaDao.checkManaCode(inmanaCode));
					JOptionPane.showMessageDialog(null, "코드가 틀렸습니다");
				} else {
					if(manaDao.checkManaPwd(inmanaCode, inmanaPwd)) {
						setVisible(false);
						new Menu();					
						return;
					} else if(inmanaPwd.equals("")){
						JOptionPane.showMessageDialog(null, "패스워드를 입력하세요");
					} else {
						JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다");
					}
				
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(557, 272);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ManagerLogin();
	}
}
