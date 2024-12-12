package homework.week2.hyewon;

import java.time.LocalDate;
import java.util.Objects;

public class Attendance {
    int employeeId; // 직원 Id
    LocalDate date; // 근태 기록 날짜
    boolean isAbsent; // 결근 여부 (true : 결근, false : 출근)

    public Attendance(int employeeId, LocalDate date, boolean isAbsent) {
        this.employeeId = employeeId;
        this.date = date;
        this.isAbsent = isAbsent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance att = (Attendance) o;
        return employeeId == att.employeeId && date.equals(att.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, date);
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "employeeId=" + employeeId +
                ", date=" + date +
                ", isAbsent=" + isAbsent +
                '}';
    }
}
