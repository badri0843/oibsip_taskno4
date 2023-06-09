import java.util.Scanner;

public class OnlineExamination {
    private static String username;
    private static String password;
    private static boolean isLoggedIn = false;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Online Examination System!");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Start Examination");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    if (isLoggedIn) {
                        updateProfileAndPassword(scanner);
                    } else {
                        System.out.println("You need to login first!");
                    }
                    break;
                case 3:
                    if (isLoggedIn) {
                        startExamination(scanner);
                    } else {
                        System.out.println("You need to login first!");
                    }
                    break;
                case 4:
                    if (isLoggedIn) {
                        logout();
                    } else {
                        System.out.println("You need to login first!");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the Online Examination System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        if (inputUsername.equals("admin") && inputPassword.equals("password")) {
            username = inputUsername;
            password = inputPassword;
            isLoggedIn = true;
            System.out.println("Login successful. Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void updateProfileAndPassword(Scanner scanner) {
        System.out.println("Updating profile and password...");
        System.out.println("Profile and password updated successfully.");
    }

    private static void startExamination(Scanner scanner) {
        System.out.println("Starting examination...");
        String[] questions = {
                "What is the capital of France?",
                "What is the largest planet in our solar system?",
                "Who painted the Mona Lisa?"
        };
        String[][] options = {
                {"A. Paris", "B. Rome", "C. London", "D. Madrid"},
                {"A. Jupiter", "B. Saturn", "C. Earth", "D. Mars"},
                {"A. Leonardo da Vinci", "B. Pablo Picasso", "C. Vincent van Gogh", "D. Claude Monet"}
        };
        int[] correctAnswers = {1, 0, 0};
        int numQuestions = questions.length;
        int remainingTime = 300; 
        int currentQuestion = 0;

        while (currentQuestion < numQuestions && remainingTime > 0) {
            System.out.println("Question " + (currentQuestion + 1) + ":");
            System.out.println(questions[currentQuestion]);
            for (String option : options[currentQuestion]) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (A, B, C, or D): ");
            String answer = scanner.nextLine().toUpperCase();

            if (answer.equals(options[currentQuestion][correctAnswers[currentQuestion]].substring(0, 1))) {
                score++;
            }
            remainingTime -= 30;
            currentQuestion++;
        }
        System.out.println("Examination completed. Your score is: " + score + " out of " + numQuestions);
    }
    private static void logout() {
        username = null;
        password = null;
        isLoggedIn = false;
        score = 0;
        System.out.println("Logout successful. Goodbye, " + username + "!");
    }
}