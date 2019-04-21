package troubleShootSearch.util;

public class Logger {


	/**
	* Level 0: No Output
	* Level 1: To print all results to StdOut
	* Level 2: Print all Constructors of the products.
	* Level 3: Print after file read for a product is successful.
	* Level 4: To print all visitor constructors after successful file read from a product.

	 *
	 *
	 */
    // FIXME: Add more enum values as needed for the assignment
    public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR,NONE, RESULTS, VISITOR
                                   };

    private static DebugLevel debugLevel;


    // FIXME: Add switch cases for all the levels
    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	case 4: debugLevel = DebugLevel.VISITOR;break;
	case 3: debugLevel = DebugLevel.FILE_PROCESSOR;break;
	case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
	case 1: debugLevel = DebugLevel.RESULTS; break;
	default: debugLevel = DebugLevel.NONE; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
}

