import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class socketServer {
    boolean active = true;
    int port= 2001;

    private boolean available(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }
    public int realPort (int port) {
        port = this.port;
        for (int i = port; i <= 2200; i++) {
            if (available(i)) {
                System.out.println(i);
                return i;
            }
        }
        System.out.println("Cant find socket port");
        return 0;
    }

    public ServerSocket server;{
        try {
            server = new ServerSocket(realPort(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void receive(){
        boolean active = true;
        while (active){
            try{
            Socket receiver = server.accept();
            BufferedReader read = new BufferedReader(new InputStreamReader(receiver.getInputStream()));
            String message= read.readLine();
            String[] separation = message.split("%");
            javaChat.showMsg.setText(separation[1]);
            receiver.close();
            }catch (IOException e){e.printStackTrace();}

}}}

