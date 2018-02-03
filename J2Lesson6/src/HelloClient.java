/**
 * Write a description of class HelloClient here.
 *
 * @author Volsky Nikita
 * @version dated 16.01.2018
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */

import java.net.*;
import java.io.*;

class HelloClient {

    public static void main(String[] args) {
        new HelloClient();
    }

    HelloClient() {
        try (Socket socket = new Socket("localhost", 1024);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println(reader.readLine());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}