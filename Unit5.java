// Unit5.java
public class Unit5 extends Unit {
    public String getName() {
        return "Unit 5: Discrete Random Variables";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What is expected value?", "Mean of random variable"),
            new Flashcard("What is variance?", "Measure of spread of a random variable"),
            new Flashcard("What is a probability distribution?", "List of possible values with probabilities")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("What must sum of probabilities equal?", new String[] {"0", "0.5", "1"}, "1"),
            new Quiz("True or False: Expected value can be negative.", new String[] {"True", "False"}, "True")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"Expected value", "Variance", "Probability distribution"},
            new String[] {"Mean", "Spread", "Probabilities of outcomes"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Random variables", "Expected value", "Variance", "Probability distribution"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Not verifying probabilities sum to 1",
            "Confusing variance with standard deviation"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "Expected value is weighted average",
            "Variance is square of standard deviation"
        });
    }
}
