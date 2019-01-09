// 키보드로 입력한 값을 받기 3 - int 값 읽기
package ch03;

public class Test08 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in); 

    System.out.print("a? ");
    int a = keyboard.nextInt();
     // nextInt()는 한 개의 토큰을 읽을 떄까지 기다린다.
     // 한 개의 '토큰'을 읽으면 4바이트 정수 값으로 바꾼 다음에 리턴한다.
     // 토큰(token)이란?
     // 토큰이란 공백으로 구분되는 단어를 뜻한다.
     // 공백(whitespace)이란?
     // 공백은 스페이스, 탭, 줄바꿈 코드를 말한다.
     // 예) aaa    bbb cc ==> aaa, bbb, cc는 토큰
     // 중간에 여러 개의 공백이 들어가더라도 한 개의 공백으로 간주한다.
    
    System.out.print("b? ");
    int b = keyboard.nextInt();
  
    System.out.printf("%d * %d = %d\n", a, b, a*b);
  }
}
