import java.util.Scanner;

public class AccessVerifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        String validPassword = "password";
        int maximumAttempts = 3;
        int loginAttempts = 0;

        while (loginAttempts < maximumAttempts) {
            System.out.print("Enter password: ");
            String userInputPassword = scanner.nextLine();

            try {
                if (!userInputPassword.equals(validPassword)) {
                    loginAttempts++;
                    if (loginAttempts < maximumAttempts) {
                        throw new InvalidPassword("Invalid password. Please try again.");
                    } else {
                        throw new MaximumAttemptsExceeded("Maximum login attempts exceeded.");
                    }
                } else {
                    System.out.println("Login successful!");
                    break; 
                }
            } catch (InvalidPassword | MaximumAttemptsExceeded e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close(); 
    }
}
