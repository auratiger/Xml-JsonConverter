package JsonXmlConverters.Xml;

public interface XmlObjectBuilder {
    public XmlObjectBuilder addElement(XmlObjectBuilder element);
    public XmlObjectBuilder addElement(String element);
    public XmlObjectBuilder addAttribute(String key, String value);
    public XmlObjectBuilder setTag(String tag);
    public boolean isEmpty();

}
