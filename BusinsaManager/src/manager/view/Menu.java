package manager.view;
// 이덕만
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Menu extends JFrame implements ActionListener{

	private JPanel  pane;
	private JButton datalist, memdetail, shopdetail, proddetail;
	private JButton orderdetail, exit;

	Menu         menu        = null;
	DataList     dataList    = null;       
	MemberDetail memDetail   = null;
	ShopDetail   shopDetail  = null;
	ProdDetail   prodDetail  = null;
	OrderDetail  orderDetail = null;

	public Menu() {
		initComponent();
	}

	private void initComponent() {
		setTitle("관리자  메뉴");
		getContentPane().setLayout(new BorderLayout());

		pane = new JPanel();
		pane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pane.setLayout(null);

		datalist = new JButton("전체목록");
		datalist.setBounds(25, 31, 96, 34);
		datalist.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane.add(datalist);

		memdetail = new JButton("회원상세");
		memdetail.setBounds(143, 31, 94, 34);
		memdetail.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane.add(memdetail);

		shopdetail = new JButton("상호상세");
		shopdetail.setBounds(260, 31, 94, 34);
		shopdetail.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane.add(shopdetail);

		proddetail = new JButton("상품상세");
		proddetail.setBounds(376, 31, 94, 34);
		proddetail.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane.add(proddetail);

		orderdetail = new JButton("주문상세");
		orderdetail.setBounds(491, 31, 92, 34);
		orderdetail.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane.add(orderdetail);

		exit = new JButton("프로그램종료");
		exit.setBackground(new Color(0, 255, 255));
		exit.setBounds(604, 31, 111, 34);
		exit.setFont(new Font("굴림체", Font.PLAIN, 12));
		pane.add(exit);

		getContentPane().add(pane, BorderLayout.CENTER);

		// 기능
		datalist.addActionListener(this);
		memdetail.addActionListener(this);
		shopdetail.addActionListener(this);
		proddetail.addActionListener(this);
		orderdetail.addActionListener(this);
		exit.addActionListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(756, 147);
		setLocation(580, 80);
		setVisible(true);
	}
	// 버튼 기능 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {  
		case "전체목록" : 
			if(dataList != null) dataList.dispose();
			if(memDetail != null) memDetail.dispose();
			if(shopDetail != null) shopDetail.dispose();
			if(prodDetail != null) prodDetail.dispose();
			if(orderDetail != null) orderDetail.dispose();
			dataList = new DataList();
			break;
		case "회원상세" :	
			if(memDetail != null) memDetail.dispose();
			if(shopDetail != null) shopDetail.dispose();
			if(prodDetail != null) prodDetail.dispose();
			if(orderDetail != null) orderDetail.dispose();
			memDetail = new MemberDetail();
			break;
		case "상호상세" :
			if(memDetail != null) memDetail.dispose();
			if(shopDetail != null) shopDetail.dispose();
			if(prodDetail != null) prodDetail.dispose();
			if(orderDetail != null) orderDetail.dispose();
			shopDetail = new ShopDetail();
			break;
		case "상품상세" :
			if(memDetail != null) memDetail.dispose();
			if(shopDetail != null) shopDetail.dispose();
			if(prodDetail != null) prodDetail.dispose();
			if(orderDetail != null) orderDetail.dispose();
			prodDetail = new ProdDetail();
			break;
		case "주문상세" :
			if(memDetail != null) memDetail.dispose();
			if(shopDetail != null) shopDetail.dispose();
			if(prodDetail != null) prodDetail.dispose();
			if(orderDetail != null) orderDetail.dispose();
			orderDetail = new OrderDetail();
			break;
		case "프로그램종료" :
			System.setSecurityManager(new SecurityManager(){
				@Override
				public void checkExit(int status) {
					if(status != 5) {
						throw new SecurityException(); 
					}else {
						JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
						System.out.println("시스템 종료!");
					}
				}
			});
			for(int i=0; i<10; i++) {
				System.out.println(i);
				try {
					System.exit(i); 
				} catch(SecurityException e1) {
				}
			}
			break;
		}
	}

	public static void main(String[] args) {
		new Menu();
	}
}
