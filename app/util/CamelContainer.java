package util;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.Route;
import org.apache.camel.impl.DefaultCamelContext;

import play.Logger;

public class CamelContainer {
	
	private static final CamelContainer instance;
	private static final CamelContext ctx = new DefaultCamelContext();
	 
	  static {
	    try {
	      instance = new CamelContainer();
	    } catch (Exception e) {
	      throw new RuntimeException("Darn, an error occurred!", e);
	    }
	  }
	 
	  public static CamelContainer getInstance() {
	    return instance;
	  }
	 
	  private CamelContainer() throws Exception {
		ctx.addRoutes(new CamelRoutes());
		Logger.info("Added Camel Routes");
		List<Route> status = ctx.getRoutes();
		Logger.info("RouteCountOnAdd:" + status.size());
		ctx.start();
	 }

	  public ProducerTemplate getProducer(){
		  List<Route> status = ctx.getRoutes();
		  Logger.info("RouteCount:" + status.size());
		  return ctx.createProducerTemplate();
	  }

}
