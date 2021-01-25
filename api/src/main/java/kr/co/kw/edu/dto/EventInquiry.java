package kr.co.kw.edu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 교원 빨간펜 교재신청 (이벤트) 문의
 */
@Data
public class EventInquiry {

    /**
     * 부모 이름
     */
    @JsonProperty(value = "parent_name")
    private String parentName;

    /**
     * 부모 생년월일
     */
    @JsonProperty(value = "parent_birthday")
    private String parentBirthday;

    /**
     * 부모 성별(M : 남자, F: 여자)
     */
    @JsonProperty(value = "parent_gender")
    private String parentGender;

    /**
     * 부모 연락처
     */
    @JsonProperty(value = "parent_phone")
    private String parentPhone;

    /**
     * 자녀 이름
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * 자녀 나이
     */
    @JsonProperty(value = "age")
    private String age;

    /**
     * 주소
     */
    @JsonProperty(value = "base_address")
    private String baseAddress;

    /**
     * 주소상세
     */
    @JsonProperty(value = "detail_address")
    private String detailAddress;

    /**
     * 우편번호
     */
    @JsonProperty(value = "zip_code")
    private String zipCode;

}
