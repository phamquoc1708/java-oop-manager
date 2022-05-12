public abstract class Staff {
    protected String idStaff;
    protected String nameStaff;
    protected int ageStaff;
    protected float coefficient;
    protected String dateStart;
    protected String department;
    protected int countDayOff;

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public int getAgeStaff() {
        return ageStaff;
    }

    public void setAgeStaff(int ageStaff) {
        this.ageStaff = ageStaff;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCountDayOff() {
        return countDayOff;
    }

    public void setCountDayOff(int countDayOff) {
        this.countDayOff = countDayOff;
    }

    public abstract void displayInformation();
}
