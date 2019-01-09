package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
     int Length = 100;
     int i = 0;
     
     int num[] = new int[Length];
     String content[] = new String[Length];
    
    while(i < Length) { 
    System.out.print("번호? ");
    num[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("내용? ");
    content[i] = keyboard.nextLine();
    
    i++;
    
    System.out.println("계속입력하시겠습니까?(Y/N)");
    
    String str = keyboard.nextLine().toLowerCase();
    
    
    if(!str.equals("Y") && !str.equals("y")) {
      break;
    } else if(str.equals("Y")||str.equals("y")) {
      continue;
    }
    
    
    } //while
    
    
    keyboard.close();
    
   
    
    Date writeDate = new Date(System.currentTimeMillis());
    
    for(int k=0; k<i; k++) {
      System.out.printf("%d. ", num[k]);
      System.out.printf("%s, ", content[k]);
      System.out.printf("%s", writeDate );
      System.out.println();
       }
    
    
  }
}
