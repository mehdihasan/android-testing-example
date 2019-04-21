package me.mehdihasan.testingexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUtilsUnitTest {

    private LoginUtils loginUtils;

    @Before
    public void prepareEnv() {
        loginUtils = new LoginUtils();
    }

    @Test
    public void charLengthBeforeDotPasses() throws Exception {
        assertEquals(3, loginUtils.getCharLenBeforeDotInEmail("i@ijk.com.bd"));
    }

    @Test
    public void charLengthAfterDotPasses() throws Exception {
        assertEquals(6, loginUtils.getCharLenAfterDotInEmail("i@ijk.com.bd"));
    }

    @Test
    public void localPartLengthForValidEmailAddress() throws Exception {
        assertEquals(1, loginUtils.getLocalPartLength("i@gmail.com"));
    }

    @Test
    public void aValidEmailAddressPasses() throws Exception {
        assertTrue(loginUtils.isValidEmailAddress("mail2oroni@gmail.com"));
    }

    @Test
    public void anEnvalidEmailAddressFails() throws Exception {
        assertFalse(loginUtils.isValidEmailAddress("mail2oroni"));
    }

    @Test
    public void aValidPasswordPasses() throws Exception {
        assertTrue(loginUtils.isValidPassword("12345678"));
    }

    @Test
    public void anInvalidPasswordFails() throws Exception {
        assertFalse(loginUtils.isValidPassword("1234567"));
    }
}