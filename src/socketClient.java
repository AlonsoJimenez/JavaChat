import java.io.DataOutputStream;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class socketClient {
    boolean inConversation = false;
    public String ip="127.0.0.1";
    public int port;
    public DataOutputStream messageObject;


    public socketClient(String ip, int port) throws IOException {
        Socket theSocketClient = new Socket(ip, port);
        messageObject = new DataOutputStream(theSocketClient.getOutputStream());

    }
    public void sendMessage(String messsage){
        try{
        messageObject.writeUTF(messsage);

    }catch(IOException e){};

    }

}
