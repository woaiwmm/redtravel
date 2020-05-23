package com.mushroom.redtravel.service.impl;

import com.mushroom.redtravel.mapper.ScenicMapper;
import com.mushroom.redtravel.pojo.People;
import com.mushroom.redtravel.pojo.Scenic;
import com.mushroom.redtravel.result.CodeMsg;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mushroom
 * @date 2020-02-07 21:11
 */
@Service
public class ScenicServiceImpl implements ScenicService {
    @Autowired
    private ScenicMapper scenicMapper;

    public Result<Scenic> getScenicMsg(int id){
        Scenic scenic = scenicMapper.getScenicMsgById(id);
        return scenic==null?Result.error(new CodeMsg(0,"没有该信息")):Result.success(scenic);
    }

    public Result<List<Scenic>> searchScenic(String city, String name){
        List<Scenic> scenicList=null;
        if ("不限".equals(city)){
            scenicList = scenicMapper.searchScenicByName(name);
            if (scenicList==null||scenicList.size()<=0){
                return Result.error(new CodeMsg(0,"没有找到结果"));
            }
            return Result.success(scenicList);
        }
        scenicList = scenicMapper.searchScenicByNameAndCity(city, name);
        if (scenicList==null||scenicList.size()<=0){
            return Result.error(new CodeMsg(0,"没有找到结果"));
        }
        return Result.success(scenicList);
    }
}
