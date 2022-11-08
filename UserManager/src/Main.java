import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static void printMenu() {
        System.out.println("Select an option");
        System.out.println("1 - Register user");
        System.out.println("2 - Log in");
        System.out.println("3 - Exit");
    }

    private static void printLoggedMenu() {
        System.out.println("Select an option: ");
        System.out.println("1 - Set Security Question");
        System.out.println("2 - Set Password");
        System.out.println("3 - Set Email");
        System.out.println("4 - Log out");
    }

    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        Scanner sc = new Scanner(System.in);
        User userToRegister = null;
        String option;
        String name, password, email;

        System.out.println("Welcome to User Manager");

        do {

            printMenu();

            option = sc.nextLine();

            switch (option) {
                case "1":

                    System.out.println("Enter your username: ");
                    name = sc.nextLine();

                    System.out.println("Enter your password: ");
                    password = sc.nextLine();

                    System.out.println("Enter your email: ");
                    email = sc.nextLine();

                    userToRegister = new User(name, password, email);

                    manager.registerUser(userToRegister);

                    // System.out.println(manager.getUsers().toString());
                    break;

                case "2":

                    if (manager.logIn()) {
                        do {
                            printLoggedMenu();

                            option = sc.nextLine();

                            switch (option) {
                                case "2":
                                    System.out.println("Enter a new password: ");
                                    password = sc.nextLine();

                                    manager.getUserLogged().setPassword(password);
                                    // System.out.println(manager.getUsers().toString());
                                    break;

                                case "3":
                                    System.out.println("Enter a new email: ");
                                    email = sc.nextLine();

                                    manager.getUserLogged().setEmail(email);

                                    break;

                                case "4":
                                    manager.getMyMessages();
                                    break;

                                case "5":
                                    manager.sendMessage();
                                    break;

                                case "6":
                                    manager.logOut();
                                    break;
                            }
                        } while (!option.equals("4"));
                    }

                    break;
            }

        } while (!option.equals("3"));

    }
}
