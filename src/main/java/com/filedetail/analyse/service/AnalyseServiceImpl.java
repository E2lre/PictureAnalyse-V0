package com.filedetail.analyse.service;

import ch.qos.logback.core.property.FileExistsPropertyDefiner;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.tiff.TiffMetadataReader;
import com.drew.imaging.tiff.TiffProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.iptc.IptcReader;
import com.filedetail.analyse.model.FileInfo;
import com.filedetail.analyse.model.FileProperty;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.*;

//import static jdk.nashorn.internal.objects.Global.println;

@Service
public class AnalyseServiceImpl implements AnalyseService {
    @Override
    public FileInfo getFileInfo(String fileName, String filePath) {
        FileInfo resultFileInfo = new FileInfo();

      //  LIRE CELA https://askcodez.com/comment-lire-jpeg-attributs-de-fichier-avec-java.html
    // https://github.com/drewnoakes/metadata-extractor

 /*       //FileDescriptor
        Proper
        File file = new File(filePath+fileName);
        if (file.exists())
        {
            String[] tableau = file.list();
            resultFileInfo.setDetailList(file.list());
        }



        return resultFileInfo;
    }

  */

        //Path path = Paths.get("c:/test.txt");
/*        Path path = Paths.get("E:/Image E/Pictures/2021-03-Mars/2021-Mars-DSC_0089.jpg");

        try {
            Map<String, Object> attrsMap = Files.readAttributes(path, "*");
            Set<String> keys = attrsMap.keySet();
            for (String attribute : keys) {
                System.out.println(attribute + ": " + Files.getAttribute(path, attribute));
            }
        } catch (Exception err) {
            err.printStackTrace();
            return resultFileInfo;
        }*/

        //Path imagePath = Paths.get("E:/Image E/Pictures/2021-03-Mars/2021-Mars-DSC_0089.jpg");

        //String fullFileName="E:/Image E/Pictures/2021-03-Mars/2021-Mars-DSC_0089.jpg";
        //String fullFileName="E:/Image E/Pictures/2021-03-Mars/Master-mars-2021/2021-Mars-DCS_9247.NEF";
        String fullFileName="D:/Image E/Pictures/2021-03-Mars/Master-mars-2021/2021-Mars-DSC_0654.NEF";
        File file = new File(fullFileName);
        // SCENARIO 1: UNKNOWN FILE TYPE
        //
        // This is the most generic approach.  It will transparently determine the file type and invoke the appropriate
        // readers.  In most cases, this is the most appropriate usage.  This will handle JPEG, TIFF, GIF, BMP and RAW
        // (CRW/CR2/NEF/RW2/ORF) files and extract whatever metadata is available and understood.
        //
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            print(metadata, "Using ImageMetadataReader");
            String result = metadata.toString();
        } catch (ImageProcessingException e) {
            print(e);
        } catch (IOException e) {
            print(e);
        }

        //
        // SCENARIO 2: SPECIFIC FILE TYPE
        //
        // If you know the file to be a JPEG, you may invoke the JpegMetadataReader, rather than the generic reader
        // used in approach 1.  Similarly, if you knew the file to be a TIFF/RAW image you might use TiffMetadataReader,
        // PngMetadataReader for PNG files, BmpMetadataReader for BMP files, or GifMetadataReader for GIF files.
        //
        // Using the specific reader offers a very, very slight performance improvement.
        //
        try {
            Metadata metadata = TiffMetadataReader.readMetadata(file);

            print(metadata, "Using TiffMetadataReader");
        } catch (IOException e) {
            print(e);
        } catch (TiffProcessingException e) {
            e.printStackTrace();
            print(e);
        }

        //
        // APPROACH 3: SPECIFIC METADATA TYPE
        //
        // If you only wish to read a subset of the supported metadata types, you can do this by
        // passing the set of readers to use.
        //
        // This currently only applies to JPEG file processing.
        //
 /*       try {
            // We are only interested in handling
            Iterable<JpegSegmentMetadataReader> readers = Arrays.asList(new ExifReader(), new IptcReader());

            Metadata metadata = JpegMetadataReader.readMetadata(file, readers);

            print(metadata, "Using JpegMetadataReader for Exif and IPTC only");
        } catch (JpegProcessingException e) {
            print(e);
        } catch (IOException e) {
            print(e);
        }
*/


/*        UserDefinedFileAttributeView view =
                Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        String name = "Copyright";
        ByteBuffer buf = ByteBuffer.allocate(view.size(name));
        view.read(name, buf);
        buf.flip();
        String value = Charset.defaultCharset().decode(buf).toString();*/
        /*
        UserDefinedFileAttributeView basicView = Files.getFileAttributeView(path,
                UserDefinedFileAttributeView.class);
        if (basicView != null) {
            UserDefinedFileAttributeView basic = basicView. .readAttributes();

            System.out.println("isRegularfile    " + basic.isRegularFile());
            System.out.println("isDirectory      " + basic.isDirectory());
            System.out.println("isSymbolicLink   " + basic.isSymbolicLink());
            System.out.println("isOther          " + basic.isOther());
            System.out.println("size             " + basic.size());
            System.out.println("creationTime     " + basic.creationTime());
            System.out.println("lastAccesstime   " + basic.lastAccessTime());
            System.out.println("lastModifiedTime " + basic.lastModifiedTime());*/

   /* //https://java.developpez.com/faq/javaio?page=Gestion-des-fichiers#Comment-obtenir-les-attributs-d-un-fichier
      BasicFileAttributeView basicView = Files.getFileAttributeView(path,
                BasicFileAttributeView.class);
        if (basicView != null) {
            BasicFileAttributes basic = basicView.readAttributes();

            System.out.println("isRegularfile    " + basic.isRegularFile());
            System.out.println("isDirectory      " + basic.isDirectory());
            System.out.println("isSymbolicLink   " + basic.isSymbolicLink());
            System.out.println("isOther          " + basic.isOther());
            System.out.println("size             " + basic.size());
            System.out.println("creationTime     " + basic.creationTime());
            System.out.println("lastAccesstime   " + basic.lastAccessTime());
            System.out.println("lastModifiedTime " + basic.lastModifiedTime());*/

        return resultFileInfo;
    }

    @Override
    public List<String> getInfoAnalyse(String fileName, String filePath) {
        //String fullFileName="D:/Image E/Pictures/2021-03-Mars/Master-mars-2021/2021-Mars-DSC_0654.NEF";
        String fullFileName=fileName+"/"+filePath;
        File file = new File(fullFileName);
        // SCENARIO 1: UNKNOWN FILE TYPE
        //
        // This is the most generic approach.  It will transparently determine the file type and invoke the appropriate
        // readers.  In most cases, this is the most appropriate usage.  This will handle JPEG, TIFF, GIF, BMP and RAW
        // (CRW/CR2/NEF/RW2/ORF) files and extract whatever metadata is available and understood.
        //
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            return readProperties(metadata, "Using ImageMetadataReader");

        } catch (ImageProcessingException e) {
            print(e);
        } catch (IOException e) {
            print(e);
        }


        return null;
    }

    /**
     * Write all extracted values to stdout.
     */
    private static void print(Metadata metadata, String method)
    {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.print(' ');
        System.out.print(method);
        System.out.println("-------------------------------------------------");
        System.out.println();

        //
        // A Metadata object contains multiple Directory objects
        //
        for (Directory directory : metadata.getDirectories()) {

            //
            // Each Directory stores values in Tag objects
            //
            for (Tag tag : directory.getTags()) {
                System.out.println(tag);
            }

            //
            // Each Directory may also contain error messages
            //
            for (String error : directory.getErrors()) {
                System.err.println("ERROR: " + error);
            }
        }
    }

    private static List<String> readProperties(Metadata metadata, String method)
    {
        List<String> resultList = new ArrayList<>();

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.print(' ');
        System.out.print(method);
        System.out.println("-------------------------------------------------");
        System.out.println();

        //
        // A Metadata object contains multiple Directory objects
        //
        for (Directory directory : metadata.getDirectories()) {

            //
            // Each Directory stores values in Tag objects
            //
            for (Tag tag : directory.getTags()) {
                System.out.println(tag);
                resultList.add(tag.toString());
            }

            //
            // Each Directory may also contain error messages
            //
            for (String error : directory.getErrors()) {
                System.err.println("ERROR: " + error);
                resultList.add("ERROR: " + error);
            }
        }
        return resultList;
    }

    private static void print(Exception exception)
    {
        System.err.println("EXCEPTION: " + exception);
    }
}