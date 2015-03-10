package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by SumitBhatia on 1/03/15.
 */
public class Testimonial implements Serializable{

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

}
