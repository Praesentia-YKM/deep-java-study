package homework.week1.kwonmo;

import java.util.ArrayList;

public class BankDataManagerArrayList<T extends BankVO> extends BankDataManager<T> {
    public BankDataManagerArrayList() {
        super(new ArrayList<>());
    }
    //

}