

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import internal.server.util.DefaultValues;

public class LogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LogTest l = new LogTest();
		l.test();
			
		
	}
	
	public void test() {
		Logger logger = LogManager.getLogger(DefaultValues.serverLog);
		
		logger.trace("trace level");
		logger.debug("debug level");
		logger.info("info level");
		logger.warn("warn level");
		logger.error("error level");
		logger.fatal("fatal level");
	}

}
