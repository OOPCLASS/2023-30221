public class BankStaff {
    private int staffId;
    private String staffName;
    private String staffPosition;

    public void BankStaff(int staffId, String staffName, String staffPosition) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffPosition = staffPosition;
    }

    public int getStaffID() {
        return staffId;
    }

    public String getName() {
        return staffName;
    }

    public String getPosition() {
        return staffPosition;
    }

}
