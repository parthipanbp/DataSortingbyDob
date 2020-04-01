package ExcelDataDrive;

import java.util.Date;

public class Customer {
	
	private String Name;
	private String Phone;
	private Date DateOfBirth;
	private String City;	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "\n \n Customer \n Name : " + Name + ",\n Phone : " + Phone + ",\n DateOfBirth=" + DateOfBirth + ",\n City=" + City + "";
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}

	

}
