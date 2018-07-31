package test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client1 {
	public static void main(String[] args) {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress(9010));
			String newData = "New String to write to file..." + System.currentTimeMillis();
			int length = newData.getBytes().length;
			System.out.println(length);
			ByteBuffer byteBuffer = ByteBuffer.allocate(length);
			byteBuffer.clear();
			byteBuffer.put(newData.getBytes());
			byteBuffer.flip();
			while(byteBuffer.hasRemaining()){
				socketChannel.write(byteBuffer);
			}
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
