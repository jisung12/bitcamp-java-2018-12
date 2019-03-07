// SQL을 실행할 때 파라미터 값 넘기기
package ch26.f;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test09 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();


    ArrayList<Integer> noList = new ArrayList<>();

    Scanner keyboard = new Scanner(System.in);

    while(true) {
      try {
        System.out.print("조회할 게시물 번호? ");
        String value = keyboard.nextLine();
        if(value.length() == 0) {
          break;
        }
        noList.add(Integer.valueOf(value));
      } catch (Exception e) {
        break;
      }
    }

    //    System.out.print("정렬 방식? ");
    //    String sort = keyboard.nextLine();
    //    if(sort.length() > 0) {
    //      params.put("sort", sort);
    //    }

    keyboard.close();


    HashMap<String, Object> params = new HashMap<>();
    params.put("noList", noList);
    
    List<Board> boards = sqlSession.selectList("board.select9", params);

    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

  }

}






