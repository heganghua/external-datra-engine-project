package com.jxzj.external.data.designmode.abstractfactory;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.jxzj.external.data.designmode.ReadXML;

public class FarmTest {

    public static void main(String[] args) {
        try {
            Farm obj = (Farm)ReadXML.getObject();
            Animal newAnimal = obj.newAnimal();
            Plant newPlant = obj.newPlant();
            newAnimal.show();
            newPlant.show();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SAXException
            | IOException e) {
            e.printStackTrace();
        }
    }
}
