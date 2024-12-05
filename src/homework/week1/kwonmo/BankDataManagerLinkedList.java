package homework.week1.kwonmo;

import java.util.LinkedList;

public class BankDataManagerLinkedList<T extends BankVO> extends BankDataManager<T> {
    public BankDataManagerLinkedList() {
        super(new LinkedList<>());
    }
    // linked
}