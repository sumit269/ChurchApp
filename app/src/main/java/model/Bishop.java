package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.jar.Attributes;

/**
 * Created by SumitBhatia on 28/02/15.
 */
public class Bishop implements Serializable {

    // http://beta.json-generator.com/Dz7pYdq


    /*
    {
    "_id": "54f246e959fe52143eb755c7",
    "index": 0,
    "isActive": true,
    "picture": "http://placehold.it/32x32",
    "age": 24,
    "designation": "dolor",
    "name": {
      "first": "Deloris",
      "last": "Boyd"
    },
    "churchName": "NIPAZ",
    "about": "Proident enim in culpa nostrud fugiat eiusmod elit excepteur consectetur nostrud labore. Labore incididunt elit irure aliquip ut adipisicing magna occaecat non ut eu. Amet eiusmod do nulla ea deserunt incididunt consequat esse proident fugiat consequat. Cupidatat qui veniam dolor Lorem nostrud magna exercitation excepteur laborum ad. Est anim officia ut exercitation ipsum.\r\n",
    "email": "deloris.boyd@undefined.org",
    "phone": "+1 (866) 524-2808",
    "address": "572 Thomas Street, Chamizal, Rhode Island, 6049",
    "latitude": -21.408853,
    "longitude": -0.837219,
    "testimonials": [
      {
        "id": 0,
        "name": "Puckett Newton",
        "description": "Anim laborum duis in exercitation mollit ut ut eu. Nisi reprehenderit deserunt quis incididunt adipisicing adipisicing. Consequat velit magna qui commodo. Excepteur ipsum labore officia voluptate occaecat aliquip.\r\n"
      },
      {
        "id": 1,
        "name": "Daniel Bass",
        "description": "Do cupidatat Lorem laboris voluptate est non magna. Ullamco ad quis commodo aute aliquip do veniam non nulla. Aliqua esse voluptate duis nisi est nostrud. Eu veniam commodo duis ex adipisicing eu nostrud ullamco minim sint ut est laboris voluptate. Commodo do laboris irure nisi fugiat laborum sunt dolor non ipsum laboris et.\r\n"
      },
      {
        "id": 2,
        "name": "Reynolds Dean",
        "description": "Duis et sit exercitation eu est ex reprehenderit id aliqua veniam deserunt. Reprehenderit eu excepteur nulla deserunt nisi proident sunt adipisicing sit eiusmod elit labore. Do incididunt irure irure reprehenderit.\r\n"
      }
    ]
  }
  */
    @SerializedName("_id")
    public String id;

    @SerializedName("index")
    public int index;

    @SerializedName("isActive")
    public boolean isActive;

    @SerializedName("picture")
    public String picture;

    @SerializedName("age")
    public int age;

    @SerializedName("designation")
    public String designation;

    public BishopName name;

    @SerializedName("churchName")
    public String churchName;

    @SerializedName("about")
    public String about;

    @SerializedName("email")
    public String email;

    @SerializedName("phone")
    public String phone;

    @SerializedName("address")
    public String address;

    @SerializedName("latitude")
    public BigDecimal latitude;

    @SerializedName("longitude")
    public BigDecimal longitude;

    public Testimonial[] testimonials;

    public class BishopName {

        @SerializedName("first")
        public String first;

        @SerializedName("last")
        public String last;
    }
}
