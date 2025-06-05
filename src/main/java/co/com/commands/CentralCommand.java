package co.com.commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.domain.TypeException;
import co.com.domain.TypeNotContainException;
import co.com.domain.TypeNotFoundException;
import static co.com.utils.Utils.isACloseSymbol;
import static co.com.utils.Utils.isAOpenSymbol;
import static co.com.utils.Utils.validateType;

public class CentralCommand {

	private static final Logger logger = LogManager.getLogger(CentralCommand.class);

	public void executeMain(String variable) {
		logger.info("Init Execution");
		evalEmptyType(variable);
		evalNonEmptyTypes(variable);		
	}

	private void evalNonEmptyTypes(String variable) {
		String[] types = variable.split("");
		List<String> open = new ArrayList<>();
		for (String type : types) {
			if (isAOpenSymbol(type)) {
				logger.info("validate initial");
				logger.info("value initial : {}", type);
				open.add(type);
			} else if (isACloseSymbol(type)) {
				evalSymbolIntegrity(open, type);
			}
		}		
		evalOpenSymbolRemain(open);		
	}

	private void evalSymbolIntegrity(List<String> open, String type) {
		if (!open.isEmpty() && validateType(type, open)) {
			logger.info("delete initial in list");
			open.remove(open.size() - 1);
		} else {
			logger.error("different types");
			throw new TypeException("different types");
		}
	}

	private void evalOpenSymbolRemain(List<String> open) {
		if (!open.isEmpty()) {
			logger.error("No more types found");
			throw new TypeNotFoundException("No more types found");
		}
	}

	private void evalEmptyType(String variable) {
		if (variable.isEmpty()) {
			logger.error("No types found");
			throw new TypeNotContainException("No types found");
		}
	}

}