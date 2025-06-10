// Unit4.java
public class Unit4 extends Unit {
    public String getName() {
        return "Unit 4: Probability";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What is the addition rule?", "P(A or B) = P(A) + P(B) - P(A and B)"),
            new Flashcard("What is independence?", "Two events where P(A and B) = P(A)*P(B)"),
            new Flashcard("What is a sample space?", "All possible outcomes")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("Are mutually exclusive events independent?", new String[] {"Yes", "No"}, "No"),
            new Quiz("True or False: P(A) always between 0 and 1.", new String[] {"True", "False"}, "True")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"Addition rule", "Multiplication rule", "Independence"},
            new String[] {"P(A or B)", "P(A and B)", "P(A and B) = P(A)*P(B)"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Probability rules", "Mutually exclusive", "Independent events", "Conditional probability"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Confusing mutually exclusive with independent",
            "Ignoring complement rule"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "Mutually exclusive events cannot be independent",
            "Always check if probabilities add up to 1"
        });
    }
}
