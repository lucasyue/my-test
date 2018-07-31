package test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server1 {

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.socket().bind(new InetSocketAddress(9010));
			serverChannel.configureBlocking(false);// accept立即返回
			ByteBuffer buf = ByteBuffer.allocate(43);
			while (true) {
				SocketChannel sc = serverChannel.accept();
				if (sc != null) {
					System.out.println("accept " + sc.socket().getRemoteSocketAddress());
					int bytesRead = sc.read(buf); // read into buffer.
					while (bytesRead != -1) {
						buf.flip(); // make buffer ready for read
						while (buf.hasRemaining()) {
							System.out.print((char) buf.get()); // read 1 byte
						}
						buf.clear(); // make buffer ready for writing
						bytesRead = sc.read(buf);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
