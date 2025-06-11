// Unit7.java
public class Unit7 extends Unit {
    @Override
    public String toString() {
        return "Unit 7: Sampling Distributions";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What is a sampling distribution?", "Distribution of sample statistics"),
            new Flashcard("What does CLT state?", "Sample mean approx normal for large n"),
            new Flashcard("What affects variability of sample mean?", "Sample size")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("What happens to sample mean distribution as n increases?", new String[] {"Becomes skewed", "Becomes normal", "No change"}, "Becomes normal"),
            new Quiz("True or False: Sampling distribution describes individuals.", new String[] {"True", "False"}, "False")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"Sampling distribution", "Central Limit Theorem", "Standard error"},
            new String[] {"Distribution of statistic", "Sample mean normality", "Std dev of sample mean"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Sampling distribution", "Central Limit Theorem", "Standard error", "Sample size"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Confusing population distribution with sampling distribution",
            "Ignoring sample size effects"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "CLT requires sufficiently large n",
            "Standard error decreases as n increases"
        });
    }
}
