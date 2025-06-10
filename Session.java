import java.util.Scanner;

public class Session {
    private Scanner scanner;

    public Session(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runSession(Unit unit, StudyMethod method) {
        System.out.println("\nStarting study session for: " + unit.getName());
        pauseOrExit("Press Enter to start...");

        // Flashcards
        Flashcard[] flashcards = method.getFlashcards();
        if (flashcards != null) {
            for (Flashcard card : flashcards) {
                System.out.println("Q: " + card.getQuestion());
                pauseOrExit("Press Enter to see answer...");
                System.out.println("A: " + card.getAnswer());
                pauseOrExit("");
            }
        }

        // Quizzes
        Quiz[] quizzes = method.getQuizzes();
        if (quizzes != null) {
            for (Quiz quiz : quizzes) {
                System.out.println(quiz.getQuestion());
                String[] options = quiz.getOptions();
                for (int i = 0; i < options.length; i++) {
                    System.out.println((char)('A' + i) + ". " + options[i]);
                }
                String ans = promptAnswer(options.length);
                if (options[ans.charAt(0) - 'A'].equals(quiz.getCorrectAnswer())) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. Correct answer: " + quiz.getCorrectAnswer());
                }
                pauseOrExit("");
            }
        }

        // Matching Activity
        MatchingActivity match = method.getMatchingActivity();
        if (match != null) {
            System.out.println("Match these terms:");
            String[] terms = match.getTerms();
            String[] defs = match.getDefinitions();
            for (String t : terms) System.out.println("- " + t + " = ?");
            pauseOrExit("Press Enter to see answers...");
            for (int i = 0; i < terms.length; i++) {
                System.out.println(terms[i] + " = " + defs[i]);
            }
            pauseOrExit("");
        }

        // Concept Map
        ContentMap map = method.getConceptMap();
        if (map != null) {
            System.out.println("Concept Map:");
            for (String concept : map.getKeyConcepts()) {
                System.out.println("- " + concept);
            }
            pauseOrExit("");
        }

        // Error Analysis
        ErrorAnalysis errors = method.getErrorAnalysis();
        if (errors != null) {
            System.out.println("Common Mistakes:");
            for (String err : errors.getErrors()) {
                System.out.println("- " + err);
                pauseOrExit("");
            }
        }

        // Review Notes
        Review review = method.getReview();
        if (review != null) {
            System.out.println("Key Points:");
            for (String point : review.getReviewPoints()) {
                System.out.println("- " + point);
                pauseOrExit("");
            }
        }

        System.out.println("Study session complete. Returning to main menu.");
    }

    private String promptAnswer(int optionCount) {
        System.out.print("Your answer (A-" + (char)('A' + optionCount - 1) + ") or 'exit': ");
        String input = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) {
            System.out.println("Exiting program.");
            System.exit(0);
        }
        if (!input.matches("[A-" + (char)('A' + optionCount - 1) + "]")) {
            System.out.println("Invalid answer. Try again.");
            return promptAnswer(optionCount);
        }
        return input;
    }

    private void pauseOrExit(String prompt) {
        if (!prompt.isEmpty()) System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) {
            System.out.println("Exiting program.");
            System.exit(0);
        }
    }
}
