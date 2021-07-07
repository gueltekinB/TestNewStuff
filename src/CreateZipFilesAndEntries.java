import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipFilesAndEntries {
    public static void main(String[] args) throws IOException {
        // Create an archive
        FileOutputStream zipFile = new FileOutputStream("c:/archive.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //Put a ZipEntry into it
        zip.putNextEntry(new ZipEntry("document.txt"));

        //Copy the file «document-for-archive.txt» to the archive under the name «document.txt»
        File file = new File("c:/document-for-archive.txt");
        Files.copy(file.toPath(), zip);

        // Close the archive
        zip.close();
    }
}
