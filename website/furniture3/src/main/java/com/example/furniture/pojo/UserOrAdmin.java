package com.example.furniture.pojo;

import jdk.jfr.Enabled;
import lombok.Data;

@Enabled
@Data
public class UserOrAdmin {
    private User user;
    private Administrator administrator;
}
