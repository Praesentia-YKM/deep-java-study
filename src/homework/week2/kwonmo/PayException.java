package homework.week2.kwonmo;

/**
 * 자바 예외
 * 체크, 언체크
 * 
 *                exception->체크 ; 체크예외가 발생하면 무조건 처리 or throw
 * sqlException               RuntimeException : 언체크 -> 처리 하지 않아도 컴파일 에러가 안남
 */

// public class PayException extends RuntimeException
public class PayException extends RuntimeException {
    private final PayErrorCode PayErrorCode;
    
    public PayException(PayErrorCode PayErrorCode) {
        super(PayErrorCode.getMessage());
        this.PayErrorCode = PayErrorCode;
    }

    public PayException(PayErrorCode PayErrorCode, String detailMessage) {
        super(PayErrorCode.getMessage() + ": " + detailMessage);
        this.PayErrorCode = PayErrorCode;
    }

    public PayErrorCode getPayErrorCode() {
        return PayErrorCode;
    }

    public String getDescription() {
        return PayErrorCode.getDescription();
    }
}

/**
 *  왜 비즈니스 예외에 RuntimeException을 사용?
 * #1. 복구 가능성을 고려
 *  대부분의 비즈니스 예외(NegativeSalary, DuplicatePayment, InvalidAccount 등)는 복구가 불가능하며, 프로그램의 정상 흐름을 방해합니다.
 * 이러한 예외를 체크 예외로 정의하면, 호출 계층에서 불필요하게 예외 처리를 강제하게 됩니다.
 *
 * #2. 코드의 단순화
 * RuntimeException을 사용하면 호출 계층에서 예외 처리를 강제하지 않으므로 코드가 단순해지고 가독성이 높아집니다.
 * 예외 처리는 꼭 필요한 곳에서만 수행할 수 있습니다.
 *
 * #3. 디버깅 및 오류 로깅에 초점
 *
 * 대부분의 비즈니스 예외는 디버깅과 로깅의 목적으로 사용됩니다.
 * 예외를 발생시켜 프로그램이 중단되고, 적절한 로그가 기록되면 이후 문제를 해결할 수 있습니다.
 */