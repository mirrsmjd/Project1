package businsa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import businsa.model.ShopDao;
import businsa.model.ShopVO;

public class V extends JFrame{
	
	
	private JLabel imageLabel;
	private JPanel buttonPanel;
	private JButton[][] buttons;
	private JScrollPane scrollPane;
	private JButton HOME;
	private JLabel buttonPanelWithLabel;
	static String userid;
    
    public V(String v,String userid) {
	
    	getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));

		// ArrayList로 이미지를 불러온다. - SHOPIMAGE에 있는것을 불러옴
		ShopDao shopDao = new ShopDao();
		ArrayList<ShopVO> shopimageList = shopDao.getShopimageList(v);
		int numRows = 2; // 2열
		int numCols = 4; // 4행
		String[][] imagePaths = new String[numRows][numCols];
		for (int i = 0; i < numRows * numCols && i < shopimageList.size(); i++) {
			imagePaths[i / numCols][i % numCols] = shopimageList.get(i).getShopimage();
		}

		setTitle("Businsa");

		getContentPane().setLayout(new BorderLayout());

		imageLabel = new JLabel("BUSINSA");
		imageLabel.setForeground(Color.BLACK);
		imageLabel.setFont(new Font("무신사",Font.BOLD,40));
		imageLabel.setBounds(550,0,200,50);
		getContentPane().add(imageLabel, BorderLayout.CENTER);

		ArrayList<ShopVO> shopDataList = shopDao.getShopList(v);
//		int  cnt   = shopDataList.size();
//		int  rows  = (int) Math.ceil(cnt / 4);
//		int  cols  = imagePaths[0].length;

		Border padding = BorderFactory.createEmptyBorder(200, 50, 50, 50);
		buttonPanel = new JPanel(new GridLayout(numRows, numCols, 100, 100));
		buttonPanel.setForeground(new Color(255, 255, 255));
		buttonPanel.setBackground(new Color(255, 255, 255));
		buttonPanel.setBorder(padding);

		buttons = new JButton[numRows][numCols];
		buttonPanelWithLabel = new JLabel();

		ArrayList<JLabel> shopList = new ArrayList<JLabel>();
		int p = 0; // 0부터 ~ 증가하는 수까지 대려오기
		int cnt = shopDataList.size();
		ShopVO shop;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (imagePaths[i][j] != null && !imagePaths[i][j].isEmpty()) {  // 이미지가 없는 버튼은 전부 삭제
					int shopIndex = (i * numCols) + j;
					if (shopIndex < shopDataList.size()) {
						shop = shopDataList.get(shopIndex);
					} else {
						shop = new ShopVO("", "");
					}
					buttons[i][j] = new JButton("" + (i * numCols + j + 1));
					buttons[i][j].setPreferredSize(new Dimension(200, 200)); 

					JLabel label = new JLabel(
							"<html>매장명 : " + shop.getShopname() + "<br><br>주소 : " + shop.getShopaddr() + "</html>",
							SwingConstants.CENTER);
					label.setFont(new Font("세방고딕", Font.PLAIN, 16));
					label.setPreferredSize(new Dimension(100, 100));
					label.setHorizontalAlignment(label.LEFT);
					buttonPanel.add(buttons[i][j]);
					buttonPanel.add(label);

					JPanel buttonPanelWithLabel = new JPanel(new BorderLayout());
					buttonPanelWithLabel.setBackground(Color.WHITE);
					buttonPanelWithLabel.add(buttons[i][j], BorderLayout.CENTER);
					buttonPanelWithLabel.add(label, BorderLayout.SOUTH);

					ImageIcon icon = new ImageIcon(imagePaths[i][j]);
					icon = resizeImageIcon(icon, 250, 200);
					buttons[i][j].setIcon(icon);
					buttons[i][j].setText(null);
					buttons[i][j].setPreferredSize(new Dimension(200, 200));
					buttons[i][j].setBackground(Color.white);
					buttons[i][j].setBorderPainted(false);

					// 버튼을 이용하여 다른 클래스로 넘어가기
					buttons[i][j].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							new Businsa_clothes_V("V",userid); // 일단 이거 임의로 joinScreen 클래스로 넘어가도록 설정
							setVisible(false);

						}
					});

					// System.out.printf("i=%d j=%d\n", i,j); - 행 열 확인용

					buttonPanel.add(buttonPanelWithLabel);

				}
			}
		}

		buttonPanel.repaint();

		scrollPane = new JScrollPane(buttonPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()); 																								

		HOME = new JButton("HOME");
		HOME.setBackground(new Color(0, 0, 0));
		HOME.setForeground(new Color(255, 255, 255));
		HOME.setBorder(null);
		HOME.setBounds(50,10,100,50);
		getContentPane().add(HOME);
		HOME.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Home2(userid);
				setVisible(false);
			}
		});
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().repaint();

		setSize(1300, 800); // 화면 사이즈
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 화면 보이기
		setLocationRelativeTo(null);

	}

	// 이미지 아이콘 사이즈 조절
	public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImg);
	}

}
