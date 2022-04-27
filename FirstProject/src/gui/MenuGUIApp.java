package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

import dao.LoginDAO;
import dao.MenuDAO;
import dao.SalesDAO;
import dto.LoginDTO;
import dto.SalesDTO;
import javax.swing.JLabel;

public class MenuGUIApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JPasswordField txtpw;
	private JLabel lblOrdername1, lblOrderCnt1, lblOrderPrice1, lblOrdername2, lblOrderCnt2, lblOrderPrice2,
			lblOrdername3, lblOrderCnt3, lblOrderPrice3, lblOrderCnt, lblOrderPrice;

	private JLabel dlblOrdername1, dlblOrderCnt1, dlblOrderPrice1, dlblOrdername2, dlblOrderCnt2, dlblOrderPrice2,
			dlblOrdername3, dlblOrderCnt3, dlblOrderPrice3, dlblOrderCnt, dlblOrderPrice;

	private JLabel clblOrdername1, clblOrderCnt1, clblOrderPrice1, clblOrdername2, clblOrderCnt2, clblOrderPrice2,
			clblOrdername3, clblOrderCnt3, clblOrderPrice3, clblOrderCnt, clblOrderPrice;

	// private ImagePanel menuOne, menuTwo, menuThree, mainPanel, login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUIApp window = new MenuGUIApp();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuGUIApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(500,0);
		ImagePanel mainPanel = new ImagePanel(
				new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//main1.png")
						.getImage());
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JButton btnMng = new JButton("");
		btnMng.setIcon(new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//mng1.png"));
		btnMng.setBounds(600, 16, 158, 59);
		mainPanel.add(btnMng);

		JButton btnOrder = new JButton("New button");
		btnOrder.setIcon(new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//btn1.png"));
		btnOrder.setBounds(18, 762, 752, 232);
		mainPanel.add(btnOrder);

		mainPanel.setVisible(true);

		// ================ham===========================================================================
		ImagePanel menuOne = new ImagePanel(
				new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//menu1.png")
						.getImage());

		getContentPane().add(menuOne);
		menuOne.setLayout(null);

		JButton hammain = new JButton("New button");
		hammain.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/ham1.png"));
		hammain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		hammain.setBounds(65, 202, 151, 51);
		menuOne.add(hammain);

		JButton hamDmain = new JButton("New button");
		hamDmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		hamDmain.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/hammain2.png"));
		hamDmain.setBounds(337, 205, 131, 40);
		menuOne.add(hamDmain);

		JButton hamCmain = new JButton("New button");

		hamCmain.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/hammenu3.png"));
		hamCmain.setBounds(565, 199, 166, 51);
		menuOne.add(hamCmain);

		JButton ham1 = new JButton("New button");

		ham1.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/hammain.png"));
		ham1.setBounds(24, 288, 336, 171);
		menuOne.add(ham1);

		JButton ham3 = new JButton("New button");
		ham3.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/ham3.png"));
		ham3.setBounds(416, 290, 317, 166);
		menuOne.add(ham3);

		JButton ham2 = new JButton("New button");
		ham2.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/ham2.png"));
		ham2.setBounds(35, 515, 336, 157);
		menuOne.add(ham2);

		JButton ham4 = new JButton("New button");
		ham4.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/ham44.png"));
		ham4.setBounds(397, 508, 359, 171);
		menuOne.add(ham4);

		JButton btnCancel = new JButton("New button");
		btnCancel.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/cancel.png"));
		btnCancel.setBounds(416, 942, 151, 38);
		menuOne.add(btnCancel);

		JButton btnBuy = new JButton("New button");

		btnBuy.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/chose.png"));
		btnBuy.setBounds(612, 937, 144, 57);
		menuOne.add(btnBuy);

		lblOrdername1 = new JLabel("");
		lblOrdername1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrdername1.setBounds(72, 788, 200, 40);
		menuOne.add(lblOrdername1);

		lblOrdername2 = new JLabel("");
		lblOrdername2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrdername2.setBounds(72, 837, 200, 40);
		menuOne.add(lblOrdername2);

		lblOrdername3 = new JLabel("");
		lblOrdername3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrdername3.setBounds(72, 879, 200, 40);
		menuOne.add(lblOrdername3);

		lblOrderCnt1 = new JLabel("");
		lblOrderCnt1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrderCnt1.setBounds(372, 788, 61, 40);
		menuOne.add(lblOrderCnt1);

		lblOrderCnt2 = new JLabel("");
		lblOrderCnt2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrderCnt2.setBounds(372, 835, 61, 40);
		menuOne.add(lblOrderCnt2);

		lblOrderCnt3 = new JLabel("");
		lblOrderCnt3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrderCnt3.setBounds(372, 877, 61, 40);
		menuOne.add(lblOrderCnt3);

		lblOrderCnt = new JLabel("");
		lblOrderCnt.setForeground(Color.RED);
		lblOrderCnt.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrderCnt.setBounds(372, 736, 61, 40);
		menuOne.add(lblOrderCnt);

		lblOrderPrice1 = new JLabel("");
		lblOrderPrice1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrderPrice1.setBounds(639, 788, 117, 40);
		menuOne.add(lblOrderPrice1);

		lblOrderPrice2 = new JLabel("");
		lblOrderPrice2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrderPrice2.setBounds(639, 835, 117, 40);
		menuOne.add(lblOrderPrice2);

		lblOrderPrice3 = new JLabel("");
		lblOrderPrice3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrderPrice3.setBounds(642, 877, 114, 40);
		menuOne.add(lblOrderPrice3);

		lblOrderPrice = new JLabel("");
		lblOrderPrice.setForeground(Color.RED);
		lblOrderPrice.setBackground(Color.RED);
		lblOrderPrice.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblOrderPrice.setBounds(629, 736, 119, 40);
		menuOne.add(lblOrderPrice);

		menuOne.setVisible(false);

		menuInfo(ham1, "베이컨버거", 1, 6500);
		menuInfo(ham2, "와우버거", 1, 7200);
		menuInfo(ham3, "치킨버거", 1, 6800);
		menuInfo(ham4, "불고기버거", 1, 4800);



		btnCancel(btnCancel);

		JButton btnHamHome = new JButton("New button");

		btnHamHome.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/goHome.png"));
		btnHamHome.setBounds(31, 938, 144, 47);
		menuOne.add(btnHamHome);

		// ===================================================================
		ImagePanel menuTwo = new ImagePanel(
				new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//menu2.png")
						.getImage());
		getContentPane().add(menuTwo);
		menuTwo.setLayout(null);

		JButton dMain = new JButton("New button");
		dMain.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/dmain1.png"));
		dMain.setBounds(325, 206, 130, 50);
		menuTwo.add(dMain);

		JButton dCMain = new JButton("New button");
		dCMain.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/dCMain.png"));
		dCMain.setBounds(572, 201, 164, 44);
		menuTwo.add(dCMain);

		JButton dHamMain = new JButton("New button");
		dHamMain.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/dHamMain.png"));
		dHamMain.setBounds(71, 199, 144, 50);
		menuTwo.add(dHamMain);

		JButton d2 = new JButton("New button");
		d2.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/d2.png"));
		d2.setBounds(38, 517, 324, 155);
		menuTwo.add(d2);

		JButton d4 = new JButton("New button");
		d4.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/d4.png"));
		d4.setBounds(447, 527, 310, 172);
		menuTwo.add(d4);

		JButton d3 = new JButton("New button");
		d3.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/d3.png"));
		d3.setBounds(424, 287, 353, 183);
		menuTwo.add(d3);

		JButton dCancel = new JButton("New button");
		dCancel.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/cancel.png"));
		dCancel.setBounds(412, 940, 156, 50);
		menuTwo.add(dCancel);

		JButton dBuy = new JButton("New button");
		dBuy.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/chose.png"));
		dBuy.setBounds(613, 940, 144, 50);
		menuTwo.add(dBuy);

		JButton d1 = new JButton("New button");
		d1.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/d1.png"));
		d1.setBounds(26, 301, 324, 155);
		menuTwo.add(d1);
		menuTwo.setVisible(false);

		dlblOrdername1 = new JLabel("");
		dlblOrdername1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrdername1.setBounds(72, 788, 200, 40);
		menuTwo.add(dlblOrdername1);

		dlblOrdername2 = new JLabel("");
		dlblOrdername2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrdername2.setBounds(72, 837, 200, 40);
		menuTwo.add(dlblOrdername2);

		dlblOrdername3 = new JLabel("");
		dlblOrdername3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrdername3.setBounds(72, 879, 200, 40);
		menuTwo.add(dlblOrdername3);

		dlblOrderCnt1 = new JLabel("");
		dlblOrderCnt1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrderCnt1.setBounds(372, 788, 200, 40);
		menuTwo.add(dlblOrderCnt1);

		dlblOrderCnt2 = new JLabel("");
		dlblOrderCnt2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrderCnt2.setBounds(372, 835, 61, 40);
		menuTwo.add(dlblOrderCnt2);

		dlblOrderCnt3 = new JLabel("");
		dlblOrderCnt3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrderCnt3.setBounds(372, 877, 61, 40);
		menuTwo.add(dlblOrderCnt3);

		dlblOrderCnt = new JLabel("");
		dlblOrderCnt.setForeground(Color.RED);
		dlblOrderCnt.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrderCnt.setBounds(372, 736, 61, 40);
		menuTwo.add(dlblOrderCnt);

		dlblOrderPrice1 = new JLabel("");
		dlblOrderPrice1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrderPrice1.setBounds(639, 788, 117, 40);
		menuTwo.add(dlblOrderPrice1);

		dlblOrderPrice2 = new JLabel("");
		dlblOrderPrice2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrderPrice2.setBounds(639, 835, 117, 40);
		menuTwo.add(dlblOrderPrice2);

		dlblOrderPrice3 = new JLabel("");
		dlblOrderPrice3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrderPrice3.setBounds(642, 877, 114, 40);
		menuTwo.add(dlblOrderPrice3);

		dlblOrderPrice = new JLabel("");
		dlblOrderPrice.setForeground(Color.RED);
		dlblOrderPrice.setBackground(Color.RED);
		dlblOrderPrice.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		dlblOrderPrice.setBounds(629, 736, 119, 40);
		menuTwo.add(dlblOrderPrice);
		menuInfo(d1, "치즈볼", 1, 3500);
		menuInfo(d2, "오징어링", 1, 3800);
		menuInfo(d3, "허쉬아이스크림", 1, 4000);
		menuInfo(d4, "치파이", 1, 3200);
		btnCancel(dCancel);
		btnCancel(dCancel);

		JButton btnDHome = new JButton("New button");

		btnDHome.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/goHome.png"));
		btnDHome.setBounds(33, 938, 144, 50);
		menuTwo.add(btnDHome);

		// ===================================================================

		ImagePanel menuThree = new ImagePanel(
				new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//menu3.png")
						.getImage());
		getContentPane().add(menuThree);
		menuThree.setLayout(null);

		JButton cHamMain = new JButton("cham");
		cHamMain.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/dHamMain.png"));
		cHamMain.setBounds(66, 204, 146, 43);
		menuThree.add(cHamMain);

		JButton CDMain = new JButton("cD");
		CDMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CDMain.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/hammain2.png"));
		CDMain.setBounds(333, 206, 132, 43);
		menuThree.add(CDMain);

		JButton c1 = new JButton("c1");
		c1.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/c1.png"));
		c1.setBounds(82, 296, 269, 181);
		menuThree.add(c1);

		JButton c2 = new JButton("c2");
		c2.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/c2.png"));
		c2.setBounds(77, 507, 306, 186);
		menuThree.add(c2);

		JButton c3 = new JButton("c3");
		c3.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/c3.png"));
		c3.setBounds(444, 296, 306, 181);
		menuThree.add(c3);

		JButton c4 = new JButton("c4");
		c4.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/c4.png"));
		c4.setBounds(437, 510, 313, 181);
		menuThree.add(c4);

		JButton cCancel = new JButton("New button");
		cCancel.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/cancel.png"));
		cCancel.setBounds(410, 941, 164, 52);
		menuThree.add(cCancel);

		JButton cbuy = new JButton("cbuy");
		cbuy.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/chose.png"));
		cbuy.setBounds(613, 941, 146, 52);
		menuThree.add(cbuy);

		JButton btnNewButton_10 = new JButton("cMain");
		btnNewButton_10.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/cMain.png"));
		btnNewButton_10.setBounds(568, 206, 164, 52);
		menuThree.add(btnNewButton_10);

		// ================================================================================

		clblOrdername1 = new JLabel("");
		clblOrdername1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrdername1.setBounds(72, 788, 200, 40);
		menuThree.add(clblOrdername1);

		clblOrdername2 = new JLabel("");
		clblOrdername2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrdername2.setBounds(72, 837, 200, 40);
		menuThree.add(clblOrdername2);

		clblOrdername3 = new JLabel("");
		clblOrdername3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrdername3.setBounds(72, 879, 200, 40);
		menuThree.add(clblOrdername3);

		clblOrderCnt1 = new JLabel("");
		clblOrderCnt1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrderCnt1.setBounds(372, 788, 61, 40);
		menuThree.add(clblOrderCnt1);

		clblOrderCnt2 = new JLabel("");
		clblOrderCnt2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrderCnt2.setBounds(372, 835, 61, 40);
		menuThree.add(clblOrderCnt2);

		clblOrderCnt3 = new JLabel("");
		clblOrderCnt3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrderCnt3.setBounds(372, 877, 61, 40);
		menuThree.add(clblOrderCnt3);

		clblOrderCnt = new JLabel("");
		clblOrderCnt.setForeground(Color.RED);
		clblOrderCnt.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrderCnt.setBounds(372, 736, 61, 40);
		menuThree.add(clblOrderCnt);

		clblOrderPrice1 = new JLabel("");
		clblOrderPrice1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrderPrice1.setBounds(639, 788, 117, 40);
		menuThree.add(clblOrderPrice1);

		clblOrderPrice2 = new JLabel("");
		clblOrderPrice2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrderPrice2.setBounds(639, 835, 117, 40);
		menuThree.add(clblOrderPrice2);

		clblOrderPrice3 = new JLabel("");
		clblOrderPrice3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrderPrice3.setBounds(642, 877, 114, 40);
		menuThree.add(clblOrderPrice3);

		clblOrderPrice = new JLabel("");
		clblOrderPrice.setForeground(Color.RED);
		clblOrderPrice.setBackground(Color.RED);
		clblOrderPrice.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		clblOrderPrice.setBounds(629, 736, 119, 40);
		menuThree.add(clblOrderPrice);
		menuThree.setVisible(false);

		menuInfo(c1, "콜라", 1, 1500);
		menuInfo(c2, "딸기쉐이크", 1, 2500);
		menuInfo(c3, "사이다", 1, 1500);
		menuInfo(c4, "아이스티", 1, 2800);

		JButton btnCHome = new JButton("New button");

		btnCHome.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/goHome.png"));
		btnCHome.setBounds(38, 937, 138, 52);
		menuThree.add(btnCHome);
		cHamMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				counterPane();
				menuOne.setVisible(true);
				menuTwo.setVisible(false);
				menuThree.setVisible(false);
				mainPanel.setVisible(false);
				// login.setVisible(false);

			}

		});
		btnCancel(cCancel);

		// ================================================================================

		ImagePanel login = new ImagePanel(
				new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//login.png")
						.getImage());
		getContentPane().add(login);
		login.setLayout(null);

		txtpw = new JPasswordField();
		txtpw.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		txtpw.setBounds(276, 572, 315, 54);
		login.add(txtpw);
		txtpw.setColumns(10);

		txtId = new JTextField();
		txtId.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		txtId.setBounds(276, 472, 315, 54);
		txtId.setColumns(10);
		login.add(txtId);

		JButton btnLogin = new JButton();
		btnLogin.setIcon(
				new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//btnLogin.png"));
		btnLogin.setBounds(247, 715, 295, 88);
		login.add(btnLogin);

		JButton btnNewButton = new JButton("New button");

		btnNewButton.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/home.png"));
		btnNewButton.setBounds(337, 830, 108, 88);
		login.add(btnNewButton);
		txtpw.setVisible(false);
		txtId.setVisible(false);
		btnLogin.setVisible(false);

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtpw.setVisible(true);
				txtId.setVisible(true);

				LoginDAO loginDao = new LoginDAO();
				ArrayList<LoginDTO> dbLogin = new ArrayList<LoginDTO>();
				dbLogin = loginDao.getLoginInfo();

				if (dbLogin.get(0).getId().equals(txtId.getText())
						&& dbLogin.get(0).getPassword().equals(txtpw.getText())) {
					JOptionPane.showConfirmDialog(null, dbLogin.get(0).getName() + "님 환영합니다.!!!", "로그인",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

					new ManagerGUIApp();
					dispose();

				} else {

					JOptionPane.showConfirmDialog(null, "로그인이 실패했습니다. \n 다시 입력해 주세요.", "로그인",
							JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuTwo.setVisible(false);
				menuOne.setVisible(false);
				menuThree.setVisible(false);
				mainPanel.setVisible(true);
				login.setVisible(false);
			}
		});

		setResizable(true);

		btnOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuOne.setVisible(true);
				menuTwo.setVisible(false);
				menuThree.setVisible(false);
				mainPanel.setVisible(false);
				login.setVisible(false);
			}
		});

		btnMng.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				txtpw.setVisible(true);
				txtId.setVisible(true);
				btnLogin.setVisible(true);
				mainPanel.setVisible(false);
				menuOne.setVisible(false);
				menuTwo.setVisible(false);
				menuThree.setVisible(false);
			}

		});
		hamCmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuThree.setVisible(true);
				menuOne.setVisible(false);
				menuTwo.setVisible(false);
				mainPanel.setVisible(false);
				login.setVisible(false);
				counterPane();

			}
		});
		hamDmain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				counterPane();
				menuTwo.setVisible(true);
				menuOne.setVisible(false);
				menuThree.setVisible(false);
				mainPanel.setVisible(false);
				login.setVisible(false);

			}

		});
		dCMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuThree.setVisible(true);
				menuTwo.setVisible(false);
				menuOne.setVisible(false);
				mainPanel.setVisible(false);
				login.setVisible(false);
				counterPane();

			}

		});

		dHamMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				counterPane();
				menuOne.setVisible(true);
				menuThree.setVisible(false);
				menuTwo.setVisible(false);
				mainPanel.setVisible(false);
				login.setVisible(false);

			}

		});

		dCMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				counterPane();
				menuThree.setVisible(true);
				menuTwo.setVisible(false);
				menuOne.setVisible(false);
				mainPanel.setVisible(false);
				login.setVisible(false);

			}

		});

		CDMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				counterPane();
				menuOne.setVisible(false);
				menuTwo.setVisible(true);
				menuThree.setVisible(false);
				mainPanel.setVisible(false);
				login.setVisible(false);
			}

		});

		btnHamHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				menuOne.setVisible(false);
				menuTwo.setVisible(false);
				menuThree.setVisible(false);
				login.setVisible(false);

			}
		});

		btnDHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				menuOne.setVisible(false);
				menuTwo.setVisible(false);
				menuThree.setVisible(false);
				login.setVisible(false);
			}
		});

		btnCHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				menuOne.setVisible(false);
				menuTwo.setVisible(false);
				menuThree.setVisible(false);
				login.setVisible(false);
			}
		});
		
		buyBuger(btnBuy);
		buyBuger(cbuy);
		buyBuger(dBuy);
		
		setVisible(true);

		pack();
	}

	public void menuInfo(JButton btn, String name, int count, int price) {
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (lblOrdername1.getText().isEmpty() || lblOrdername1.getText() == name) {
					if (lblOrdername1.getText() == name) {
						lblOrderCnt1.setText(Integer.toString(count + Integer.valueOf(lblOrderCnt1.getText())));
						lblOrderPrice1.setText(Integer.toString(price + Integer.valueOf(lblOrderPrice1.getText())));
					} else {
						lblOrdername1.setText(name);
						lblOrderCnt1.setText(Integer.toString(count));
						lblOrderPrice1.setText(Integer.toString(price));
					}
				} else if (lblOrdername2.getText().isEmpty() || lblOrdername2.getText() == name) {
					if (lblOrdername2.getText() == name) {
						lblOrderCnt2.setText(Integer.toString(count + Integer.valueOf(lblOrderCnt2.getText())));
						lblOrderPrice2.setText(Integer.toString(price + Integer.valueOf(lblOrderPrice2.getText())));
					} else {
						lblOrdername2.setText(name);
						lblOrderCnt2.setText(Integer.toString(count));
						lblOrderPrice2.setText(Integer.toString(price));
					}
				} else if (lblOrdername3.getText().isEmpty() || lblOrdername3.getText() == name) {
					if (lblOrdername3.getText() == name) {
						lblOrderCnt3.setText(Integer.toString(count + Integer.valueOf(lblOrderCnt3.getText())));
						lblOrderPrice3.setText(Integer.toString(price + Integer.valueOf(lblOrderPrice3.getText())));
					} else {
						lblOrdername3.setText(name);
						lblOrderCnt3.setText(Integer.toString(count));
						lblOrderPrice3.setText(Integer.toString(price));
					}
				}

				dlblOrdername1.setText(lblOrdername1.getText());
				dlblOrdername2.setText(lblOrdername2.getText());
				dlblOrdername3.setText(lblOrdername3.getText());
				clblOrdername1.setText(lblOrdername1.getText());
				clblOrdername2.setText(lblOrdername2.getText());
				clblOrdername3.setText(lblOrdername3.getText());
				dlblOrderCnt1.setText(lblOrderCnt1.getText());
				dlblOrderCnt2.setText(lblOrderCnt2.getText());
				dlblOrderCnt3.setText(lblOrderCnt3.getText());
				clblOrderCnt1.setText(lblOrderCnt1.getText());
				clblOrderCnt2.setText(lblOrderCnt2.getText());
				clblOrderCnt3.setText(lblOrderCnt3.getText());
				dlblOrderPrice1.setText(lblOrderPrice1.getText());
				dlblOrderPrice2.setText(lblOrderPrice2.getText());
				dlblOrderPrice3.setText(lblOrderPrice3.getText());
				clblOrderPrice1.setText(lblOrderPrice1.getText());
				clblOrderPrice2.setText(lblOrderPrice2.getText());
				clblOrderPrice3.setText(lblOrderPrice3.getText());
			}
		});
	}

	public void initialization() {
		lblOrdername1.setText("");
		lblOrderCnt1.setText("");
		lblOrderPrice1.setText("");
		lblOrdername2.setText("");
		lblOrderCnt2.setText("");
		lblOrderPrice2.setText("");
		lblOrdername3.setText("");
		lblOrderCnt3.setText("");
		lblOrderPrice3.setText("");
		lblOrderCnt.setText("");
		lblOrderPrice.setText("");
		dlblOrdername1.setText("");
		dlblOrderCnt1.setText("");
		dlblOrderPrice1.setText("");
		dlblOrdername2.setText("");
		dlblOrderCnt2.setText("");
		dlblOrderPrice2.setText("");
		dlblOrdername3.setText("");
		dlblOrderCnt3.setText("");
		dlblOrderPrice3.setText("");
		dlblOrderCnt.setText("");
		dlblOrderPrice.setText("");
		clblOrdername1.setText("");
		clblOrderCnt1.setText("");
		clblOrderPrice1.setText("");
		clblOrdername2.setText("");
		clblOrderCnt2.setText("");
		clblOrderPrice2.setText("");
		clblOrdername3.setText("");
		clblOrderCnt3.setText("");
		clblOrderPrice3.setText("");
		clblOrderCnt.setText("");
		clblOrderPrice.setText("");
	}

	public void counterPane() {
		lblOrdername1.setVisible(true);
		lblOrderCnt1.setVisible(true);
		lblOrderPrice1.setVisible(true);
		lblOrdername2.setVisible(true);
		lblOrderCnt2.setVisible(true);
		;
		lblOrderPrice2.setVisible(true);
		lblOrdername3.setVisible(true);
		lblOrderCnt3.setVisible(true);
		lblOrderPrice3.setVisible(true);
		lblOrderCnt.setVisible(true);
		lblOrderPrice.setVisible(true);
		dlblOrdername1.setVisible(true);
		dlblOrderCnt1.setVisible(true);
		dlblOrderPrice1.setVisible(true);
		dlblOrdername2.setVisible(true);
		dlblOrderCnt2.setVisible(true);
		;
		dlblOrderPrice2.setVisible(true);
		dlblOrdername3.setVisible(true);
		dlblOrderCnt3.setVisible(true);
		dlblOrderPrice3.setVisible(true);
		dlblOrderCnt.setVisible(true);
		dlblOrderPrice.setVisible(true);
		clblOrdername1.setVisible(true);
		clblOrderCnt1.setVisible(true);
		clblOrderPrice1.setVisible(true);
		clblOrdername2.setVisible(true);
		clblOrderCnt2.setVisible(true);
		;
		clblOrderPrice2.setVisible(true);
		clblOrdername3.setVisible(true);
		clblOrderCnt3.setVisible(true);
		clblOrderPrice3.setVisible(true);
		clblOrderCnt.setVisible(true);
		clblOrderPrice.setVisible(true);

	}

	// (String sold_name, int sold_price, int sold_cnt, int sold_totprice)
	public void insertSales() {
		ArrayList<SalesDTO> sales = new ArrayList<SalesDTO>();
		SalesDTO vo;

		if (!(lblOrderCnt1.getText() == null || lblOrderCnt1.getText() == "")) {

			vo = new SalesDTO(lblOrdername1.getText(),
					Integer.parseInt(lblOrderPrice1.getText()) / Integer.parseInt(lblOrderCnt1.getText()),
					Integer.parseInt(lblOrderCnt1.getText()), Integer.parseInt(lblOrderPrice1.getText()));
			sales.add(vo);
		}
		if (!(lblOrderCnt2.getText() == null || lblOrderCnt2.getText() == "")) {
			vo = new SalesDTO(lblOrdername2.getText(),
					Integer.parseInt(lblOrderPrice2.getText()) / Integer.parseInt(lblOrderCnt2.getText()),
					Integer.parseInt(lblOrderCnt2.getText()), Integer.parseInt(lblOrderPrice2.getText()));
			sales.add(vo);

		}
		if (!(lblOrderCnt3.getText() == null || lblOrderCnt3.getText() == "")) {
			vo = new SalesDTO(lblOrdername3.getText(),
					Integer.parseInt(lblOrderPrice3.getText()) / Integer.parseInt(lblOrderCnt3.getText()),
					Integer.parseInt(lblOrderCnt3.getText()), Integer.parseInt(lblOrderPrice3.getText()));
			sales.add(vo);

		}

		new SalesDAO().insertSalesInfo(sales);
		new MenuDAO().UpdateStockInfo(sales);

		JOptionPane.showConfirmDialog(null, "결제가 완료 되었습니다.","결제창",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);

	}

	public void buyBuger(JButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totOrderCnt = 0;
				int totOrderPrice = 0;

				if(!(lblOrderCnt1.getText() == null || lblOrderCnt1.getText() == "")
						||!(lblOrderCnt2.getText() == null || lblOrderCnt2.getText() == "")
						||!(lblOrderCnt3.getText() == null || lblOrderCnt3.getText() == "")) {
					
					if (!(lblOrderCnt1.getText() == null || lblOrderCnt1.getText() == "")) {
						totOrderCnt += Integer.parseInt(lblOrderCnt1.getText());
					}
					if (!(lblOrderCnt2.getText() == null || lblOrderCnt2.getText() == "")) {
						totOrderCnt += Integer.parseInt(lblOrderCnt2.getText());
					}
					if (!(lblOrderCnt3.getText() == null || lblOrderCnt3.getText() == "")) {
						totOrderCnt += Integer.parseInt(lblOrderCnt3.getText());
					}

					if (!(lblOrderPrice1.getText() == null || lblOrderPrice1.getText() == "")) {
						totOrderPrice += Integer.parseInt(lblOrderPrice1.getText());
					}

					if (!(lblOrderPrice2.getText() == null || lblOrderPrice2.getText() == "")) {
						totOrderPrice += Integer.parseInt(lblOrderPrice2.getText());
					}

					if (!(lblOrderPrice3.getText() == null || lblOrderPrice3.getText() == "")) {
						totOrderPrice += Integer.parseInt(lblOrderPrice3.getText());
					}

					lblOrderCnt.setText(String.valueOf(totOrderCnt));
					lblOrderPrice.setText(String.valueOf(totOrderPrice));

					dlblOrderCnt.setText(lblOrderCnt.getText());
					clblOrderCnt.setText(lblOrderCnt.getText());

					dlblOrderPrice.setText(lblOrderPrice.getText());
					clblOrderPrice.setText(lblOrderPrice.getText());


					JOptionPane.showConfirmDialog(null,
							"고객님께서 주문하신" + lblOrderCnt.getText() + "개의 \n 총금액은 " + lblOrderPrice.getText() + "원 입니다",
							"결제창",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);

						insertSales();
				}else {
					JOptionPane.showConfirmDialog(null,
							"메뉴를 선택하십시오!","결제창",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);

				}
	
				initialization();
			}
		});
	}

	public void btnCancel(JButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialization();
			}
		});
	}
}
