package JsonXmlConverters;

import JsonXmlConverters.Json.ArrayObjectBuilder;
import JsonXmlConverters.Json.Json;
import JsonXmlConverters.Json.JsonObjectBuilder;
import JsonXmlConverters.Xml.Xml;
import JsonXmlConverters.Xml.XmlObjectBuilder;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlJsonConverter {
    private final Resources resources = Resources.getInstance();

    private final String xmlPattern = resources.get("pattern.xml");
    private final String attributePattern = resources.get("pattern.attribute");

    private final Pattern patCompiler = Pattern.compile(xmlPattern);
    private final Pattern attributeCompiler = Pattern.compile(attributePattern);

    class XmlNode{
        private String tag;
        private String attributes;
        private String body;

        public XmlNode(String tag, String attributes, String body) {
            this.tag = tag;
            this.attributes = attributes;
            this.body = body;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getAttributes() {
            return attributes;
        }

        public void setAttributes(String attributes) {
            this.attributes = attributes;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(!(obj instanceof Xml)) return false;
            return tag.equals(((XmlNode) obj).tag);
        }
    }

    public JsonObjectBuilder parseXml(String xmlText){
        JsonObjectBuilder builder = Json.createJsonBuilder();

        LinkedHashMap<String, List<XmlNode>> matches = findXmlMatches(xmlText);

        if(matches.isEmpty()) return null;

        Set<String> keys = matches.keySet();

        for(Iterator<String> it = keys.iterator(); it.hasNext();){
            String key = it.next();
            List<XmlNode> list = matches.get(key);

            if(!list.isEmpty() && list.size() > 1){
                ArrayObjectBuilder arrayObjectBuilder = Json.createArrayBuilder();
                for(XmlNode node : list){
                    JsonObjectBuilder bodyBuilder = Json.createJsonBuilder();

                    if(!node.attributes.equals("")){
                        JsonObjectBuilder innerBody;
                        addAttributes(node.attributes, bodyBuilder);

                        if(node.body == null || node.body.equals("")){
                            bodyBuilder.add("#"+node.tag, (JsonObjectBuilder) null);
                        }else if((innerBody = parseXml(node.body)) == null){
                            bodyBuilder.add("#"+node.tag, node.body);
                        }else{
                            bodyBuilder.add("#"+node.tag, innerBody);
                        }
                        arrayObjectBuilder.add(bodyBuilder);
                    }else{
                        if(node.body == null || node.body.equals("")){
                            arrayObjectBuilder.add((JsonObjectBuilder) null);
                        }else if((bodyBuilder = parseXml(node.body)) == null){
                            arrayObjectBuilder.add(node.body);
                        }else{
                            arrayObjectBuilder.add(bodyBuilder);
                        }
                    }
                }
                builder.add(key, arrayObjectBuilder);

            }else{
                JsonObjectBuilder bodyBuilder = Json.createJsonBuilder();

                XmlNode node = list.get(0);

                if(!node.attributes.equals("")){
                    JsonObjectBuilder innerBody;
                    addAttributes(node.attributes, bodyBuilder);

                    if(node.body == null || node.body.equals("")){
                        bodyBuilder.add("#"+node.tag, (JsonObjectBuilder) null);
                    }else if((innerBody = parseXml(node.body)) == null){
                        bodyBuilder.add("#"+node.tag, node.body);
                    }else{
                        bodyBuilder.add("#"+node.tag, innerBody);
                    }
                    builder.add(node.tag, bodyBuilder);
                }else{
                    if(node.body == null || node.body.equals("")){
                        builder.add(node.tag, (JsonObjectBuilder) null);
                    }else if((bodyBuilder = parseXml(node.body)) == null){
                        builder.add(node.tag, node.body);
                    }else{
                        builder.add(node.tag, bodyBuilder);
                    }
                }
            }
        }

        return builder;
    }

    private LinkedHashMap<String, List<XmlNode>> findXmlMatches(String xmlText){
        LinkedHashMap<String, List<XmlNode>> matches = new LinkedHashMap<>();

        Matcher matcher = patCompiler.matcher(xmlText);

        while (matcher.find()){
            String tag = matcher.group(1);
            String attributes = matcher.group(2);
            String body = matcher.group(3);

            XmlNode node = new XmlNode(tag, attributes, body);

            if(matches.containsKey(tag)){
                matches.get(tag).add(node);
            }else{
                matches.put(tag, new ArrayList<XmlNode>());
                matches.get(tag).add(node);
            }
        }

        return matches;
    }

    private void addAttributes(String attributes, JsonObjectBuilder builder){
        Matcher matcher = attributeCompiler.matcher(attributes);

        while(matcher.find()){
            String name = matcher.group(1);
            String value = matcher.group(2);
            builder.add("@"+name, value);
        }
    }

    public XmlObjectBuilder parseJson(String jsonText){

        return null;
    }

}