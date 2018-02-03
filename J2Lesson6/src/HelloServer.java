/**
 * Write a description of class HelloServer here.
 *
 * @author Volsky Nikita
 * @version dated 16.01.2018
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */

import java.io.*;
import java.net.*;

class HelloServer {

    public static void main(String[] args) {
        new HelloServer();
    }

    HelloServer() {
        try (ServerSocket server = new ServerSocket(1024)) {
            while (true) {
                Socket socket = server.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println("Server says: Hello");
                System.out.println("Message sent to client.");
                writer.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}