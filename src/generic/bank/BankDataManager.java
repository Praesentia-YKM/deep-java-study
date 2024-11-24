package generic.bank;

import java.util.List;

public abstract class BankDataManager<T> {
    protected List<T> dataList;

    public void addData(T data) {
        dataList.add(data);
    }

    public T getLatestData() {
        if (dataList.isEmpty()) {
            throw new IllegalStateException("데이터가 없습니다.");
        }
        return dataList.get(dataList.size() - 1);
    }

    public List<T> getAllData() {
        return dataList;
    }

    public void addDataAt(int index, T data) {
        dataList.add(index, data);
    }

    public void removeData(int index) {
        dataList.remove(index);
    }
}

