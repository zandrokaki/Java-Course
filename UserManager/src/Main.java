
import java.util.Scanner;

public class Main {
    private static void printMenu() {
        System.out.println("Select an option");
        System.out.println("1 - Register user");
        System.out.println("2 - Log in");
        //System.out.println("3 - Did you forget your password?");
        System.out.println("3 - Exit");
    }

    private static void printSecurityQuestion(){
        System.out.println("Select a security question:");
        System.out.println("1 - When is your mother's birthday?");
        System.out.println("2 - What is the name of your best friend?");
        System.out.println("3 - What is the name of the place where you were born?");
    }

    private static void printLoggedMenu(String userlogged) {
        System.out.println("----------------- " + userlogged + "'s dashboard -----------------");
        System.out.println("Select an option: ");
        System.out.println("1 - Set Security Question");
        System.out.println("2 - Set Password");
        System.out.println("3 - Set Email");
        System.out.println("4 - Read my messages");
        System.out.println("5 - Send message");
        System.out.println("6 - Log out");
    }

    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        Scanner sc = new Scanner(System.in);
        User userToRegister = null;
        String option;
        String name, password, email;
        boolean tryLogin = false, tryLoginQuest = false;

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

                    System.out.println("User registered successfully!");
                    break;

                case "2" :

                    if(!manager.logIn()){
                        System.out.println("Did you forget your password? Y-Yes");
                        option = sc.nextLine();
                        option = option.toUpperCase();

                        if(option.equals("Y")){
                            manager.logInWithQuestion();
                        }
                    }

                    if (manager.getUserLogged() != null) {
                        do {
                            printLoggedMenu(manager.getUserLogged().getName());

                            option = sc.nextLine();

                            switch (option) {
                                case "1":
                                    printSecurityQuestion();
                                    option = sc.nextLine();

                                    switch(option)
                                    {
                                        case "1":
                                            manager.getUserLogged().setQuestion("When is your mother's birthday?");
                                            break;

                                        case "2":
                                            manager.getUserLogged().setQuestion("What is the name of your best friend?");
                                            break;

                                        case "3":
                                            manager.getUserLogged().setQuestion("What is the name of the place where you were born?");
                                            break;
                                    }

                                    System.out.println("Write an answer:");
                                    manager.getUserLogged().setAnswer(sc.nextLine());


                                    break;

                                case "2":
                                    System.out.println("Enter a new password: ");
                                    password = sc.nextLine();

                                    manager.getUserLogged().setPassword(password);

                                    break;

                                case "3":
                                    System.out.println("Enter a new email: ");
                                    email = sc.nextLine();

                                    manager.getUserLogged().setEmail(email);

                                    break;

                                case "4":
                                    System.out.println(manager.getMyMessages());
                                    break;

                                case "5":

                                    System.out.println("Enter your destination (Username):");
                                    option = sc.nextLine();

                                    User destination = manager.getUsers().get(option);

                                    System.out.println("Enter the message:");

                                    option = sc.nextLine();

                                    manager.sendMessage(destination, option);

                                    break;

                                case "6":
                                    manager.logOut();
                                    break;
                            }
                        } while (!option.equals("6"));

                    }

                    break;
            }

        } while (!option.equals("3"));

    }
}
