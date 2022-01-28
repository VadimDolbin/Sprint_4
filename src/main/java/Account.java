import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;
    private final String regex = "^(?=.{3,19}$)([А-Яа-яЁё]+\\s[А-Яа-яЁё]+)$";
    private final Pattern pattern = Pattern.compile(regex);

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name == null)
            return false;
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}