package businsa.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businsa.view.B;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//구매완료
public class Buymessage {

	private JFrame frame;
       String userid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buymessage window = new Buymessage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Buymessage() {
		initialize();
	}

	public Buymessage(String userid) {
		this.userid = userid;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 260);
		frame.getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("장바구니에 넣으셨습니다 확인하시겠습니까?");
		lblNewLabel.setFont(new Font("세방고딕", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 0, 350, 120);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("예");
		btnNewButton.setBounds(15, 100, 147, 55);
		btnNewButton.setFont(new Font("세방고딕", Font.BOLD, 15));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		panel.add(btnNewButton);
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Buylist yc= new Buylist(userid);
				frame.setVisible(false);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("쇼핑 계속하기");
		btnNewButton_1.setBounds(220, 100, 155, 55);
		btnNewButton_1.setFont(new Font("세방고딕", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 new B("B",userid);
				 frame.setVisible(false);
		           
				
			}
		});
	}
}
