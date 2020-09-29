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

        setOddEvenTester(number -> number%2==1);
        setPrimeTester(number -> {
            PrimeNumbers primes = new PrimeNumbers(number);
            return primes.isPrime(number);
        });
        setPalindromeTester(number -> {
            String numberString = ""+number;
            StringBuilder invertedNumberString = new StringBuilder();
            for(int i = numberString.length()-1; i>=0; i--){
                invertedNumberString.append(numberString.charAt(i));
            }
            int invertedNumber = Integer.parseInt(invertedNumberString.toString());

            return number==invertedNumber;
        });
    }

    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester){
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = palindromeTester;
    }

    public void testFile(){
        int numberOfOperations = 0;

        String[] lines = fileContent.split("\n");
        try{
            numberOfOperations = Integer.parseInt(lines[0]);
        }catch (NumberFormatException ex){
            System.out.println("Invalid content of file!");
            System.exit(0);
        }

        int line = 1;
        while (line<=numberOfOperations){
            try{
                String[] args = lines[line].split(" ");
                if(args.length==2) {
                    int operation = Integer.parseInt(args[0]);
                    int number = Integer.parseInt(args[1]);
                    operate(operation,number);
                }else{
                    System.out.println("line "+line+": Invalid number of arguments!");
                }
            }catch (NumberFormatException ex){
                System.out.println("line "+line+": Invalid arguments!");
            }
            line++;
        }
    }

    public void operate(int operation, int number){
        switch (operation){
            case 1:
                if(oddTester.testNumber(number)){
                    System.out.println("ODD");
                }else{
                    System.out.println("EVEN");
                }
                break;
            case 2:
                if(primeTester.testNumber(number)){
                    System.out.println("PRIME");
                }else{
                    System.out.println("NOT PRIME");
                }
                break;
            case 3:
                if(palindromeTester.testNumber(number)){
                    System.out.println("PALINDROME");
                }else{
                    System.out.println("NO PALINDROME");
                }
                break;
            default:
                break;
        }
    }
}
