package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static int i = 0;

  public static void main(String[] args) {

    while(i<Lesson.LENGTH) {
      System.out.print("명령> ");
      String cmd = keyboard.nextLine();
      if(cmd.equals("/lesson/add")) {    
        addLesson();
      } else if(cmd.equals("/lesson/list")){
        listLesson();
      } else if(cmd.equals("quit")) {
        System.out.println("종료");
        break;
      } else {
        System.out.println("잘못입력하셨습니다.");
      }
      System.out.println();

    }//while
    System.out.println();
    keyboard.close();
  }//main

  

  public static void listLesson() {
    for(int j=0; j<i; j++) {

      System.out.printf("번호? %d\n수업명? %s\n수업내용? %s\n기간: %s ~ %s\n총수업시간: %d시간\n일수업시간: %d시간\n",
          Lesson.no[j], Lesson.title[j], Lesson.contents[j],
          Lesson.startDate[j], Lesson.endDate[j], Lesson.totalHours[j], Lesson.dayHours[j]);
    } 
  }//listLesson
  
}//app
