import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class socketServer {
    boolean active = true;
    int port= 4000;
    int realPort;

    private boolean available(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }

    public void setRealPort(int port) {
        if(available(port)){
            this.realPort=port;
        }
        else{
            if(port==4100){
                System.out.println("Can't create socket server");
            }
        }
        else{
            port++;
            this.setRealPort(port);
        }
    }
    public socketServer() throws IOException {
        ServerSocket server = new ServerSocket(realPort);
    }
    }

}
