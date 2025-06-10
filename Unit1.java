// Unit1.java
public class Unit1 extends Unit {
    public String getName() {
        return "Unit 1: Exploring One-Variable Data";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What are the measures of center?", "Mean and median"),
            new Flashcard("What is standard deviation?", "A measure of spread around the mean"),
            new Flashcard("What does a boxplot show?", "Five-number summary and potential outliers")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("Which measure of center is resistant to outliers?", new String[] {"Mean", "Median", "Standard Deviation"}, "Median"),
            new Quiz("True or False: Range is a resistant measure.", new String[] {"True", "False"}, "False")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"Mean", "Median", "Standard Deviation"},
            new String[] {"Average value", "Middle value", "Spread around mean"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Mean", "Median", "Mode", "Standard Deviation", "IQR", "Boxplot"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Confusing mean with median",
            "Misidentifying outliers in boxplots"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "Use median for skewed data",
            "IQR is resistant; range is not"
        });
    }
}
