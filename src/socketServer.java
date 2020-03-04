import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class socketServer {
    manageHistory history;
    boolean active = true;
    int port= 3000;

    private boolean available(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return true;
        } catch (IOException ignored) {
            return false;
        }
    }
    public int realPort (int port) {
        port = this.port;
        for (int i = port; i <= 3100; i++) {
            if (available(i)) {
                System.out.println(i);
                return i;
            }
        }
        System.out.println("Cant find socket port");
        return 0;
    }

    public ServerSocket server(){
        try {
            return new ServerSocket(realPort(realPort(port)));
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }
    public void receive(){
        boolean active = true;
        while (active){
            try{
            Socket receiver = server().accept();
            BufferedReader read = new BufferedReader(new InputStreamReader(receiver.getInputStream()));
            String message= read.readLine();
            String[] separation = message.split("%");
            int portNumber=Integer.parseInt(separation[0]);
            history.setText(portNumber,"HIM:\n"+separation[1]);
            receiver.close();
            }catch (IOException e){e.printStackTrace();}

}}}

