package JsonXmlConverters;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Resources {
    private final static Resources instance = new Resources();
    private final String resourceFile = "C:\\Users\\jboxers\\IdeaProjects\\JetBrains_Academy_Projects\\src\\main\\resources\\regexPatterns.properties";
    private final Properties properties;

    private Resources(){
        properties = new Properties();
        try {
            properties.load(new FileReader(resourceFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Resources getInstance(){
        return instance;
    }

    public String get(String tag){
        return properties.getProperty(tag);
    }



}
