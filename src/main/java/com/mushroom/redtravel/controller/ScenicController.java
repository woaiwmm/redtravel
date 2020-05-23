package com.mushroom.redtravel.controller;

import com.mushroom.redtravel.pojo.Scenic;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 景点控制器
 *
 * @author Mushroom
 * @date 2020-02-07 21:08
 */
@Controller
public class ScenicController {

    @Autowired
    private ScenicService scenicService;
    @RequestMapping(value = "/scenic/getScenicMsg")
    @ResponseBody
    public Result<Scenic> getScenicMsg(int id) {
        return scenicService.getScenicMsg(id);
    }


    @RequestMapping(value = "/scenic/searchScenic")
    @ResponseBody
    public Result<List<Scenic>> searchScenic(String city, String name){
        return scenicService.searchScenic(city,name);
    }
}
