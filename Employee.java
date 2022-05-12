public class Employee extends Staff implements ICalculator{
    private float overTime;

    public Employee(String idStaff, String nameStaff, int ageStaff, float coefficient, String dateStart, String department, int countDayOff, float overTime) {
        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.coefficient = coefficient;
        this.dateStart = dateStart;
        this.department = department;
        this.countDayOff = countDayOff;
        this.overTime = overTime;
    }
    // Method to calculateSalary
    public double calculateSalary() {
        return calculateSalaryStaff();
    }

    @Override
    public void displayInformation() {
        System.out.println("Employee ID is " + idStaff);
        System.out.println("Employee name is " + nameStaff);
        System.out.println("Employee age is " + ageStaff);
        System.out.println("The Employee's work department is " + department);
        System.out.println("The Employee's first working day: " + dateStart + "\n");

    }

    @Override
    public float calculateSalaryStaff() {
        float salary;
        salary = (coefficient * 3000000) + (overTime * 200000);
        return salary;
    }

    @Override
    public float calculateSalaryManager() {
        return 0;
    }

}
