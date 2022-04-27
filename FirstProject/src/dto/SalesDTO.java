package dto;

import java.sql.Date;

public class SalesDTO {	
	private int id;
	private String sold_name;
	private int sold_price;
	private int sold_cnt;
	private int sold_totprice;
	private Date sold_date;
	
	public SalesDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SalesDTO(int id, String sold_name, int sold_price, int sold_cnt, int sold_totprice, Date sold_date) {
		this.id = id;
		this.sold_name = sold_name;
		this.sold_price = sold_price;
		this.sold_cnt = sold_cnt;
		this.sold_totprice = sold_totprice;
		this.sold_date = sold_date;
 	}
	
	public SalesDTO(String sold_name, int sold_price, int sold_cnt, int sold_totprice) {
		this.sold_name = sold_name;
		this.sold_price = sold_price;
		this.sold_cnt = sold_cnt;
		this.sold_totprice = sold_totprice;
 	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSold_name() {
		return sold_name;
	}

	public void setSold_name(String sold_name) {
		this.sold_name = sold_name;
	}

	public int getSold_price() {
		return sold_price;
	}

	public void setSold_price(int sold_price) {
		this.sold_price = sold_price;
	}

	public int getSold_cnt() {
		return sold_cnt;
	}

	public void setSold_cnt(int sold_cnt) {
		this.sold_cnt = sold_cnt;
	}

	public int getSold_totprice() {
		return sold_totprice;
	}

	public void setSold_totprice(int sold_totprice) {
		this.sold_totprice = sold_totprice;
	}

	public Date getSold_date() {
		return sold_date;
	}

	public void setSold_date(Date sold_date) {
		this.sold_date = sold_date;
	}		
	
}
