package homework.week2.wooyoung;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class payMain {
    public static void main(String[] args) {

        Set<Employee> employees = new HashSet<>();

        employees.add(new Employee("FAKER","페이커","미드",1000000,"111111111111"));
        employees.add(new Employee("ZEUS","제우스","탑",2000000,"222222222222"));
        employees.add(new Employee("GUMAYUSI","구마유시","원딜",3000000,"333333333333"));

        Set<Attendance> attendances = new HashSet<>();

        attendances.add(new Attendance("FAKER", Date.valueOf("2024-01-01"), "Y"));
        attendances.add(new Attendance("ZEUS", null, "N"));
        attendances.add(new Attendance("GUMAYUSI", Date.valueOf("2024-03-01"), "Y"));

        payment payment = new payment();

        for(Employee employee : employees) {
            try {
                int salary = Payroll.salaryCalculation(employee, attendances);
                payment.salaryPayment(employee.id,salary);
            }catch (IllegalArgumentException e) {
                System.out.println("오류 : " + e.getMessage());
            }
        }

        payment.salaryPayment("FAKER", 10);
    }
}
