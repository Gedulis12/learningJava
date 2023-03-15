import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket; // listens for incoming connections and clients

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() { // method responsible for keeping the server running
        try {
            while (!serverSocket.isClosed()) { //constantly running until the server socket is closed
                Socket socket = serverSocket.accept(); // io blocking method
                System.out.println("New user has connected!");
                ClientHandler clientHandler = new ClientHandler(socket); // each object of this class is responsible for communicating with a client

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {

        }
    }
    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
