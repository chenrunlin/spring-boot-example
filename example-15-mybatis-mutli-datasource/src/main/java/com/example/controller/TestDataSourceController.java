package com.example.controller;

import com.example.common.datasource.DataSourceContextHolder;
import com.example.common.datasource.DataSourceType;
import com.example.model.BlackList;
import com.example.model.VersionFile;
import com.example.service.BlackListService;
import com.example.service.VersionFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestDataSourceController {

    @Autowired
    private BlackListService blackListService;

    @Autowired
    private VersionFileService versionFileService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public List<BlackList> getTotalBlackList() {
        System.out.println("查询二级平台数据源");
        DataSourceContextHolder.setDbType(DataSourceType.BUS_SERVER_DATASOURCE);
        return blackListService.getTotalBlackList();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public VersionFile getVersionFileListByCondition() {
        System.out.println("查询前置服务器数据源");
        DataSourceContextHolder.setDbType(DataSourceType.EQU_WATCH_DATASOURCE);
        return versionFileService.getLatestVersionFile();
    }

    //DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public Map<String, Object> mixtureDataSource() {
        System.out.println("交叉查询二级平台数据源和前置服务器数据源");
        Map<String, Object> map = new HashMap<String, Object>();
        //
        DataSourceContextHolder.setDbType(DataSourceType.BUS_SERVER_DATASOURCE);
        List<BlackList> blackList1 = blackListService.getTotalBlackList();
        //
        DataSourceContextHolder.setDbType(DataSourceType.EQU_WATCH_DATASOURCE);
        VersionFile versionFile = versionFileService.getLatestVersionFile();
        //
        DataSourceContextHolder.setDbType(DataSourceType.BUS_SERVER_DATASOURCE);
        List<BlackList> blackList2 = blackListService.getTotalBlackList();
        map.put("blackList1", blackList1);
        map.put("blackList2", blackList2);
        map.put("versionFile", versionFile);
        return map;
    }

}