// StudyMethod.java
public class StudyMethod {
    private Flashcard[] flashcards;
    private Quiz[] quizzes;
    private MatchingActivity matching;
    private ContentMap conceptMap;
    private ErrorAnalysis errors;
    private Review reviews;

    public StudyMethod(Flashcard[] f, Quiz[] q, MatchingActivity m, ContentMap c, ErrorAnalysis e, Review r) {
        flashcards = f;
        quizzes = q;
        matching = m;
        conceptMap = c;
        errors = e;
        reviews = r;
    }

    public Flashcard[] getFlashcards() {
        return flashcards;
    }

    public Quiz[] getQuizzes() {
        return quizzes;
    }

    public MatchingActivity getMatchingActivity() {
        return matching;
    }

    public ContentMap getConceptMap() {
        return conceptMap;
    }

    public ErrorAnalysis getErrorAnalysis() {
        return errors;
    }

    public Review getReview() {
        return reviews;
    }

    public static StudyMethod[] selectMethods(int time, Unit unit) {
        Flashcard[] f = unit.getFlashcards();
        Quiz[] q = null;
        MatchingActivity m = null;
        ContentMap c = null;
        ErrorAnalysis e = null;
        Review r = null;

        if (time <= 15) {
            m = unit.getMatchingActivity();
        } else if (time <= 30) {
            m = unit.getMatchingActivity();
            c = unit.getConceptMap();
        } else if (time <= 45) {
            m = unit.getMatchingActivity();
            c = unit.getConceptMap();
            r = unit.getReviewNotes();
        } else if (time <= 120) {
            m = unit.getMatchingActivity();
            c = unit.getConceptMap();
            r = unit.getReviewNotes();
            e = unit.getErrorAnalysis();
        } else {
            m = unit.getMatchingActivity();
            c = unit.getConceptMap();
            r = unit.getReviewNotes();
            e = unit.getErrorAnalysis();
            q = unit.getQuizzes();
        }

        return new StudyMethod[] {
            new StudyMethod(f, q, m, c, e, r)
        };
    }
}
