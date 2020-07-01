package JsonXmlConverters;

import JsonXmlConverters.Json.JsonObjectBuilder;
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
        int size = text.length();

        long start = System.nanoTime();

        for(int i = 0; i < size; i++){
            System.out.println(text.charAt(i));
        }

        long end = System.nanoTime();

        System.out.println("==========================");
        System.out.println((end - start) / 1000000);

        final String regex = "(\\s*\"([@#:\\w\\s]+)\"\\s*:\\s*(null|false|true|\"[\\w\\s\\\\\\/:.\\-?!@#$%^&*]*\"|\\d+\\.*\\d*|\\[[\\w\\W]*\\]|(\\{((?(?=(?:[^\\{}]*)\\{)(?:[^\\{}]*(?4))|[^\\{}]*)(?(?=\\s*\\})(?:\\s*\\})|(?:(?5)))))))";
        Pattern pattern = Pattern.compile(regex);

        start = System.nanoTime();

        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println("-----------");
        }

        end = System.nanoTime();

        System.out.println("==========================");
        System.out.println((end - start) / 1000000);
    }
}
