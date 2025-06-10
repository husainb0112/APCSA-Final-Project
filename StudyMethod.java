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
        return new StudyMethod[]{
            new StudyMethod(unit.getFlashcards(), unit.getQuizzes(),
                            unit.getMatchingActivity(), unit.getConceptMap(),
                            unit.getErrorAnalysis(), unit.getReviewNotes())
        };
    }
}
