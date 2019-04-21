package me.mehdihasan.testingexample;

public class LoginUtils {

    /**
     *
     * @param password
     * @return
     */
    public boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean isValidEmailAddress(String email) {
        return hasAtInEmail(email)
                && hasDotInEmail(email)
                && getLocalPartLength(email) > 0
                && getCharLenBeforeDotInEmail(email) > 0
                && getCharLenAfterDotInEmail(email) > 0;
    }

    /**
     *
     * @param email
     * @return
     */
    public int getCharLenBeforeDotInEmail(String email) {
        String charLenBeforeDotInEmail = email.substring(email.indexOf("@") + 1, email.indexOf("."));
        return charLenBeforeDotInEmail.length();
    }

    /**
     *
     * @param email
     * @return
     */
    public int getCharLenAfterDotInEmail(String email) {
        String charLenAfterDotInEmail = email.substring(email.indexOf(".") + 1);
        return charLenAfterDotInEmail.length();
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean hasAtInEmail(String email) {
        boolean hasAtSign = email.indexOf("@") > -1;
        return hasAtSign;
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean hasDotInEmail(String email) {
        boolean hasAtSign = email.indexOf(".") > -1;
        return hasAtSign;
    }

    /**
     *
     * @param email
     * @return
     */
    public int getLocalPartLength(String email) {
        String localPartText = email.substring(0, email.indexOf("@"));
        return localPartText.length();
    }
}
