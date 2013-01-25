package test.dto;

public class friendDTO {
	public friendDTO(){};
	
	private int num;
	private String name;
	private String phone;
	private String regdate;
	
	//인자를 갖는 클래스 생성자
	public friendDTO(int num, String name, String phone, String regdate) {
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	//getter and setter Method
}
