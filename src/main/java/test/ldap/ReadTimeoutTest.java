package test.ldap;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class ReadTimeoutTest {
	public static void testTestLdap() {
		DirContext ctx = null;
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put("com.sun.jndi.ldap.connect.timeout", "10000");
		// env.put("com.sun.jndi.ldap.read.timeout", "1000000");
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://noahwmtest.com.local:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "noahwmtest\\gyc7480");
		env.put(Context.SECURITY_CREDENTIALS, "qwer@4321");
		// String principal=authentication.getPrincipal().toString();
		// if("xhy9448".equals(principal)){
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(sdf.format(now) + " test log begin,ldap begin...................");
		System.out.println("ldapProviderUrl:" + env.get(Context.INITIAL_CONTEXT_FACTORY));
		System.out.println("PROVIDER_URL:" + env.get(Context.PROVIDER_URL));
		System.out.println("SECURITY_AUTHENTICATION:" + env.get(Context.SECURITY_AUTHENTICATION));
		System.out.println("SECURITY_PRINCIPAL:" + env.get(Context.SECURITY_PRINCIPAL));
		System.out.println("SECURITY_CREDENTIALS:" + env.get(Context.SECURITY_CREDENTIALS));
		System.out.println("test log end ...................");
		// }
		try {
			ctx = new InitialDirContext(env);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void testLdap() {
		DirContext ctx = null;
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put("com.sun.jndi.ldap.connect.timeout", "10000");
		// env.put("com.sun.jndi.ldap.read.timeout", "1000000");
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://noahwm.com.local:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "noahwm\\gyc7480");
		env.put(Context.SECURITY_CREDENTIALS, "Gaoxing2017");
		// String principal=authentication.getPrincipal().toString();
		// if("xhy9448".equals(principal)){
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(sdf.format(now) + " test log begin,ldap begin...................");
		System.out.println("ldapProviderUrl:" + env.get(Context.INITIAL_CONTEXT_FACTORY));
		System.out.println("PROVIDER_URL:" + env.get(Context.PROVIDER_URL));
		System.out.println("SECURITY_AUTHENTICATION:" + env.get(Context.SECURITY_AUTHENTICATION));
		System.out.println("SECURITY_PRINCIPAL:" + env.get(Context.SECURITY_PRINCIPAL));
		System.out.println("SECURITY_CREDENTIALS:" + env.get(Context.SECURITY_CREDENTIALS));
		System.out.println("test log end ...................");
		// }
		try {
			ctx = new InitialDirContext(env);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		//testTestLdap();
	    testServer();
	}

	private static void testServer() {
		boolean passed = false;
		// Set up the environment for creating the initial context
		Hashtable env = new Hashtable(11);
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		// env.put("com.sun.jndi.ldap.connect.timeout", "1000");
		env.put("com.sun.jndi.ldap.read.timeout", "200");
		env.put(Context.PROVIDER_URL, "ldap://10.21.21.189:4700");
		// env.put("com.sun.jndi.ldap.connect.timeout", "10000");
		Server s = new Server();
		try {
			// start the server
			//s.start();
			// Create initial context
			DirContext ctx = new InitialDirContext(env);
			System.out.println("LDAP Client: Connected to the Server");
			// Close the context when we're done
			// ctx.close();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		// s.interrupt();
	}

	static class Server extends Thread {

		static int serverPort = 2001;

		Server() {
		}

		public void run() {
			try {
				ServerSocket serverSock = new ServerSocket(serverPort);
				Socket socket = serverSock.accept();
				System.out.println("Server: Connection accepted");
				BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
				while (true) {
					char c = (char) bin.read();
					System.out.println(c);
				}
			} catch (IOException e) {
				// ignore
			}
		}
	}
}