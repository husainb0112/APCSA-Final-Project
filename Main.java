// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Unit[] units = UnitData.getAllUnits();

        System.out.println("Welcome to StatsCrammer - Your AP Stats study helper!");
        System.out.println("Please select a unit to study:");
        for (int i = 0; i < units.length; i++) {
            System.out.println((i + 1) + ". " + units[i].getName());
        }

        int unitChoice = 0;
        while (unitChoice < 1 || unitChoice > units.length) {
            System.out.print("Enter unit number (1-" + units.length + "): ");
            if (scanner.hasNextInt()) {
                unitChoice = scanner.nextInt();
            } else {
                scanner.next(); // discard invalid input
            }
        }

        Unit selectedUnit = units[unitChoice - 1];

        int time = -1;
        while (time < 0) {
            System.out.print("Enter how many minutes you have to study: ");
            if (scanner.hasNextInt()) {
                time = scanner.nextInt();
                if (time < 0) {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
                scanner.next();
            }
        }

        scanner.nextLine(); // Consume newline after numeric input

        StudyMethod[] methods = StudyMethod.selectMethods(time, selectedUnit);
        System.out.println("\nStudy Plan for " + selectedUnit.getName() + " with " + time + " minutes:");

        for (StudyMethod method : methods) {
            if (method.getFlashcards() != null) {
                System.out.println("\nFlashcards:");
                for (Flashcard card : method.getFlashcards()) {
                    System.out.println("- Q: " + card.getQuestion());
                    System.out.print("Press Enter to see the answer...");
                    scanner.nextLine();
                    System.out.println("  A: " + card.getAnswer());
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                }
            }

            if (method.getQuizzes() != null) {
                System.out.println("\nQuiz Questions:");
                for (Quiz quiz : method.getQuizzes()) {
                    System.out.println("- " + quiz.getQuestion());
                    String[] opts = quiz.getOptions();
                    for (int i = 0; i < opts.length; i++) {
                        System.out.println("   " + (char)('A' + i) + ". " + opts[i]);
                    }

                    String answer = "";
                    while (true) {
                        System.out.print("Your answer (letter): ");
                        answer = scanner.nextLine().trim().toUpperCase();
                        int index = answer.length() == 1 ? answer.charAt(0) - 'A' : -1;
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
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                }
            }

            if (method.getErrorAnalysis() != null) {
                System.out.println("\nError Analysis Points:");
                for (String error : method.getErrorAnalysis().getErrors()) {
                    System.out.println("- " + error);
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                }
            }

            if (method.getReview() != null) {
                System.out.println("\nReview Notes:");
                for (String note : method.getReview().getReviewPoints()) {
                    System.out.println("- " + note);
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                }
            }
        }

        System.out.println("\nStudy session complete. Good luck on your test!");
        scanner.close();
    }
}
