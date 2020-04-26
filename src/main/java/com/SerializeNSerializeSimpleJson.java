package com;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;


public class SerializeNSerializeSimpleJson {
    /**
     * Convert Java Object to JSON String
     **/
    public static String SerializedJson="";
    public static UserSimple DeserailizedUSerSimple;
    public static String SerializedJsonToFile="";
    public static String SerializedJsonFromFile="";
    public static UserSimple DeserailizedUSerSimplefromFile;
    /*public static void main(String[] args) {
        SerializeUserSimple();
        DeSerializeUserSimple();
    }*/

    public static void SerializeUserSimple() {
        UserSimple user = new UserSimple();
        user.setName("Sunil");
        user.setEmail("sunilnautomation@gmail.com");
        user.setAge(34);
        user.setDeveloper(true);

        Gson gson = new Gson();
        SerializedJson = gson.toJson(user);
        System.out.println("Serialized : " + SerializedJson);
    }

    public static void DeSerializeUserSimple() {
        Gson gson = new Gson();
        DeserailizedUSerSimple = gson.fromJson(SerializedJson, UserSimple.class);
        System.out.println("De-Serialized : " + DeserailizedUSerSimple);
    }


    public static void SerializeUserSimplenWriteToFile() throws IOException {
        UserSimple user = new UserSimple();
        user.setName("Anil");
        user.setEmail("anilautomation@gmail.com");
        user.setAge(34);
        user.setDeveloper(true);

        Gson gson = new Gson();
        SerializedJsonToFile = gson.toJson(user);
        System.out.println("Serialized : " + SerializedJsonToFile);

        //System.out.println(System.getProperty("user.dir")+"/src/test/resources/UserSimple.json");
        File f = new File(System.getProperty("user.dir") + "/src/test/resources/UserSimple.json");
        if (f.exists())
            f.delete();
        BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/test/resources/UserSimple.json"));
        writer.write(SerializedJsonToFile);
        writer.close();
    }

    public static void DeSerializeUserSimplenfromFile() throws FileNotFoundException,InterruptedException,IOException {
        Thread.sleep(100);
        File f = new File(System.getProperty("user.dir") + "/src/test/resources/UserSimple.json");
        Scanner theReader = new Scanner(f);
        while (theReader.hasNextLine()) {
            SerializedJsonFromFile = SerializedJsonFromFile+theReader.nextLine();
        }
        theReader.close();

        System.out.println("The File Read is : "+SerializedJsonFromFile);
        Gson gson = new Gson();
        DeserailizedUSerSimplefromFile = gson.fromJson(SerializedJsonFromFile, UserSimple.class);

    }
}

