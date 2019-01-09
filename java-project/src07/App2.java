package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    int Length = 100;
    int i = 0;
    
    int num[] = new int[Length];
    String name[] = new String[Length];
    String email[] = new String[Length];
    String phone[] = new String[Length];
    
    
    
    while(i < Length) {
    System.out.print("번호? ");
    num[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("이름? ");
    name[i] = keyboard.nextLine();
    
    System.out.print("이메일? ");
    email[i] = keyboard.nextLine();
    
    System.out.print("전화? ");
    phone[i] = keyboard.nextLine();
    
    System.out.println();
    
    i++;
    
    System.out.println("계속입력하시겠습니까?(Y/N)");
    
    String str = keyboard.nextLine().toLowerCase();
    
    if(!str.equals("Y") && !str.equals("y")) {
      break;
    } else if(str.equals("Y") || str.equals("y")) {
      continue;
    }
    System.out.println();
   }
    
    keyboard.close();
    
    Date registeredDate = new Date(System.currentTimeMillis());
    
    for(int k=0; k<i; k++) {
      System.out.printf("%d. ", num[k]);
      System.out.printf("%s, ", name[k]);
      System.out.printf("%s, ", email[k]);
      System.out.printf("%s, ", phone[k]);
      System.out.printf("%s ", registeredDate);
      System.out.println();
    }
    
    
 
  }  
}