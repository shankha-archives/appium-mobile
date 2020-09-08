package mobile.Frontline.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestDataManager 
{
	public static ConfigFileManager configFileManager;
	File fXmlFile;
	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	Document doc;
	public TestDataManager() 
	{
		try {
		configFileManager = ConfigFileManager.getInstance();
		if (configFileManager.getProperty("testdata") != null && configFileManager.getProperty("testdata") != "")
        {
			fXmlFile = new File(configFileManager.getProperty("testdata"));
        }
		else
		{
			throw new FileNotFoundException("Please set testdata path in config file (ex - testdata=<path of the file>.xml)");
		}
		//fXmlFile = new File("testdata/testdata.xml");
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		    }
	}
	public TestDataManager(String fileName) 
	{
		try {
			fXmlFile = new File(fileName);
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		    }
	}
	public String read_property (String tag,String type,String value)
	{
		String attrvalue="";
		NodeList nList = doc.getElementsByTagName(tag);
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName() == tag) 
			{
				Element eElement = (Element) nNode;
				if(eElement.getAttribute("type").equalsIgnoreCase(type))
				{
					attrvalue=eElement.getElementsByTagName(value).item(0).getTextContent();
				}
			}
		}
		return attrvalue;
	}
	public ArrayList<String> read_listProperty (String tag,String type,String value)
	{
		ArrayList<String> attrvalue=new ArrayList<String>();
		NodeList nList = doc.getElementsByTagName(tag);
		for (int temp = 0; temp < 2; temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName() == tag) 
			{
				Element eElement = (Element) nNode;
				if(eElement.getAttribute("type").equalsIgnoreCase(type))
				{
					attrvalue.add(eElement.getElementsByTagName(value).item(0).getTextContent());
				}
			}
		}
		return attrvalue;
	}
}
