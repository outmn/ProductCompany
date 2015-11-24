package userInterface;

import java.net.Socket;

/**
 * Created by maximgrozniy on 24.11.15.
 */
public class CustomerPanel {
    private Socket socket;

    public CustomerPanel(Socket socket) {
        this.socket = socket;
    }
}
