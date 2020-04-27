package com;

import com.google.gson.Gson;
import com.UserNested;
import com.UserAddress;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Scanner;


public class SerializeNSerializeComplexJson {
    /**
     * Convert Java Object to JSON String
     **/
    public static String SerializedJson = "";
    public static UserNested DeserailizedUSerComplex;
    public static String SerializedJsonToFile = "";
    public static String SerializedJsonFromFile = "";
    public static UserNested DeserailizedUSerComplexfromFile;

    public static void main(String[] args) throws IOException, InterruptedException {
        SerializeUserComplex();
        DeSerializeUserComplex();
        SerializeUserComplexnWriteToFile();
        DeSerializeUserSimplenfromFile();
    }

    public static void SerializeUserComplex() {

        UserAddress userAdd = new UserAddress();
        userAdd.setHouseNumber("42A");
        userAdd.setStreet("Main Street");
        userAdd.setCity("Magdeburg");
        userAdd.setCountry("Germany");

        UserNested userNested = new UserNested();
        userNested.setName("Sunil");
        userNested.setEmail("sunilnautomation@gmail.com");
        userNested.setAge(34);
        userNested.setDeveloper(true);
        userNested.setUserAddress(userAdd);

        Gson gson = new Gson();
        SerializedJson = gson.toJson(userNested);
        System.out.println("Serialized : " + SerializedJson);
    }

    public static void DeSerializeUserComplex() {
        Gson gson = new Gson();
        DeserailizedUSerComplex = gson.fromJson(SerializedJson, UserNested.class);
        System.out.println("De-Serialized : " + DeserailizedUSerComplex);
    }


    public static void SerializeUserComplexnWriteToFile() throws IOException {
        UserAddress userAdd = new UserAddress();
        userAdd.setHouseNumber("41A");
        userAdd.setStreet("Not Main Street");
        userAdd.setCity("Magdeburg");
        userAdd.setCountry("Germany");

        UserNested userNested = new UserNested();
        userNested.setName("Anil");
        userNested.setEmail("anilautomation@gmail.com");
        userNested.setAge(30);
        userNested.setDeveloper(true);
        userNested.setUserAddress(userAdd);

        Gson gson = new Gson();
        SerializedJsonToFile = gson.toJson(userNested);
        System.out.println("Serialized to be written to file: " + SerializedJsonToFile);

        //System.out.println(System.getProperty("user.dir")+"/src/test/resources/UserComplex.json");
        File f = new File(System.getProperty("user.dir") + "/src/test/resources/UserComplex.json");
        if (f.exists())
            f.delete();
        BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/test/resources/UserComplex.json"));
        writer.write(SerializedJsonToFile);
        writer.close();
    }

    public static void DeSerializeUserSimplenfromFile() throws FileNotFoundException, InterruptedException, IOException {
        Thread.sleep(100);
        File f = new File(System.getProperty("user.dir") + "/src/test/resources/UserComplex.json");
        Scanner theReader = new Scanner(f);
        while (theReader.hasNextLine()) {
            SerializedJsonFromFile = SerializedJsonFromFile + theReader.nextLine();
        }
        theReader.close();

        System.out.println("De-Serialized from reading the file : " + SerializedJsonFromFile);
        Gson gson = new Gson();
        DeserailizedUSerComplexfromFile = gson.fromJson(SerializedJsonFromFile, UserNested.class);
    }
}

