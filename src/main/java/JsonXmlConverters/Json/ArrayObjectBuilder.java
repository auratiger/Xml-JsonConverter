package JsonXmlConverters.Json;

public interface ArrayObjectBuilder {
    public ArrayObjectBuilder add(String value);
    public ArrayObjectBuilder add(int value);
    public ArrayObjectBuilder add(double value);
    public ArrayObjectBuilder add(float value);
    public ArrayObjectBuilder add(long value);
    public ArrayObjectBuilder add(boolean value);
    public ArrayObjectBuilder add(JsonObjectBuilder value);
    public ArrayObjectBuilder add(ArrayObjectBuilder value);
}
