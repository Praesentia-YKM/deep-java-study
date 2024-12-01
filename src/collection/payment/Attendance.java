package collection.payment;

import java.time.LocalDate;

public class Attendance {
    int employeeId; // 직원 ID
    LocalDate date; // 근태 기록 날짜
    boolean isAbsent; // 결근 여부 (true: 결근, false: 출근)

    public Attendance(int employeeId, LocalDate date, boolean isAbsent) {
        this.employeeId = employeeId;
        this.date = date;
        this.isAbsent = isAbsent;
    }
}
