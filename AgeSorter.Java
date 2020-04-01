package ExcelDataDrive;

import java.util.Comparator;

public class AgeSorter  implements Comparator<Customer> {

    public int compare(Customer c1, Customer c2) {

        return c2.getDateOfBirth().compareTo(c1.getDateOfBirth());
    }
}
