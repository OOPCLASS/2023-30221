package lab5;

public class BankStaff {
    private String staffID;
    private String name;
    private String position;

    public BankStaff(String staffID, String name, String position){
        this.name = name;
        this.staffID = staffID;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
}
