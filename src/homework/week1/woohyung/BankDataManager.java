package homework.week1.woohyung;

import java.util.List;

public class BankDataManager <T> {
    protected List<T> dataList;
    //	void addData(T data): 데이터를 추가합니다.
    //	List<T> getAllData(): 모든 데이터를 반환합니다.
    //	T getLatestData(): 가장 최근에 추가된 데이터를 반환합니다.
    //	addDataAt() : 중간 데이터 삽입
    //	removeData : 삭제

    public BankDataManager(List<T> dataList) {
        this.dataList = dataList;
    }

    public void addData(T data) {
        dataList.add(data);
    }

    public List<T> getAllData() {
        return dataList;
    }

    public T getLatestData() {
        return dataList.get(dataList.size() - 1);
    }

    public void addDataAt(int index, T data) {
        dataList.add(index,data);
    }

    public void removeData(int index) {
        dataList.remove(index);
    }
}
