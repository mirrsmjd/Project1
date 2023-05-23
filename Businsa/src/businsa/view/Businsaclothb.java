package businsa.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;


import businsa.model.BusinsaDao;
//보세 옷

public class Businsaclothb {
 BusinsaDao mdao = new BusinsaDao();
	
 	String     cl   = mdao.clothslabel();
    JFrame frame;
	JTextField adulttxt;
	static 	String userid;
	static 	String B;
			Buylist BuyList = null;
	static 	LoginWindow b 	= null;
	public static void main(String[] args) {
         new Businsaclothb(B,userid);		
	}

	public Businsaclothb(String B,String userid) {
		this.userid = userid;
		initialize();
		
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setForeground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		JLabel lo = new JLabel("BUSINSA");
		lo.setFont(new Font("무신사", Font.BOLD, 50));
		lo.setBounds(350, 0, 300, 80);
		frame.add(lo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\편집샵.jfif"));
		lblNewLabel.setBounds(70, 150, 336, 353);
		frame.add(lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("TITLE :");
		frame.add(lblNewLabel_2);
		lblNewLabel_2.setBounds(480, 150, 117, 53);
		lblNewLabel_2.setFont(new Font("무신사",Font.BOLD,20));
		BusinsaDao mdao = new BusinsaDao();
		
		JLabel prod = new JLabel();
		prod.setBounds(600, 150, 205, 53);
		prod.setFont(new Font("무신사",Font.BOLD,20));
		frame.add(prod);
		prod.setText(cl);
		
		JLabel lblNewLabel_3 = new JLabel("SIZE   :");
		frame.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("무신사",Font.BOLD,20));
		lblNewLabel_3.setBounds(480, 200, 71, 47);
		
		JLabel size1 = new JLabel();
		size1.setBounds(600, 200, 155, 47);
		size1.setFont(new Font("무신사",Font.BOLD,20));
		frame.add(size1);
		String size = mdao.sizeabel();
		size1.setText(size);
		
		JLabel lblNewLabel_4 = new JLabel("PRICE :");
		lblNewLabel_4.setBounds(480, 250, 74, 47);
		lblNewLabel_4.setFont(new Font("무신사",Font.BOLD,20));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel price = new JLabel();
		price.setHorizontalAlignment(SwingConstants.LEFT);
		price.setBounds(600, 250, 205, 53);
		price.setFont(new Font("무신사",Font.BOLD,20));
		frame.add(price);
		String pr = mdao.pricelabel();
		price.setText(pr);
		
		JLabel adult = new JLabel("EA   :");
		frame.add(adult);
		adult.setFont(new Font("무신사",Font.BOLD,20));
		adult.setBounds(489, 300, 71, 47);
		
		adulttxt = new JTextField();
		frame.add(adulttxt);
		adulttxt.setBounds(600, 310, 50, 30);
		adulttxt.setColumns(10);
		
		
		JButton buybtn = new JButton("구매하기");
		buybtn.setBounds(481, 440, 94, 62);
		frame.add(buybtn);
		buybtn.setForeground(Color.WHITE);
		buybtn.setBackground(Color.BLACK);
		buybtn.setFont(new Font("세방고딕", Font.BOLD, 15));
		buybtn.setFocusPainted(false);
		// 구매하기 버튼을 눌러서 장바구니에 담는 형식
		buybtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
			Buymessage Bm =new Buymessage(userid);
			BusinsaDao mdao= new BusinsaDao();
		    mdao.addBuycloths(userid,cl,adulttxt.getText());
					
			}             
	
		});
		
		JButton backbtn = new JButton("이전으로");
		backbtn.setBounds(721, 440, 94, 63);
		backbtn.setForeground(Color.WHITE);
		backbtn.setBackground(Color.BLACK);
		frame.add(backbtn);
		backbtn.setFont(new Font("세방고딕", Font.BOLD, 15));
		backbtn.setFocusPainted(false);
		//backbtn.setBorderPainted( false );
		
		JButton rsvbtn = new JButton("픽업하기");
		rsvbtn.setBounds(600, 440, 94, 63);
		frame.add(rsvbtn);
		rsvbtn.setFont(new Font("세방고딕", Font.BOLD, 15));
		rsvbtn.setForeground(Color.WHITE);
		rsvbtn.setBackground(Color.BLACK);
		rsvbtn.setFocusPainted(false);
		rsvbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
            new PickupSucess(userid);				
			}
		});
		
		backbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		            new B("B",userid);
		            frame.setVisible(false);
			}
		});
	}
	
}
