package com.claro.itec.xpapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentRsDTO {

    private Long id;

    private Integer agentNumber;

    private String businessName;
    private String fullName;
    private String phoneType;
    private Integer fullphoneNumber;
    private String email;
    private String location;
    private String country;
    private String province;
    private String city;
    private String street;
    private Integer addressNumber;
    private String postalCode;


}
