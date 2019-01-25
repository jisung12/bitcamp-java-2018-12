// Object 클래스 - toString()을 오버라이딩 할 때
package ch15;

// 클래스를 정의할 때 수퍼 클래스를 지정하지 않으면
// 컴파일러는 자동으로 Object를 상속 받는다.


class My3 {
  String name;
  int age;
  
  // 개발을 하다보면 인스턴스의 현재 값을 간단히 확인하고 싶을 경우가 있다.
  // 그럴 경우 toString()을 오버라이딩 하라!

  
  @Override
  public String toString() {
    return "My3 [name=" + name + ", age=" + age + "]";
  }
  
  
}

public class Test03 {

  public static void main(String[] args) {
    My3 obj1 = new My3();
    obj1.name = "홍길동";
    obj1.age = 20;
    System.out.println(obj1.toString());
    
    // println()의 파라미터 값으로 문자열을 넘겨주지 않으면
    // println() 내부에서 파라미터로 넘어온 객체에 대해 toString
    // 그 리턴 값을 출력한다.
    // 따라서 그냥 객체(주소)를 넘겨줘도 된다.
    System.out.println(obj1);
    
  }

}