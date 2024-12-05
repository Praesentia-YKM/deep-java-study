package homework.week1.kwonmo;

public class NHBankVO implements BankVO {
    private String cardNumber;
    private int amount;
    private String transactionDate;

    public NHBankVO(String cardNumber, int amount, String transactionDate) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Override
    public String getId() {
        return cardNumber; // 고유 식별자로 카드 번호 반환
    }

    @Override
    public String toString() {
        return "NHBankVO{" +
                "cardNumber='" + cardNumber + '\'' +
                ", amount=" + amount +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}
