package homework.week1.woohyung;

import java.util.ArrayList;
import java.util.LinkedList;

public class BankDataManagetMain {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //ArrayList
        BankDataManager<KaKaoVo> kakaoArrayListData = new BankDataManager<>(new ArrayList<>());

        //데이터 추가
        kakaoArrayListData.addData(new KaKaoVo("홍길동", "111-111-111", 10));
        kakaoArrayListData.addData(new KaKaoVo("가나다", "222-222-222", 20));
        kakaoArrayListData.addData(new KaKaoVo("일이삼", "333-333-333", 30));

        System.out.println(kakaoArrayListData.getAllData());

        //마지막 데이터
        System.out.println(kakaoArrayListData.getLatestData());

        //중간데이터 삽임
        kakaoArrayListData.addDataAt(1, new KaKaoVo("이삼사", "444-444-444", 40));
        System.out.println(kakaoArrayListData.getAllData());

        //삭제
        kakaoArrayListData.removeData(1);
        System.out.println(kakaoArrayListData.getAllData());

        //LinkedList
        BankDataManager<KaKaoVo> kakaoLinkedListData = new BankDataManager<>(new LinkedList<>());

        //데이터 추가
        kakaoLinkedListData.addData(new KaKaoVo("홍길동", "111-111-111", 10));
        kakaoLinkedListData.addData(new KaKaoVo("가나다", "222-222-222", 20));
        kakaoLinkedListData.addData(new KaKaoVo("일이삼", "333-333-333", 30));

        System.out.println(kakaoLinkedListData.getAllData());

        //마지막 데이터
        System.out.println(kakaoLinkedListData.getLatestData());

        //중간데이터 삽임
        kakaoLinkedListData.addDataAt(1, new KaKaoVo("이삼사", "444-444-444", 40));
        System.out.println(kakaoLinkedListData.getAllData());

        //삭제
        kakaoLinkedListData.removeData(1);
        System.out.println(kakaoLinkedListData.getAllData());
    }
}
