import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name == null)
            return false;
        else if (name.length() < 3 || name.length() > 19)
            return false;
        else {
            String regex = "^[А-Я]{1}[а-я]*\\s[А-Я]{1}[а-я]*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            return matcher.matches();
        }
    }
}