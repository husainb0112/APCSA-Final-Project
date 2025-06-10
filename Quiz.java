// Quiz.java
public class Quiz {
    private String question;
    private String[] options;
    private String correctAnswer;
    public Quiz(String q, String[] o, String c) { 
        question = q; 
        options = o; 
        correctAnswer = c; 
    }
    public String getQuestion() { 
        return question; 
    }
    public String[] getOptions() { 
        return options; 
    }
    public String getCorrectAnswer() { 
        return correctAnswer; 
    }
}
