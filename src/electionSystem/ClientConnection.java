package electionSystem;

import java.io.*;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClientConnection {

    public static Socket socket;
    public static PrintWriter out;
    public static BufferedReader in;

    public static void connectToServer() {
        try {
            socket = new Socket("localhost", 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));            
            System.out.println("Connected to server successfully."+socket.getInetAddress());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to server: " + e.getMessage(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public static void socketClose(){
        try{
            out.close();
            in.close();
            socket.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error connecting to server: " + e.getMessage(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
}
