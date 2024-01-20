import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            String clientSentence= inFromClient.readLine();
            
            if (clientSentence.equalsIgnoreCase("ping")) {
                System.out.println("Someone ping me!");
                outToClient.writeBytes("Pong!\n");
            } else {
                System.out.println("Someone, I wanna play Ping-Pong!");
                outToClient.writeBytes("Ping?\n");
            }
        }
    }
}
