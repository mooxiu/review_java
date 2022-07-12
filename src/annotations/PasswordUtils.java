package annotations;

import java.util.List;

public class PasswordUtils {
    @Usecase(id = 47, description = "passwords must contains at least one numeric")
    public boolean validatePassword(String passwd) {
        return (passwd.matches("\\w*\\d\\w*"));
    }

    @Usecase(id = 48)
    public String encryptPassword(String passwd) {
        return new StringBuilder(passwd).reverse().toString();
    }

    @Usecase(id = 49, description = "new passwords can not equal previously used ones")
    public boolean checkForNewPasswd(List<String> prevPasswords, String passwd) {
        return !prevPasswords.contains(passwd);
    }
}
