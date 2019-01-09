// 메서드 - 가변 파라미터
package ch06;

public class Test06 {
  public static void main(String[] args) {
    // 가변 파라미터에 값 전달하기
    // => 0개 이상의 값을 전달한다.
    int result = plus(); // 아규먼트를 넘겨주지 않아도 된다. 0개 이상이기때문.
    System.out.println(result);
    
    result = plus(2);
    System.out.println(result);
    
    result = plus(2,3 );
    System.out.println(result);
    
    result = plus(2, 3, 4);
    System.out.println(result);
    
    // 가변 파라미텅딘 경우 값을 배열에 담아서 넘겨도 된다.
    
    // 파라미터에 넘겨 줄 값으로 배열을 바로 만든다.
    result = plus(new int[] {10, 20, 30});
    System.out.println(result);
    
   
    // 실행 순서
    // 1) int 배열 3개를 만든다.
     // 2) 중괄호 {}에 들어있는 값으로 각 배열 항목을 초기화시킨다.
     // 3) 배열의 주소를 파라미터의 값으로 놓는다. => plus(1237번지);
     // 주의! 배열 자체가 넘어가는 것이 아니라 배열의 주소가 넘어간다는 것이다.
    
    // result = plus({100, 200, 300});   컴파일 오류
    //배열 레퍼런스가 있을 때는 new int[] 생략 가능 하지만
    // 없는 경우에는 생략할 수 없다.
    int[] arr = {1, 2, 3, 4};
    result = plus(arr);
    System.out.println(result);
   
    
  }

 //같은 타입의 값을 0개 이상 받을 때 가변 파라미터를 사용하라!
  static int plus(int... value) {
    // value는 int[] 배열 주소를 갖고있는 레퍼런스이다.
    
    // 가변 파라미터는 배열 레퍼런스처럼 사용한다.
    int sum = 0; // <== 메서드 안에 선언된 변수를 "로컬 변수(local variable)"라 한다.
                   // <== 파라미터도 로컬 변수입니까? 예. 로컬 변수이다.
    for (int i = 0; i < value.length; i++) {
      sum += value[i];
    }
    return sum;
  }
}//class Test06
