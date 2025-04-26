package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

class Files{

    String name;
    String type;
    int size;



    @Override
    public String toString() {
        return "Files{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                '}';
    }
}



public class App 
{
    static final String JSON = """ 
    
        [ { "name": "1.txt", "size": 1234, "type": "txt" }, 
        { "name": "2.png", "size": 456, "type": "png" } ] 
    
    """;

    public static void main( String[] args )
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type filesListType = new TypeToken<List<Files>>() {}.getType();
        List<Files> list = gson.fromJson(JSON, filesListType);

        for (Files files : list) {
            System.out.println(files);

        }
        String json = gson.toJson(list);
        System.out.println(json);

    }
}
