package collection.payment;

class Employee {
    int id; // 직원 ID
    String name; // 직원 이름
    String position; // 직급
    int baseSalary; // 기본 급여
    String accountNumber; // 계좌번호

    public Employee(int id, String name, String position, int baseSalary, String accountNumber) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", 이름: " + name + ", 직급: " +
                position + ", 기본 급여: " + baseSalary + "원, 계좌번호: " + accountNumber;
    }
}

