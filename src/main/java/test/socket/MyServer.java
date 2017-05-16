package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class MyServer extends Thread{
	
	public static void main(String[] args) {
		MyServer server = new MyServer();
		server.start();
	}
	
    ServerSocket server = null;
	@Override
	public void run() {
		readStream();
		super.run();
	}
	private void readStream() {
		try {
			server = new ServerSocket(4700);
			Socket socket = null;
			socket = server.accept();
			String line= null;
			BufferedReader socketClient = new BufferedReader(new InputStreamReader(socket.getInputStream(),Charset.forName("utf8")));
			PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
			BufferedReader localClientIn = new BufferedReader(new InputStreamReader(System.in));
			CharBuffer cbuf = CharBuffer.allocate(100);
			System.out.println("socketClient:"+socketClient.read(cbuf));
			line = localClientIn.readLine();
			//读取控制台的输入，写入socket输出流，然后从输入流读取一行数据（会阻塞）
			while(!"bye".equals(line)){
				//socketOut.println(line);
				//socketOut.flush();
				socketClient.read(cbuf);
				String cbufStr = cbuf.toString();
				if(cbufStr != null && cbufStr.length()>0)
				System.out.println("socketClient:"+cbuf.toString());
				//line = localClientIn.readLine();
			}
			socketOut.close();
			socketClient.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void readChar() {
		try {
			server = new ServerSocket(4700);
			Socket socket = null;
			socket = server.accept();
			String line= null;
			BufferedReader socketClient = new BufferedReader(new InputStreamReader(socket.getInputStream(),Charset.forName("gbk")));
			PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
			BufferedReader localClientIn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("socketClient:"+socketClient.read());
			line = localClientIn.readLine();
			//读取控制台的输入，写入socket输出流，然后从输入流读取一行数据（会阻塞）
			while(!"bye".equals(line)){
				//socketOut.println(line);
				//socketOut.flush();
				System.out.println("socketClient:"+socketClient.readLine());
				//line = localClientIn.readLine();
			}
			socketOut.close();
			socketClient.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}