import java.io.DataOutputStream;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class socketClient {
    boolean inConversation = false;
    Socket theSocketClient;
    public String ip="127.0.0.1";
    public int port;
    public DataOutputStream messageObject;


    public socketClient(String ip, int port) throws IOException {
        theSocketClient = new Socket("127.0.0.1",port);
        messageObject = new DataOutputStream(theSocketClient.getOutputStream());

    }
    public void sendMessage(String messsage){
        try{
        messageObject.writeUTF(messsage);

    }catch(IOException e){e.printStackTrace();};

    }
    public void disconnect() throws IOException {
        theSocketClient.close();
    }



}
