package com.wx.springcloud.controller;


import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.CheckPresenceModel;
import com.wx.springcloud.service.CheckPresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/checkPresence")
public class CheckPresenceController {

    @Autowired
    CheckPresenceService checkPresenceService;

    @PostMapping("/checkPresenceAdd")
    public CommonResult checkPresenceAdd(@RequestBody CheckPresenceModel checkPresenceModel){

        String checkPresenceInfo = checkPresenceModel.getCheckPresenceInfo().replace("[", "").replace("]", "");
        checkPresenceInfo = checkPresenceInfo.replace("\"", "");
        String[] checkPresenceInfoArray = checkPresenceInfo.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(checkPresenceInfoArray));
        List<CheckPresenceModel> checkPresenceModels=new ArrayList<>();

        List<String> userCodes=new ArrayList<>();
        List<String> userNames=new ArrayList<>();
        List<String> records=new ArrayList<>();
        for (String s:list){
            String[] split = s.split("@@");
            records.add(split[0]);
            userCodes.add(split[1]);
            userNames.add(split[2]);
        }
        for (int i=0;i<userCodes.size();i++){
            CheckPresenceModel model=new CheckPresenceModel();
            model.setUserCode(userCodes.get(i));
            model.setRecord(records.get(i));
            model.setUserName(userNames.get(i));
            checkPresenceModels.add(model);
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        checkPresenceModel.setRecordTime(simpleDateFormat.format(new Date()));
        checkPresenceModel.setCheckPresenceModelList(checkPresenceModels);
        int count=checkPresenceService.checkPresenceAdd(checkPresenceModel);
        return CommonResult.success(count);
    }

//    得到所有的考勤信息
    @PostMapping("/getAllPresence")
    public CommonResult getAllPresence(@RequestBody(required = false) CheckPresenceModel checkPresenceModel){
        List<CheckPresenceModel> list=checkPresenceService.getAllPresence(checkPresenceModel);
        return CommonResult.success(list);
    }

//   删除考勤信息
    @DeleteMapping("/checkPresenceDelete/{id}")
    public CommonResult checkPresenceDelete(@PathVariable("id") String id){

        int count=checkPresenceService.checkPresenceDelete(id);

        return CommonResult.success(count);

    }
}

