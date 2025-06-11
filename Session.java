import java.util.Scanner;

public class Session {
    private Scanner scanner;
    private String prompt;

    public Session(Scanner s) {
         scanner = s;
         prompt = "Press Enter to continue";
    }

    public void runSession(Unit unit, StudyMethod method) {
        System.out.println("\nStarting study session for: " + unit);
        promptContinue("Press Enter to start");

        int total = countSteps(method);
        int step = 0;

        // Flashcards
        Flashcard[] flashcards = method.getFlashcards();
        if (flashcards != null) {
            for (int i = 0; i < flashcards.length; i++) {
                Flashcard card = flashcards[i];
                System.out.println("Q: " + card.getQuestion());
                promptContinue("Press Enter to see answer");
                System.out.println("A: " + card.getAnswer());
                promptContinue(prompt);
            }
            step++;
            printProgress(step, total);
        }

        // Quizzes
        Quiz[] quizzes = method.getQuizzes();
        if (quizzes != null) {
            for (int i = 0; i < quizzes.length; i++) {
                Quiz quiz = quizzes[i];
                System.out.println(quiz.getQuestion());
                String[] options = quiz.getOptions();
                for (int j = 0; j < options.length; j++) {
                    System.out.println((char)('A' + j) + ". " + options[j]);
                }
                String ans = promptAnswer(options.length);
                if (options[ans.charAt(0) - 'A'].equals(quiz.getCorrectAnswer())) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. Correct answer: " + quiz.getCorrectAnswer());
                }
                promptContinue(prompt);
            }
            step++;
            printProgress(step, total);
        }

        // Matching Activity
        MatchingActivity match = method.getMatchingActivity();
        if (match != null) {
            System.out.println("Match these terms:");
            String[] terms = match.getTerms();
            String[] defs = match.getDefinitions();
            for (int i = 0; i < terms.length; i++) {
                System.out.println("- " + terms[i] + " = ?");
            }
            promptContinue("Press Enter to see answers");
            for (int i = 0; i < terms.length; i++) {
                System.out.println(terms[i] + " = " + defs[i]);
            }
            promptContinue(prompt);
            step++;
            printProgress(step, total);
        }

        // Concept Map
        ContentMap map = method.getConceptMap();
        if (map != null) {
            System.out.println("Concept Map:");
            String[] concepts = map.getKeyConcepts();
            for (int i = 0; i < concepts.length; i++) {
                System.out.println("- " + concepts[i]);
            }
            promptContinue(prompt);
            step++;
            printProgress(step, total);
        }

        // Error Analysis
        ErrorAnalysis errors = method.getErrorAnalysis();
        if (errors != null) {
            System.out.println("Common Mistakes:");
            String[] errList = errors.getErrors();
            for (int i = 0; i < errList.length; i++) {
                System.out.println("- " + errList[i]);
                promptContinue(prompt);
            }
            step++;
            printProgress(step, total);
        }

        // Review Notes
        Review review = method.getReview();
        if (review != null) {
            System.out.println("Key Points:");
            String[] reviewPoints = review.getReviewPoints();
            for (int i = 0; i < reviewPoints.length; i++) {
                System.out.println("- " + reviewPoints[i]);
                promptContinue(prompt);
            }
            step++;
            printProgress(step, total);
        }

        System.out.println("Study session complete. Returning to main menu.");
    }

    public String promptAnswer(int optionCount) {
        System.out.println("Your answer (A-" + (char) ('A' + optionCount - 1) + ") or 'exit':");
        System.out.print("> ");
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

    public void promptContinue(String prompt) {
        if (!prompt.isEmpty()) {
            System.out.println(prompt);
            System.out.print("> ");
        }
        String input = scanner.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) {
            System.out.println("Exiting program.");
            System.exit(0);
        }
    }

    public int countSteps(StudyMethod m) {
        int count = 0;
        if (m.getFlashcards() != null) count++;
        if (m.getQuizzes() != null) count++;
        if (m.getMatchingActivity() != null) count++;
        if (m.getConceptMap() != null) count++;
        if (m.getErrorAnalysis() != null) count++;
        if (m.getReview() != null) count++;
        return count;
    }

    public void printProgress(int step, int total) {
        int width = 30;
        int completed = (step * width) / total;
        System.out.print("Progress: [");
        for (int i = 0; i < completed; i++) System.out.print("#");
        for (int i = completed; i < width; i++) System.out.print(" ");
        int percent = (step * 100) / total;
        System.out.println("] " + percent + "%\n");
    }
}
