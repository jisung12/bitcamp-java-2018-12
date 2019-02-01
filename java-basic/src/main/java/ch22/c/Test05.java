// 정리
package ch22.c;


public class Test05 {

  public static void main(String[] args) {
    // IO Stream 클래스
    // 1) data sink stream class
    //   => 파일이나 메모리에서 직접 데이터를 읽고 쓰는 클래스
    //   => 파일 : 
    //         FileInputStream/FileOutputStream
    //         FileReader/FileWriter
    //  => 메모리 : 
    //         ByteArrayInputStream/ByteArrayOutputStream
    //         CharArrayReader/CharArrayWriter
    //         StringReader/StringWriter
    // => 프로세스 : 다른프로그램과 연결되어 데이터를 읽고 쓴다.
    //         PipedInputStream/PipedOutputStream
    //         PipedReader/PipedWriter
    
    // 2) data processing stream class
    //  => 데이터를 읽고 쓸 때 중간에서 가공하는 클래스
    //  => 데코레이터 역할을 수행한다.
   //  => FilterInputStream/FilterOutputStream의 서브 클래스이다.
   //  => FileterReader/FilterWriter의 서브 클래스이다.
   //  => data sink stream class를 제외한 모든 클래스
    //  => 예 :
   //     BufferedInputStream/BufferedOutputStream
   //     BufferedReader/BufferedWriter
   //     DataInputStream/DataOutputStream
   //     ObjectInputStream/ObjectOutputStream
    // 
    // 바이너리 스트림과 문자 스트림 클래스
    // 1) binary stream class
    //     => 바이트 단위로 데이터를 다루는 클래스이다.
   //     => InputStream/OutputStream의 서브 클래스이다.
    //     => 보통 클래스 이름 뒤에 InputStream/OutputStream 으로 끝난다
   //  2) character stream class
    //     => 문자 단위로 데이터를 다루는 클래스이다.
    //     => 데이터를 입출력 할 때 UTF-16을 다른 문자표의 코드 값으로 자동 변환해준다.
    //   => Reader/Writer의 서브 클래스이다.
    //     => 보통 클래스 이름 뒤에 Reader/Writer로 끝난다.
    
    
  }

}
