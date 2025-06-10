// AppRunner.java
import java.util.Scanner;

public class AppRunner {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Unit[] units = new Unit[] {
            new Unit1(), new Unit2(), new Unit3(),
            new Unit4(), new Unit5(), new Unit6(),
            new Unit7(), new Unit8(), new Unit9()
        };

        while (true) {
            Unit selected = promptUnit(scanner, units);
            if (selected == null) { exit(scanner); return; }

            Integer time = promptTime(scanner);
            if (time == null) { exit(scanner); return; }

            StudyMethod method = StudyMethod.selectMethods(time, selected)[0];
            runSession(scanner, selected, method);
        }
    }

    public Unit promptUnit(Scanner s, Unit[] units) {
        System.out.println("Select a unit or type 'exit':");
        for (int i = 0; i < units.length; i++) {
            System.out.println((i + 1) + ". " + units[i].getName());
        }
        String input = s.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) return null;
        if (!input.matches("[1-9]")) return promptUnit(s, units);
        return units[Integer.parseInt(input) - 1];
    }

    public Integer promptTime(Scanner s) {
        System.out.println("Enter your study time in minutes or type 'exit':");
        String input = s.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) return null;
        if (input.matches("[0-9]+")) return Integer.parseInt(input);
        return promptTime(s);
    }

    public void runSession(Scanner s, Unit unit, StudyMethod m) {
        System.out.println("\nStarting: " + unit.getName());
        pauseOrExit(s, "Press Enter to start...");

        Flashcard[] flashcards = m.getFlashcards();
        if (flashcards != null) {
            for (Flashcard f : flashcards) {
                System.out.println("Q: " + f.getQuestion());
                pauseOrExit(s, "Press Enter to see answer...");
                System.out.println("A: " + f.getAnswer());
                pauseOrExit(s, "");
            }
        }

        Quiz[] quizzes = m.getQuizzes();
        if (quizzes != null) {
            for (Quiz q : quizzes) {
                System.out.println(q.getQuestion());
                String[] options = q.getOptions();
                for (int i = 0; i < options.length; i++)
                    System.out.println((char)('A' + i) + ". " + options[i]);
                String ans = promptAnswer(s, options.length);
                System.out.println(
                    options[ans.charAt(0) - 'A'].equals(q.getCorrectAnswer())
                    ? "Correct!"
                    : "Incorrect. Correct answer: " + q.getCorrectAnswer()
                );
                pauseOrExit(s, "");
            }
        }

        MatchingActivity match = m.getMatchingActivity();
        if (match != null) {
            String[] terms = match.getTerms();
            String[] defs = match.getDefinitions();
            System.out.println("Matching Terms:");
            for (String t : terms) System.out.println("- " + t + " = ?");
            pauseOrExit(s, "Press Enter to see answers...");
            for (int i = 0; i < terms.length; i++)
                System.out.println(terms[i] + " = " + defs[i]);
            pauseOrExit(s, "");
        }

        ContentMap map = m.getConceptMap();
        if (map != null) {
            System.out.println("Concept Map:");
            for (String c : map.getKeyConcepts())
                System.out.println("- " + c);
            pauseOrExit(s, "");
        }

        ErrorAnalysis err = m.getErrorAnalysis();
        if (err != null) {
            System.out.println("Common Mistakes:");
            for (String e : err.getErrors()) {
                System.out.println("- " + e);
                pauseOrExit(s, "");
            }
        }

        Review review = m.getReview();
        if (review != null) {
            System.out.println("Key Points:");
            for (String r : review.getReviewPoints()) {
                System.out.println("- " + r);
                pauseOrExit(s, "");
            }
        }

        System.out.println("Study session complete. Returning to menu...");
    }

    public String promptAnswer(Scanner s, int optCount) {
        System.out.print("Your answer (A-" + (char)('A' + optCount - 1) + ") or 'exit': ");
        String input = s.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) { exit(s); System.exit(0); }
        if (input.matches("[A-" + (char)('A' + optCount - 1) + "]")) return input;
        return promptAnswer(s, optCount);
    }

    public void pauseOrExit(Scanner s, String prompt) {
        if (!prompt.isEmpty()) System.out.print(prompt);
        String input = s.nextLine().trim();
        if ("exit".equalsIgnoreCase(input)) { exit(s); System.exit(0); }
    }

    public void exit(Scanner s) {
        System.out.println("Exiting program.");
        s.close();
    }
}
