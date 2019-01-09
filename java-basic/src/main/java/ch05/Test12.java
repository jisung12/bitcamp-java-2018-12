//흐름제어문 - for 반복문
package ch05;

public class Test12 {

  public static void main(String[] args) {
    for(int i = 1; i <= 10; i++) {
      System.out.print(i + " ");


      //실행순서
      // 1) 변수 초기화 => int i = 1;
      // 2) 조건 => i <= 10
      // 3) 문장 => System.out.print(i + " ");
      // 4) 변수증가문 => i++
      // 조건이 참인 동안 2 ~ 4를 반복한다.
    }
    System.out.println();
    //for문 안에 선언된 i 변수는 for블럭을 나가면 삭제된다. 
    //그래서 다음 문장에서 i 변수를 선언 할 수있는 것이다.
    int i = 1;
    for(; i <= 10; i++) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

}

