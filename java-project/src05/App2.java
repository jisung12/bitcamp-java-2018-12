package bitcamp.lms;

import java.util.Date;

public class App2 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    
    System.out.print("번호? ");
    int age = Integer.parseInt(keyboard.nextLine());
    System.out.print("이름? ");
    String name = keyboard.next();
    System.out.print("이메일? ");
    String email = keyboard.next();
    
    System.out.print("암호? ");
    int password = keyboard.nextInt();
    System.out.print("사진? ");
    String picture = keyboard.next();
    System.out.print("전화? ");
    String phone = keyboard.next();
    
    Date registeredDate = new Date(System.currentTimeMillis());
    
  
    
    keyboard.close();
    
    System.out.print("\n\n\n\n\n\n\n\n");
    System.out.printf("번호 : %d \n이름 : %s \n이메일 : %s\n", age, name, email);
    System.out.printf("암호 : %d \n사진 : %s전화 : %s\n", password, picture, phone);
    System.out.printf("가입일 : %s", registeredDate);  // 년-월-일 시:분:초를 출력. Ymd IMS
  }  
}