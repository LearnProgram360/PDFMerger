package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PDFMerger {
    public static void main(String[] args) {
        // Print the current working directory
        System.out.println("Current working directory: " + new File(".").getAbsolutePath());

        // List of input PDF files to be merged
        List<String> pdfFiles = Arrays.asList("src\\main\\java\\org\\example\\Jun_2024.pdf", "src\\main\\java\\org\\example\\Jul_2024.pdf", "src\\main\\java\\org\\example\\Aug_2024.pdf");

        // Output file name
        String mergedFile = "src\\main\\java\\org\\example\\Jun_To_Aug.pdf";

        // Create PDFMergerUtility instance
        PDFMergerUtility pdfMerger = new PDFMergerUtility();

        try {
            // Add each PDF file to the merger
            for (String pdf : pdfFiles) {
                pdfMerger.addSource(new File(pdf));
            }

            // Set the destination for the merged PDF
            pdfMerger.setDestinationFileName(mergedFile);

            // Merge the PDFs
            pdfMerger.mergeDocuments(null);

            System.out.println("PDFs merged successfully into " + mergedFile);
        } catch (IOException e) {
            System.err.println("Error while merging PDFs: " + e.getMessage());
        }
    }
}
