import java.util.Scanner;

public class Setup {
    private Scanner scanner;

    public Setup(Scanner s) {
        scanner = s;
    }

    public Unit promptUnit(Unit[] units) {
        System.out.println("Welcome to StasCrammer: your last-minute AP Stats study guide! Select a unit or type 'exit':");
        for (int i = 0; i < units.length; i++) {
            System.out.println((i + 1) + ". " + units[i]);
        }
        String input = getUserInput("[1-9]|exit");
        if ("exit".equalsIgnoreCase(input)) return null;
        return units[Integer.parseInt(input) - 1];
    }

    public Integer promptTime() {
        System.out.println("Enter your study time in minutes or type 'exit':");
        String input = getUserInput("\\d+|exit");
        if ("exit".equalsIgnoreCase(input)) return null;
        return Integer.parseInt(input);
    }

    public String getUserInput(String validInput) {
        System.out.print("> ");
        String input = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) return "exit";
        if (!input.matches(validInput)) {
            System.out.println("Invalid input, please try again.");
            return getUserInput(validInput);
        }
        return input;
    }
}
