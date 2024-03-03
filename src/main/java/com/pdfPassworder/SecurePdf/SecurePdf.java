package com.pdfPassworder.SecurePdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.File;
import java.util.Scanner;

public class SecurePdf {

    public static void secure() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Podaj sciezke do pdfa np: C:\\Users\\mateu\\OneDrive\\Obrazy\\ControlCenter4\\Scan\\mojPdf.pdf");
            String pathToPdf = scanner.nextLine();

            PDDocument document = PDDocument.load(new File(pathToPdf));

            AccessPermission accessPermission = new AccessPermission();
            System.out.println("Podaj haslo do pdfa");
            String passwordToPdf = scanner.nextLine();
            StandardProtectionPolicy spp = new StandardProtectionPolicy(passwordToPdf, passwordToPdf, accessPermission);

            spp.setEncryptionKeyLength(128);
            spp.setPermissions(accessPermission);
            document.protect(spp);

            System.out.println("Haslo zapisane. Plik się teraz zapisze w tej samej sciezce");

            String newPdf = pathToPdf.substring(0, pathToPdf.length() - 4).concat("WithPassword").concat(".pdf");
            document.save(newPdf);
            document.close();
            System.out.println("Nowo powstaly plik to: " + newPdf);
            System.out.println("Dokument zostal zabezpieczony.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
