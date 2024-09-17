package enumeration.ref2;

public enum Grade {
    // 필드에 괄호에 값을 넣음으로서 매개변수가 있는 생성자 초기화
    BASIC(10), GOLD(20), DIAMOND(30);
    
    private final int discountPercent;

    // enum은 무조건 private 생성자라 자동으로 생략됨
    Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
