package businsa.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businsa.view.B;
//픽업완료
public class PickupSucess {

	private JFrame frame;
      String userid ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickupSucess window = new PickupSucess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public PickupSucess(String userid) {
		this.userid= userid;
		initialize();
	}
	/**
	 * Create the application.
	 */
	public PickupSucess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("픽업 되었습니다.");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 52));
		lblNewLabel.setBounds(12, 62, 410, 123);
		panel.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("계속 쇼핑하기");
		btnNewButton.setBounds(271, 195, 124, 43);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
              new B("B",userid); 
				
			}
		});
	}
}
