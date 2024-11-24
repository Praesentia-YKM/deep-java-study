package generic.bank;

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
        return "카드번호: " + cardNumber + ", 금액: " + amount + "원, 날짜: " + transactionDate;
    }
}
