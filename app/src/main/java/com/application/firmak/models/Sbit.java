package com.application.firmak.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sbit {

@SerializedName("Key")
@Expose
private String key;
@SerializedName("Value")
@Expose
private String value;
@SerializedName("Description")
@Expose
private String description;

    public Sbit(String key, String value, String description){
        this.key = key;
        this.value = value;
        this.value = description;
    }

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

}