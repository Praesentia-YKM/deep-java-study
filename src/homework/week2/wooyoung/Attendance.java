package homework.week2.wooyoung;

import java.util.Date;

public class Attendance {
    protected String empId;
    protected Date absentDate;
    protected String absentYn;

   	public Attendance(String empId, Date absentDate, String absentYn) {
   		this.empId = empId;
   		this.absentDate = absentDate;
   		this.absentYn = absentYn;
   	}
}
