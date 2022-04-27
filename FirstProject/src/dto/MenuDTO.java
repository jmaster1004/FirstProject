package dto;

public class MenuDTO {
	private int id;
	private String prod_name;
	private int prod_price;
	private int prod_stock;
	private int prod_cnt;
	
	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}

	public MenuDTO(int id, String prod_name, int prod_price, int prod_stock, int prod_cnt) {
		super();
		this.id = id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_stock = prod_stock;
		this.prod_cnt = prod_cnt;
	}
	
	public MenuDTO(String prod_name, int prod_price, int prod_stock) {
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_stock = prod_stock;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_stock() {
		return prod_stock;
	}

	public void setProd_stock(int prod_stock) {
		this.prod_stock = prod_stock;
	}

	public int getProd_cnt() {
		return prod_cnt;
	}

	public void setProd_cnt(int prod_cnt) {
		this.prod_cnt = prod_cnt;
	}			
}