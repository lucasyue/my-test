package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class Client1 {

	public static void main(String[] args) {
		write();
	}

	private static void write() {
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 4700);
			BufferedReader localIn = new BufferedReader(new InputStreamReader(System.in,Charset.forName("gbk")));
			PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String readline = null;
			//只发不收，只收不发，边发变收
			readline = localIn.readLine();
			while (!readline.equals("bye")) {
				socketOut.println(readline);
				socketOut.flush();
				System.out.println("localIn:" + readline);
				// 在系统标准输出上打印读入的字符串
				//System.out.println("Server:" + socketIn.readLine());
				// 从Server读入一字符串，并打印到标准输出上
				readline = localIn.readLine(); // 从系统标准输入读入一字符串
			}
			socketOut.close(); //关闭Socket输出流
            socketIn.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

