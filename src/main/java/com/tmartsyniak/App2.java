package com.tmartsyniak;

import org.apache.fop.apps.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class App2 {

    public static final String DEST = "/Users/tarasmartsyniak/Desktop/test.pdf";
    public static final String HTML = "/Users/tarasmartsyniak/Desktop/test3.htm";
    public static final String XSL = "/Users/tarasmartsyniak/Desktop/xhtml-to-xslfo.xsl";

    private static File createTempFile(String content) throws IOException {
        Path path = Files.createTempFile("sample-file", ".xml");
        File file = path.toFile();
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        file.deleteOnExit();
        return file;
    }

    public static void main(String[] args) throws Exception {
        FileOutputStream outputStream = new FileOutputStream(DEST);
        File templateFile = new File(XSL);
        File sourceFile = new File(HTML);

        Document parsedDocument = Jsoup.parse(sourceFile, StandardCharsets.UTF_8.name());
        parsedDocument.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);


        final Source xmlSource = new StreamSource(createTempFile(parsedDocument.html()));
        final Source sourceTemplate = new StreamSource(templateFile);

        FopFactoryBuilder builder = new FopFactoryBuilder(new URI("http://google.com"));
        builder.setSourceResolution(96);
        FopFactory fopFactory = builder.build();

        final FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        Fop fop;
        try {
            fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outputStream);


            final TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(sourceTemplate);

            final Result result = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, result);

            outputStream.flush();

        } catch (final Exception exp) {
            throw new RuntimeException("Error creating PDF", exp);
        }
    }
}
