import java.io.IOException;
import java.util.logging.*;


/*
1. Setting Log level for Handler and Logger
2. Creating Formatter to populate the log data to the home directory
 */
public class LoggingInJava {
    static Logger logger = Logger.getLogger(LoggingInJava.class.getName());

    public static void main(String[] args) throws IOException {


        // With the set Level method, can you determine till which Logging level should be logged
        // in order to see it in the console, a console handler is needed.
        Handler handler = new FileHandler("%h/myapp_%g.log", 1000, 4);
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.FINER);
        logger.addHandler(handler);

        logger.log(Level.FINE, "Test Fine");
        logger.log(Level.SEVERE, "nix");
        // with the logp method can be specified the package name, the source Method and the message name
        logger.logp(Level.SEVERE, "com.package.name", "MethodName", "Message");
    }
}
