// SQL을 실행할 때 파라미터 값 넘기기
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test07_2 {

  public static void main(String[] args) throws Exception {
    
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
 
    HashMap<String,Object> params = new HashMap<>();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("정렬할 컬럼? ");
    String column = keyboard.nextLine();
    
    if(column.length() > 0) {
      switch (column) {
        case "title": //params.put("column", "title");
        case "contents": //params.put("column", "contents");
        case "created_date": //params.put("column", "created_date");
        case "view_count": 
          params.put("column", column);
        default:
          params.put("column", "board_id");
      }
      
      System.out.print("정렬 방식? ");
      String sort = "asc";
      if (keyboard.nextLine().equalsIgnoreCase("desc")) {
        sort = "desc";
      }
      params.put("sort", sort); 
    }
    
    keyboard.close();
    
    
    
    List<Board> boards = sqlSession.selectList("board.select7_ok", params);
    
    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");
    
  }

}






