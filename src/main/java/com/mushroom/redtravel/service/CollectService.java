package com.mushroom.redtravel.service;

import com.mushroom.redtravel.result.Result;

/**
 * @author Administrator
 * @date 2020-03-05 23:14
 */
public interface CollectService {
    Result<String> isCollectPost(int uid, int pid);
    Result<String> updateCollectStatus(int uid, int pid, int flag);
}
