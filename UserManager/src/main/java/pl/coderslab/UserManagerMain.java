package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDAO;

import java.util.Scanner;

public class UserManagerMain {

    public static void main(String[] args) {


        boolean end = false;

        while (!end) {
            Scanner scanner = new Scanner(System.in);
            printMenu();
            String letter = scanner.nextLine();
            char firstLetter = letter.charAt(0);

            switch (firstLetter) {
                case 'c': {
                    UserDAO userDAO = new UserDAO();
                    Scanner scanner1 = new Scanner(System.in);
                    User createUser = new User();
                    System.out.println("Podaj email użytkownika:");
                    createUser.setEmail(scanner1.nextLine());
                    System.out.println("Podaj nazwę użytkownika:");
                    createUser.setUserName(scanner1.nextLine());
                    System.out.println("Podaj hasło użytkownika:");
                    createUser.setPassword(scanner1.nextLine());
                    userDAO.create(createUser);
                    break;
                }
                case 'r': {
                    UserDAO userDAO = new UserDAO();
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Podaj indeks użytkownika:");
                    userDAO.read(scanner1.nextInt());
                    break;
                }
                case 'u': {
                    UserDAO userDAO = new UserDAO();
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Podaj indeks użytkownika");
                    User updateUser = userDAO.read(scanner1.nextInt());
                    scanner1.nextLine();
                    System.out.println("Podaj nową nazwę użytkownika:");
                    updateUser.setUserName(scanner1.nextLine());
                    System.out.println("Podaj nowy email użytkownika:");
                    updateUser.setEmail(scanner1.nextLine());
                    System.out.println("Podaj nowe hasło użytkownika:");
                    updateUser.setPassword(scanner1.nextLine());
                    userDAO.update(updateUser);
                    break;
                }
                case 'd': {
                    UserDAO userDAO = new UserDAO();
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Podaj indeks użytkownika:");
                    userDAO.delete(scanner1.nextInt());
                    break;
                }

                case 'f': {
                    UserDAO userDAO = new UserDAO();
                    User[] users = userDAO.findAll();
                    for (User u : users) {
                        System.out.println(u.getId() + " " + u.getUserName() + " " + u.getEmail());
                    }
                }
                default:
                    break;
                case 'x': {
                    end = true;
                    break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Jaką czynność chcesz wykonać:");
        System.out.println("c - create user, r - read user, u - update user, d - delete user, f - find all users, x - zakończenie pracy");
    }
}
