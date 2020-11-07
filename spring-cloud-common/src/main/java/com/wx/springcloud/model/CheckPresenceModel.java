package com.wx.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckPresenceModel implements Serializable {

    private Integer id;
    private String userCode;
    private String userName;
    private String record;
    private String recordTime;
    private String checkPresenceInfo;
    List<CheckPresenceModel> CheckPresenceModelList;
}
