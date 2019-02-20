// PreparedStatement을 이용하여 SQL 삽입 공격 차단하기
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {

  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      System.out.print("번호? ");
      String no = keyboard.nextLine();
      
      System.out.print("제목? ");
      String title = keyboard.nextLine();
      
      System.out.print("내용? ");
      String contents = keyboard.nextLine();
      
      // PreparedStatement는 미리 SQL 문장을 준비하여 값을 삽입하는 기법이다.
      try (PreparedStatement stmt = con.prepareStatement(
          "update x_board set title=?, contents=? where board_id=?")) {
        // SQL 문장을 준비할 때, 값이 들어 갈 자리에 ?로 표시한다.
        // ? 를 "in-parameter"라 부른다.
        // 
        // SQL을 서버에 전달하기 전에 in-parameter 자리에 값을 넣는다.
        // => PreparedStatement.setXxx(in-parameter 인덱스, 값)
        //     -setXxx : 컬럼의 타입에 따라 setInt(), setString(), setDate() 등
        //                   숫자 값을 삽입할 때 setString()을 사용할 수 있다.
        //     -in-parameter 인덱스 : ? 문자가 등장하는 순서대로 1부터 번호를 부여한다.
        //       - 값 : SQL 문장에 삽입될 값이다. 실제 SQL 문장과 별도로 서버에 전달되기 때문에
        //              문자열 값 중간에 '(작은 따옴표)가 포함되더라도 SQL 문에 영향을 끼치지 않는다.
        // => in-parameter 값을 설정할 때 순서대로 할 필요는 없다.
        
        stmt.setString(1, title);
        stmt.setString(2, contents);
        stmt.setString(3, no);
        stmt.executeUpdate();
        
        // SQL 삽입 공격
        // => 입력 문자열에 SQL 명령을 삽입하여 프로그램의 의도와 다르게 데이터를 조작하는 행위.
        // => 사용자가 입력한 값을 가지고 SQL 문장을 만들 때 이런 문제가 발생한다.
        // => 예를 들어 이 예제를 실행할 때 다음과 같이 입력해 보라!
        // 번호? 1
        // 제목? okok
        // 내용? test', view_count = 300, created_date = '2019-3-3
        
//        stmt.executeUpdate("update x_board set title = '"+title+"' where board_id="+no);
//        stmt.executeUpdate("update x_board set contents = '"+contents+"' where board_id="+no);
        System.out.println("입력 완료");
        // 위에서 사용자가 입력한 값을 가지고 SQL 문장을 만들면 다음과 같다.
        // update x_board set title = 'okok', 
        // contents = 'test', view_count = 300, created_date = '2019-3-3' 
        // where board_id = 1
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

// Statement vs PreparedStatment
// 1) SQL 문장의 간결함
//    Statement : 값을 가지고 문자열로 직접 SQL문을 만들기 때문에 작성하거나 읽기 힘들다.
//    PreparedStatement : SQL 문장과 값이 분리되어 있기 때문에 작성하거나 읽기 쉽다.
// 2) SQL 삽입 공격
//    Statement : 사용자가 입력한 값을 가지고 SQL 문장을 만들기 때문에 해킹되기 쉽다.
//    PreparedStatement : SQL 문장과 값이 분리되어 다뤄지기 때문에 해킹할 수 없다.
// 3) 바이너리 데이터 다루기
//    Statement : 문자열로 SQL 문장을 만들기 때문에 바이트 배열의 값을 다룰 수 없다.
//    PreparedStatement : setXxx() 메서드를 호출하여 값을 설정하기 때문에
//                            바이트 배열의 값을 다룰 수 있다.
// 4) 실행 속도
//    Statement : executeUpdate()를 실행할 때 마다 SQL문을 전달하기 때문에
//                   서버로 보내기 전에 매번 SQL 문법을 검사해야 한다.
//                   반복 실행하는 경우 SQL문법도 반복하므로 실행속도가 느리다.
//    PreparedStatement : 미리 SQL문을 작성한 다음에 값을 넣은 후 executeUpdate()를
//                            호출한다. 따라서 executeUpdate()를 호출할 때 마다 SQL 문법을
//                            분석하지 않으므로 반복 실행 시 실행속도가 빠르다..




