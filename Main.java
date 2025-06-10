// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Unit[] units = UnitData.getAllUnits();

        System.out.println("Welcome to StatsCrammer - Your AP Stats study helper!");

        while (true) {
            System.out.println("\nPlease select a unit to study (or type 'exit' to quit):");
            for (int i = 0; i < units.length; i++) {
                System.out.println((i + 1) + ". " + units[i].getName());
            }

            String input = "";
            int unitChoice = -1;

            // Prompt for unit
            while (unitChoice < 1 || unitChoice > units.length) {
                System.out.print("Enter unit number (1-" + units.length + "): ");
                input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Good Luck!");
                    scanner.close();
                    return;
                }

                try {
                    unitChoice = Integer.parseInt(input);
                    if (unitChoice < 1 || unitChoice > units.length) {
                        System.out.println("Invalid number. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number or 'exit'.");
                }
            }

            Unit selectedUnit = units[unitChoice - 1];

            // Prompt for study time
            int time = -1;
            while (time < 0) {
                System.out.print("Enter how many minutes you have to study (or type 'exit'): ");
                input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Good Luck!");
                    scanner.close();
                    return;
                }

                try {
                    time = Integer.parseInt(input);
                    if (time < 0) {
                        System.out.println("Please enter a positive number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number or 'exit'.");
                }
            }

            // Get study plan
            StudyMethod[] methods = StudyMethod.selectMethods(time, selectedUnit);
            System.out.println("\nStudy Plan for " + selectedUnit.getName() + " with " + time + " minutes:");

            for (StudyMethod method : methods) {
                // Flashcards
                if (method.getFlashcards() != null) {
                    System.out.println("\nFlashcards:");
                    for (Flashcard card : method.getFlashcards()) {
                        System.out.println("- Q: " + card.getQuestion());
                        if (waitForEnter(scanner)) return;
                        System.out.println("  A: " + card.getAnswer());
                        if (waitForEnter(scanner)) return;
                    }
                }

                // Quizzes
                if (method.getQuizzes() != null) {
                    System.out.println("\nQuiz Questions:");
                    for (Quiz quiz : method.getQuizzes()) {
                        System.out.println("- " + quiz.getQuestion());
                        String[] opts = quiz.getOptions();
                        for (int i = 0; i < opts.length; i++) {
                            System.out.println("   " + (char) ('A' + i) + ". " + opts[i]);
                        }

                        while (true) {
                            System.out.print("Your answer (letter) or type 'exit': ");
                            input = scanner.nextLine().trim();

                            if (input.equalsIgnoreCase("exit")) {
                                System.out.println("Good Luck!");
                                scanner.close();
                                return;
                            }

                            int index = input.length() == 1 ? input.toUpperCase().charAt(0) - 'A' : -1;
                            if (index >= 0 && index < opts.length) {
                                if (opts[index].equals(quiz.getCorrectAnswer())) {
                                    System.out.println("Correct!");
                                } else {
                                    System.out.println("Incorrect. Correct answer: " + quiz.getCorrectAnswer());
                                }
                                break;
                            } else {
                                System.out.println("Invalid option. Try again.");
                            }
                        }

                        if (waitForEnter(scanner)) return;
                    }
                }

                // Errors
                if (method.getErrorAnalysis() != null) {
                    System.out.println("\nError Analysis Points:");
                    for (String error : method.getErrorAnalysis().getErrors()) {
                        System.out.println("- " + error);
                        if (waitForEnter(scanner)) return;
                    }
                }

                // Review
                if (method.getReview() != null) {
                    System.out.println("\nReview Notes:");
                    for (String note : method.getReview().getReviewPoints()) {
                        System.out.println("- " + note);
                        if (waitForEnter(scanner)) return;
                    }
                }
            }

            System.out.println("\n✅ Study session complete! Returning to home menu...");
        }
    }

    // Helper method to pause until Enter or exit command
    public static boolean waitForEnter(Scanner scanner) {
        System.out.print("Press Enter to continue or type 'exit' to quit: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Good Luck!");
            scanner.close();
            return true;
        }
        return false;
    }
}
