import java.io.*;
import java.net.*;
public class TCPClient{
	public static void main(String args[]) throws Exception{
		String sentence;
		String modifiedSentence;
		System.out.println("Enter the sentence :");
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost",2345);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence+"\n");
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER : "+ modifiedSentence);
		clientSocket.close();
	}
}