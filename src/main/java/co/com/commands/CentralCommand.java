package co.com.commands;

import co.com.domain.TypeException;
import co.com.domain.TypeNotContainException;
import co.com.domain.TypeNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CentralCommand {

    private static final Logger logger = LogManager.getLogger(CentralCommand.class);

    private static final String INITIAL_ONE = "[";
    private static final String INITIAL_TWO = "(";
    private static final String INITIAL_THREE = "{";

    private static final String CLOSING_ONE = "]";
    private static final String CLOSING_TWO = ")";
    private static final String CLOSING_THREE = "}";

    public void executeMain(String variable) {
        logger.info("Init Execution");

        if(variable.isEmpty()){
            logger.error("No types found");
            throw new TypeNotContainException("No types found");
        }

        String[] types = variable.split("");
        List<String> open = new ArrayList<>();

        Map<String, String> mapInitial = new HashMap<>() {{
            put("key1", INITIAL_ONE);
            put("key2", INITIAL_TWO);
            put("key3", INITIAL_THREE);
        }};

        Map<String, String> mapClosing = new HashMap<>() {{
            put("key1", CLOSING_ONE);
            put("key2", CLOSING_TWO);
            put("key3", CLOSING_THREE);
        }};

        if (types.length > 0) {
            for (int i = 0; i < types.length; i++) {
                if (mapInitial.containsValue(types[i])) {
                    logger.info("validate initial");
                    logger.info("value initial : {}", types[i]);
                    open.add(types[i]);
                } else if (mapClosing.containsValue(types[i])) {
                    logger.info("value closing : {}", types[i]);
                    if (!open.isEmpty() && validateType(types[i], open)) {
                        logger.info("delete initial in list");
                        open.remove(open.size() - 1);
                    } else {
                        logger.error("different types");
                        throw new TypeException("different types");
                    }
                }
            }

            if (!open.isEmpty()) {
                logger.error("No more types found");
                throw new TypeNotFoundException("No more types found");
            }
        }else{
            logger.error("No types found");
            throw new TypeNotContainException("No types found");
        }
    }

    private static boolean validateType(String type, List<String> open) {

        if (open.get(open.size() - 1).equals(INITIAL_ONE) && type.equals(CLOSING_ONE)) {
            return true;
        }

        if (open.get(open.size() - 1).equals(INITIAL_TWO) && type.equals(CLOSING_TWO)) {
            return true;
        }

        if (open.get(open.size() - 1).equals(INITIAL_THREE) && type.equals(CLOSING_THREE)) {
            return true;
        }

        return false;
    }

}