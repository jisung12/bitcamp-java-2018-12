// 리터럴(literal) - 자바 언어로 표현한 값
package ch02;

public class Test03 {
  public static void main(String[] args) {
   //12,3456,7890 정수 값을 자릿수를 포함하여 표현
      //3자리마다 자릿수 표기
    System.out.println(1_234_567_890);
      //4자리마다 자릿수 표기
    System.out.println(12_3456_7890);
   
   //0b01100001 2진수 자릿수를 포함하여 표현
      //4비트마다 자릿수 표기
    System.out.println(0b0110_0001);
  }  
}

/*
# 리터럴
정수(integer)
  100 (10진수)
  0144 (8진수)
  0x64, 0X64 (16진수)
  0b01100100, 0B01100100 (2진수; binary)  
부동소수점(floating point)
  3.14
  31.4E-1
  314E-2
  0.314E1
  0.0314E2
논리
  true
  false
문자(결국 숫자로 표현한다)
  (char)0x41
  (char)65
  'A'
문자열
  "ABC"
  "가각간"
메모리 주소(레퍼런스; reference)
  자바에서는 임의의 메모리 주소를 표현할 방법이 없다.
  new 명령으로 메모리를 주소를 리턴 받아야 한다.

# 콘솔로 출력하는 명령어
  System.out.println(값);
 */















