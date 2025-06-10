// Main.java
// Main driver for StatsCrammer; handles user input and displays study plan.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Unit[] units = UnitData.getAllUnits();

        System.out.println("Welcome to StatsCrammer - Your AP Stats study crammer!");
        System.out.println("Please select a unit to study:");
        for (int i = 0; i < units.length; i++) {
            System.out.println((i + 1) + ". " + units[i].getName());
        }

        int unitChoice = 0;
        // Prompt user to select valid unit number
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
        // Prompt user to enter positive study time in minutes
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

        // Get study materials for selected unit and time
        StudyMethod[] methods = StudyMethod.selectMethods(time, selectedUnit);

        System.out.println("\nStudy Plan for " + selectedUnit.getName() + " with " + time + " minutes:");

        // Display flashcards, quizzes, errors, and review notes
        for (StudyMethod method : methods) {
            if (method.getFlashcards() != null) {
                System.out.println("\nFlashcards:");
                for (Flashcard card : method.getFlashcards()) {
                    System.out.println("- Q: " + card.getQuestion());
                    System.out.println("  A: " + card.getAnswer());
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
                    System.out.println("  Correct answer: " + quiz.getCorrectAnswer());
                }
            }

            if (method.getErrorAnalysis() != null) {
                System.out.println("\nError Analysis Points:");
                for (String error : method.getErrorAnalysis().getErrors()) {
                    System.out.println("- " + error);
                }
            }

            if (method.getReview() != null) {
                System.out.println("\nReview Notes:");
                for (String note : method.getReview().getReviewPoints()) {
                    System.out.println("- " + note);
                }
            }
        }

        scanner.close();
    }
}


