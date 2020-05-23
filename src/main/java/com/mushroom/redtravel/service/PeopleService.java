package com.mushroom.redtravel.service;

import com.mushroom.redtravel.pojo.People;
import com.mushroom.redtravel.result.Result;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-02-07 20:15
 */
public interface PeopleService {
    Result<People> getPeopleMsg(int id);
    Result<List<People>> searchPeople(String city, String name);
}
