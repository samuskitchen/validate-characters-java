package co.com;


import co.com.commands.CentralCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoMain {

	private static final Logger logger = LogManager.getLogger(DemoMain.class);

	private static final CentralCommand centralCommand = new CentralCommand();

	public static void main(String[] args) {
		logger.info("Init Process");
		centralCommand.executeMain("[({})]");
	}

}
