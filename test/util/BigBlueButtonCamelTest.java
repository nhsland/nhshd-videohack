package util;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;


public class BigBlueButtonCamelTest extends CamelTestSupport{


	public void setUp() throws Exception {
    	super.setUp();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new CamelRoutes();
    }

    @Test
    public void testCallRESTApi() throws Exception {
        // create a new file in the inbox folder with the name hello.txt and containing Hello World as body
        template.sendBody("direct:apiinput","create");
        // wait a while to let the file be moved
        Thread.sleep(2000);

        //String content = context.getTypeConverter().convertTo(String.class, target);
        String content = "boo";
        assertEquals("Hello World", content);
    }

	
	
	
}
