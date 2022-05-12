import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class HumanResoucres {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // Format Salary is VietNam Dong
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(0);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

        ArrayList<Department> departmentsList = new ArrayList<>();
        ArrayList<Manager> managersList = new ArrayList<>();
        ArrayList<Employee> employeesList = new ArrayList<>();
        // Create 2 Department(String idDepartment, String nameDepartment, int totalStaff);
        departmentsList.add(new Department("D01","ABC",4));
        departmentsList.add(new Department("D02","XYZ",4));
        // Create 4 Manager(String idStaff, String nameStaff, int ageStaff, float coefficient, String dateStart, String department,int countDayOff, String title)
        managersList.add(new Manager("M01", "PhamQuoc M01", 19, 1.8f, "13/08/2017","ABC", 2, "Project Leader"));
        managersList.add(new Manager("M02", "PhamQuoc M02", 20, 1.7f, "14/08/2017","ABC", 1, "Technical Leader"));
        managersList.add(new Manager("M03", "PhamQuoc M03", 21, 2f, "15/08/2017","XYZ", 0, "Business Leader"));
        managersList.add(new Manager("M04", "PhamQuoc M04", 22, 1.7f, "16/08/2017","XYZ", 2, "Technical Leader"));
        // Create 8 Employee(String idStaff, String nameStaff, int ageStaff, float coefficient, String dateStart, String department, int countDayOff, float overTime)
        employeesList.add(new Employee("E01", "PhamQuoc E01", 19, 1.2f, "17/08/2020","XYZ", 2, 2));
        employeesList.add(new Employee("E02", "PhamQuoc E02", 20, 1.7f, "18/08/2020","ABC", 3, 3));
        employeesList.add(new Employee("E03", "PhamQuoc E03", 21, 1.4f, "19/08/2020","ABC", 1, 2));
        employeesList.add(new Employee("E04", "PhamQuoc E04", 22, 1.4f, "20/08/2020","XYZ", 4, 2));
        employeesList.add(new Employee("E05", "PhamQuoc E05", 23, 1.5f, "21/08/2020","XYZ", 2, 4));
        employeesList.add(new Employee("E06", "PhamQuoc E06", 34, 1.9f, "22/08/2020","ABC", 3, 3));
        employeesList.add(new Employee("E07", "PhamQuoc E07", 39, 1.9f, "23/08/2020","ABC", 4, 3));
        employeesList.add(new Employee("E08", "PhamQuoc E07", 29, 1.2f, "24/08/2020","XYZ", 1, 2));

        boolean program = true;
        do {
            System.out.println("\nApplication Manager Officer ");
            System.out.println("Enter 1: To insert officer ");
            System.out.println("Enter 2: To show information officers in company ");
            System.out.println("Enter 3: To show information Department in company ");
            System.out.println("Enter 4: To show Salary Employee ");
            System.out.println("Enter 5: To search for employee information by name or employee ID ");
            System.out.println("Enter 6: To show Employee by Department ");
            System.out.println("Enter 7: To show salary of company employees increase");
            System.out.println("Enter 8: To show salary of company employees decrease");
            System.out.println("Enter 9: To Exit");
            System.out.print("You choose: ");
            int choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1 : {
                    System.out.println("Enter 1: to insert Department");
                    System.out.println("Enter 2: to insert Manager");
                    System.out.println("Enter 3: to insert Employee");
                    System.out.print("You choose: ");
                    int typeChoose = scanner.nextInt();
                    scanner.nextLine();
                    switch (typeChoose) {
                        case 1 : {
                            System.out.print("Enter the number of Department: ");
                            int quantily = scanner.nextInt();
                            scanner.nextLine();
                            // Check ID Department is duplicate or not
                            for (int i = 1 ; i <= quantily ; i++) {
                                boolean test = true;
                                System.out.print("\nEnter the ID Department " + i + " : ");
                                String idDepartment = scanner.nextLine();
                                // If idDepartment is duplicate then Enter again
                                while (test) {
                                    int count = 0;
                                    for (int j = 0 ; j < departmentsList.size() ; j++ ) {
                                        if ( idDepartment.equals(departmentsList.get(j).getIdDepartment())) {
                                            count = count + 1;
                                        }
                                    }
                                    if ( count > 0 ) {
                                        System.out.print("ID Department has duplicated, please re-enter: ");
                                        idDepartment = scanner.nextLine();
                                    } else {
                                        test = false;
                                    }
                                }
                                System.out.print("Enter the Name Department: ");
                                String nameDepartment = scanner.nextLine();
                                System.out.print("Enter the total Staff current: ");
                                int totalStaff = scanner.nextInt();
                                scanner.nextLine();
                                // Get the information just added to enter the departmentList
                                // Department(String idDepartment, String nameDepartment, int totalStaff)
                                Department department = new Department(idDepartment, nameDepartment, totalStaff);
                                departmentsList.add(department);
                            }
                            break;
                        }
                        case 2 : {
                            System.out.print("Enter the number of Manager: ");
                            int quantily = scanner.nextInt();
                            scanner.nextLine();
                            for ( int i = 1 ; i <= quantily ; i++ ) {
                                System.out.println("\nEnter the Manager " + i + ": ");
                                // Choose title
                                System.out.println("Enter a: if Title is Business Leader! ");
                                System.out.println("Enter b: if Title is Project Leader! ");
                                System.out.println("Enter c: if Title is Technical Leader! ");
                                System.out.print("You choose: ");
                                String titleChoose = scanner.nextLine();
                                String title = "";
                                switch (titleChoose) {
                                    case "a" : {
                                        title = "Business Leader";
                                        break;
                                    }
                                    case "b" : {
                                        title = "Project Leader";
                                        break;
                                    }
                                    case "c" : {
                                        title = "Technical Leader";
                                        break;
                                    }
                                }
                                boolean test = true;
                                System.out.print("Enter Manager's ID: ");
                                String idManager = scanner.nextLine();
                                // Check ID Manager is duplicate or not
                                while (test) {
                                    int count = 0;
                                    for ( int j = 0 ; j < managersList.size() ; j++) {
                                        // If ID Manager is duplicate then enter again
                                        if ( idManager.equals(managersList.get(j).getIdStaff())) {
                                            count = count + 1;
                                        }
                                    }
                                    if ( count > 0) {
                                        System.out.print("ID Manager has duplicated, please re-enter: ");
                                        idManager = scanner.nextLine();
                                    } else {
                                        test = false;
                                    }
                                }
                                System.out.print("Enter Manager's name: ");
                                String nameManager = scanner.nextLine();
                                System.out.print("Enter Manager's age: ");
                                int ageManager = scanner.nextInt();
                                System.out.print("Enter the Manager's salary coefficient: ");
                                float coefficient = scanner.nextFloat();
                                while ( coefficient < 0 ) {
                                    System.out.print("You have entered Coefficient wrong! Re-enter: ");
                                    coefficient = scanner.nextFloat();
                                }
                                scanner.nextLine();
                                System.out.print("Enter the Manager's start date: ");
                                String dateStart = scanner.nextLine();
                                System.out.print("Enter the Manager's Department: ");
                                String departmentManager = scanner.nextLine();
                                System.out.print("Enter the number of days off of the Manager: ");
                                int countDayOff = scanner.nextInt();
                                scanner.nextLine();
                                // Get Information just added to enter the managerList
                                //Manager(String idStaff, String nameStaff, int ageStaff, float coefficient, String dateStart, String department, int countDayOff, String title)
                                Manager manager = new Manager(idManager, nameManager, ageManager, coefficient, dateStart, departmentManager, countDayOff, title);
                                managersList.add(manager);
                            }
                            break;
                        }
                        case 3 : {
                            System.out.print("Enter the number of Employee: ");
                            int quantily = scanner.nextInt();
                            scanner.nextLine();
                            for ( int i = 1; i <= quantily ; i++ ){
                                boolean test = true;
                                System.out.print("\nEnter Employee's ID " + i + ": ");
                                String idEmployee = scanner.nextLine();
                                // Check ID Employee is duplicate or not
                                while (test) {
                                    int count = 0;
                                    for ( int j = 0 ; j < employeesList.size() ; j++) {
                                        // If ID Employee is duplicate then enter again
                                        if ( idEmployee.equals(employeesList.get(j).getIdStaff())) {
                                            count = count + 1;
                                        }
                                    }
                                    if ( count > 0) {
                                        System.out.print("ID Manager has duplicated, please re-enter: ");
                                        idEmployee = scanner.nextLine();
                                    } else {
                                        test = false;
                                    }
                                }
                                System.out.print("Enter Employee's name: ");
                                String nameEmployee = scanner.nextLine();
                                System.out.print("Enter Employee's age: ");
                                int ageEmployee = scanner.nextInt();
                                System.out.print("Enter the Employee's salary coefficient: ");
                                float coefficient = scanner.nextFloat();
                                while ( coefficient < 0 ) {
                                    System.out.print("You have entered Coefficient wrong! Re-enter: ");
                                    coefficient = scanner.nextFloat();
                                }
                                scanner.nextLine();
                                System.out.print("Enter the Employee's start date: ");
                                String dateStart = scanner.nextLine();
                                System.out.print("Enter the Employee's Department: ");
                                String department = scanner.nextLine();
                                System.out.print("Enter the number of days off of the Employee: ");
                                int countDayOff = scanner.nextInt();
                                System.out.print("Enter the Employee's overtime hours: ");
                                float overTime = scanner.nextFloat();
                                scanner.nextLine();
                                // Get Information just added enter the employeesList
                                //Employee(String idStaff, String nameStaff, int ageStaff, float coefficient, String dateStart, String department, int countDayOff, float overtime)
                                Employee employee = new Employee(idEmployee, nameEmployee, ageEmployee, coefficient, dateStart, department, countDayOff, overTime);
                                employeesList.add(employee);
                            }
                            break;
                        }
                        default: {
                            System.out.println("Invalid");
                            break;
                        }
                    }
                    break;
                }
                case 2 : {
                    // Print the List Manager with method displayInformation()
                    System.out.println("\nLIST MANAGER: ");
                    for ( int i = 0 ; i < managersList.size(); i++ ) {
                        managersList.get(i).displayInformation();
                    }
                    // Print the List Employee with method displayInformation()
                    System.out.println("\nLIST EMPLOYEE: ");
                    for ( int i = 0 ; i < employeesList.size() ; i++ ) {
                        employeesList.get(i).displayInformation();
                    }
                    System.out.println("Enter to continue");
                    System.in.read();
                    break;
                }
                case 3 : {
                    // Print the List Department with method toString()
                    for ( int i = 0 ; i < departmentsList.size() ; i++ ) {
                        System.out.println(departmentsList.get(i).toString());
                    }
                    System.out.println("Enter to continue");
                    System.in.read();
                    break;
                }
                case 4 : {
                    for ( int i = 0; i < managersList.size() ; i++ ) {
                        // Because decimalFormat.format will convert to String, so i will convert back to float
                        float tmp = Float.parseFloat(decimalFormat.format(managersList.get(i).calculateSalaryManager()));
                        // Format tmp to currency VN
                        String salaryManager = currencyVN.format(tmp);
                        System.out.println("Salary of Manager have ID " + managersList.get(i).getIdStaff() + ": " + salaryManager);
                    }
                    for ( int i = 0 ; i < employeesList.size() ; i++ ) {
                        // Because decimalFormat.format will convert to String, so i will convert back to float
                        float tmp = Float.parseFloat(decimalFormat.format(employeesList.get(i).calculateSalaryStaff()));
                        // Format tmp to currency VN
                        String salaryEmployee = currencyVN.format(tmp);
                        System.out.println("Salary of employee have ID " + employeesList.get(i).getIdStaff() + ": " + salaryEmployee);
                    }
                    System.out.println("Enter to continue");
                    System.in.read();
                    break;
                }
                case 5 : {
                    System.out.print("\nEnter 1 if you search for Employee information by Name Or Enter 2 by ID: ");
                    int find = scanner.nextInt();
                    scanner.nextLine();
                    if ( find == 1 ) {
                        System.out.print("Enter your name Employee: ");
                        String name = scanner.nextLine();
                        int count = 0;
                        // Search for Employee by Name and print the Information by method displayInformation()
                        for ( int i = 0 ; i < employeesList.size() ; i++) {
                            if ( name.equals(employeesList.get(i).getNameStaff())) {
                                employeesList.get(i).displayInformation();
                                count = count + 1;
                            }
                        }
                        // Search for Manager by Name and print the Information by method displayInformation()
                        for ( int i = 0 ; i < managersList.size() ; i++ ) {
                            if ( name.equals(managersList.get(i).getNameStaff())) {
                                managersList.get(i).displayInformation();
                                count = count + 1;
                            }
                        }
                        // if count == 0 then no employee or manager found
                        if ( count == 0 ) {
                            System.out.println("No Information");
                        }
                        System.out.println("Enter to continue");
                        System.in.read();
                    } else if ( find == 2 ) {
                        System.out.print("Enter your ID Employee: ");
                        String id = scanner.nextLine();
                        int count = 0;
                        // Search for Employee by ID and print the Information by method displayInformation()
                        for ( int i = 0 ; i < employeesList.size() ; i++) {
                            if ( id.equals(employeesList.get(i).getIdStaff())) {
                                employeesList.get(i).displayInformation();
                                count = count + 1;
                            }
                        }
                        // Search for Manager by ID and print the Information by method displayInformation()
                        for ( int i = 0 ; i < managersList.size() ; i++ ) {
                            if ( id.equals(managersList.get(i).getIdStaff())){
                                managersList.get(i).displayInformation();
                                count = count + 1;
                            }
                        }
                        // if count == 0 then no employee or manager found
                        if ( count == 0 ) {
                            System.out.println("No Information");
                        }
                        System.out.println("Enter to continue");
                        System.in.read();
                    }
                    break;
                }
                case 6 : {
                    // Run each element in departmentList
                    for ( int i = 0 ; i < departmentsList.size() ; i++) {
                        System.out.println("Department " + departmentsList.get(i).getNameDepartment() + ": ");
                        // Run each element getDepartment in employeesList and compare to getNameDepartment
                        // if the same print information with method displayInformation
                        for ( int j = 0 ; j < employeesList.size() ; j ++ ) {
                            if ( departmentsList.get(i).getNameDepartment().equals(employeesList.get(j).getDepartment()) ) {
                                employeesList.get(j).displayInformation();
                            }
                        }
                    }
                    System.out.println("Enter to continue");
                    System.in.read();
                    break;
                }
                case 7 : {
                    // Create listSalary to contain Staff's salary
                    ArrayList<Float> listSalary = new ArrayList<>();
                    for ( int i = 0 ; i < managersList.size() ; i++ ) {
                        listSalary.add(managersList.get(i).calculateSalaryManager());
                    }
                    for ( int i = 0 ; i < employeesList.size() ; i++ ) {
                        listSalary.add(employeesList.get(i).calculateSalaryStaff());
                    }
                    // Create tempSalary to contain Staff's salary but delete duplicate element
                    ArrayList<Float> tempSalary = new ArrayList<>();
                    for (int i = 0 ; i < listSalary.size() ; i++ ) {
                        if ( !tempSalary.contains(listSalary.get(i))) {
                            tempSalary.add(listSalary.get(i));
                        }
                    }
                    // Sort the tempSalary in ascending order
                    tempSalary.sort(Comparator.reverseOrder());
                    for ( int i = 0 ; i < tempSalary.size() ; i++ ) {
                        // Print the Manager have salary equals element in tempSalary
                        for ( int j = 0 ; j < managersList.size() ; j++) {
                            if ( tempSalary.get(i) == managersList.get(j).calculateSalaryManager()) {
                                float tmp = Float.parseFloat(decimalFormat.format(managersList.get(j).calculateSalaryManager()));
                                String salaryManager = currencyVN.format(tmp);
                                System.out.println("Salary's Manager: " + salaryManager);
                                managersList.get(j).displayInformation();
                            }
                        }
                        for ( int z = 0 ; z < employeesList.size() ; z++ ) {
                            // Print the Employees have salary equals element in tempSalary
                            if ( tempSalary.get(i) == employeesList.get(z).calculateSalaryStaff()) {
                                float tmp = Float.parseFloat(decimalFormat.format(employeesList.get(z).calculateSalaryStaff()));
                                String salaryManager = currencyVN.format(tmp);
                                System.out.println("Salary's Employee: " + salaryManager);
                                employeesList.get(z).displayInformation();
                            }
                        }
                    }
                    System.out.println("Enter to continue");
                    System.in.read();
                    break;
                }
                case 8 : {
                    // Create listSalary to contain Employee's salary
                    ArrayList<Float> listSalary = new ArrayList<>();
                    for ( int i = 0 ; i < employeesList.size() ; i++ ) {
                        if ( !listSalary.contains(employeesList.get(i).calculateSalaryStaff())) {
                            listSalary.add(employeesList.get(i).calculateSalaryStaff());
                        }
                    }
                    // Sort the listSalary by descending and print the Employees have salary equals element in listSalary
                    listSalary.sort(Comparator.naturalOrder());
                    for (int i = 0 ; i < listSalary.size() ; i++ ) {
                        for ( int j = 0 ; j < employeesList.size() ; j++ ) {
                            if ( listSalary.get(i) == employeesList.get(j).calculateSalaryStaff()) {
                                float tmp = Float.parseFloat(decimalFormat.format(employeesList.get(j).calculateSalaryStaff()));
                                String salary = currencyVN.format(tmp);
                                System.out.println("Salary's Employee: " + salary);
                                employeesList.get(j).displayInformation();
                            }
                        }
                    }
                    System.out.println("Enter to continue");
                    System.in.read();
                    break;
                }
                case 9 : {
                    // program = false then while will stop
                    program = false;
                    System.out.println("Escaped");
                    break;
                }
                default: {
                    // if enter number wrong then print Invalid
                    System.out.println("Invalid");
                }
            }
        } while (program);
    }
}
