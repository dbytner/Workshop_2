package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDAO;

public class UserManagerTest {

    public static void main(String[] args) {

        User user_1 = new User("jkowalski@wp.pl", "Jan Kowalski", "kowalski123");
        User user_2 = new User("pnowak@wp.pl", "Piotr Nowak", "nowak123");
        User user_3 = new User("k.kowalczyk@onet.pl", "Krystyna Kowalczyk", "kowalczyk56");
        User user_4 = new User("zboniek@interia.pl", "Zbigniew Boniek", "pilka09");
        User user_5 = new User("z.jaskula@wp.pl", "Zenon Jaskuła", "jaskula0012");
        UserDAO userDAO_1 = new UserDAO();
        //userDAO_1.create(user_1);
//        userDAO_1.create(user_2);
//        userDAO_1.create(user_3);
//        userDAO_1.create(user_4);
//        userDAO_1.create(user_5);
        User user = new User();
        user = userDAO_1.read(5);


//        user = userDAO_1.read(5);
//        user.setUserName("Robert Kubica");
//        user.setEmail("rkubica@wp.pl");
//        user.setPassword("formula1");
//        userDAO_1.update(user);

        //userDAO_1.delete(6);

        User[] users = userDAO_1.findAll();
        for (User u: users) {
            System.out.println(u.getId() + " " + u.getUserName() + " " + u.getEmail());
        }

    }
}
