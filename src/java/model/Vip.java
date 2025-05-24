package model;

public class Vip {
    private int vipID;
    private String vipName; // ✅ sửa đúng: String viết hoa S

    public Vip() {}

    public Vip(int vipID, String vipName) {
        this.vipID = vipID;
        this.vipName = vipName;
    }

    public int getVipID() {
        return vipID;
    }

    public void setVipID(int vipID) {
        this.vipID = vipID;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    @Override
    public String toString() {
        return "Vip{" + "vipID=" + vipID + ", vipName='" + vipName + '\'' + '}';
    }
}
