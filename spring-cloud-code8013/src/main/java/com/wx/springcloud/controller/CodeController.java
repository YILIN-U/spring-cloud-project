package com.wx.springcloud.controller;



import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.CodeModel;
import com.wx.springcloud.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class CodeController {

    @Autowired
    CodeService codeService;

    @GetMapping("/getAllEducation")
    public CommonResult getAllEducation(){
        List<CodeModel> list=codeService.getAllEducation();
        return CommonResult.success(list);
    }

    @GetMapping("/getAllMajor")
    public CommonResult getAllMajor(){
        List<CodeModel> list=codeService.getAllMajor();
        return CommonResult.success(list);
    }

    @GetMapping("/getAllReportStatus")
    public CommonResult getAllReportStatus(){
        List<CodeModel> list=codeService.getAllReportStatus();
        return CommonResult.success(list);
    }

//    得到日报为查看的状态信息
    @GetMapping("/getCheckStatus")
    public CommonResult getCheckStatus(){
        List<CodeModel> list=codeService.getCheckStatus();
        return CommonResult.success(list);
    }


    @PostMapping("/getEducationValue/{codeKey}")
    public CommonResult getEducationValue(@PathVariable("codeKey") String codeKey){
        CodeModel codeModel=codeService.getEducationValue(codeKey);
        return CommonResult.success(codeModel);
    }

    @GetMapping("/getValueByStatus/{codeKey}")
    public CommonResult getValueByStatus(@PathVariable("codeKey") String codeKey){
        CodeModel codeModel=codeService.getValueByStatus(codeKey);
        return CommonResult.success(codeModel);
    }


//查询所有的点到状态
    @GetMapping("/getCheckPresence")
    public CommonResult getCheckPresence(){
        List<CodeModel> list=codeService.getCheckPresence();
        return CommonResult.success(list);
    }

// 得到考勤的value值

    @GetMapping("/getCheckPresenceValue/{record}")
    public CommonResult getCheckPresenceValue(@PathVariable("record") String record){
        String value=codeService.getCheckPresenceValue(record);
        return CommonResult.success(value);
    }


}
