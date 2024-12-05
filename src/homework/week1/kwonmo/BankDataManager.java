package homework.week1.kwonmo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class BankDataManager<T extends BankVO> {
    protected List<T> dataList;

    public BankDataManager(List<T> dataList) {
        this.dataList = dataList;
    }

    public void addData(T data) {
        dataList.add(data);
    }

    public void addDataAt(int index, T data) {
        if (index < 0 || index > dataList.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        dataList.add(index, data);
    }

    public void removeData(int index) {
        if (index < 0 || index >= dataList.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        dataList.remove(index);
    }

    public List<T> getAllData() {
        return Collections.unmodifiableList(dataList); // 불변 리스트 반환
    }

    public Optional<T> getLatestData() {
        if (dataList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(dataList.get(dataList.size() - 1));
    }

    public Optional<T> searchById(String id) {
        return dataList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst();
    }
}

