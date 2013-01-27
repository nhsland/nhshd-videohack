package util;

import static org.junit.Assert.*;

import org.apache.camel.ProducerTemplate;
import org.junit.Test;

public class CamelContainerTest {

	@Test
	public void CamelContainerRouteTest() {
		
		ProducerTemplate producer = CamelContainer.getInstance().getProducer();
		producer.sendBody("direct:apiinput","boo11");
		
		fail("Not yet implemented");
	}

}
