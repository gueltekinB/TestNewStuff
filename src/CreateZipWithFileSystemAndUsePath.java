import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class CreateZipWithFileSystemAndUsePath {
    public static void main(String[] args) {
        String[] data = {
                "Test1",
                "Test2",
                "Test3"
        };

        try (FileSystem zipFS = openZip(Paths.get("myData.zip"))) {
            copyToZip(zipFS);
            writeToFileInZip1(zipFS, data);
            writeToFileInZip2(zipFS, data);

        } catch (Exception e) {
            System.out.print(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);


        return FileSystems.newFileSystem(zipUri, providerProps);
    }

    private static void copyToZip(FileSystem zipFS) throws IOException {
        // The first param is to get from the root folder the resource and the second parameter is to where to store the resource in the zip file and the name
        Files.copy(Paths.get("file1.txt"), zipFS.getPath("/file1.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))) {
            for (String dats : data) {
                writer.write(dats);
                writer.newLine();
            }
        }

    }

    // Method doesn't work at the moment
    private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException {
        Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data),
                Charset.defaultCharset(), StandardOpenOption.CREATE);
    }

    private static void writeToTextFile() throws IOException {
        Path textToWrite = Paths.get("file1.txt");
        Files.write(textToWrite, "text".getBytes());
    }

}
