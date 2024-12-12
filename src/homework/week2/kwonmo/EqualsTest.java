package homework.week2.kwonmo;

import com.sun.source.tree.NewClassTree;

/**
 * 동등성 : 두 객체의 "값"이 같냐 -> equals
 * 동일성 : 두 객체의 "참조"가 같냐 -> ==
 *
 * -> 마이바티스 if test문에 equals를 쓰는게 좋은 이유 but 마이바티스에서는 String 문자열 리터럴(string pool로만듬)
 * 따라서 문제는 없음
 *
 *
 */
public class EqualsTest {
    public static void main(String[] args) {
        String str1 = "좋은데?"; // x002
        String str2 = "좋은데?"; // x002

        String str3 = new String("좋은데?"); // x001 -> 좋은데?
        String str4 = new String("좋은데?"); // x999 -> 좋은데?

        System.out.println("Case 1:");
        System.out.println("str1 == str2: " + (str1 == str2)); // TRUE
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // TRUE

        System.out.println("\nCase 2:");
        System.out.println("str3 == str4: " + (str3 == str4)); // FALSE
        System.out.println("str3.equals(str4): " + str3.equals(str4)); // TRUE

        /**
         * Tree -> 이진트리
         * TreeSet 정렬을 유지 하는 이유는?
         * 이진트리 구조라서.
         * 이진탐색트리 -> 정렬을 기본
         *
         * 루트 -> 절반 씩 나누면서 너 나보다 큼? log(N)
         *
         * ===> 인덱스
         * SELECT * FROM EXP_CST; A : 1 2 3 4 5 6 7 8
         *
         * 1~8 이진탐색트리 => 정렬 -> 디스크 물리적으로 가지고 있음
         *
         * 이진탐색트리 -> 6   LOG(N)
         * -> 트리 노드  BETWEEN 범위 검색이 빨라지게한다. RED BLACK
         *
         * B+ TREE 범위검색
         * SELECT *
         * FROM TABLE
         * WHERE  A BETWWEN;
         *
         * 1. 많은 조회를 하는데 INDEX -> CREATE INDEX
         * 2. PLAN
         * 테이블 본질의 값 -> gogo, GoGo, GOgO
         *
         * SELECT *
         * FROM MY_PGM
         * WHERE UPPER(PGM_ID) = 'GOGO'; full scan
         *
         * SELECT FN_GET_DEPT_NM(DEPT_CD)
         * , A.DEPT_NM
         * . A.DEPT_NM
         * , FN_GET_DEPT_NM(DEPT_CD)
         * , FN_GET_DEPT_NM(DEPT_CD)
         * , FN_GET_DEPT_NM(DEPT_CD)
         * , FN_GET_DEPT_NM(DEPT_CD)
         * , FN_GET_DEPT_NM(DEPT_CD)
         * , FN_GET_DEPT_NM(DEPT_CD)
         * , FN_GET_DEPT_NM(DEPT_CD)
         * , FN_GET_DEPT_NM(DEPT_CD)
         * , CASE WHEN FN_GET_DEPT_NM
         * THEN  FN_GET_DEPT_NM
          * FROM MY_PGM
          * WHERE FN_GET_DEPT_NM(DEPT_CD) = 'GOGO';
         *  JOIN SYS_DEPT  A
         *     ON
         *
         *
         * EXPLAIN FULL-SCAN, INDEXING
         *
         *
         *
         * SELECT *
          * FROM MY_PGM A
          * WHERE DEPT_NM = (SELECT DEPT_NM
     *          * FROM SYS_DEPT
     *          * WHERE DEPT_CD =  A.DEPT_CD)
         *
         * FUNCTION FN_GET_DEPT_NM
         * SELECT DEPT_NM
         * FROM SYS_DEPT
         * WHERE 매개변수 = DEPT_CD
         *
         */
    }
}
