package util;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExchangeHeaderLogger implements Processor {

        @Override
        public void process(Exchange exchange) throws Exception {
                System.out.println("We just got: ");
                for (String header : exchange.getIn().getHeaders().keySet()) {
                        System.out.println("Header:" + header +" - object:" + exchange.getIn().getHeaders().get(header));
                }
        }
}
