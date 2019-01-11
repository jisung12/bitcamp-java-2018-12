package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class LessonHandler {
  
  
  
  public static void addLesson() {

    System.out.print("번호? ");
    Lesson.no[i] = Integer.parseInt(keyboard.nextLine());

    System.out.print("수업명? ");
    Lesson.title[i] = keyboard.nextLine();

    System.out.print("설명? ");
    Lesson.contents[i] = keyboard.nextLine();

    System.out.print("시작일? ");
    Lesson.startDate[i] = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일? ");
    Lesson.endDate[i] = Date.valueOf(keyboard.nextLine());

    System.out.print("총수업시간? ");
    Lesson.totalHours[i] = Integer.parseInt(keyboard.nextLine());

    System.out.print("일수업시간? ");
    Lesson.dayHours[i] = Integer.parseInt(keyboard.nextLine());

    i++;
    System.out.println("저장");
  }//addLesson

}//Lesson
