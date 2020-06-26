package JsonXmlConverters;

import JsonXmlConverters.Json.ArrayObjectBuilder;
import JsonXmlConverters.Json.Json;
import JsonXmlConverters.Json.JsonObjectBuilder;
import JsonXmlConverters.Xml.Xml;
import JsonXmlConverters.Xml.XmlObjectBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonToXmlConverter {

    public static void main(String[] args) {
        String text = "<ns1:RequestHeader>\n" +
                "\t\t\t\t<ns1:NeType>ORDER</ns1:NeType>\n" +
                "\t\t\t\t<ns1:OrderNo>GG</ns1:OrderNo>\n" +
                "\t\t\t\t<ns1:Priority>2</ns1:Priority>\n" +
                "\t\t\t\t<ns1:ReqUser>VLOCITY</ns1:ReqUser>\n" +
                "\t\t\t</ns1:RequestHeader>\n" +
                "\t\t\t<ns1:RequestParameters>\n" +
                "\t\t\t\t<ns1:Parameter name=\"OWNER\" value=\"VASIL\"/>\n" +
                "\t\t\t\t<!-- please do not change it-->\n" +
                "\t\t\t\t<ns1:Parameter name=\"OWNER_TEST\" value=\"GG\"/>\n" +
                "\t\t\t\t<ins:Parameter name=\"REQUEST_TRACE\" value=\"EVERYTHING\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"ORDER_NO\" value=\"15411\"/>\n" +
                "\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_ID\" value=\"0060000678\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_NAME_FIRST\" value=\"JUAN\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_NAME_LAST\" value=\"PEREZ\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_ADDRESS_ID\" value=\"uaxhjhg\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_ADDRESS_LOCALITY\" value=\"BAZFOO\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_ADDRESS_CITY\" value=\"BAZFOO\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_ADDRESS_PROVINCE\" value=\"BAZFOO\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_ADDRESS_NUMBER\" value=\"BAZFOO\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_ADDRESS_COUNTRY\" value=\"BAZFOO\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"SUBS_ADDRESS_STREET\" value=\"BAZFOO\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"CRM_CORRELATION_ID\" value=\"12345\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"WF_ORDER\" value=\"876\"/>\n" +
                "\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_1_INSTANCE_ID\" value=\"202006221220\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_1_CFS\" value=\"FTTH_DATA_ACCESS\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_1_WF_ACTIVITY\" value=\"1\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_1_ACTION\" value=\"CONNECT\"/>\n" +
                "\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_2_INSTANCE_ID\" value=\"2020062212201\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_2_CFS\" value=\"FTTH_INTERNET_SERVICE\"/>                       \n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_2_PARENT_INSTANCE_ID\" value=\"202006221220\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_2_PRODUCT\" value=\"2805\"/>                       \n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_2_ACTION\" value=\"CONNECT\"/>\n" +
                "\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_INSTANCE_ID\" value=\"2020062212202\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_CFS\" value=\"FTTH_TOIP_ACCOUNT\"/>                       \n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_PARENT_INSTANCE_ID\" value=\"202006221220\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_PARENT_INSTANCE_ID_ALIAS_ADD_1\" value=\"2020062212203\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_DN\" value=\"542006221220\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_LI\" value=\"12\"/>     \n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_ACTION\" value=\"CONNECT\"/>\n" +
                "\n" +
                "\t\t\t\t<!-- OPTIONAL PARAMETERS FOR PORTABILITY CASES -->                                                     \n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_PORTED\" value=\"0\"/>\n" +
                "\t\t\t\t<ns1:Parameter name=\"LINE_3_PORTED_TYPE\" value=\"PI\"/> \n" +
                "\t\t\t\t\n" +
                "\t\t\t</ns1:RequestParameters>";
        String pattern = "\\n*<\\s*(?<first>[\\w:]+)([\\w\\s\\d=\":\\/.\\-]*)(?:\\/>|>\\s*([\\w\\s\\W]*)\\s*<\\/(\\k<first>)>)";

        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(text);

//        while(matcher.find()){
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            System.out.println(matcher.group(3));
//            System.out.println(matcher.group(4));
//
//        }

//        JsonObjectBuilder builder = Json.createJsonBuilder();
//        JsonObjectBuilder builder1 = Json.createJsonBuilder();
//        JsonObjectBuilder builder2 = Json.createJsonBuilder();
//        JsonObjectBuilder builder3 = Json.createJsonBuilder();
//        ArrayObjectBuilder arrayObjectBuilder = Json.createArrayBuilder();
//
//        builder1.add("firstName", "Whitney");
//        builder1.add("lastName", "Byrd");
//        builder1.add("age", 23);
//
//        builder2.add("firstName", (ArrayObjectBuilder) null);
//        builder2.add("lastName", "Lang");
//        builder2.add("age", 26.4);
//
//        builder3.add("firstName", "Sophie");
//        builder3.add("lastName", "Goodwin");
//        builder3.add("age", false);
//
//        arrayObjectBuilder.add(builder1).add(builder2).add(builder3);
//
//        builder.add("persons", arrayObjectBuilder);
//
//        System.out.println(builder.toString());


        XmlObjectBuilder builder = Xml.createXmlObjectBuilder("person");
        XmlObjectBuilder builder1 = Xml.createXmlObjectBuilder("child");
        XmlObjectBuilder builder2 = Xml.createXmlObjectBuilder("child2");
        builder1.addElement("body");
        builder.addElement(builder1);
        builder2.addElement("body2");
        builder.addElement(builder2);

        builder.addAttribute("name", "\"value\"");
        System.out.println(builder.toString());

    }

    public String parse(){
        return "";
    }

}
