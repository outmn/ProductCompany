package userInterface;

/**
 * Created by maximgrozniy on 18.09.15.
 */
public class PasswordAuthentication {

    private int login;
    private String administrativePassword;
    private String salesPassword;

    public PasswordAuthentication(String administrativePassword, String salesPassword) {
        this.administrativePassword = administrativePassword;
        this.salesPassword = salesPassword;
    }

    private boolean checkPassword(String password, String enteredPassword) {
        if (password.equals(enteredPassword)) {
                return true;
        }
        return false;
    }


    public String check(int login, char[] password) {
        String enteredPassword = "";
        for (int i = 0; i < password.length; i++) enteredPassword += password[i];

        switch (login) {
            case 0:

                break;
            case 1:
                if (checkPassword(salesPassword, enteredPassword)) {
                    return "Sales manager";
                }
                break;
            case 2:
                if (checkPassword(administrativePassword, enteredPassword)) {
                    return "Administrator";
                }
                break;
        }
        return "Chose User";
    }
}

