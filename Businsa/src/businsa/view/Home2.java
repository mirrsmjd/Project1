package businsa.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import businsa.model.MemberDao;

public class Home2 extends JFrame {
	
	JLabel a,p1,p2,p3;
	JLabel l1,l2,l3,l4,l5;
	static String userid;
	static String b;
	ImageIcon i1;
	
	
	
	public  Home2(String userid) {
	this.userid = userid;
	
	
	JFrame fr = new JFrame("HOME");
	
	fr.getContentPane().setLayout(null);
	
    fr.setSize(1450, 830);
    fr.setLocationRelativeTo(null);
    fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    fr.getContentPane().setBackground(Color.WHITE);
    
    a = new JLabel("BUSINSA");
    a.setFont(new Font("무신사",Font.BOLD,40));
    a.setForeground(Color.BLACK);
    a.setBounds(625,0,200,50);
    
    p1 = new JLabel("보세사진");
    p1.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\보세.jfif"));
    p1.setBounds(100, 100, 350, 500);
    p1.setOpaque(true);
    p1.setBackground(Color.DARK_GRAY);
    //i1 = new ImageIcon(getClass().getResource("스크린샷(1).png"));
    //p1.setIcon(i1);

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

    l2 = new JLabel(" 편집샵 ");
    l2.setBounds(700,600,150,50);
    l2.setFont(new Font("세방고딕", Font.BOLD, 15));

    l3 = new JLabel(" 빈티지 ");
    l3.setBounds(1150,600,150,50);
    l3.setFont(new Font("세방고딕", Font.BOLD, 15));
    
    l4 = new JLabel(userid + "님이 로그인");
    l4.setBounds(670,650,200,50);
    l4.setFont(new Font("세방고딕", Font.BOLD, 15));
    
    l5 = new JLabel("<html>주식회사 부신사 (BUSINSA Co., Ltd.)<br>"
    		+ "부산광역시 부산진구 중앙대로 749 426호<br>"
    		+ "업체등록문의 051-912-1000</html>");
    l5.setFont(new Font("세방고딕", Font.PLAIN, 12));
    l5.setBounds(1200,680,300,150);
    
    fr.getContentPane().add(a);
    fr.getContentPane().add(p1);
    fr.getContentPane().add(p2);
    fr.getContentPane().add(p3);
    
    fr.getContentPane().add(l1);
    fr.getContentPane().add(l2);
    fr.getContentPane().add(l3);
    fr.getContentPane().add(l4);
    fr.getContentPane().add(l5);
    
    fr.setVisible(true);
    
   
l4.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		new Mypage(userid);
		fr.setVisible(false);
		
		
	}
});


p1.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
				
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		new B("B",userid);
		fr.setVisible(false);
		
	}
});

p2.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
				
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		new P("P",userid);
		
		fr.setVisible(false);
		
	}
});

p3.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
				
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		new V("V",userid);
		fr.setVisible(false);
		
	}
});

}

	public static void main(String[] args) {
		new Home();
		
	}
	
}

