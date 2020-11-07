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
public class CollectionModel implements Serializable {

    private Integer id;
    private String userCode;
    private String wordCode;

}
