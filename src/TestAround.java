import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TestAround {
    public static void main(String[] args) throws IOException, URISyntaxException {

        try(FileSystem zipFS = openZip(Paths.get("myData.zip"))){

        }catch (Exception e){
            System.out.print(e.getClass().getSimpleName() + " - "  + e.getMessage());
        }
    }

    private static FileSystem openZip (Path zipPath) throws IOException, URISyntaxException{
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri, providerProps);

        return zipFs;
    }

    private static void copyToZip (FileSystem zipFS) throws IOException{

    }

    private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException{

    }

    private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException{

    }

}
