package com.example.service.impl;

import java.util.List;
import java.util.Map;

import com.example.mapper.VersionFileMapper;
import com.example.model.VersionFile;
import com.example.service.VersionFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionFileServiceImpl implements VersionFileService {
	
	@Autowired
	private VersionFileMapper versionFileMapper;

	@Override
	public VersionFile getLatestVersionFile() {
		return versionFileMapper.getLatestVersionFile();
	}
}
