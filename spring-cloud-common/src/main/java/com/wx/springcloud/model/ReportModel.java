package com.wx.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportModel implements Serializable {

    private Integer id;
    private String providerCode;
    private String provider;
    private String submitDate;
    private String major;
    private String supervisionCode;
    private String supervisionName;
    private String coachCode;
    private String coachName;
    private String harvest;
    private String insufficient;
    private String opinion;
    private String status;
}
