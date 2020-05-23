package com.mushroom.redtravel.service.impl;

import com.mushroom.redtravel.mapper.PeopleMapper;
import com.mushroom.redtravel.pojo.People;
import com.mushroom.redtravel.result.CodeMsg;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-02-07 20:16
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;

    public Result<People> getPeopleMsg(int id){
        People people = peopleMapper.getPeopleMsgById(id);
       return people==null?Result.error(new CodeMsg(0,"查询失败")):Result.success(people);
    }

    public Result<List<People>> searchPeople(String city, String name){
        List<People> peopleList=null;
        if ("不限".equals(city)){
            peopleList = peopleMapper.searchPeopleByName(name);
            if (peopleList==null||peopleList.size()<=0){
                return Result.error(new CodeMsg(0,"没有找到结果"));
            }
            return Result.success(peopleList);
        }
         peopleList = peopleMapper.searchPeopleByNameAndCity(city, name);
        if (peopleList==null||peopleList.size()<=0){
            return Result.error(new CodeMsg(0,"没有找到结果"));
        }
        return Result.success(peopleList);
    }
}
