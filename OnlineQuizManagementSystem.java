import java.util.*;

public class OnlineQuizManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Quiz questions and answers
        String[] questions = {
            "1. What is the capital of Punjab?\n" +
            "   A. Bathinda\n" +
            "   B. Chandigarh\n" +
            "   C. Ludhiana\n",
            "2. Singer Sidhu Moosewala Died on which date?\n" +
            "   A. 20 May, 2022\n" +
            "   B. 29 May, 2022\n" +
            "   C. 25 May, 2022\n",
            "3. What is the powerhouse of the cell?\n" +
            "   A. Nucleus\n" +
            "   B. Mitochondria\n" +
            "   C. Ribosome\n"
        };
        
        String[] answers = {"B", "B", "B"}; // Correct answers
        
        int score = 0;
        
        System.out.println("Welcome to the Online Quiz!\n");
        
        // Display and process each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            
            System.out.print("Enter your answer (A, B, or C): ");
            String userAnswer = scanner.next().toUpperCase();
            
            // Check if answer is correct
            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + answers[i] + "\n");
            }
        }
        
        // Display final score
        System.out.println("Quiz ended. Your final score is: " + score + "/" + questions.length);
        
        scanner.close();
    }
}
