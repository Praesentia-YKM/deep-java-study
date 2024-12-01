package collection.payment;

public enum PayErrorCode {
    NEGATIVE_SALARY("E001", "계산된 급여가 음수입니다.", "급여 계산 중 음수가 발생했습니다."),
    INVALID_ACCOUNT("E002", "잘못된 계좌번호입니다.", "계좌번호가 비어 있거나 유효하지 않습니다."),
    DUPLICATE_PAYMENT("E003", "중복된 급여 전송 요청입니다.", "이미 전송된 급여에 대한 요청입니다."),
    UNKNOWN_ERROR("E999", "알 수 없는 오류가 발생했습니다.", "시스템에서 처리되지 않은 예외가 발생했습니다.");

//  enum 값이 클래스의 상수로 정의되고, 해당 객체가 단 하나만 존재하도록 보장!
//  public static final ErrorCode NEGATIVE_SALARY = new ErrorCode("NEGATIVE_SALARY", 0, "E001", "계산된 급여가 음수입니다.");
//  public static final ErrorCode INVALID_ACCOUNT = new ErrorCode("INVALID_ACCOUNT", 1, "E002", "잘못된 계좌번호입니다.");
//  public static final ErrorCode DUPLICATE_PAYMENT = new ErrorCode("DUPLICATE_PAYMENT", 2, "E003", "중복된 급여 전송 요청입니다.");

    private final String errorCode;
    private final String message;
    private final String description;

    PayErrorCode(String errorcCode, String message, String description) {
        this.errorCode = errorcCode;
        this.message = message;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

}

