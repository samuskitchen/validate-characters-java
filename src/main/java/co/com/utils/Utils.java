package co.com.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Utils {
	
	private Utils() {}
	
	private static  Map<String, String> mapOpeningSymbol = new HashMap<>();
	private static  Map<String, String> mapClosingymbol = new HashMap<>();
	private static  Map<String, String> mapRelationSymbol = new HashMap<>();
	
    private static final String INITIAL_ONE = "[";
    private static final String INITIAL_TWO = "(";
    private static final String INITIAL_THREE = "{";

    private static final String CLOSING_ONE = "]";
    private static final String CLOSING_TWO = ")";
    private static final String CLOSING_THREE = "}";
	
	static {		
        mapOpeningSymbol.put("key1", INITIAL_ONE);
        mapOpeningSymbol.put("key2", INITIAL_TWO);
        mapOpeningSymbol.put("key3", INITIAL_THREE);
        mapClosingymbol.put("key1", CLOSING_ONE);
        mapClosingymbol.put("key2", CLOSING_TWO);
        mapClosingymbol.put("key3", CLOSING_THREE);
        mapRelationSymbol.put(INITIAL_ONE, CLOSING_ONE);
        mapRelationSymbol.put(INITIAL_TWO, CLOSING_TWO);
        mapRelationSymbol.put(INITIAL_THREE, CLOSING_THREE);
	}
	
	public static boolean isAOpenSymbol(String value) {
		return mapOpeningSymbol.containsValue(value);		
	}
	
	public static boolean isACloseSymbol(String value) {
		return mapClosingymbol.containsValue(value);		
	}
	
    public static boolean validateType(String closeSymbol, List<String> open) {
    	int lastIndex = open.size() - 1;
    	String lastType = open.get(lastIndex);
    	return mapRelationSymbol.get(lastType).equals(closeSymbol);
    }

}
