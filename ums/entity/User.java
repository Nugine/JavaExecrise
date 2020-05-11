package ums.entity;

public class User {
	private String email;
	private String userName;
	private String sex;
	private String hobbies;

	public User(String email, String userName, String sex, String hobbies) {
		this.email = email;
		this.userName = userName;
		this.sex = sex;
		this.hobbies = hobbies;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

}
