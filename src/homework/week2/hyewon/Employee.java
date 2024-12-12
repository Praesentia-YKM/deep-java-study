package homework.week2.hyewon;

import java.util.Objects;

public class Employee {
    // TODO 캡슐화를 위한 private 처리 -> 없으면 Default(package private)
    int id; // 직원 Id
    String name;  // 직원 이름
    String position; // 직급
    int baseSalary; // 기본 급여
    String accountNumber; // 계좌 번호

    public Employee(int id, String name, String position, int baseSalary, String accountNumber) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id; // ID만 비교하여 동일 여부 판단
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // ID 기반으로 해시코드 생성
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", baseSalary=" + baseSalary +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
//        return String.format("Employee{id=%d, name='%s', position='%s', baseSalary=%.2f, accountNumber='%s'}",
//                              id, name, position, baseSalary, accountNumber);
    }
}
