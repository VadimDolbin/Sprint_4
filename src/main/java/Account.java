import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;
    private final String regex = "^(?=.{1,19}$)[А-Я]{1}[а-я]*\\s[А-Я]{1}[а-я]*$";
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