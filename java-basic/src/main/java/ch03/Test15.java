// 변수와 블록
package ch03;

public class Test15 {
  public static void main(String[] args) {
    //변수는 선언된 블록에서만 유효하다.
    //블록을 벗어나면 제거된다.
    int a = 100;
    { 
      //블록 밖에 있는 변수와 이름이 같은 변수를 만들 수 없다.
      //int a = 200; //컴파일 오류
      
      //블록 밖에 있는 변수를 사용할 수 있다.
      System.out.println(" => " + a);
      //블록 안에 선언된 변수는 블록을 나가면 삭제된다.
      int b = 200;
      System.out.println(b);
    }
    System.out.println(a);
      
      //블록 실행을 마친 후에는 블록 안에서 만든 변수를 사용 할 수 없다.
      //삭제 되었기 때문.
     // System.out.println(b);    //컴파일 오류!
    
    }      
  }
  
