package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;;

public class App {
 
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    int Length = 100;
    int i = 0;
    
    int[] number = new int[Length];
    String[] subName = new String[Length];
    String[] subCon = new String[Length];
    Date[] startDate = new Date[Length];
    Date[] endDate = new Date[Length];
    int[] totalTime = new int[Length];
    int[] dateTime = new int[Length];
   
    
    
    while(i < Length) {
    System.out.print("번호? ");
    number[i] = Integer.parseInt(keyboard.nextLine()); 
    
    System.out.print("수업명? ");
    subName[i] = keyboard.nextLine();
    
    System.out.print("수업내용? ");
    subCon[i] = keyboard.nextLine();
    
    System.out.print("시작일? ");
    startDate[i] = Date.valueOf(keyboard.nextLine()); 
    
    System.out.print("종료일? ");
    endDate[i] =  Date.valueOf(keyboard.nextLine());
    
    System.out.print("총수업시간? ");
    totalTime[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("일수업시간? ");
    dateTime[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.println();
    
    i++;
    
    System.out.print("계속입력하시겠습니까? (Y/N)");
    
    String str = keyboard.nextLine().toLowerCase();
   
    System.out.println();
    
    if(!str.equals("y") && !str.equals("Y")) {
      break;
    } else if (str.equals("y") || str.equals("Y")){
      continue;
    }
  
    }
    
    
    keyboard.close();  // 사용 후 스캐너 객체의 자원을 해제
    //닫아야하면 close()라는 메서드를 가지고 있다.
    
    for(int k=0; k<i; k++) {
      System.out.printf("%d. ", number[k]);
      System.out.printf("%s, ", subName[k]);
      System.out.printf("%s, ", subCon[k]);
      System.out.printf("%s, ", startDate[k]);
      System.out.printf("%s, ", endDate[k]);
      System.out.printf("%d, ", totalTime[k]);
      System.out.printf("%d \n\n", dateTime[k]);
      System.out.println();
    }
    
    
  
    
  
  }  
}