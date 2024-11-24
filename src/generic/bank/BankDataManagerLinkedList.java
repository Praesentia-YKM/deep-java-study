package generic.bank;

import java.util.LinkedList;

public class BankDataManagerLinkedList<T> extends BankDataManager<T> {
    public BankDataManagerLinkedList() {
        this.dataList = new LinkedList<>();
    }
}
