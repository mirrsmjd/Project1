package businsa.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import businsa.view.B;
import businsa.model.BusinsaDao;
import javax.swing.JTextField;


//구매목록
public class Buylist  {
       String userid;
	private JFrame frame;
	private JTable table;
	 JLabel yeyak;
	 JScrollPane   pane; 
	 JTextField textField;
	 Buylist  yc = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buylist window = new Buylist();
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
	public Buylist() {
		initialize();
	}
	public Buylist(String userid) {
		this.userid= userid;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 600);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel yeyak = new JLabel(userid + "님의 구매목록");
		yeyak.setFont(new Font("세방고딕", Font.BOLD, 30));
		yeyak.setBounds(340, 20, 393, 80);
		panel.add(yeyak);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 100, 830, 400);
		
		scrollPane.getViewport().setBackground(Color.WHITE);
		
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getTableHeader().setBackground(new Color(153,153,153,153));;
		table.getTableHeader().setFont(new Font("세방고딕", Font.BOLD, 13));
		table.setModel(
				new DefaultTableModel( getDataList() , getColumnList() ) {				
					// 기본 option 설정 - 각 cell 에 대한 편집가능여부 :isCellEditable
					@Override
					public boolean isCellEditable(int row, int column) {
					//	int  currLine = jTable.getSelectedRow();  // 선택한 줄만 수정가능
					//	if( row == currLine  )
					//		return true;			
						return false;   // 모든 cell 편집불가능
					}				
				}	
			);
	
		
	
		
JButton btnNewButton = new JButton("HOME");
btnNewButton.setBounds(30, 505, 100, 40);
panel.add(btnNewButton);
btnNewButton.setBackground(Color.BLACK);
btnNewButton.setForeground(Color.WHITE);
btnNewButton.setFont(new Font("세방고딕", Font.BOLD, 15));
btnNewButton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
              new B("B",userid);
              frame.setVisible(false);
		
	}
});
JButton btnNewButton_2 = new JButton("쇼핑 계속하기");
btnNewButton_2.setBounds(730, 505, 130, 40);
btnNewButton_2.setBackground(Color.BLACK);
btnNewButton_2.setForeground(Color.WHITE);
btnNewButton_2.setFont(new Font("세방고딕", Font.BOLD, 15));
panel.add(btnNewButton_2);
btnNewButton_2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new B("B",userid);
		frame.setVisible(false);
	}
});


}

	private Vector<Vector> getDataList() {
		
		
		BusinsaDao       dao   =  new BusinsaDao();
		Vector<Vector>  list  =  dao.getprodList(userid);
				return list ;
	}

	
	
	

	private Vector<String> getColumnList() {
		Vector<String>  cols = new Vector<>();  // 문자배열 대신 사용
		
		
		cols.add("가게이름");
		cols.add("가게번호");
		cols.add("내주소");
		cols.add("상품이름");
		cols.add("가격");
		cols.add("사이즈");
		cols.add("수량");
		cols.add("담은날짜");
		
		
		return  cols;
	}
 }

	
	

	


