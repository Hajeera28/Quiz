import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding questions to the quiz
        quiz.addQuestion(new Question("Which planet has the most moons?",
                new String[]{"Saturn", "Jupiter", "Mars", "Venus"}, 0));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?",
                new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 1));
        quiz.addQuestion(new Question("What is the powerhouse of the cell?",
                new String[]{"Nucleus", "Mitochondria", "Ribosome", "Chloroplast"}, 1));
        quiz.addQuestion(new Question("Who wrote 'To Kill a Mockingbird'?",
                new String[]{"Mark Twain", "Harper Lee", "Charles Dickens", "F. Scott Fitzgerald"}, 1));
        quiz.addQuestion(new Question("What is the chemical symbol for water?",
                new String[]{"H2O", "CO2", "O2", "H2SO4"}, 0));

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < quiz.getTotalQuestions(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());
            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            userAnswer--; // Adjust index
            if (userAnswer >= 0 && userAnswer < options.length) {
                if (userAnswer == question.getCorrectAnswerIndex()) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect!");
                }
            } else {
                System.out.println("Invalid input! Please try again.");
                i--; // Repeat the current question
            }
        }

        System.out.println("Quiz complete! Your score is: " + score + "/" + quiz.getTotalQuestions());
        scanner.close();
    }
}

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}
