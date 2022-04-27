package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.MenuDAO;
import dao.SalesDAO;
import dto.MenuDTO;
import dto.SalesDTO;

import javax.swing.JLabel;

public class ManagerGUIApp extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtNum, txtName, txtPrice, txtStock;
	private JTable stockTable, saleTable;
	private JLabel lbltotPrice;

	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int UPDATE_CHANGE = 2;
	public static final int SEARCH = 3;
	public static final int DELETE = 4;

	int cmd;

	
	/**
	 * Launch the application.ssss
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUIApp window = new ManagerGUIApp();
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
	public ManagerGUIApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(500,0);
		Object[] salesTitle = { "¹øÈ£", "Á¦Ç°¸í", "°¡°Ý", "¼ö·®" ,"ÃÑ°¡°Ý", "ÆÇ¸ÅÀÏ" };

		Object[] stockTitle = { "¹øÈ£", "Á¦Ç°¸í", "°¡°Ý", "Àç°í·®", "ÆÇ¸Å·®" };
		saleTable = new JTable(new DefaultTableModel(salesTitle, 0));
		saleTable.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		saleTable.setRowHeight(20);
		saleTable.setEnabled(false);
		saleTable.getTableHeader().setReorderingAllowed(false);
		saleTable.getTableHeader().setResizingAllowed(false);
		
		JTableHeader header1 = saleTable.getTableHeader();
		header1.setFont(header1.getFont().deriveFont(20f));
		
		stockTable = new JTable(new DefaultTableModel(stockTitle, 0));
		stockTable.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		stockTable.setEnabled(false);
		stockTable.getTableHeader().setReorderingAllowed(false);
		stockTable.getTableHeader().setResizingAllowed(false);
		stockTable.setRowHeight(20);
		JTableHeader header2 = stockTable.getTableHeader();
		header2.setFont(header2.getFont().deriveFont(20f));
		
		
		ImagePanel stockPane = new ImagePanel(
				new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//mngStock.png")
						.getImage());
		getContentPane().add(stockPane);
		stockPane.setLayout(null);
		pack();

		JButton btnStock = new JButton("\uC7AC\uACE0\uD604\uD669");
		btnStock.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/btnStockMain.png"));
		btnStock.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnStock.setBounds(188, 140, 176, 53);
		stockPane.add(btnStock);

		JButton btnStockSale = new JButton("\uB9E4\uCD9C\uD604\uD658");

		btnStockSale.setIcon(
				new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/btnStockSaleMain.png"));
		btnStockSale.setBounds(443, 140, 163, 53);
		stockPane.add(btnStockSale);

		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setIcon(
				new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/btnStockSearch.png"));

		btnSearch.setBounds(630, 293, 130, 29);
		stockPane.add(btnSearch);

		JButton btnUpdate = new JButton("\uBCC0\uACBD");
		btnUpdate.setIcon(
				new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/btnStockUpdate.png"));

		btnUpdate.setBounds(630, 252, 130, 29);
		stockPane.add(btnUpdate);

		JButton btnAdd = new JButton("\uCD94\uAC00");
		btnAdd.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/btnStockInsert.png"));

		btnAdd.setBounds(630, 210, 138, 29);
		stockPane.add(btnAdd);

		JButton btnHome = new JButton("\uD648");

		btnHome.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/StockHome.png"));
		btnHome.setBounds(31, 940, 138, 47);
		stockPane.add(btnHome);

		JButton btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/stockDelete.png"));

		btnDelete.setBounds(614, 938, 146, 50);
		stockPane.add(btnDelete);

		txtNum = new JTextField();
		txtNum.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		txtNum.setBounds(20, 262, 124, 40);
		stockPane.add(txtNum);
		txtNum.setColumns(10);

		txtName = new JTextField();
		txtName.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		txtName.setColumns(10);
		txtName.setBounds(172, 262, 124, 40);
		stockPane.add(txtName);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		txtPrice.setColumns(10);
		txtPrice.setBounds(319, 262, 130, 40);
		stockPane.add(txtPrice);

		txtStock = new JTextField();
		txtStock.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		txtStock.setColumns(10);
		txtStock.setBounds(468, 262, 130, 40);
		stockPane.add(txtStock);

		JScrollPane stockScroll = new JScrollPane();
		stockScroll.setBounds(38, 351, 708, 545);
		stockPane.add(stockScroll);

		stockScroll.setViewportView(stockTable);

		JButton btnReset = new JButton("New button");

		btnReset.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/btnReset.png"));
		btnReset.setBounds(426, 943, 146, 44);
		stockPane.add(btnReset);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(cmd == 1)) {
					setEditable(ADD);
				} else {
					insertStock();
					setBlankTF();
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(cmd == 2)) {
					setEditable(UPDATE_CHANGE);
				} else {
					updateData();
					setBlankTF();

				}

			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(cmd == 3)) {
					setEditable(SEARCH);
				} else {
					searchStock();
					setBlankTF();

				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(cmd == 4)) {
					setEditable(DELETE);
				} else {
					deleteStock();
					setBlankTF();

				}
			}
		});

		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuGUIApp();

			}
		});

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStockInfo();
				setBlankTF();
			}
		});


		ImagePanel salePane = new ImagePanel(
				new ImageIcon("//Users//limyeongjin//eclipse-workspace//MenuProject//src//images//mngSales.png")
						.getImage());
		getContentPane().add(salePane);
		salePane.setLayout(null);

		JButton btnSaleStock = new JButton("New button");

		btnSaleStock.setIcon(
				new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/salesStockHome.png"));
		btnSaleStock.setBounds(199, 141, 155, 42);
		salePane.add(btnSaleStock);

		JButton btnSale = new JButton("New button");
		btnSale.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/salesMain.png"));
		btnSale.setBounds(428, 148, 179, 42);
		salePane.add(btnSale);

		JButton btnSaleHome = new JButton("New button");

		btnSaleHome.setIcon(new ImageIcon("/Users/limyeongjin/eclipse-workspace/MenuProject/src/images/StockHome.png"));
		btnSaleHome.setBounds(30, 941, 147, 48);
		salePane.add(btnSaleHome);

		JScrollPane saleScroll = new JScrollPane(saleTable);
		saleScroll.setBounds(28, 216, 725, 617);
		salePane.add(saleScroll);

		lbltotPrice = new JLabel("");
		lbltotPrice.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lbltotPrice.setBounds(586, 845, 155, 47);
		salePane.add(lbltotPrice);


		btnSaleHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuGUIApp();

			}
		});


		btnSaleStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockPane.setVisible(true);
				salePane.setVisible(false);
			}
		});
		
		btnStockSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockPane.setVisible(false);
				salePane.setVisible(true);

			}
		});
		setVisible(true);

		initializeTF();

		stockPane.setVisible(true);
		salePane.setVisible(false);
		
		showStockInfo();
		showSalesInfo();

	}

	public void setBlankTF() {
		txtNum.setText("");
		txtName.setText("");
		txtStock.setText("");
		txtPrice.setText("");
	}

	public void initializeTF() {
		txtNum.setEditable(false);
		txtName.setEditable(false);
		txtStock.setEditable(false);
		txtPrice.setEditable(false);
	}

	public void setEditable(int n) {
		switch (n) {
		case ADD:
			txtNum.setEditable(true);
			txtName.setEditable(true);
			txtStock.setEditable(true);
			txtPrice.setEditable(true);
			cmd = 1;
			break;
		case UPDATE_CHANGE:
			txtNum.setEditable(true);
			txtName.setEditable(true);
			txtStock.setEditable(true);
			txtPrice.setEditable(true);
			cmd = 2;
			break;
		case SEARCH:
			txtName.setEditable(true);
			cmd = 3;
			break;
		case DELETE:
			txtNum.setEditable(true);
			cmd = 4;
			break;
		case NONE:
			txtNum.setEditable(false);
			txtName.setEditable(false);
			txtStock.setEditable(false);
			txtPrice.setEditable(false);
		}
	}

	public void showSalesInfo() {
		ArrayList<SalesDTO> salesList = new ArrayList<SalesDTO>();
		salesList = new SalesDAO().getAllInfo();

		if (salesList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ ÇÐ»ýÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}

		DefaultTableModel model = (DefaultTableModel) saleTable.getModel();

		for (int i = model.getRowCount(); i > 0; i--) {

			model.removeRow(0);
		}

		int valTotPrice = 0;

		for (SalesDTO sales : salesList) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(sales.getId());
			rowData.add(sales.getSold_name());
			rowData.add(sales.getSold_price());
			rowData.add(sales.getSold_cnt());
			rowData.add(sales.getSold_totprice());
			rowData.add(sales.getSold_date());

			model.addRow(rowData);

			valTotPrice += sales.getSold_totprice();
		}
		lbltotPrice.setText(Integer.toString(valTotPrice));
	}

	public void showStockInfo() {
		ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();
		menuList = new MenuDAO().getAllInfo();

		if (menuList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ ÇÐ»ýÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}

		DefaultTableModel model = (DefaultTableModel) stockTable.getModel();

		for (int i = model.getRowCount(); i > 0; i--) {

			model.removeRow(0);
		}

		for (MenuDTO menu : menuList) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(menu.getId());
			rowData.add(menu.getProd_name());
			rowData.add(menu.getProd_price());
			rowData.add(menu.getProd_stock());
			rowData.add(menu.getProd_cnt());

			model.addRow(rowData);
			initializeTF();
			cmd = 0;

		}
	}

	public void insertStock() {
		String num = txtNum.getText();

		if (num.equals("")) {
			JOptionPane.showMessageDialog(this, "¹øÈ£  ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtNum.requestFocus();
			return;
		}

		String numReg = "^[0-9]*$";
		if (!Pattern.matches(numReg, num)) {
			JOptionPane.showMessageDialog(this, "¹øÈ£´Â ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtNum.requestFocus();
			return;
		}

		String name = txtName.getText();

		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "Á¦Ç°¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtName.requestFocus();
			return;
		}

		String nameReg = "^[°¡-ÆR]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtName.requestFocus();
			return;
		}

		String price = txtPrice.getText();//ÀüÈ­¹øÈ­°¡ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹ÝÈ¯¹Þ¾Æ ÀúÀå

		if (price.equals("")) {
			JOptionPane.showMessageDialog(this, "°¡°ÝÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtPrice.requestFocus();
			return;
		}

		String priceReg = "^[0-9]*$";
		if (!Pattern.matches(priceReg, price)) {
			JOptionPane.showMessageDialog(this, "°¡°ÝÀº ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtPrice.requestFocus();
			return;
		}

		String stock = txtStock.getText();

		if (stock.equals("")) {
			JOptionPane.showMessageDialog(this, "Àç°í¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtStock.requestFocus();
			return;
		}

		String stockReg = "^[0-9]*$";
		if (!Pattern.matches(stockReg, stock)) {
			JOptionPane.showMessageDialog(this, "Àç°í´Â ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtStock.requestFocus();
			return;
		}

		int priceEdit = Integer.parseInt(price);
		int stockEdit = Integer.parseInt(stock);

		MenuDTO dto = new MenuDTO();

		dto.setProd_name(name);
		dto.setProd_price(priceEdit);
		dto.setProd_stock(stockEdit);

		int rows = new MenuDAO().InsertInfo(dto);

		JOptionPane.showConfirmDialog(this, rows + "°³ÀÇ ¸Þ´º Á¤º¸°¡ Ãß°¡ µÇ¾ú½À´Ï´Ù.");
		initializeTF();

		showStockInfo();
		cmd = 0;

	}

	public void updateData() {
		String num = txtNum.getText();

		if (num.equals("")) {
			JOptionPane.showMessageDialog(this, "¹øÈ£  ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtNum.requestFocus();
			return;
		}

		String numReg = "^[0-9]*$";
		if (!Pattern.matches(numReg, num)) {
			JOptionPane.showMessageDialog(this, "¹øÈ£´Â ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtNum.requestFocus();
			return;
		}

		String name = txtName.getText();

		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "Á¦Ç°¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtName.requestFocus();
			return;
		}

		String nameReg = "^[°¡-ÆR]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtName.requestFocus();
			return;
		}

		String price = txtPrice.getText();

		if (price.equals("")) {
			JOptionPane.showMessageDialog(this, "°¡°ÝÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtPrice.requestFocus();
			return;
		}

		String priceReg = "^[0-9]*$";
		if (!Pattern.matches(priceReg, price)) {
			JOptionPane.showMessageDialog(this, "°¡°ÝÀº ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtPrice.requestFocus();
			return;
		}

		String stock = txtStock.getText();

		if (stock.equals("")) {
			JOptionPane.showMessageDialog(this, "Àç°í¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtStock.requestFocus();
			return;
		}

		String stockReg = "^[0-9]*$";
		if (!Pattern.matches(stockReg, stock)) {
			JOptionPane.showMessageDialog(this, "Àç°í´Â ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtStock.requestFocus();
			return;
		}

		int idEdit = Integer.parseInt(num);
		int priceEdit = Integer.parseInt(price);
		int stockEdit = Integer.parseInt(stock);

		MenuDTO dto = new MenuDTO();

		dto.setId(idEdit);
		dto.setProd_name(name);
		dto.setProd_price(priceEdit);
		dto.setProd_stock(stockEdit);

		int rows = new MenuDAO().UpdateInfo(dto);

		JOptionPane.showConfirmDialog(this, rows + "°³ÀÇ ¸Þ´º Á¤º¸°¡ º¯°æ µÇ¾ú½À´Ï´Ù.");
		initializeTF();

		showStockInfo();
		cmd = 0;

	}

	public void searchStock() {

		String name = txtName.getText();

		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "Á¦Ç°¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtName.requestFocus();
			return;
		}

		String nameReg = "^[°¡-ÆR]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtName.requestFocus();
			return;
		}

		ArrayList<MenuDTO> menuList = new MenuDAO().getSearchInfo(name);

		if (menuList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "¸Þ´º Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}

		DefaultTableModel model = (DefaultTableModel) stockTable.getModel();

		for (int i = model.getRowCount(); i > 0; i--) {

			model.removeRow(0);
		}

		for (MenuDTO menu : menuList) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(menu.getId());
			rowData.add(menu.getProd_name());
			rowData.add(menu.getProd_price());
			rowData.add(menu.getProd_stock());
			rowData.add(menu.getProd_cnt());

			model.addRow(rowData);

		}
		initializeTF();
		cmd = 0;

	}

	public void deleteStock() {

		String no = txtNum.getText();

		if (no.equals("")) {
			JOptionPane.showMessageDialog(this, "¹øÈ£¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtNum.requestFocus();
			return;
		}

		String noReg = "^[0-9]*$";
		if (!Pattern.matches(noReg, no)) {
			JOptionPane.showMessageDialog(this, "¹øÈ£´Â ¼ýÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			txtNum.requestFocus();
			return;
		}

		int rows = new MenuDAO().DeleteInfo(Integer.parseInt(no));

		JOptionPane.showConfirmDialog(this, rows + "°³ÀÇ ¸Þ´º Á¤º¸°¡ »èÁ¦ µÇ¾ú½À´Ï´Ù.");
		initializeTF();

		showStockInfo();
		cmd = 0;
	}
	
}
