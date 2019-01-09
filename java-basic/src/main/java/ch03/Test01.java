// 변수 선언
package ch03;

public class Test01 {
  public static void main(String[] args) {
    // 1바이트 정수 값을 담을 메모리 준비
     byte b1; 
     byte b2;
     byte b3;
     
     b1 = -128; //리터럴 값이 비록 4바이트 크기이지만 메모리에 넣을 수 있다면 허락한다.
     b2 = 127;  // OK
  // b2 = 127L; // 단 8바이트 값은 담을 수 있더라도 허락하지 않는다. 컴파일 오류.
  // b3 = 128;  // 128은 1바이트 메모리에 담을 수 없기 때문에 오류 발생.
     

    // 2바이트 정수 값을 담을 메모리 준비
     short s1;
     short s2;
     short s;
     
     s1 = -32768; // OK
     s2 = 32767;  // OK
  // s3 = 300L;  // 컴파일 오류
  // s3 = 32768; // 컴파일 오류 
    
    // 4바이트 정수 값을 담을 메모리 준비
     int i1;
     int i2;
     int i3;
     
     i1 = -21000000; //OK
     i2 = 210000000; //OK
  // i2 = 210000000L;  //컴파일 오류
     i3 = 220000000;  //리터럴 표현 오류 4바이트를 초과하는 값을 표현했다
     
    // 8바이트 정수 값을 담을 메모리
     long l1;
     long l2;
     long l3;
     
      l1 = 9000000000000000000L;
   // l2 = 9900000000000000000L; //8바이트 리터럴 표현 오류
  
     
    // 논리 값을 담을 메모리 준비
     boolean bool1;
     boolean bool2;
     boolean bool3;
     bool1 = true;
     bool2 = false;
   //bool3 = 1;   //true, false 외의 다른 값은 저장할 수 없다.
     
    // 문자의 UTF-16 코드 값을 담을 메모리 준비
     char c1;
     char c2;
     char c3;
      c1 = 44032; // 4바이트 정수 리터럴이더라도 0~65536까지의 값이라면 
                      // char 메모리에 저장하는것을 허락한다
      c2 = 0xac00;
      c3 = '가';   // ''의 리턴 값은 2바이트(0~65535) 유니코드 정수 값이다.
      
      System.out.println(c1); //변수 자체가 char이기 때문에 (char) 안붙여도 된다.
      System.out.println(c2);
      System.out.println(c3);
  }
}
