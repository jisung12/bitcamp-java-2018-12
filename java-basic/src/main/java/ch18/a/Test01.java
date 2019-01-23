package ch18.a;

public class Test01 {

  public static void main(String[] args) {
    A tool;
    
    // A 규칙에 따라 만든 도구를 사용한다
    use(new ToolA());
    use(new ToolB());
    
    // A 규칙을 따르지 않은 객체를 파라미터에 넘길 수 없다.
    use(new String("Hello"));
    
  }
    
    static void use(A tool) {
      tool.m1();
    }

  


