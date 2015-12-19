/*
 * @(#)XMLPrasingUtil.java     v1.01, 2012-8-3
 *
 * Copyright (c) 2011, TNT All Rights Reserved.
 */

package com.mynms.common.util.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ClassName:   XMLPrasingUtil.java
 * <p>
 *
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-8-3 上午11:34:27
 */
public class XMLPrasingUtil {

    private Document document = null;

    public XMLPrasingUtil(String fileName) {
        try {
            SAXReader reader = new SAXReader();
            document = reader.read(new File(fileName));
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Element getRootElement() {
        return document.getRootElement();
     } 

    @SuppressWarnings("unchecked")
    public List<Element> getElements(String elementName) {
        return getRootElement().elements(elementName);
    }

    public Element getElement(String elementName) {
        return getRootElement().element(elementName);
    }

    public String getElementText(String elementName) {
        return getRootElement().elementText(elementName);
    }

    public String getElementTextTrim(String elementName) {
        return getRootElement().elementTextTrim(elementName);
    }

    public String getElementAttribute(String elementName, String attributeName) {
        return getElement(elementName).attributeValue(attributeName);
    }
}

