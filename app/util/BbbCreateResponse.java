package util;

import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.language.XPath;
import org.w3c.dom.Document;

public class BbbCreateResponse {
	
	@Handler
	public String response(@XPath("response/meetingID") String status) {
		
		return status;
	}

}
