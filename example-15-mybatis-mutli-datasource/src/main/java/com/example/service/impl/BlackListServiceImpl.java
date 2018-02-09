package com.example.service.impl;

import java.util.List;
import java.util.Map;

import com.example.mapper.BlackListMapper;
import com.example.model.BlackList;
import com.example.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackListServiceImpl implements BlackListService {

	@Autowired
	private BlackListMapper blackListMapper;

	@Override
	public BlackList getBlackListById(String id) {
		return blackListMapper.getBlackListById(id);
	}

	@Override
	public BlackList getBlackListByCardNo(String card_no) {
		return blackListMapper.getBlackListByCardNo(card_no);
	}

	@Override
	public List<BlackList> getTotalBlackList() {
		return blackListMapper.getTotalBlackList();
	}
}
