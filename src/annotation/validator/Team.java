package annotation.validator;

/**
 * Spring MVC에서 @RequestBody와 함께 사용되면 HTTP 요청이 컨트롤러에 도달하기 전에 유효성 검사를 한다.
 * Service나 Controller 계층에서 **@Valid**를 사용하여 엔티티나 DTO를 검증할 수 있다.
 */
public class Team {

    @NotEmpty(message = "이름이 비었습니다.")
    private String name;

    @Range(min = 1, max = 999, message = "회원 수는 1과 999 사이여야 합니다.")
    private int memberCount;

    public Team(String name, int memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public int getMemberCount() {
        return memberCount;
    }
}
