package homework.week1.hyewon;

public class WooriBankVO {
    private String customerName;
    private int amount;
    private String location;

    public WooriBankVO(String customerName, int amount, String location) {
        this.customerName = customerName;
        this.amount = amount;
        this.location = location;
    }

    @Override
    public String toString() {
        return "WooriBankVO{" +
                "고객명 : '" + customerName + '\'' +
                ", 금액 : " + amount + " 원"+
                ", 위치 : '" + location + '\'' +
                '}';
    }
}
