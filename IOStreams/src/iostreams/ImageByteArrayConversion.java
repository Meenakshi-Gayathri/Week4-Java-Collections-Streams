package iostreams;

import java.io.*;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String sourceImage = "sourceImage.jpg";
        String destinationImage = "destinationImage.jpg";

        try {
            FileInputStream fis = new FileInputStream(sourceImage);
            byte[] imageBytes = new byte[fis.available()];
            fis.read(imageBytes);
            fis.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(destinationImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int data;
            while ((data = bais.read()) != -1) {
                baos.write(data);
            }

            fos.write(baos.toByteArray());
            fos.close();

            System.out.println("Image copied successfully from " + sourceImage + " to " + destinationImage);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

