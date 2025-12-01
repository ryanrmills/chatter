import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// To recompile files and run server:
// javac src/*.java && java -cp src OutServer
public class OutServer {
    
    public static void main(String[] args) {
        try {
            writeToSocket(12345);
        } catch (IOException e){
            System.err.println("Error writing to socket");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void writeToSocket(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("waiting for client to connect...");
        Socket socket = server.accept();
        System.out.println("client connected!");
        

        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, java.nio.charset.StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        int count = 0;
        while (count < 10){
            bufferedWriter.write("hello");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            count++;
        }
    }
}
