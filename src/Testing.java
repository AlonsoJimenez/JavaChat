import java.io.IOException;
import java.net.ServerSocket;

public class Testing {
    public static void main(String[] args) throws IOException {
        socketServer socketTest = new socketServer();
        ServerSocket thesocketServer = socketTest.server();

    }
}
