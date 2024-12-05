package homework.week1.hyewon;

public class NHBankVO {
    private String cardNumber;
    private int amount;
    private String transactionDate;

    public NHBankVO(String cardNumber, int amount, String transactionDate) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "NHBankVO{" +
                "카드 번호 : '" + cardNumber + '\'' +
                ", 금액 : " + amount + "원" +
                ", 날짜 : '" + transactionDate + '\'' +
                '}';
    }
}
