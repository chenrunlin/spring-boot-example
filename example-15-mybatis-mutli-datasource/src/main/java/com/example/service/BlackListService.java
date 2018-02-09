package com.example.service;

import com.example.model.BlackList;

import java.util.List;
import java.util.Map;

public interface BlackListService {
	/**
	 * 根据id获取对象
	 * @param id
	 * @return
	 */
	BlackList getBlackListById(String id);
	/**
	 * 根据卡号获取对象
	 * @param card_no
	 * @return
	 */
	BlackList getBlackListByCardNo(String card_no);
	/**
	 * 获取所有对象
	 * @return
	 */
	List<BlackList> getTotalBlackList();
}
