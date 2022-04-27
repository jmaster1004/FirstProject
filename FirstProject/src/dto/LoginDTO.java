package dto;


public class LoginDTO {
	private String id;
	private String password;
	private String name;
	private String grade;
	
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}


	public LoginDTO(String id, String password, String name, String grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.grade = grade;
	}




	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
}
