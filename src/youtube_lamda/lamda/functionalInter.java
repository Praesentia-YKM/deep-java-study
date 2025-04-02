package youtube_lamda.lamda;
// 어노테이션 생략은 가능하지만 이걸 써놓으면 하나 초과의 추상메서드를 작성하면 컴파일 오류 뜸
@FunctionalInterface
public interface functionalInter {
    public abstract int max(int a, int b);
}
