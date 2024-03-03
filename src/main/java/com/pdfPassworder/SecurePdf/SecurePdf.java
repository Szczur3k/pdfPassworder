package com.pdfPassworder.SecurePdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.File;

public class SecurePdf {

    public void secure(String pathToPdf, String savePathPdf, String pdfName, String passwordToPdf) {
        try {
            PDDocument document = PDDocument.load(new File(pathToPdf));

            AccessPermission accessPermission = new AccessPermission();
            StandardProtectionPolicy spp = new StandardProtectionPolicy(passwordToPdf, passwordToPdf, accessPermission);

            spp.setEncryptionKeyLength(128);
            spp.setPermissions(accessPermission);
            document.protect(spp);

            String newPdf = pdfName.substring(0, pdfName.length() - 4).concat("Password").concat(".pdf");
            String newLocalizationPdf = savePathPdf.concat("\\").concat(newPdf);
            document.save(newLocalizationPdf);
            document.close();
        } catch (Exception e) {
            throw (new IllegalStateException("PDF zostal zle zapisany. Cos poszlo nie tak.", e));
        }
    }
}
