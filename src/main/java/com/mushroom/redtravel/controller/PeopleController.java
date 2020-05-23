package com.mushroom.redtravel.controller;

import com.mushroom.redtravel.pojo.People;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 红色人物相关
 * @author Mushroom
 * @date 2020-02-07 20:15
 */
@Controller
public class PeopleController {

    @Autowired
    private PeopleService peopleService;


    /**
     * 获得红色人物信息
     * @param id
     * @return
     */
    @RequestMapping(value="/people/getPeopleMsg")
    @ResponseBody
    public Result<People> getPeopleMsg(int id){
       return peopleService.getPeopleMsg(id);
    }


    @RequestMapping(value = "/people/searchPeople")
    @ResponseBody
    public Result<List<People>> searchPeople(String city,String name){
         return peopleService.searchPeople(city,name);
    }
}
