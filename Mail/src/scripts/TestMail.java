package scripts;

import java.net.Authenticator;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;

public class TestMail {

	public static void main(String arg[]){
		getCount();
	}
	
	public static void getCount(){
		Properties props = new Properties();
	    props.put("mail.pop3.host" , "pop.gmail.com");
	    //
	    props.put("mail.pop3.socketFactory.class" , "javax.net.ssl.SSLSocketFactory" );
	    props.put("mail.pop3.port" , 995);
	    
	    Session emailSession = Session.getDefaultInstance(props);
	    try {
	        Store store  = emailSession.getStore("pop3");
	        store.connect("pop.gmail.com" , "TestLeaf001@gmail.com" , "Testleaf123");
	        Folder ibox = store.getFolder("INBOX");
	        ibox.open(Folder.HOLDS_MESSAGES);
	        int count = ibox.getMessageCount();
	        System.out.println("The number of emails are: "+count);
	        System.out.println("The top email subject is: "+ibox.getMessages()[2].getSubject());
	        System.out.println(ibox.getMessages()[3].getContent());
	        
	    } catch(Exception exc) {
	        System.out.println(exc + " error");
	    }
	}
}
