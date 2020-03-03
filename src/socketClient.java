import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class socketClient {
    boolean inConversation = false;
    public int ip;
    public int port;
    public String ipString;


    public socketClient(int ip, int port) throws IOException {
        ipString = Integer.toString(ip);
        Socket theSocketClient = new Socket(ipString, port);


    }

}
