package JsonXmlConverters;

import JsonXmlConverters.Json.JsonObjectBuilder;
import JsonXmlConverters.Xml.XmlObjectBuilder;
import com.florianingerl.util.regex.Matcher;
import com.florianingerl.util.regex.Pattern;

import java.io.*;

public class XmlJsonConverterTerm {

    public static void main(String[] args) {

//        XmlObjectBuilder builder = Xml.createXmlObjectBuilder("person");
//        XmlObjectBuilder builder1 = Xml.createXmlObjectBuilder("child");
//        XmlObjectBuilder builder2 = Xml.createXmlObjectBuilder("child2");
//        builder1.addElement("body");
//        builder.addElement(builder1);
//        builder2.addElement("body2");
//        builder.addElement(builder2);
//
//        builder.addAttribute("name", "\"value\"");
//        System.out.println(builder.toString());

//        String xmlFileResource;
//
//        if (args.length < 1){
//            xmlFileResource = "C:\\Users\\jboxers\\IdeaProjects\\JetBrains_Academy_Projects\\src\\main\\java\\JsonXmlConverters\\XmlFile.xml";
//        }else {
//            xmlFileResource = args[0];
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        try(BufferedReader reader = new BufferedReader(new FileReader(new File(xmlFileResource)))){
//            String st;
//            while ((st = reader.readLine()) != null){
//                sb.append(st).append("\n");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        String text = sb.toString();
//
//        XmlJsonConverter converter = new XmlJsonConverter();
//        JsonObjectBuilder result = converter.parseXml(text);
//        System.out.println(result.toString());

        String jsonFileResource = "C:\\Users\\jboxers\\IdeaProjects\\JetBrains_Academy_Projects\\src\\main\\java\\JsonXmlConverters\\JsonFile.json";
        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(new File(jsonFileResource)))){
            String st;
            while((st = reader.readLine()) != null){
                sb.append(st).append("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        String text = sb.toString();
        System.out.println(text);

        XmlJsonConverter converter = new XmlJsonConverter();
        XmlObjectBuilder result = converter.parseJson(text);
        System.out.println(result);


    }
}
