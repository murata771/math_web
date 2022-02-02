package lisner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class tryLoginLisner
 *
 */
@WebListener
public class tryLoginLisner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public tryLoginLisner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	Integer logincounter=0;
    	Integer registcounter=0;
    	ServletContext app=sce.getServletContext();
    	app.setAttribute("logincounter", logincounter);
    	app.setAttribute("registcounter", registcounter);
    }
	
}
