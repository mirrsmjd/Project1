package businsa.view;
import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businsa.model.MemberDao;


//로그인
public class LoginWindow extends JFrame {

   private JPanel contentPane;
   private JTextField userid;
   private JPasswordField passwd;
   private JButton loginBtn, joinBtn;
 
   
   public LoginWindow() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 450);
      setLocationRelativeTo(null);
      
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 255, 255));
      contentPane.setBorder(new EmptyBorder(0, 0, 1, 1));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("BUSINSA",JLabel.CENTER);
      lblNewLabel.setFont(new Font("무신사", Font.BOLD,35));
      lblNewLabel.setBounds(40, 0, 303, 133);
      contentPane.add(lblNewLabel);
      
      JLabel lblNewLabel1 = new JLabel("로그인",JLabel.CENTER);
      lblNewLabel1.setFont(new Font("세방고딕", Font.BOLD,25));
      lblNewLabel1.setBounds(40, 40, 303, 133);
      contentPane.add(lblNewLabel1);
      
      
      userid = new JTextField();
      userid.setText("");
      userid.setBounds(40, 155, 303, 35);
      userid.setFont(new Font("세방고딕", Font.BOLD,15));
      contentPane.add(userid);
      userid.setColumns(10);
      userid.getBorder();
      
      passwd = new JPasswordField();
      passwd.setText("");
      passwd.setColumns(10);
      passwd.setFont(new Font("세방고딕", Font.BOLD,15));
      passwd.setBounds(40, 200, 303, 35);
      passwd.setEchoChar('*');
      contentPane.add(passwd);
          
      loginBtn = new JButton("로그인");
      loginBtn.setBackground(new Color(000, 000, 000));
      loginBtn.setForeground(new Color(255, 255, 255));
      loginBtn.setBorderPainted(false);
      loginBtn.setFont(new Font("세방고딕", Font.BOLD, 14));
      loginBtn.setBounds(40, 250, 303, 29);
      contentPane.add(loginBtn);
      
      joinBtn = new JButton("회원가입");
      joinBtn.setFont(new Font("세방고딕", Font.BOLD, 15));
      joinBtn.setBackground(new Color(255, 255, 255));
      joinBtn.setForeground(new Color(0, 128, 255));
      joinBtn.setBounds(125, 300, 136, 29);
      joinBtn.setBorderPainted(false);
      contentPane.add(joinBtn);
      
      
      setVisible(true);
      
      loginBtn.addKeyListener(new KeyListener() {
          @Override
          public void keyTyped(KeyEvent e) { }
          @Override
          public void keyReleased(KeyEvent e) {
             if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            	 loginBtn.doClick();
             }
          }
          @Override
          public void keyPressed(KeyEvent e) { }
       });
      
      loginBtn.addActionListener(new ActionListener() {
          MemberDao memDao = new MemberDao();
          @Override
          public void actionPerformed(ActionEvent e) {
             if(memDao.checkMemCode(userid.getText())){
                if(memDao.checkMemPwd(passwd.getText())) {
                  
                  new Home2(userid.getText());             
                	setVisible(false);
                   return;
                } else {
                   JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다");
                }
             } else {
                JOptionPane.showMessageDialog(null, "아디디가 틀렸습니다");
                userid.grabFocus();
             }   
          }
       });
      
      //회원가입 액션
      joinBtn.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new JoinScreen();
            setVisible(false);
         }
      });
   }
      public static void main(String[] args) {
  		new Home();
  	}
}