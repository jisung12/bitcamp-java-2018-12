// 클래스 로딩과 클래스 필드의 생성, Method Area의 관계
package ch08;

class My2 {
  // 클래스 필드
  static String manager = "관리자";
  static String member = "회원";
  static String guest = "손님";
  
  // 인스턴스 필드
  String name;
  String userType;
  int age;
 
} 

public class Test02 {
  public static void main(String[] args) {
    System.out.println(My2.manager);
    System.out.println(My2.member);
    
    
    // 클래스 로딩 과정
    //      $ java Test02
    // 1) Test02.class를 "Method Area 영역"에 로딩한다.
    // 2) Test02의 main()메서드를 호출한다.
    // 3) main() 메서드에 선언된 로컬 변수를 "JVM 스택 메모리"에 생성한다.
    //      - args 변수를 스택영역에 생성
    // 4) main()의 코드를 실행한다.
    //      - My2.class를 "Method Area"에 로딩한다.
    //      - My2의 클래스 필드를 "Method Area"에 생성한다.
    //      - System.out.println(My2.manager);를 실행한다.
    //      - My2 클래스가 이미 로딩되었기 때문에 다시 로딩하지 않는다.
    //      - System.out.println(My2.member);를 실행한다
    // 5) new 명령에 따라 "힙 영역"에 인스턴스 필드를 생성한다.
    
    
  }//main

}//class 

/*
  1) Heap
  2) JVM Stack
  3) Method Area
 */
