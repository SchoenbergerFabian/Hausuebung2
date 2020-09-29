import java.io.*;
import java.util.Scanner;

public class NumberTester {

    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    private String fileContent;

    public NumberTester(String fileName){
        try{
            InputStream is = new FileInputStream(fileName);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            fileContent = sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester){
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = primeTester;
    }

    public void testFile(){

    }
}
