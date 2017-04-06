package echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyEchoServer {
	
	ServerSocket  server;
	int port = 5555;
	Socket  socket;
	
	public MyEchoServer() {
		
		try {
			server = new ServerSocket(port);
			socket = server.accept();
			
			BufferedReader buffr= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MyEchoServer();

	}

}
