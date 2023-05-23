package businsa.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame {
	
	JLabel a;
	JLabel p1,p2,p3;
	JLabel l1,l2,l3,l4,l5;
	JButton btnlog;
	ImageIcon i1;

	public  Home() {
		
	JFrame fr = new JFrame("HOME");
	fr.getContentPane().setBackground(Color.white);
	
	
	fr.getContentPane().setLayout(null);
	
    fr.setSize(1450, 830);
    fr.setLocationRelativeTo(null);
    fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    a = new JLabel("BUSINSA");
    a.setFont(new Font("무신사",Font.BOLD,40));
    a.setForeground(Color.BLACK);
    a.setBounds(625,0,200,50);
    
    
    p1 = new JLabel("보세사진");
    p1.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\보세.jfif"));
    p1.setBounds(100, 100, 350, 500);
    p1.setOpaque(true);
    p1.setBackground(Color.DARK_GRAY);
 

    p2 = new JLabel("편집샵사진");
    p2.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\편집샵.jfif"));
    p2.setBounds(550, 100, 350, 500);
    p2.setOpaque(true);
    p2.setBackground(Color.GRAY);
    
    p3 = new JLabel("빈티지사진");
    p3.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\빈티지.jpg"));
    p3.setBounds(1000, 100, 350, 500);
    p3.setOpaque(true);
    p3.setBackground(Color.LIGHT_GRAY);
      
    l1 = new JLabel(" 보세 ");
    l1.setBounds(250,600,150,50);
    
    l1.setFont(new Font("세방고딕", Font.BOLD, 15));
    l1.setForeground(Color.BLACK);

    l2 = new JLabel(" 편집샵 ");
    l2.setBounds(700,600,150,50);
    l2.setFont(new Font("세방고딕", Font.BOLD, 15));
    l2.setForeground(Color.BLACK);
    
    l3 = new JLabel(" 빈티지 ");
    l3.setBounds(1150,600,150,50);
    l3.setFont(new Font("세방고딕", Font.BOLD, 15));
    l3.setForeground(Color.BLACK);
    
    btnlog = new JButton("LOGIN");
    btnlog.setBounds(625,680,200,50);
    btnlog.setBackground(new Color(0,0,0));
    btnlog.setForeground(new Color(255,255,255));
    btnlog.setBorderPainted( false );
    btnlog.setFont(new Font("세방고딕", Font.BOLD, 20));
    btnlog.setFocusPainted(false);
    
    l4 = new JLabel("<html>주식회사 부신사 (BUSINSA Co., Ltd.)<br>"
    		+ "부산광역시 부산진구 중앙대로 749 426호<br>"
    		+ "업체등록문의 051-912-1000</html>");
    l4.setFont(new Font("세방고딕", Font.PLAIN, 12));
    l4.setBounds(1200,680,300,150);
    
    
    fr.getContentPane().add(a);
    fr.getContentPane().add(p1);
    fr.getContentPane().add(p2);
    fr.getContentPane().add(p3);
    
    fr.getContentPane().add(l1);
    fr.getContentPane().add(l2);
    fr.getContentPane().add(l3);
    fr.getContentPane().add(l4);
    fr.getContentPane().add(btnlog);
    
    fr.setVisible(true);
    
   
btnlog.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new LoginWindow();
		fr.setVisible(false);
		
		
	}
});

p1.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		new B("B",null);
		fr.setVisible(false);
		
	}
});
	}

public static void main(String[] args) {
	new Home();
	

}

}

