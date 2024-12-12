package homework.week2.wooyoung;

import java.util.Date;

public class Attendance {
    private String empId;
    private Date absentDate;
    private String absentYn;

   	public Attendance(String empId, Date absentDate, String absentYn) {
   		this.empId = empId;
   		this.absentDate = absentDate;
   		this.absentYn = absentYn;
   	}

}
