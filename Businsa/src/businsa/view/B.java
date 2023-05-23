package businsa.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class B extends JFrame {

	private JLabel imageLabel;
	private JPanel buttonPanel;
	private JButton[][] buttons;
	private JScrollPane scrollPane;
	private JButton HOME;
	private JLabel buttonPanelWithLabel;
	static String userid;

	public B(String b,String userid) {  // b 라는 인수를 만들어서 데이터를 받아올수 있음

		
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));

		// ArrayList로 이미지를 불러온다. - SHOPIMAGE에 있는것을 불러옴
		ShopDao shopDao = new ShopDao();	// ShopDao 에 있는 데이터 불러오기 준비
		ArrayList<ShopVO> shopimageList = shopDao.getShopimageList(b); // 마찬가지로 b라는 인수로 ShopDao에 있는 sql문 데이터를 들고올 수 있다.
		int numRows = 2; // 2열
		int numCols = 4; // 4행 
		String[][] imagePaths = new String[numRows][numCols];  // 2중 for문을 사용하기 때문에 배열을 2개사용 
		for (int i = 0; i < numRows * numCols && i < shopimageList.size(); i++) {
			imagePaths[i / numCols][i % numCols] = shopimageList.get(i).getShopimage();  // 이미지를 행과 열로 고정
		}

		setTitle("Businsa"); // 타이틀

		getContentPane().setLayout(new BorderLayout()); // 레이아웃설정

		imageLabel = new JLabel("BUSINSA");
		imageLabel.setForeground(Color.BLACK);
		imageLabel.setFont(new Font("무신사",Font.BOLD,40));
		imageLabel.setBounds(550,0,200,50);
		getContentPane().add(imageLabel, BorderLayout.CENTER); // 위쪽으로 설정한다.

		ArrayList<ShopVO> shopDataList = shopDao.getShopList(b); // ArrayList로 담겨진 shopdataList 가져오기 준비
//		int  cnt   = shopDataList.size();
//		int  rows  = (int) Math.ceil(cnt / 4);
//		int  cols  = imagePaths[0].length;

		Border padding = BorderFactory.createEmptyBorder(200, 50, 50, 50); // 버튼 패널의 상하 좌우 50 씩 비우기
		buttonPanel = new JPanel(new GridLayout(numRows, numCols, 100, 100)); // 행과 열 좌 우 간격
		buttonPanel.setForeground(new Color(255, 255, 255));	// 앞의 배경 칼러
		buttonPanel.setBackground(new Color(255, 255, 255));	// 뒤 배경 칼러
		buttonPanel.setBorder(padding); 

		buttons = new JButton[numRows][numCols]; // 버튼 배열 설정 
		buttonPanelWithLabel = new JLabel();     // 버튼패널 및 라벨 설정 

		ArrayList<JLabel> shopList = new ArrayList<JLabel>(); // shopList 대려오기 준비
		int p = 0; // 0부터 ~ 증가하는 수까지 대려오기 - 중요
		int cnt = shopDataList.size(); // ShopDataList에 담긴 전체 데이터 사이즈
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
					buttons[i][j] = new JButton("" + (i * numCols + j + 1)); // 버튼 배열 설정
					buttons[i][j].setPreferredSize(new Dimension(0, 0)); // 버튼의 크기 간격 설정 200 * 200 적당

					JLabel label = new JLabel(
							"<html>매장명 : " + shop.getShopname() + "<br>" + "<br>주소 : " + shop.getShopaddr() + "</html>",
							SwingConstants.CENTER);  // 라벨쪽으로 가져올 데이터들 정리
					label.setFont(new Font("세방고딕", Font.PLAIN, 16));
					label.setPreferredSize(new Dimension(100, 100));  // 라벨 사이즈
					label.setHorizontalAlignment(label.CENTER); // 라벨을 왼쪽으로 위치 설정
					buttonPanel.add(buttons[i][j]); 
					buttonPanel.add(label);

					JPanel buttonPanelWithLabel = new JPanel(new BorderLayout()); // 버튼 패널의 설정 
					buttonPanelWithLabel.setBackground(Color.WHITE); 
					buttonPanelWithLabel.add(buttons[i][j], BorderLayout.CENTER); // 버튼은 중앙으로
					buttonPanelWithLabel.add(label, BorderLayout.SOUTH); // 레이아웃은 남쪽으로

					ImageIcon icon = new ImageIcon(imagePaths[i][j]); // 버튼에 이미지를 담아줄 아이콘 설정
					icon = resizeImageIcon(icon, 250, 200); // 버튼 이미지 사이즈 설정
					buttons[i][j].setIcon(icon);
					buttons[i][j].setText(null);
					buttons[i][j].setPreferredSize(new Dimension(200, 200)); // 버튼 간격 사이즈 설정 
					buttons[i][j].setBackground(Color.white);
					buttons[i][j].setBorderPainted(false); // 설정이 끝난이후 닫기

					// 버튼을 이용하여 다른 클래스로 넘어가기
					buttons[i][j].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							new Businsa_clothes_B("B",userid);
							setVisible(false);

						}
					});

					// System.out.printf("i=%d j=%d\n", i,j); - 행 열 확인용

					buttonPanel.add(buttonPanelWithLabel);

				}
			}
		}

		buttonPanel.repaint();

		// 스크롤 패널 설정
		scrollPane = new JScrollPane(buttonPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());

		// HOME 버튼 설정 
		HOME = new JButton("HOME");
		HOME.setBackground(new Color(0, 0, 0));
		HOME.setForeground(new Color(255, 255, 255));
		HOME.setBorder(null);
		HOME.setBounds(50,10,100,50);
		getContentPane().add(HOME);
		HOME.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // HOME 버튼을 클릭하면 home 버튼으로 돌아가게 설정
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
