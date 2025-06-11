// Unit9.java
public class Unit9 extends Unit {
    @Override
    public String toString() {
        return "Unit 9: Inference for Quantitative Data";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What is a confidence interval?", "Range of plausible values for parameter"),
            new Flashcard("What is a t-distribution?", "Used when population SD unknown"),
            new Flashcard("What does p-value indicate?", "Strength of evidence against null")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("What distribution to use when sigma unknown?", new String[] {"Normal", "T", "Chi-square"}, "T"),
            new Quiz("True or False: Smaller p-value means stronger evidence.", new String[] {"True", "False"}, "True")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"Confidence interval", "T-distribution", "P-value"},
            new String[] {"Range estimate", "For unknown sigma", "Evidence strength"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Confidence intervals", "Hypothesis tests", "T-distribution", "P-values"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Misinterpreting confidence interval",
            "Confusing one-sided and two-sided tests"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "CI gives range for parameter with certain confidence",
            "T-distribution is wider for small samples"
        });
    }
}
