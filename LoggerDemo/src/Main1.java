import org.apache.log4j.*;

public class Main1 {
static Logger log = Logger.getLogger(Main1.class);
	
	public static void main(String[] args) {
		log.info("Welcome to Logger");
		log.debug("Debugging started!");
		log.warn("I warned you??");
		log.error("Dont ignore me! I am Error!!");
	}

}
