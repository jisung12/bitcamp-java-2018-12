// Serialize - SerialVersionUID 스태틱 필드 사용하기
package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test3_1 {

  public static void main(String[] args) {
    try(ObjectOutputStream out = new ObjectOutputStream (
        new FileOutputStream("score3.data"))) {
      
      // 인스턴스 출력하기
      
     // Score3 클래스는 java.io.Serializable을 구현하였다.
      // serialVersionUID의 값은 100으로 설정하였다.
      // => Score3 클래스에 tel 필드와 getter/setter이 없는 상태에서 출력.
      out.writeObject(new Score3("홍길동", 100, 100, 100));
      
      System.out.println("출력 완료!");
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    
  }

}