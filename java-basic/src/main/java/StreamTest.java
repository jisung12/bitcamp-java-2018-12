import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamTest {

  public static void main(String[] args) {
    FileInputStream fis = null;
    byte[] read = new byte[100];
    byte[] console = new byte[100];
    
    try {
      System.out.println("파일명 : ");
      System.in.read(console);
      String file = new String(console).trim();
      fis = new FileInputStream(file);
      fis.read(read, 0, read.length);
      System.out.println(new String(read).trim());
    }catch(FileNotFoundException e) {
      e.printStackTrace();
    }catch(IOException e1) {
      e1.printStackTrace();
    }finally {
      try {
        if(fis != null) fis.close();
      }catch(IOException e2) {
        e2.printStackTrace();
      }
      
    }
  }

}
