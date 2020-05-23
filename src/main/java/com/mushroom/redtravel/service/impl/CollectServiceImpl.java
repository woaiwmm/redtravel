package com.mushroom.redtravel.service.impl;

import com.mushroom.redtravel.mapper.CollectMapper;
import com.mushroom.redtravel.result.CodeMsg;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2020-03-05 22:59
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;


    public Result<String> isCollectPost(int uid, int pid) {
        int resultCount = collectMapper.isCollectPost(uid, pid);
        if (resultCount <= 0)//未收藏
            return Result.error(new CodeMsg(0, "未收藏"));
        return Result.success("已收藏");
    }

    public Result<String> updateCollectStatus(int uid, int pid, int flag) {
        if (flag == 0) {//要收藏
            Integer resultCount = collectMapper.addCollect(uid, pid);
            if (resultCount<=0)
                return Result.error(new CodeMsg(0,"操作失败"));
        } else {//取消收藏
            Integer resultCount= collectMapper.deleteCollect(uid, pid);
            if (resultCount<=0)
                return Result.error(new CodeMsg(0,"操作失败"));
        }
        return Result.success("操作成功");
    }

}
