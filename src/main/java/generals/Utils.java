package generals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class Utils
   {
        public static Map<String,String> assertMap=new HashMap<String,String>();

        public static void rememberTheValue(String key, String value)
        {
            assertMap.put(key, value);
        }
        public static String whatIsThevalue(String key)
        {
            return assertMap.get(key);
        }

        public static String getData(String propertyToRead) throws IOException {
            FileInputStream fileInputStream=new FileInputStream("src\\main\\resources\\test.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(propertyToRead);
        }

    }
