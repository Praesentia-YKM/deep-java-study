package homework.week2.kwonmo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PayrollSystem {
    public static void main(String[] args) {
        // 직원 정보 초기화
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "양권모", "사원", 3000000, "123-456-7890"));
        employees.add(new Employee(102, "이우형", "주임", 4000000, "987-654-3210"));
        employees.add(new Employee(103, "이혜원", "대리", 5000000, "555-555-5555"));

        // 근태 기록 초기화
        Set<Attendance> attendances = new HashSet<>();
        attendances.add(new Attendance(101, LocalDate.of(2024, 12, 1), false));
        attendances.add(new Attendance(102, LocalDate.of(2024, 12, 1), false));
        attendances.add(new Attendance(103, LocalDate.of(2024, 12, 1), true)); // 결근

        // 언체크예외, 체크예외
        // 스프링 에러 리졸버 -> transaction.xml errorResolver propertise -> errorView
        // throw Exception

        // 급여 계산 및 전송
        // RuntimeException 상속하게 두면 언체크 예외라 이 try문이 필요없어진다.
        // 회사 ProcException보면 extends Exception이라서 무조건 컨트롤러에서 try catch가 필요한 것이다. (물론 설정파일에 에러 리졸버로 잡아놔서 컨트롤러에서 안 잡아도됨)
        Payment paymentSystem = new Payment();
        for (Employee employee : employees) {
            try {
                int finalSalary = Payroll.calculateFinalSalary(employee, attendances);
                paymentSystem.sendSalary(employee, finalSalary);
            } catch (PayException e) {
                System.err.println("오류 발생: " + e.getPayErrorCode().getErrorCode());
                System.err.println("메시지: " + e.getMessage());
                System.err.println("설명: " + e.getDescription());
            }
        }

        // 중복 전송 테스트
        System.out.println("\n중복 전송 테스트:");
        paymentSystem.sendSalary(employees.get(0), 2752800); // 홍길동 중복 전송 시도
    }
}
