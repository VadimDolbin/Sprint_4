import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    @DisplayName("Check that valid user full name is not null")
    public void testNullUserName() {
        Account account = new Account(null);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name is not less than 3 letters long")
    public void testShortUserName() {
        Account account = new Account("ПО");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name is not more than 19 letters long")
    public void testLongUserName() {
        Account account = new Account("Аристарх Аристархович");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check valid user full name matching all input conditions")
    public void testValidUserName() {
        Account account = new Account("Вадим Долбин");
        boolean actual = account.checkNameToEmboss();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name is not started with space character")
    public void testSpaceBeforeUserName() {
        Account account = new Account(" Вадим Долбин");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name is not ended with space character")
    public void testSpaceAfterUserName() {
        Account account = new Account("Вадим Долбин ");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name contains not more than one space character")
    public void testSpacesInsideUserName() {
        Account account = new Account("Вадим  Долбин");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name contains one space character")
    public void testNoSpacesInUserName() {
        Account account = new Account("ВадимДолбин");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user first name is not started with lowercase letter")
    public void testLowercaseUserFirstName() {
        Account account = new Account("вадим Долбин");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user last name is not started with lowercase letter")
    public void testLowercaseUserLastName() {
        Account account = new Account("Вадим долбин");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name does not contain numbers")
    public void testNumbersInUserName() {
        Account account = new Account("Вад1м Д0лбин");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name does not contain special characters")
    public void testSpecialCharactersInUserName() {
        Account account = new Account("В@д!м Д:лб|н");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check that valid user full name does not contain other languages letters")
    public void testOtherLanguagesInUserName() {
        Account account = new Account("Ваdiм Doлбиn");
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }
}