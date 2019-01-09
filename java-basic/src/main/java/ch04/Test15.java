// 비트 이동 연산자 : >>, >>>, <<
package ch04;

public class Test15 {
  public static void main(String[] args) {
    // >> : 오른쪽으로 비트를 이동시킨다. 
    // 경계를 넘어가는 값은 버린다. 
    // 왼쪽 빈자리는 부호비트로 채운다.
    int a = 0xca; // 202
    System.out.println(Integer.toHexString(a >> 4)); //0xc = 12
    System.out.println(a >>> 4);
    // 00000000_00000000_00000000_11001010
    //     0000_00000000_00000000_00001100|1010
    // 00000000_00000000_00000000_00001100 
    
    System.out.println(Integer.toHexString(a >> 3)); //0x19 = 25
    System.out.println(a >>> 3);
    
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
    a = -202; // 11111111_11111111_11111111_00110110 = 0xff_ff_ff_36
    System.out.println(a >>> 1); // = 
              // 01111111_11111111_11111111_10011011|0 => 넘어가는 값은 버린다.
              // 0x7f_ff_ff_9b = 
    System.out.println(a >>> 2); // 
    System.out.println(a >>> 3); // 
    System.out.println(a >>> 4); // 
    System.out.println(Integer.MAX_VALUE);
    
    
    
    
  }
}