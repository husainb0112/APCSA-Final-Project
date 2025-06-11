// Unit.java
// Base class for all AP Stats units
public class Unit {
    @Override
    public String toString() { 
        return "Unit"; 
    }
    public Flashcard[] getFlashcards() { 
        return null; 
    }
    public Quiz[] getQuizzes() { 
        return null; 
    }
    public MatchingActivity getMatchingActivity() { 
        return null; 
    }
    public ContentMap getConceptMap() { 
        return null; 
    }
    public ErrorAnalysis getErrorAnalysis() { 
        return null; 
    }
    public Review getReviewNotes() { 
        return null; 
    }
}
