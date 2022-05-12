public class Manager extends Staff implements ICalculator{
    private String title;

    public Manager(String idStaff, String nameStaff, int ageStaff, float coefficient, String dateStart, String department,int countDayOff, String title) {
        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.coefficient = coefficient;
        this.dateStart = dateStart;
        this.department = department;
        this.countDayOff = countDayOff;
        this.title = title;
    }

    @Override
    public void displayInformation() {
        System.out.println("Manager ID is " + idStaff);
        System.out.println("Manager name is " + nameStaff);
        System.out.println("Manager's title is " + title);
        System.out.println("Manager age is " + ageStaff);
        System.out.println("The Manager's work department is " + department);
        System.out.println("The Manager's first working day: " + dateStart + "\n");

    }

    @Override
    public float calculateSalaryStaff() {
        return 0;
    }

    @Override
    public float calculateSalaryManager() {
        float salary;
        if ( title.equals("Business Leader")) {
            salary = (5000000 * coefficient) + 8000000;
            return salary;
        } else if (title.equals("Project Leader")) {
            salary = (5000000 * coefficient) + 5000000;
            return salary;
        } else if (title.equals("Technical Leader")){
            salary = (5000000 * coefficient) + 6000000;
            return salary;
        } else {
            return 0;
        }
    }
}
