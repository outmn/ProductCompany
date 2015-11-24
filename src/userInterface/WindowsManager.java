package userInterface;

import java.net.Socket;

/**
 * Created by maximgrozniy on 24.11.15.
 */
public class WindowsManager {


    public WindowsManager(int user, Socket socket) {
        System.out.println(user);
        switch (user) {
            case 0:
                new CustomerPanel(socket);
                break;
            case 1:
                new SalesManagerPanel(socket);
                break;
            case 2:
                new AdminPanel(socket);
                System.out.println("windows manager admin");
                break;
        }
    }
}
