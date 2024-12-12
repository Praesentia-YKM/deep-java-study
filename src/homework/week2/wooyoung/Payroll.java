package homework.week2.wooyoung;

import java.util.Set;

public class Payroll {
    public static int insuranceCalculation(int salary) {

        double nationalPension = salary * 0.045;
        double healthInsurance = salary * 0.032;
        double employmentInsurance = salary * 0.008;
        double industrialAccidentInsurance = salary * 0.007;

        return (int) (nationalPension + healthInsurance + employmentInsurance +industrialAccidentInsurance);
    }

    public static int absentCalculation(String empId, Set<Attendance> attendanceList) {

        int absentPay = 0;

        for(Attendance attendance : attendanceList) {
            if(empId.equals(attendance.empId) && "Y".equals(attendance.absentYn)) {
                absentPay += 100000;
            }
        }

        return absentPay;
    }

    public static int salaryCalculation(Employee employee, Set<Attendance> attendanceList) {

        int fourMajorInsurancePay = insuranceCalculation(employee.salary);
        int absentPay = absentCalculation(employee.id, attendanceList);
        int salary = employee.salary - fourMajorInsurancePay - absentPay;

        if(salary < 0 ) {
            throw new IllegalArgumentException(
                     "계산된 급여가 음수입니다. 직원 ID: " + employee.id + ", 최종 급여: " + salary
            );
        }

        return salary;
    }
}
