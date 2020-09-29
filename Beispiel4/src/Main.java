import java.util.Scanner;

public class Main {
    private static String menuCalculators = "Choose calculator:\n" +
            "1 - Relational calculator\n" +
            "2 - Vector calculator\n" +
            "3 - Complex calculator\n" +
            "4 - Exit program\n" +
            "> ";
    private static String menuOperations = "Choose operation:\n" +
            "1 - add\n" +
            "2 - subtract\n" +
            "3 - multiply\n" +
            "4 - divide\n" +
            "5 - enter numbers again\n" +
            "> ";

    private static AbstractCalculator calculator;
    private static Number x;
    private static Number y;

    public static void main(String[] args) {
        while(true){
            promptCalculators();
        }
    }

    private static void promptCalculators(){
        System.out.print(menuCalculators);
        int option = 0;
        try{
            option = intInput();
        }catch(NumberFormatException ex){
            System.out.println("Invalid Input!");
        }

        switch(option){
            case 1:
                calculator = new RelationalCalculator();
                enterNumbers();
                break;
            case 2:
                calculator = new VectorCalculator();
                enterNumbers();
                break;
            case 3:
                calculator = new ComplexCalculator();
                enterNumbers();
                break;
            case 4:
                System.exit(0);
            default:
                break;
        }
    }

    private static void enterNumbers(){
        enterNumber(x,"x");
        enterNumber(y,"y");
        promptOperations();
    }

    private static void enterNumber(Number number,String numberIdentifier){
        try{
            printEnterNumber(numberIdentifier+" a");
            number.setA(intInput());
            printEnterNumber(numberIdentifier+" b");
            number.setA(intInput());
        }catch(NumberFormatException ex){
            System.out.println("Invalid Input!");
            enterNumber(number, numberIdentifier);
        }
    }

    private static void printEnterNumber(String numberIdentifier){
        System.out.print("Enter number "+numberIdentifier+" > ");
    }

    private static void promptOperations(){
        System.out.print(menuOperations);
        int option = 0;
        try{
            option = intInput();
        }catch(NumberFormatException ex){
            System.out.println("Invalid Input!");
        }

        Number solution;
        switch(option){
            case 1:
                solution = calculator.add(x,y);
                printSolution(solution);
                break;
            case 2:
                solution = calculator.subtract(x,y);
                printSolution(solution);
                break;
            case 3:
                solution = calculator.multiply(x,y);
                printSolution(solution);
                break;
            case 4:
                solution = calculator.divide(x,y);
                printSolution(solution);
                break;
            case 5:
                enterNumbers();
                break;
            default:
                break;
        }
    }

    private static void printSolution(Number solution){
        System.out.println("-----------------\n" +
                "Solution:\n" +
                "a = "+solution.getA()+"\n" +
                "b = "+solution.getB()+"\n" +
                "-----------------");
    }

    private static int intInput() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in, "Windows-1252");
        return Integer.parseInt(scanner.nextLine());
    }
}