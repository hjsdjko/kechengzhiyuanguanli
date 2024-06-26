package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuoyeEntity;
import java.util.Map;

/**
 * 作业信息 服务类
 */
public interface ZuoyeService extends IService<ZuoyeEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}