package JsonXmlConverters.Json;

import java.util.*;

public class Json {
    public static JsonObjectBuilder createJsonBuilder(){
        return new JsonBuilder();
    }

    public static ArrayObjectBuilder createArrayBuilder(){
        return new ArrayBuilder();
    }
}

class JsonBuilder implements JsonObjectBuilder{
    private final HashMap<Value, Value> var = new HashMap<Value, Value>();

    public JsonObjectBuilder add(String key, String value){
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value));
        return this;
    }

    public JsonObjectBuilder add(String key, int value) {
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value));
        return this;
    }

    public JsonObjectBuilder add(String key, double value) {
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value));
        return this;
    }

    public JsonObjectBuilder add(String key, float value) {
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value));
        return this;
    }

    public JsonObjectBuilder add(String key, long value) {
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value));
        return this;
    }

    public JsonObjectBuilder add(String key, boolean value) {
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value));
        return this;
    }

    public JsonObjectBuilder add(String key, JsonObjectBuilder value) {
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value));
        return this;
    }

    public JsonObjectBuilder add(String key, ArrayObjectBuilder value) {
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value));
        return this;
    }

    public JsonObjectBuilder add(String key, Object value) {
        if(key == null) throw new NullKeyException("Key value can not be a null value.");
        var.put(new Value(key), new Value(value.toString()));
        return this;
    }

    public boolean isEmpty(){
        return var.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof JsonObjectBuilder)) return false;
        JsonBuilder jsonObjectBuilder = (JsonBuilder) obj;
        return var.equals(jsonObjectBuilder.var);
    }

    @Override
    public int hashCode() {
        return var.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");

        Set<Value> keySet = var.keySet();

        for(Iterator<Value> it = keySet.iterator(); it.hasNext();){
            Value key = it.next();
            sb.append(key)
              .append(":")
              .append(var.get(key))
              .append(it.hasNext() ? ", " : "");
        }

        sb.append(" }");

        return sb.toString();
    }
}

class Value{
    private String value;

    public Value(String value){
        if(value == null)
            this.value = "null";
        else
            this.value = "\"" + value + "\"";
    }
    
    public Value(int value){
        this.value = "" + value;
    }
    
    public Value(double value){
        this.value = "" + value;
    }
    
    public Value(float value){
        this.value = "" + value;
    }
    
    public Value(long value){
        this.value = "" + value;
    }

    public Value(boolean value){
        this.value = "" + value;
    }
    
    public Value(JsonObjectBuilder value){
        if(value == null)
            this.value = "null";
        else
            this.value = value.toString();
    }

    public Value(ArrayObjectBuilder value){
        if(value == null)
            this.value = "null";
        else
            this.value = value.toString();
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Value)) return false;
        Value var = (Value)obj;
        return value.equals(var.value);
    }

    @Override
    public String toString() {
        return value;
    }
}

class ArrayBuilder implements ArrayObjectBuilder{
    private final List<Value> var = new ArrayList<Value>();

    public ArrayObjectBuilder add(String value) {
        var.add(new Value(value));
        return this;
    }

    public ArrayObjectBuilder add(int value) {
        var.add(new Value(value));
        return this;
    }

    public ArrayObjectBuilder add(double value) {
        var.add(new Value(value));
        return this;
    }

    public ArrayObjectBuilder add(float value) {
        var.add(new Value(value));
        return this;
    }

    public ArrayObjectBuilder add(long value) {
        var.add(new Value(value));
        return this;
    }

    public ArrayObjectBuilder add(boolean value){
        var.add(new Value(value));
        return this;
    }

    public ArrayObjectBuilder add(JsonObjectBuilder value) {
        var.add(new Value(value));
        return this;
    }

    public ArrayObjectBuilder add(ArrayObjectBuilder value) {
        var.add(new Value(value));
        return this;
    }

    @Override
    public int hashCode() {
        return var.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof ArrayObjectBuilder)) return false;
        ArrayBuilder arrayBuilder = (ArrayBuilder)obj;
        return var.equals(arrayBuilder.var);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for(Iterator<Value> it = var.iterator(); it.hasNext();){
            sb.append(it.next())
                    .append(it.hasNext() ? ", " : "]");
        }
        return sb.toString();
    }
}
