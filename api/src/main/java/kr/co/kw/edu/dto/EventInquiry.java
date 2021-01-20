package kr.co.kw.edu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EventInquiry {

    @JsonProperty(value = "parent_name")
    private String parentName;

    @JsonProperty(value = "parent_birthday")
    private String parentBirthday;
    @JsonProperty(value = "parent_gender")
    private String parentGender;
    @JsonProperty(value = "parent_phone")
    private String parentPhone;

    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "age")
    private Integer age;

    @JsonProperty(value = "base_address")
    private String baseAddress;
    @JsonProperty(value = "detail_address")
    private String detailAddress;
    @JsonProperty(value = "zip_code")
    private String zipCode;

}
