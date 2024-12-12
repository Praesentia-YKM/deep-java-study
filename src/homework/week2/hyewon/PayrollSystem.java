package homework.week2.hyewon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PayrollSystem {
    public static void main(String[] args) {
        // 직원 정보 초기화
        // id 중복 허용 X
        Set<Employee> employees = new HashSet<>();
        addEmployee(employees, new Employee(101, "양권모", "사원", 3000000, "123-456-7890"));
        addEmployee(employees, new Employee(102, "이우형", "주임", 4000000, "456-789-1011"));
        addEmployee(employees, new Employee(101, "양권모", "사원", 3000000, "123-456-7890")); // 중복
        addEmployee(employees, new Employee(103, "이혜원", "대리", 5000000, "111-111-1111"));

        // 근태기록
        System.out.println("\n=== 근태 기록 ===");
        Set<Attendance> attendances = new HashSet<>();
        addAttendance(attendances, new Attendance(101, LocalDate.of(2024, 12, 1), false));
        addAttendance(attendances, new Attendance(102, LocalDate.of(2024, 12, 1), false));
        addAttendance(attendances, new Attendance(102, LocalDate.of(2024, 12, 1), false));
        addAttendance(attendances, new Attendance(103, LocalDate.of(2024, 12, 1), true));

        // 급여 계산/전송 시스템 초기화
        Payroll payroll = new Payroll();
        Payment payment = new Payment();

        for (Employee employee : employees) {
            try {
                // 급여 계산
                int finalSalary = payroll.calcFinalSalary(employee, new ArrayList<>(attendances));
                System.out.println("급여: " + finalSalary + "원, 직원명: " + employee.name);

                // 급여 전송
                payment.processPayment(employee, finalSalary);
            } catch (IllegalArgumentException e) {
                System.out.println("급여 계산 오류 - " + employee.name + ": " + e.getMessage());
            }
        }

        // 중복 전송 테스트
        System.out.println("== 중복 전송 테스트 ==");
        for (Employee employee : employees) {
            payment.processPayment(employee, 0);
        }
    }

    public static void addEmployee(Set<Employee> employees, Employee employee) {
        if (employees.contains(employee)) {
            System.out.println("중복된 직원입니다: " + employee);
        } else {
            employees.add(employee);
            System.out.println("직원이 추가되었습니다: " + employee);
        }
    }

    private static void addAttendance(Set<Attendance> attendances, Attendance attendance) {
        if (!attendances.add(attendance)) {
            System.out.println("중복된 근태 기록입니다: " + attendance);
        } else {
            System.out.println("근태 기록이 추가되었습니다: " + attendance);
        }
    }
}
