package homework.week2.kwonmo;

import java.util.Set;

public class Payroll {

    // 4대보험 공제 계산
    public static int calculateDeductions(int baseSalary) {
        double nationalPension = baseSalary * 0.045; // 국민연금
        double healthInsurance = baseSalary * 0.032; // 건강보험
        double employmentInsurance = baseSalary * 0.008; // 고용보험
        double industrialAccidentInsurance = baseSalary * 0.007; // 산재보험
        return (int) (nationalPension + healthInsurance + employmentInsurance + industrialAccidentInsurance);
    }

    // 결근 차감 계산
    public static int calculateAbsencePenalty(int employeeId, Set<Attendance> attendances) {
        int penaltyPerAbsence = 100_000; // 결근 1회당 차감 금액
        int absenceCount = 0;
        for (Attendance attendance : attendances) {
            if (attendance.employeeId == employeeId && attendance.isAbsent) {
                absenceCount++;
            }
        }
        return penaltyPerAbsence * absenceCount;
    }

    // 최종 급여 계산
    // 체크예외로 했을땐 throws 로 던짐처리가 필요하다. 이래서 PayException을 RuntimeException으로 두는거다.
    // public static int calculateFinalSalary(Employee employee, Set<Attendance> attendances) throws RuntimeException
    public static int calculateFinalSalary(Employee employee, Set<Attendance> attendances) throws PayException {
        int deductions = calculateDeductions(employee.baseSalary);
        int absencePenalty = calculateAbsencePenalty(employee.id, attendances);
        int finalSalary = employee.baseSalary - deductions - absencePenalty;

        // 예외 처리: 최종 급여가 음수인 경우 예외 발생
        if (finalSalary < 0) {
            throw new PayException(
                PayErrorCode.NEGATIVE_SALARY,
                "직원 ID: " + employee.id + ", 계산된 급여: " + finalSalary + "원"
            );
        }

        return finalSalary;
    }
}
