package JsonXmlConverters.Xml;

import com.sun.istack.internal.NotNull;

import java.util.*;

public class Xml {
    public static XmlObjectBuilder createXmlObjectBuilder(String tag){
        return new XmlBuilder(tag);
    }
}

class XmlBuilder implements XmlObjectBuilder{
    private String tag;
    private final Attributes attributes = new Attributes();
    private final List<XmlObject> children = new ArrayList<XmlObject>();

    public XmlBuilder(String tag){
        if(tag == null) throw new IllegalArgumentException();
        this.tag = tag;
    }

    public XmlObjectBuilder addElement(XmlObjectBuilder element){
        if(element == null) throw new IllegalArgumentException();
        children.add(new XmlObject(element));
        return this;
    }

    public XmlObjectBuilder addElement(String element){
        if(element == null) throw new IllegalArgumentException();
        children.add(new XmlObject(element));
        return this;
    }

    public XmlObjectBuilder addAttribute(String key, String value){
        if (key == null || value == null) throw new IllegalArgumentException();
        attributes.addAttribute(key, value);
        return this;
    }

    public XmlObjectBuilder setTag(String tag) {
        if(tag == null) throw new IllegalArgumentException();
        this.tag = tag;
        return this;
    }

    public boolean isEmpty() {
        return children.size() == 0;
    }

    @Override
    public String toString() {

        if (isEmpty()){
            return "<" + tag + attributes + "/>";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<")
          .append(tag)
          .append(attributes)
          .append(">");

        for(XmlObject child : children){
            sb.append(child);
        }

        sb.append("</")
          .append(tag)
          .append(">");

        return sb.toString();
    }
}

class XmlObject{
    private String value;

    public XmlObject(@NotNull String value){
        this.value = value;
    }

    public XmlObject(@NotNull XmlObjectBuilder value){
        this.value = value.toString();
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof XmlObject)) return false;
        XmlObject object = (XmlObject) obj;
        return value.equals(object.value);
    }

    @Override
    public String toString() {
        return value;
    }
}

class Attributes implements AttributeBuilder{
    private HashMap<String, String> attributes = new HashMap<String, String>();

    public AttributeBuilder addAttribute(@NotNull String key, @NotNull String value) {
        attributes.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        if(attributes.isEmpty()){
            return "";
        }
        Set<String> keys = attributes.keySet();
        StringBuilder sb = new StringBuilder();
        for(Iterator<String> it = keys.iterator(); it.hasNext();){
            String key = it.next();
            String value = attributes.get(key).trim();
            char quot = '"';

            if(value.startsWith("\"") || value.endsWith("\"")){
                quot = '\'';
            }

            sb.append(" ")
              .append(key)
              .append("=")
              .append(quot)
              .append(value)
              .append(quot);
        }
        return sb.toString();
    }
}

