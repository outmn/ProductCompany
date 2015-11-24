package connection;

import userInterface.Entrance;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by maximgrozniy on 11.11.15.
 */
public class Client {
    private Socket socket;
    private final int PORT = 5634;

    public Client() {
        try {
            InetAddress inetAddress = InetAddress.getByName(null);
            socket = new Socket(inetAddress, PORT);

            new SocketThread(socket);
            new Entrance(socket);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
