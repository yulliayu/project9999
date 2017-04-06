package echo.server;

import java.net.ServerSocket;
import java.net.Socket;

public class MyEchoServer {
	
	ServerSocket  server;
	int port = 5555;
	
	public MyEchoServer() {
		
	}

	public static void main(String[] args) {
		new MyEchoServer();

	}

}
