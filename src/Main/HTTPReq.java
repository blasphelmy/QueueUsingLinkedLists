package Main;

public class HTTPReq {
	public String 	URL		;
	public String	ORG_IP	;
	public int		UUID	;
	public  HTTPReq(String URL, String OrgIP) {
		this.URL 	= URL;
		this.ORG_IP = OrgIP;
	}
	public  HTTPReq(String URL, String OrgIP, int UUID) {
		this.URL 	= URL;
		this.ORG_IP = OrgIP;
		this.UUID 	= UUID;
	}
	public  HTTPReq(String URL) {
		this.URL 	= URL;
	}
	public  HTTPReq(int UUID) {
		this.UUID 	= UUID;
	}
	public HTTPReq() { }
	public String toString() {
		return "URL = " + URL + " Originating IP = " + ORG_IP + " UUID = " + UUID;
	}
}
