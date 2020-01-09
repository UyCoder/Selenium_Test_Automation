package com.seleniummaster.tika.parser.hello;

import jdk.internal.org.xml.sax.SAXException;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.language.LanguageIdentifier;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.apache.tika.sax.ToXMLContentHandler;
import org.apache.tika.sax.XHTMLContentHandler;
import org.apache.tika.sax.xpath.Matcher;
import org.apache.tika.sax.xpath.MatchingContentHandler;
import org.apache.tika.sax.xpath.XPathParser;
import org.xml.sax.ContentHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmet Bughra
 * @create 2020-01-09-8:02 PM
 * @email bughra1991@gmail.com
 */
public class TikaDemo {
    private static final int MAXIMUM_TEXT_CHUNK_SIZE = 15;

    //The Tika facade, provides a number of very quick and easy ways to have your content parsed by Tika, and return the resulting sun.net.www.content.text.plain text
    public String parseToStringExample() throws IOException, SAXException, TikaException {
        Tika tika = new Tika();
        try (InputStream stream = ParsingExample.class.getResourceAsStream("test.doc")) {
            return tika.parseToString(stream);
        }
    }

    //Parsing using the Auto-Detect Parser
//    For more control, you can call the Tika Parsers directly. Most likely, you'll want to start out using the Auto-Detect Parser, which automatically figures out what kind of content you have, then calls the appropriate parser for you.
    public String parseExample() throws IOException, SAXException, TikaException {
        AutoDetectParser parser = new AutoDetectParser();
        org.apache.tika.sax.BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try (InputStream stream = ParsingExample.class.getResourceAsStream("test.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        return "";
    }
//Picking different output formats
//    With Tika, you can get the textual content of your files returned in a number of different formats. These can be plain text, html, xhtml, xhtml of one part of the file etc. This is controlled based on the ContentHandler you supply to the Parser.

    //Parsing to Plain Text
//    By using the BodyContentHandler, you can request that Tika return only the content of the document's body as a plain-text string.
    public String parseToPlainText() throws IOException, SAXException, TikaException {
        BodyContentHandler handler = new BodyContentHandler();

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = ContentHandlerExample.class.getResourceAsStream("test.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        return "";
    }
//    Parsing to XHTML

    //    By using the ToXMLContentHandler, you can get the XHTML content of the whole document as a string.
    public String parseToHTML() throws IOException, SAXException, TikaException, org.xml.sax.SAXException {
        ContentHandler handler = new ToXMLContentHandler();

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = ContentHandlerExample.class.getResourceAsStream("test.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        }
    }

    //    If you just want the body of the xhtml document, without the header, you can chain together a BodyContentHandler and a ToXMLContentHandler as shown:
    public String parseBodyToHTML() throws IOException, SAXException, TikaException {
        org.xml.sax.ContentHandler handler = new BodyContentHandler(
                new ToXMLContentHandler());

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = ContentHandlerExample.class.getResourceAsStream("test.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        return "";
    }
//    Fetching just certain bits of the XHTML

    //    It possible to execute XPath queries on the parse results, to fetch only certain bits of the XHTML.
    public String parseOnePartToHTML() throws IOException, SAXException, TikaException {
        // Only get things under html -> body -> div (class=header)
        XPathParser xhtmlParser = new XPathParser("xhtml", XHTMLContentHandler.XHTML);
        Matcher divContentMatcher = xhtmlParser.parse("/xhtml:html/xhtml:body/xhtml:div/descendant::node()");
        ContentHandler handler = new MatchingContentHandler(
                new ToXMLContentHandler(), divContentMatcher);

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = ContentHandlerExample.class.getResourceAsStream("test2.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        return "";
    }
//    Custom Content Handlers

//    The textual output of parsing a file with Tika is returned via the SAX ContentHandler you pass to the parse method. It is possible to customise your parsing by supplying your own ContentHandler which does special things.
//    Extract Phone Numbers from Content into the Metadata

//    By using the PhoneExtractingContentHandler, you can have any phone numbers found in the textual content of the document extracted and placed into the Metadata object for you.
//    Streaming the plain text in chunks

    //    Sometimes, you want to chunk the resulting text up, perhaps to output as you go minimising memory use, perhaps to output to HDFS files, or any other reason! With a small custom content handler, you can do that.
    public List<String> parseToPlainTextChunks() throws IOException, SAXException, TikaException, org.xml.sax.SAXException {
        final List<String> chunks = new ArrayList<>();
        chunks.add("");
        ContentHandlerDecorator handler = new ContentHandlerDecorator() {
            @Override
            public void characters(char[] ch, int start, int length) {
                String lastChunk = chunks.get(chunks.size() - 1);
                String thisStr = new String(ch, start, length);

                if (lastChunk.length() + length > MAXIMUM_TEXT_CHUNK_SIZE) {
                    chunks.add(thisStr);
                } else {
                    chunks.set(chunks.size() - 1, lastChunk + thisStr);
                }
            }
        };

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = ContentHandlerExample.class.getResourceAsStream("test2.doc")) {
            parser.parse(stream, handler, metadata);
            return chunks;
        }
    }
//    Translation

//    Tika provides a pluggable Translation system, which allow you to send the results of parsing off to an external system or program to have the text translated into another language.
//    Translation using the Microsoft Translation API

    //    In order to use the Microsoft Translation API, you need to sign up for a Microsoft account, get an API key, then pass the key to Tika before translating.
    public String microsoftTranslateToFrench(String text) {
        MicrosoftTranslator translator = new MicrosoftTranslator();
        // Change the id and secret! See http://msdn.microsoft.com/en-us/library/hh454950.aspx.
        translator.setId("dummy-id");
        translator.setSecret("dummy-secret");
        try {
            return translator.translate(text, "fr");
        } catch (Exception e) {
            return "Error while translating.";
        }
    }
//    Language Identification

    //    Tika provides support for identifying the language of text, through the LanguageIdentifier class.
    public String identifyLanguage(String text) {
        LanguageIdentifier identifier = new LanguageIdentifier(text);
        return identifier.getLanguage();
    }
}
