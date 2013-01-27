package util;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelRoutes extends RouteBuilder {

	private static final String BBB_SERVER = "192.168.190.194";
	private static final String BBB_SERVER_SALT = "cb357f07e25eaaa116dde56fd9411a6c";
	private static final String SMTP_SERVER = "<MYMAILSERVERHERE>";

    private BigBlueButton bbb_api;

	@Override
	public void configure() throws Exception {
    	bbb_api = new BigBlueButton(BBB_SERVER, BBB_SERVER_SALT);

		    from("direct:apiinput")
            .process(new Processor(){
            		@Override
            		public void process(Exchange exchange) throws Exception {
            			
            			String meetingID = exchange.getIn().getBody().toString();
						exchange.getIn().setHeader(Exchange.HTTP_URI, bbb_api.create(meetingID));
            			exchange.getIn().setHeader(Exchange.HTTP_METHOD, constant("GET"));
            		}
            	})
            .to("http://192.168.190.190").bean(BbbCreateResponse.class)
            .process(new Processor(){
				@Override
				public void process(Exchange exchange) throws Exception {
					
					String msg = exchange.getIn().getBody(String.class);
		  			Map<String, Object> map = new HashMap<String, Object>();
        			map.put("To", "mark@mark.com");
        			map.put("From", "steve@steve.com");
        			map.put("Subject", "You're meeting is approved");

        			String body = "Hello! Here is your msg:" + msg;
        			exchange.getIn().setBody(body);
        			exchange.getIn().setHeaders(map);
    			}
            })
            .to(String.format("smtp://%s", SMTP_SERVER));
            //.to("file:blarglebox");
        }
		
	}

