package UI;

import java.util.ArrayList;

public class UserManage {
    private static ArrayList<User> users = new ArrayList<>();

    public static void userAdd(User user) {
        users.add(user);
    }
    public static ArrayList<User> getUsers () {
        return users;
    }

    public static User login (String username, String password){
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}


