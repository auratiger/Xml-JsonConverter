package JsonXmlConverters.Json;

public interface JsonObjectBuilder {

    public JsonObjectBuilder add(String key, Object value);
    public JsonObjectBuilder add(String key, String value);
    public JsonObjectBuilder add(String key, int value);
    public JsonObjectBuilder add(String key, double value);
    public JsonObjectBuilder add(String key, float value);
    public JsonObjectBuilder add(String key, long value);
    public JsonObjectBuilder add(String key, boolean value);
    public JsonObjectBuilder add(String key, JsonObjectBuilder value);
    public JsonObjectBuilder add(String key, ArrayObjectBuilder value);

    public boolean isEmpty();
}
