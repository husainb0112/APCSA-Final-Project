import java.util.Scanner;

public class Setup {
    private Scanner scanner;

    public Setup(Scanner scanner) {
        this.scanner = scanner;
    }

    public Unit promptUnit(Unit[] units) {
        System.out.println("Select a unit or type 'exit':");
        for (int i = 0; i < units.length; i++) {
            System.out.println((i + 1) + ". " + units[i].getName());
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

    private String getUserInput(String validPattern) {
        System.out.print("> ");
        String input = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) {
            return "exit";
        }
        if (!input.matches(validPattern)) {
            System.out.println("Invalid input, please try again.");
            return getUserInput(validPattern);
        }
        return input;
    }
}
