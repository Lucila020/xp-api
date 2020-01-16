package com.claro.itec.xpapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentDTO {

    private Long id;

    private Integer agentNumber;

    private String businessName;
    private String name;
    private String surname;

    private String phoneType;

    private Integer characteristic;
       private Integer phoneNumber;
    private String email;
    private String location;
    private String country;
    private String province;
    private String city;
    private String street;
    private Integer addressNumber;
    private String postalCode;


}
