// Unit8.java
public class Unit8 extends Unit {
    @Override
    public String toString() {
        return "Unit 8: Inference for Categorical Data";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What is a chi-square test?", "Test for categorical association"),
            new Flashcard("What are expected counts?", "Counts expected under null hypothesis"),
            new Flashcard("What is degrees of freedom?", "Number of values free to vary")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("When to use chi-square test?", new String[] {"Numerical data", "Categorical data", "Both"}, "Categorical data"),
            new Quiz("True or False: Large chi-square means evidence against null.", new String[] {"True", "False"}, "True")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"Chi-square", "Expected count", "Degrees of freedom"},
            new String[] {"Test statistic", "Under null hypothesis", "df"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Categorical data", "Chi-square test", "Expected counts", "Degrees of freedom"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Using chi-square for small expected counts",
            "Mixing up degrees of freedom calculation"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "Expected counts should be at least 5",
            "Degrees of freedom depends on table size"
        });
    }
}
