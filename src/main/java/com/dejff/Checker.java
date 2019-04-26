package com.dejff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Checker {

    private FileInputStream fileInputStream;
    private DocumentBuilderFactory builderFactory;
    private DocumentBuilder builder;
    private Document xmlDocument;
    private XPath xPath;
    private Node node;
    private NodeList nodeList;
    String val;

    public String getNode(String xpathExpression, File file) {
        builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);

        try {
            builder = builderFactory.newDocumentBuilder();
            fileInputStream = new FileInputStream(file);
            xmlDocument = builder.parse(fileInputStream);
            xPath = XPathFactory.newInstance().newXPath();
            node = (Node) xPath.compile(xpathExpression).evaluate(xmlDocument, XPathConstants.NODE);
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku\n"+e.getMessage());
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        } catch (XPathExpressionException e){
            e.printStackTrace();
        }

        // System.out.println("node: "+node.toString());

        StringBuilder sb = new StringBuilder();
        NodeList nl = node.getChildNodes();
        for(int i=0; i<node.getChildNodes().getLength(); i++){
            // System.out.println(nl.item(i).getNodeName());
            sb.append(nl.item(i).getNodeName()).append("\n");
        }
        // for(Node n : node.getChildNodes()){
        //     sb.append(n.getNodeName()+"\n");
        // }
        // return sb.toString();

        return node.getTextContent();
        // return val;

        // return "Janusz Nosacz";
    }

}
