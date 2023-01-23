package Main;
import java.util.Random;
public class Main {

	public static void main(String[] args) {	
		String[] websites = { 
				"www.google.com"		,
				"www.facebook.com"		,
				"www.newyorktimes.com"	,
				"www.rtc.edu"			,
				"www.reddit.com"		,
				"www.msn.com"			,
				"www.outlook.com"		,
				"www.mail.google.com"	,
				"musescore.com"			,
				"google.com"			,
				"facebook.com"			,
				"fb.com"				,
				"newyorktimes.com"		,
				"rtc.edu"				,
				"reddit.com"			,
				"msn.com"				,
				"outlook.com"			,
				"mail.google.com"		,
				"musescore.com"			,
				
		};
		
		HTTPReq newReq 	= new HTTPReq	("/index.html" , "10.0.0.1", 0);
		HTTPReq newReq2 = new HTTPReq	("/dogs.html" , "10.0.0.9", 1);
		HTTPReq newReq3 = new HTTPReq	("/cats.html" , "10.0.0.23", 2);
		
		Queue<HTTPReq> newQueue = new Queue<HTTPReq>(newReq);
		
		newQueue.enqueue(newReq2);
		newQueue.enqueue(newReq3);
		
		Random rand = new Random();
		
		for(int i = 0; i < 512; i++) {
			String newIp = rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
			HTTPReq newRequest = new HTTPReq(websites[rand.nextInt(websites.length)], newIp, rand.nextInt(10));
			newQueue.enqueue(newRequest);
		}
		newQueue.searchAndRemove(new HTTPReq("/index.html" , "10.0.0.1", 2), (HTTPReq a, HTTPReq b) -> {
			if(b.UUID == 9) {
				System.out.println("REMOVING.... " + b);
				return true;
			}
			return false;
		});		
		while(newQueue.Iterator()) {
			System.out.println("ITERATOR : " + newQueue.getCurrentNode()._data);	
		}
		while(newQueue.getSize() > 0 ) {
			int nextInt = rand.nextInt(100);
			if(nextInt > 51) {
				String newIp = rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
				HTTPReq newRequest = new HTTPReq(websites[rand.nextInt(websites.length)], newIp, rand.nextInt(10));
				System.out.println("RECIEVING.... " + newRequest);
				System.out.println("Size = " + newQueue.getSize());
				newQueue.enqueue(newRequest);
			}
			if(nextInt < 50) {
				
				System.out.println("SERVED.... " + newQueue.dequeue()._data);
				System.out.println("Size = " + newQueue.getSize());
			}
			if(nextInt > 80) {
				newQueue.searchAndRemove(new HTTPReq("/index.html" , "10.0.0.1", 2), (HTTPReq a, HTTPReq b) -> {
					if(b.UUID == 9) {
						System.out.println("DELETING REQUEST...." + b);
						return true;
					}
					return false;
				});	
			}
		}
	}

}
