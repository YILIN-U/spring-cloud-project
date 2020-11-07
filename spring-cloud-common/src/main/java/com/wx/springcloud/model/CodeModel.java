package com.wx.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeModel {

    private Integer id;
    private String app;
    private String type;
    private String codeKey;
    private String codeValue;
    private Integer codeOrder;




}
