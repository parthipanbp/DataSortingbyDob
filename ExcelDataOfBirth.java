package ExcelDataDrive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataOfBirth {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Assignment code snippet for print the Data based on Data's DataOfBirth : Used Business Customer Information");
		File src = new File(
				"C:\\Users\\pabalakrishnan\\Documents\\selenium automation\\CRM_BDD_FW_V1_latest\\FreeCrmBddFramework\\TestDataInPuts\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet cus_sheet = wb.getSheetAt(0);
		int lastRow = cus_sheet.getLastRowNum()+1;
		/* DataFormatter dataFormatter = new DataFormatter(); */
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Total number Of rows present in given External Data Sheet: " + lastRow);
		List<Customer> list = new ArrayList<Customer>();
		/* List<Customer>sortedListBasedUponDOB = new ArrayList<Customer>(); */

		for (int i = 1; i <= lastRow; i++) {
			String cus_Name = cus_sheet.getRow(i).getCell(0).getStringCellValue();
			String cus_Phone = cus_sheet.getRow(i).getCell(1).getRawValue();
			String tempdate = cus_sheet.getRow(i).getCell(2).getStringCellValue();
			Date datenew = formatter.parse(tempdate);
			String cus_City = cus_sheet.getRow(i).getCell(3).getStringCellValue();

			/* Adding fetched Data to List */
			Customer cust = new Customer();
			cust.setName(cus_Name);
			cust.setDateOfBirth(datenew);
			cust.setPhone(cus_Phone);
			cust.setCity(cus_City);
			list.add(cust);

		}
		/* Sorting the data based on DOB by using Comparator interface at AgeSorter.Java class */
		list.sort(new AgeSorter());

		/* Printing the customer details which sorted by Date of Birth Desc */
		for (Customer ct : list) {
			System.out.println("--------Starts--------");
			System.out.println("Customer Name : " + ct.getName());
			System.out.println("Customer Phone : " + ct.getPhone());
			System.out.println("Customer Date Of birth : " + ct.getDateOfBirth());
			System.out.println("Customer City  : " + ct.getCity());
			System.out.println("--------Ends--------");

		}

	}

}
