package generic.bank;

import java.util.ArrayList;

public class BankDataManagerArrayList<T> extends BankDataManager<T> {
    public BankDataManagerArrayList() {
        this.dataList = new ArrayList<>();
    }
}