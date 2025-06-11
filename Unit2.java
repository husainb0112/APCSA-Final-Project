// Unit2.java
public class Unit2 extends Unit {
    @Override
    public String toString() {
        return "Unit 2: Two-Variable Data";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What does correlation measure?", "Strength and direction of a linear relationship"),
            new Flashcard("What is a residual?", "Observed - predicted"),
            new Flashcard("What is r-squared?", "Proportion of variance explained by the regression line")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("What is the range of correlation coefficient r?", new String[] {"-2 to 2", "-1 to 1", "0 to 100"}, "-1 to 1"),
            new Quiz("True or False: High r implies causation.", new String[] {"True", "False"}, "False")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"r", "r-squared", "Residual"},
            new String[] {"Correlation", "Variance explained", "Observed - Predicted"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Scatterplot", "Correlation", "Least-squares regression", "Residual", "Outlier"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Assuming correlation implies causation",
            "Forgetting to check residual plots"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "Use residual plots to assess fit",
            "High r doesn’t prove cause"
        });
    }
}
