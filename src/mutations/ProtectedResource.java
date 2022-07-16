package mutations;

public class ProtectedResource {
    private Resource theResource = new Resource();
    private String[] allowedUsers = {"john", "paul"};

    public String[] getAllowedUsers() {
        return allowedUsers;
    }

    public String currentUser() {
        return "k";
    }

    public void useTheResource() throws IllegalAccessException {
        for (int i = 0; i < allowedUsers.length; i++) {
            if (currentUser().equals(allowedUsers[i])) {
                System.out.println("you're allowed to get access to resource");
                return;
            }
        }
        throw new IllegalAccessException();
    }

    public static void main(String[] args) throws IllegalAccessException {
        var p = new ProtectedResource();
        var allowedUsers = p.getAllowedUsers();
        allowedUsers[0] = "k";
        p.useTheResource();
    }
}

class Resource {

}