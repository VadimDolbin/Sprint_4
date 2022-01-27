import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][] {
                {null, false},
                {"ПО", false},
                {"Аристарх Аристархович", false},
                {"Вадим Долбин", true},
                {" ВадимДолбин", false},
                {"ВадимДолбин ", false},
                {"Вадим  Долбин", false},
                {"ВадимДолбин", false},
                {"вадим Долбин", false},
                {"Вадим долбин", false},
        };
    }

    @Test
    public void testUserNameConditions() throws Exception {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();;
        assertEquals(expected, actual);
    }
}