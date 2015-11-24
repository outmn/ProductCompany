package connection;

import java.net.Socket;

/**
 * Created by maximgrozniy on 11.11.15.
 */
public class SocketThread extends Thread{
    private Socket socket;

    public SocketThread (Socket socket) {
        this.socket = socket;
        this.start();
    }
    @Override
    public void run() {

    }

}
