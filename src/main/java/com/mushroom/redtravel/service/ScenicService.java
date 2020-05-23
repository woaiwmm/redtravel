package com.mushroom.redtravel.service;

import com.mushroom.redtravel.pojo.Scenic;
import com.mushroom.redtravel.result.Result;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-02-07 21:09
 */
public interface ScenicService {
    Result<Scenic> getScenicMsg(int id);
    Result<List<Scenic>> searchScenic(String city, String name);
}
