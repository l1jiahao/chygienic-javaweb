package com.ncu.chygienicjavaweb.controller.admin;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.admin.GetForm;
import com.ncu.chygienicjavaweb.mapper.admin.GetFormMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

//第6个接口控制层，获取已经发布的表单
@RestController
@RequestMapping("/getForm")
public class GetFormController {

    @Resource
    GetFormMapper getFormMapper;
    @RequestMapping("/getAllForm")
    public JSONObject getAllForm(int proj_type_id){

        ArrayList<GetForm> list =getFormMapper.getAllForm(proj_type_id);

        JSONArray projectJsonAry = new JSONArray();
        JSONObject jsonTotal =new JSONObject();
        //判断条件不能用list==null来判断，因为即使查询不到list也不为空，但长度为空
        if(list.size()==0){
            jsonTotal.put("status",0);
            jsonTotal.put("message","未正确选择项目类型");
        }
        else {
            projectJsonAry.addAll(list);
            jsonTotal.put("message",projectJsonAry);
            jsonTotal.put("status",1);
        }
        return jsonTotal;
    }

}
