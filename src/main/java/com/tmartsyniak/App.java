package com.tmartsyniak;

public class App {
    public static final String DEST = "/Users/tarasmartsyniak/Desktop/test.pdf";
    public static final String HTML = "/Users/tarasmartsyniak/Desktop/test.htm";
    public static final String CSS = "/Users/tarasmartsyniak/Desktop/test_files/simongrant.css";

//    public static void main(String[] args) {
//
//        FileInputStream input = null;
//        String htmlFileName = HTML;
//        try {
//            input = new FileInputStream(htmlFileName);
//        } catch (java.io.FileNotFoundException e) {
//            System.out.println("File not found: " + htmlFileName);
//
//        }
//
////        Document parsedDocument = Jsoup.parse(new File(HTML), Charset.defaultCharset().name());
////        Document parsedDocument = Jsoup.parse(url, 5000);
////        parsedDocument.outputSettings().syntax(Syntax.xml);
//
//        Tidy tidy = new Tidy();
//        Document xmlDoc = tidy.parseDOM(input, null);
//
//        Document foDoc = xml2FO(xmlDoc, null);
//        try {
//            OutputStream pdf = new FileOutputStream(new File(DEST));
//            pdf.write(fo2PDF(foDoc));
//        } catch (java.io.FileNotFoundException e) {
//            System.out.println("Error creating PDF: " + DEST);
//        } catch (java.io.IOException e) {
//            System.out.println("Error writing PDF: " + DEST);
//        }
//
//    }
//
//    private static Document xml2FO(Document xml, String styleSheet) {
//
//        DOMSource xmlDomSource = new DOMSource(xml);
//        DOMResult domResult = new DOMResult();
//
////        Transformer transformer = getTransformer(styleSheet);
////
////        if (transformer == null) {
////            System.out.println("Error creating transformer for " + styleSheet);
////            System.exit(1);
////        }
////        try {
////            transformer.transform(xmlDomSource, domResult);
////        }
////        catch (javax.xml.transform.TransformerException e) {
////            return null;
////        }
//        return (Document) domResult.getNode();
//
//    }
//
//    private static byte[] fo2PDF(Document foDocument) {
//
//        DocumentInputSource fopInputSource = new DocumentInputSource(foDocument);
//
//        try {
//
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            Logger log = new ConsoleLogger(ConsoleLogger.LEVEL_WARN);
//
//            Driver driver = new Driver(fopInputSource, out);
//            driver.setLogger(log);
//            driver.setRenderer(Driver.RENDER_PDF);
//            driver.run();
//
//            return out.toByteArray();
//
//        } catch (Exception ex) {
//            return null;
//        }
//    }
}
