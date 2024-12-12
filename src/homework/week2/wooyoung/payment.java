package homework.week2.wooyoung;

import java.util.HashSet;
import java.util.Set;

public class payment {
    private Set<String> paymentList = new HashSet<>();

   	protected String empId;
   	protected int salary;

   	public void salaryPayment(String empId, int salary) {
   		if(paymentList.contains(empId)) {
   			System.out.println("id : " + empId + "는 이미 지급이 되었습니다.");
   		}else {
   			paymentList.add(empId);
   			System.out.println("id : " + empId + "의 급여 " + salary + "원이 지급되었습니다.");
   		}
   	}
}
