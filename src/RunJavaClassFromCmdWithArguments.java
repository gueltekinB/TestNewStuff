import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class RunJavaClassFromCmdWithArguments {
    private static Logger LOGGER = Logger.getLogger("RunJavaClassFromCmdWithArguments");

    public static void main(String[] args) {
        if (args.length == 0) {
            LOGGER.info("Provide a fileName");
            return;
        }

        String fileName = args[0];
        if (!Files.exists(Paths.get(fileName))) {
            LOGGER.info("File not found " + fileName);
        }

        printFile(fileName);
    }

    private static void printFile(String fileName) {

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
