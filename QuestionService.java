import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[4];
    String[] selection = new String[4];

    public QuestionService() {
        questions[0] = new Question(1, "Which language is used for Android development?",
                new Opt[]{new Opt(1, "Java"), new Opt(2, "Python"), new Opt(3, "Ruby"), new Opt(4, "Kotlin")}, "Java");

        questions[1] = new Question(2, "Which of these is a frontend framework?",
                new Opt[]{new Opt(1, "React"), new Opt(2, "Django"), new Opt(3, "Flask"), new Opt(4, "Angular")}, "React");

        questions[2] = new Question(3, "What does SQL stand for?",
                new Opt[]{new Opt(1, "Structured Query Language"), new Opt(2, "Simple Query Language"),
                        new Opt(3, "Standard Query Language"), new Opt(4, "Sequential Query Language")},
                "Structured Query Language");

        questions[3] = new Question(4, "Which language is primarily used for web development?",
                new Opt[]{new Opt(1, "HTML"), new Opt(2, "C#"), new Opt(3, "Swift"), new Opt(4, "CSS")}, "HTML");
    }

    public void playQuiz() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
    
        for (Question q : questions) {
            System.out.println("Question no.: " + q.getId());
            System.out.println(q.getQuestion());
            showOptions(q.getOptions());
    
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter your choice (number or answer): ");
                    String result = sc.nextLine().trim();
    
                    // Check if the input is a number
                    if (result.matches("\\d+")) {
                        int number = Integer.parseInt(result);
                        if (number > 0 && number <= q.getOptions().length) {
                            String userInput = getStringFromOptions(q.getOptions(), number);
                            selection[i] = userInput;
                            validInput = true;
                        } else {
                            System.out.println("Invalid choice. Please select a valid option number.");
                        }
                    } else {
                        // Check if the input matches any option directly
                        String userInput = result.toLowerCase();
                        boolean found = false;
    
                        for (Opt option : q.getOptions()) {
                            if (option.getOpt().equalsIgnoreCase(userInput)) {
                                selection[i] = option.getOpt();
                                validInput = true;
                                found = true;
                                break;
                            }
                        }
    
                        if (!found) {
                            System.out.println("Invalid answer. Please enter a valid option or number.");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred. Please try again.");
                }
            }
            i++;
        }
        sc.close();

        int j = 0;
        for (String s : selection) {
            System.out.println("Your choice no. :" + (j+1) + " was: " + s);
            System.out.println("--------------------------------------------------------------------");
            j++;
        }
    }

    private String getStringFromOptions(Opt[] options, int number) {
        return options[number - 1].getOpt(); 
    }

    private void showOptions(Opt[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " : " + options[i].getOpt()); 
        }
    }

    public void printScore() {
        int score = 10;
        for (int i = 0; i < questions.length; i++) {
            Question que = questions[i];
            String actualAnswer = que.getAnswer();
            String userAnswer = selection[i];

            if (actualAnswer.equals(userAnswer)) {
                score += 30;
            }
        }
        System.out.println("Your score is: " + score);
    }
}
