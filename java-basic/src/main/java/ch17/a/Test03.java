// 추상 메서드
package ch17.a;

abstract class B {
  public void m1() {
    System.out.println("Hello");
  }

class My2 extends A{

  @Override
  public void m2(String name) {
    // 이렇게 상속받은 추상 메서드를 구현하게 되면 
    // 해당 클래스는 일반 클래스가 될 수 있다.
    System.out.println("My2.m2() - " + name);
  } 

  public void m3() {
    System.out.println("Hello");
  }
  
}

}

public class Test03 {

  public static void main(String[] args) {
    // 추상 클래스는 절대로 인스턴스를 생성할 수 없다.
    // B obj = new B();  // 컴파일 오류!
    
    // 추상 클래스의 목적
    // => 추상 메서드가 있든 없든 상관없이 추상 클래스를 만들 수 있다.
    // => 서브 클래스에게 공통 필드나 메서드를 상속해주는 것이 목적이다.
    // => 여러 클래스를 같은 타입으로 묶기 위함이다.
    // => 상속에서 generalization을 통해 수퍼클래스를 정의하는 경우에 주로 추상 클래스를 만든다.
    
  }

 
  }


