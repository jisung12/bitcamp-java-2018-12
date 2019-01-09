package bitcamp.lms;

import java.sql.Date;

public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    System.out.print("번호? ");
    int age = Integer.parseInt(keyboard.nextLine()); //*
    
    System.out.print("수업명? ");
    String subName = keyboard.nextLine();
    
    System.out.print("수업내용? ");
    String subCon = keyboard.nextLine();
    
    System.out.print("시작일? ");
    Date startDate = Date.valueOf(keyboard.nextLine()); //*
    
    System.out.print("종료일? ");
    Date endDate =  Date.valueOf(keyboard.nextLine());
    
    System.out.print("총수업시간? ");
    int totalTime = keyboard.nextInt();
    
    System.out.print("일수업시간? ");
    int dateTime = keyboard.nextInt();
    
    keyboard.close();  // 사용 후 스캐너 객체의 자원을 해제
    //닫아야하면 close()라는 메서드를 가지고 있다.
    
  
    System.out.print("\n\n\n\n\n");
    System.out.printf("번호 : %d \n수업명 : %s \n수업내용 : %s \n", age, subName, subCon);
    System.out.printf("시작일 : %s \n종료일 : %s \n", startDate, endDate);
    System.out.printf("총수업시간 : %d \n일수업시간 : %d", totalTime, dateTime );
    
    
    
  
  }  
}