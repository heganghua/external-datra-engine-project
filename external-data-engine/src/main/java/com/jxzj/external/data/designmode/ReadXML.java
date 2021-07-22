package com.jxzj.external.data.designmode;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {
    public static Object getObject()
        throws SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = newInstance.newDocumentBuilder();
            Document doc = builder.parse(new File("./src/main/resources/config.xml"));
            // 拿到节点列表
            NodeList nl = doc.getElementsByTagName("className");
            System.out.println(nl.toString());
            // 获取节点
            Node classNodel = nl.item(0).getFirstChild();
            String cName = "com.jxzj.external.data.designmode.abstractfactory." + classNodel.getNodeValue();
            System.out.println("新类名" + cName);
            Class<?> forName = Class.forName(cName);
            Object obj = forName.newInstance();
            return obj;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }

    }
}
