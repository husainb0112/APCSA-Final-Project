// Unit6.java
public class Unit6 extends Unit {
    @Override
    public String toString() {
        return "Unit 6: Continuous Random Variables and Normal Distribution";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What is the normal distribution?", "Bell-shaped, symmetric"),
            new Flashcard("What does the area under curve represent?", "Probability"),
            new Flashcard("What is the empirical rule?", "68-95-99.7% rule for normal")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("What is the mean of standard normal?", new String[] {"0", "1", "Unknown"}, "0"),
            new Quiz("True or False: Normal is discrete.", new String[] {"True", "False"}, "False")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"Normal curve", "Standard normal", "Empirical rule"},
            new String[] {"Bell-shaped", "Mean 0 SD 1", "68-95-99.7%"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Continuous variables", "Normal distribution", "Z-scores", "Empirical rule"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Using normal for non-continuous data",
            "Misinterpreting area under curve"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "Z-scores standardize data",
            "Empirical rule helps approximate probabilities"
        });
    }
}
