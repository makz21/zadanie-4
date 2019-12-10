package pl.weeia.makz.zadanie4;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.parameter.Encoding;
import ezvcard.property.FormattedName;
import ezvcard.property.StructuredName;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class VCardUtils {

    private void generateVCard(String firstName, String lastName) {
        VCard vcard = new VCard();

        StructuredName n = new StructuredName();
        n.setFamily(lastName);
        n.setGiven(firstName);
        vcard.setStructuredName(n);

        FormattedName fn = vcard.setFormattedName(firstName + " " + lastName);
        //fn.getParameters().setEncoding(Encoding.QUOTED_PRINTABLE);
        fn.getParameters().setCharset("iso-8859-1");
        vcard.setFormattedName(fn);

        String str = Ezvcard.write(vcard).version(VCardVersion.V3_0).go();
        try {
            File f = new File("contact.vcf");
            FileOutputStream fop = new FileOutputStream(f);
            fop.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void responseWithVCardFile(String firstName, String lastName, HttpServletResponse response) {
        generateVCard(firstName, lastName);
        try {
            String filePathToBeServed = "/Users/makz/Desktop/Politechnika/Pkwu/zadanie-4/contact.vcf";
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=contact.vcf");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
