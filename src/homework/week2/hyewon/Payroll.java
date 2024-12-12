package homework.week2.hyewon;

import java.util.List;
import java.util.Optional;

public class Payroll {
    // 4대 보험 공제 비율
    private static final double NATIONAL_PENSION_RATE = 0.045;
    private static final double HEALTH_INSURANCE_RATE = 0.032;
    private static final double EMPLOYMENT_INSURANCE_RATE = 0.008;
    private static final double WORK_ACCIDENT_INSURANCE_RATE = 0.007;
    // 결근 차감
    private static final int ABSENCE_DEDUCTION_AMOUNT = 100000;

    /**
     * 4대 보험 공제 금액 계산
     * @param baseSalary 기본 급여
     * @return 공제 금액
     */
    public double calcInsuranceDeduction(int baseSalary) {
        double totalDeductionRate = NATIONAL_PENSION_RATE + HEALTH_INSURANCE_RATE + EMPLOYMENT_INSURANCE_RATE + WORK_ACCIDENT_INSURANCE_RATE;
        return baseSalary * totalDeductionRate;
    }

    /**
     * 결근으로 인한 차감
     * @param absences 결근 횟수
     * @return 차감 금액
     */
    public int calcAbsenceDeduction(int absences) {
        return absences * ABSENCE_DEDUCTION_AMOUNT;
    }

    /**
     * 최종 급여
     * @param employee
     * @param attendanceList 직원 근태 기록
     * @return 최종 급여
     */
    public int calcFinalSalary(Employee employee, List<Attendance> attendanceList) {
        // 결근 횟수 계산
        // TODO attendanceList 에 대한 NPE 보장

//        long absences = Optional.ofNullable(attendanceList)
//                .orElseThrow(() -> new IllegalArgumentException("널일 수 없음"))
//                .stream()
//                .filter(att -> att != null && att.employeeId == employee.id && att.isAbsent)
//                .count();

        long absences = attendanceList.stream()
                                      .filter(att -> att.employeeId == employee.id && att.isAbsent)
                                      .count();

        // 공제 금액 계산
        double insuranceDeduction = calcInsuranceDeduction(employee.baseSalary);
        int absenceDeduction = calcAbsenceDeduction((int) absences);

        // 최종 급여 계산
        int finalSalary = (int) (employee.baseSalary - insuranceDeduction - absenceDeduction);

        // 음수 급여 예외 처리
        if (finalSalary < 0) {
            throw new IllegalArgumentException("급여는 음수일 수 없습니다. 계산을 확인하세요.");
        }

        return finalSalary;
    }
}
