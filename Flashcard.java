// Flashcard.java
// Represents a question-answer flashcard for study.
public class Flashcard {
    private String question; // Question text
    private String answer;   // Answer text

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
