public class Department {
    private String idDepartment;
    private String nameDepartment;
    private int totalStaff;

    public Department(String idDepartment, String nameDepartment, int totalStaff) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.totalStaff = totalStaff;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public int getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(int totalStaff) {
        this.totalStaff = totalStaff;
    }

    @Override
    public String toString() {
        return "Department:" +
                "IdDepartment: " + idDepartment + "\n" +
                "NameDepartment: " + nameDepartment + "\n" +
                "TotalStaff: " + totalStaff + "\n";
    }
}
