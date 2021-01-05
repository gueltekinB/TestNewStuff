import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
    }

    public static void createProperties(){
        Properties properties = new Properties();
        properties.setProperty("Name", "Berkay");
        properties.setProperty("Number", "0784016208");

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("test.properties"))){
            properties.store(writer, "Test Comment");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void createPropertiesAsXML(){
        Properties properties = new Properties();
        properties.setProperty("Name", "Berkay");
        properties.setProperty("Number", "+41784016208");


        try(OutputStream bufferedOutputStream = Files.newOutputStream(Paths.get("test.xml"))){
            properties.storeToXML(bufferedOutputStream, "This is XML");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadPropertiesFrom() throws IOException {
        Properties properties = new Properties();
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("test.properties"))){
            properties.load(bufferedReader);
            System.out.println(properties.getProperty("Name"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadPropertiesFromXML() throws IOException {
        Properties properties = new Properties();
        try(InputStream inputStream = Files.newInputStream(Paths.get("test.xml"))){
            properties.loadFromXML(inputStream);
            System.out.println(properties.getProperty("Name"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
