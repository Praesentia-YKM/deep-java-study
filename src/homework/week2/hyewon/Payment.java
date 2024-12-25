package homework.week2.hyewon;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Set<String> set = Set.of("A", "B", "C");
 * // set.add("D"); // UnsupportedOperationException
 *
 * Set<String> originalSet = new HashSet<>();
 * originalSet.add("A");
 * Set<String> unmodifiableSet = Collections.unmodifiableSet(originalSet);
 *
 * // 원본 set 수정 가능
 * originalSet.add("B");
 *
 * // unmodifiableSet은 여전히 불변이므로 수정 불가
 * // unmodifiableSet.add("C"); // UnsupportedOperationException
 *
 *
 * 즉, 원본 Set은 여전히 변경 가능하지만(이래서 이거에 대한 접근은 private으로 막고 getter는 만들지 않았음),
 *  unmodifiableSet을 통해 반환된 Set은 수정할 수 없게 됨!!
 */
public class Payment {
    // TODO final -> 급여를 줘야하는 직원은 fianl 불변성처리
    private final Set<Integer> processedEmployees = new HashSet<>();

//    // TODO 불변성 보장
//    public Set<Integer> getProcessedEmployees() {
//       // Set<Set<Integer>> aa = Set.of(processedEmployees);
//        Collections.unmodifiableSet(processedEmployees);
//        processedEmployees.remove(1);
//        return processedEmployees;
//    }

    // TODO 불변성 보장
    public Set<Set<Integer>> getProcessedEmployees() {
        Set<Set<Integer>> aa = Set.of(processedEmployees);
        processedEmployees.remove(1);
        return aa;
    }

    public void processPayment(Employee employee, int finalSalary) {
        if (hasProcessed(employee.id)) {
            System.out.println("이미 급여가 입금되었습니다: " + employee.name);
            return;
        }
        // 급여 전송
        System.out.println("급여 전송: " + employee.name + " - " + finalSalary + "원 입금 (" + employee.accountNumber + ")");
        processedEmployees.add(employee.id);
    }

    public boolean hasProcessed(int employeeId) {
        return processedEmployees.contains(employeeId);
    }
}
