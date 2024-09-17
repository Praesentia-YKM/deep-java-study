package enumeration.ref3;

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

    // 추가
    // 이제는 계산을 내가 스스로 할 수 있게 됐다. 따라서 내가 가지고 있는 데이터 이기 때문에 내가 계산을 한다.
    // 캡슐화 원칙에 좀 더 부합
    public int discount(int price) {
        return price * discountPercent / 100;
    }
}
