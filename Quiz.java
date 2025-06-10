// Quiz.java
// Represents a multiple-choice quiz question.
public class Quiz {
    private String question;      // Quiz question
    private String[] options;     // Possible answers
    private String correctAnswer; // Correct option text

    public Quiz(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
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


