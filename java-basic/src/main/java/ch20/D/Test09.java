// Hashtable에서 value 목록 꺼내기 -elements()
package ch20.D;

import java.util.Enumeration;
import java.util.Hashtable;

public class Test09 {
  public static void main(String[] args) {
    class Student{
      String name;
      int age;

      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }

    }//Student

    Hashtable<String, Student> map = new Hashtable<>();

    map.put("aaa", new Student("홍길동",20));
    map.put("bbb", new Student("임꺽정",30));
    
    Student s = new Student("안중근",25);
    map.put("ccc", s);
    map.put("ddd", s);
    
    

    // value 목록 꺼내기
    Enumeration<Student> values = map.elements();
    while (values.hasMoreElements()) {   // for문 사용 불가.
      System.out.println(values.nextElement());
    }


  }//main

}//Test01

/*
 # List vs Set vs Map
      항목                   List             Set               Map
 1) 중복 저장           |     가능       |      불가능       |   key 불가능, value 가능
 2) null 허용 여부     |     가능       |    가능(한개만)   |  HashMap(key, value 가능), 
                                                     Hashtable(key, value불가능)
 3) 중복 저장           |     가능       |      불가능       |   key 불가능, value 가능
 4) 중복 저장           |     가능       |      불가능       |   key 불가능, value 가능
   
 */
