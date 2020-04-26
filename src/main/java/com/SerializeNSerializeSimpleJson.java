package com;

import com.google.gson.Gson;

public class SerializeNSerializeSimpleJson {
    /**
     * Convert Java Object to JSON String
     **/
    public static String SerializedJson;
    public static UserSimple DeserailizedUSerSimple;
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

        Gson gson=new Gson();
        SerializedJson=gson.toJson(user);
        System.out.println("Serialized : "+SerializedJson);
    }
    public static void DeSerializeUserSimple() {
        Gson gson=new Gson();
        DeserailizedUSerSimple=gson.fromJson(SerializedJson,UserSimple.class);
        System.out.println("De-Serialized : "+DeserailizedUSerSimple);
    }
}
