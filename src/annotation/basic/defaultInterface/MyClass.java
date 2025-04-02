package annotation.basic.defaultInterface;

public class MyClass implements DefaultInterface {

    @Override
    public String overridingMethod() {
        return "끼얏호";
    }

    // 오버라이딩 안 해도 됨
//    @Override
//    public void print() {
//        DefaultInterface.super.print();
//    }

    // 이렇게 접근제어자 지정 안하면 package-private 내 패지지 내에서만 접근 가능
    // (default 접근제어자 라고 부름)
    void display() {
        System.out.println("Hello from MyClass");
    }
}
