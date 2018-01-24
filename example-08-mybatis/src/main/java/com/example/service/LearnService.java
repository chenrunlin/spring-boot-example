package com.example.service;

import com.example.domain.LearnResouce;

import java.util.List;
import java.util.Map;

/**
 * Created by tengj on 2017/4/7.
 */

public interface LearnService {
    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String[] ids);
    LearnResouce queryLearnResouceById(Long learnResouce);
    int queryLearnResouceCount(Map<String, Object> params);
    List<LearnResouce> queryLearnResouceList(Map<String, Object> params);
}
