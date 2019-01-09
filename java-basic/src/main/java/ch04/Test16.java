// 비트 이동 연산자 : >>, >>>, <<
package ch04;

public class Test16 {
  public static void main(String[] args) {
    // << : 왼쪽으로 비트를 이동시킨다. 
    // 왼쪽 경계를 넘어가는 값은 버린다. 
    // 오른쪽 빈자리는 무조건 0으로 채운다.
    int a = 0xc9; // 201
    System.out.println(Integer.toHexString(a << 1)); //0xc = 12
    System.out.println(a << 1);
     // 00000000_00000000_00000000_11001001
    // 0|00000000_00000000_00000001_10010010 = 0x00_00_01_92
    
    System.out.println(Integer.toHexString(a << 2)); //0x19 = 25
    System.out.println(a << 2);
     // 00000000_00000000_00000000_11001001
   
    
    System.out.println(Integer.toHexString(a >> 2)); //0x32 = 50
    System.out.println(a >>> 2); 
    
    System.out.println(Integer.toHexString(a >> 1)); //0x65 = 101
    System.out.println(a >>> 1);
    
    // 오른쪽 비트 이동의 효과
    // => 1비트 이동할때마다 2로 나누는 효과.
    // 예) n에 대해 x비트를 오른쪽으로 이동 = n / 2**x
    // 나누기 연산을 수행하는 것 보다 계산 속도가 빠르다
    
    // 음수 값을 오른쪽으로 비트 이동할 때 왼쪽 빈자리가 0으로 채워지므로 거대한 큰 양수 값으로 바뀐다.
    // => 2**n으로 나눈 것과 같다.
    // => 소수점 이하를 반올림 한 결과가 나온다.
    // => 왼쪽 빈자리가 부호비트로 채워진다.
    
    // 음수를 왼쪽으로 이동할 때는 부호비트에 상관없이 무조건 이동.
    a = -0x7f_ff_ff_fa; 
    System.out.println(a);
    System.out.println(a << 1); //          
    System.out.println(a << 2); // 
    System.out.println(a << 3); // 
    System.out.println(a << 4); // 
    
    // 결론
    // 왼쪽으로 x 만큼 비트를 이동시키는 것은 주어진 양수에 대해 2**x로 곱한 것과 같다.
    // 주의!
    // 음수의 경우는 양수로 바뀔 수 있다.
  }
}