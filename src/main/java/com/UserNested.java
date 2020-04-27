package com;
import lombok.Data;

@Data
public class UserNested {
    String name;
    String email;
    boolean isDeveloper;
    int age;
    UserAddress userAddress;
}