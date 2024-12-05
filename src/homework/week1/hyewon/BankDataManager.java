package homework.week1.hyewon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BankDataManager<T> {
    private List<T> dataList;

    //    // todo 1-1
    public BankDataManager(List<T> dataList) {
        this.dataList = new ArrayList<>(dataList); // 방어적 복사
    }

    // 방어적 복사본 반환
    public List<T> getAllData() {
        return new ArrayList<>(dataList);
    }

    /* 데이터 추가 */
    public void addData(T data) {
        dataList.add(data);
    }

    // getter setter 를 지양하자.
//    /* 모든 데이터를 반환 */
//    public List<T> getAllData() {
//        return dataList;
//        // todo 1-2 불변타입에 대한 이야기
////        return Collections.unmodifiableList(dataList);
//    }

    /* 가장 최근에 추가된 데이터를 반환 */
    // todo 2 외부에서 이 함수 호출 시, 데이터가 널이 될 수 있다는 사실을 인지하기 힘들다
//    public T getLatestData() {
//        if (dataList.isEmpty()) {
//            return null;
//        }
//        return dataList.get(dataList.size() - 1);
//    }

    public Optional<T> getLatestData() {
        if (dataList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(dataList.get(dataList.size() - 1));
    }

    /* 중간 데이터 삽입 */
    public void addDataAt(int index, T data) {
        if (index < 0 || index > dataList.size()) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        dataList.add(index, data);
    }

    /* 데이터 삭제 */
    //
    public void removeData(int index) {
        if (index < 0 || index >= dataList.size()) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        dataList.remove(index);
    }
}
