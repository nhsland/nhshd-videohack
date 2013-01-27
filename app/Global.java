import play.Application;
import play.GlobalSettings;
import play.Logger;
import util.CamelContainer;

public class Global extends GlobalSettings {
	
	  private CamelContainer camelContainer;
	
	 @Override
	  public void onStart(Application app) {
	    Logger.info("Application has started - t4 - start a camel Instance singleton");
	    camelContainer = CamelContainer.getInstance();
	    
	  }  
	  
	  @Override
	  public void onStop(Application app) {
	    Logger.info("Application shutdown... - t4");
	    camelContainer = null;
	  }  	

}
