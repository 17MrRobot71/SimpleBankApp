import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, User> users = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private static User currentuser = null;

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            if (currentuser != null) {
                bankSystem();
            }
        }
    }


        private static void login(){

            System.out.println("Write username: ");
            String username = sc.nextLine();
            System.out.println("Write password: ");
            String password = sc.nextLine();

            currentuser = users.get(username);
            if(currentuser!=null && currentuser.auntephic(password)){
                System.out.println("Login successful. Welcome, " + currentuser.getUsername() + "!");
            }
            else {
                System.out.println("Invalid username or password.");
            }
        }
        private static void register(){

            User user = null;
            System.out.println("Write username: ");
            String username = sc.nextLine();
            System.out.println("Write password: ");
            String password = sc.nextLine();
            user = users.get(username);
            if(user == null){
                users.put(username,new User(username,password));
                System.out.println("Registration completed");
            }
            else{
                System.out.println("Invalid login");
            }


        }
        private static void bankSystem(){
            while (true) {
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Logout");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        currentuser.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.println("Enter withdraw amount: ");
                        double withdrawAmount = sc.nextDouble();
                        currentuser.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Your balane: " + currentuser.getBalance());
                        break;
                    case 4:
                        currentuser = null;
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }




