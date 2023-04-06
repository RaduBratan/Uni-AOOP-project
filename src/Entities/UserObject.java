package Entities;

import java.util.ArrayList;
import java.util.List;

public class UserObject {
    private static UserObject instance = null;
    final private UserFactory factory = new UserFactory();
    private List<UserData> users = new ArrayList<UserData>();

    public static UserObject getInstance() {
        if (instance == null)
            instance = new UserObject();
        return instance;
    }

    public List<UserData> getUsers() {
        return users;
    }
    public void setUsers(List<UserData> users) {
        this.users = users;
    }
}
