package userInterface;

import java.net.Socket;

/**
 * Created by maximgrozniy on 24.11.15.
 */
public class SalesManagerPanel {
    private Socket socket;

    public SalesManagerPanel(Socket socket) {
        this.socket = socket;
    }
}
