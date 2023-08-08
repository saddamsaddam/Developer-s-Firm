package proxiserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSideProgram {

  //initialize socket and input stream
   Socket socket ;
   ServerSocket server ;
  DataInputStream in ;
  DataOutputStream out;

  // constructor with port
  public ServerSideProgram(int port) {
    // starts server and waits for a connection
    try {
      server = new ServerSocket(port);
      System.out.println("Server started::");

      System.out.println("Waiting for a client ........");

      socket = server.accept();
      System.out.println("Client accepted.");

      // takes input from the client socket
      in = new DataInputStream(
          new BufferedInputStream(socket.getInputStream()));
          System.out.println(in.readUTF());
      String line = "";
      

      // reads message from client until "Done" is sent
      while (!line.equals("Done")) {
        try {
          line = in.readUTF();
          System.out.println(line);

        } catch (IOException i) {
          System.out.println(i);
        }
      }
      System.out.println("Closing connection");

      // close connection
      socket.close();
      in.close();
    } catch (IOException i) {
      System.out.println(i);
    }
  }

  public static void main(String args[]) {
    ServerSideProgram serverSideProgram = new ServerSideProgram(5000);
  }

}
