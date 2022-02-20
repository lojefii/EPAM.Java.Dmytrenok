package nau.advanced.practice2.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class CitySerialize {
    public static String pathXml = "src/main/java/nau/advanced/practice2/data/Cities.xml";
    public static String pathJson = "src/main/java/nau/advanced/practice2/data/Cities.JSON";


    public static void main(String[] args) throws IOException {
        String path = pathXml;
        writeToXML(cities, path);
        System.out.println(Arrays.toString((City[]) readFromXml(path)));
    }

    static City[] cities = new City[]{
            new City("Kyiv", "Ukraine", "2884000"),
            new City("London", "Great Britain", "8982000"),
            new City("Praha", "Czech Republic", "1309000"),
            new City("Lille", "France", "232741")
    };

    public static void writeToXML(Object object, String path) throws IOException {
        try (XMLEncoder out = new XMLEncoder(new ObjectOutputStream(new FileOutputStream(path)))) {
            out.writeObject(object);
        }
    }

    public static Object readFromXml(String path) throws IOException {
        try (XMLDecoder in = new XMLDecoder(new ObjectInputStream(new FileInputStream(path)))) {
            return in.readObject();
        }
    }

    public static void writeToJson(Iterator<Object> iterator, String path) throws IOException {
        try (ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(path))) {
            ObjectMapper mapper = new ObjectMapper();
            while (iterator.hasNext()) {
                in.writeObject(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(iterator.next()));
            }
        }
    }
}
