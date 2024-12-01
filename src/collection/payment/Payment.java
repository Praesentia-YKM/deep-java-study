package collection.payment;

import java.util.HashSet;
import java.util.Set;

public class Payment {
    private final Set<Integer> paymentHistory = new HashSet<>(); // 전송된 직원 ID 기록

    // 급여 전송
    public void sendSalary(Employee employee, int amount) {
        if (paymentHistory.contains(employee.id)) {
            System.out.println("이미 급여가 입금되었습니다: " + employee.name);
        } else {
            System.out.println(employee.name + "님에게 " + amount +
                    "원을 계좌 (" + employee.accountNumber + ")로 전송 완료.");
            paymentHistory.add(employee.id);
        }
      }
}
