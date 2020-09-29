import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in,"Windows-1252");
        System.out.println("Enter file name:");
        String filename = scanner.nextLine();

        NumberTester numberTester = new NumberTester(filename);
        numberTester.testFile();
    }
}
