// Unit3.java
public class Unit3 extends Unit {
    public String getName() {
        return "Unit 3: Collecting Data";
    }

    public Flashcard[] getFlashcards() {
        return new Flashcard[] {
            new Flashcard("What is a census?", "Data collected from entire population"),
            new Flashcard("What is a simple random sample?", "Every individual has equal chance of being chosen"),
            new Flashcard("What is an observational study?", "Study where no treatment is imposed")
        };
    }

    public Quiz[] getQuizzes() {
        return new Quiz[] {
            new Quiz("Which design gives all groups equal chance?", new String[] {"Convenience", "Voluntary", "SRS"}, "SRS"),
            new Quiz("True or False: Experiments prove causation.", new String[] {"True", "False"}, "True")
        };
    }

    public MatchingActivity getMatchingActivity() {
        return new MatchingActivity(
            new String[] {"Census", "SRS", "Experiment"},
            new String[] {"Whole population", "Equal random selection", "Impose treatment"}
        );
    }

    public ContentMap getConceptMap() {
        return new ContentMap(new String[] {
            "Sample", "Population", "Bias", "Randomization", "Placebo", "Control group"
        });
    }

    public ErrorAnalysis getErrorAnalysis() {
        return new ErrorAnalysis(new String[] {
            "Using biased sampling methods",
            "Confusing observational with experimental design"
        });
    }

    public Review getReviewNotes() {
        return new Review(new String[] {
            "Random assignment allows causal conclusions",
            "Control groups reduce confounding"
        });
    }
}
