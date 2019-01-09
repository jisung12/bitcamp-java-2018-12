package bitcamp.lms;

import java.util.Date;

public class App3 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
   
    
    System.out.print("번호? ");
    int age = keyboard.nextInt();
    System.out.print("내용? ");
    String name = keyboard.next();
    int view = 0;
    
    
    Date cratedDate = new Date(System.currentTimeMillis());
    
    keyboard.close();
    
    System.out.printf("번호 : %d \n내용 : %s \n", age, name);
    System.out.printf("작성일 : %s \n", cratedDate); // 년-월-일 시:분:초를 출력. Ymd IMS
    System.out.printf("조회수 : %d", view);
  }  
}