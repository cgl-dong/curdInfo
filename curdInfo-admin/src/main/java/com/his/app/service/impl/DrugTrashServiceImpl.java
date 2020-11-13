package com.his.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.his.app.mapper.DrugTrashMapper;
import com.his.app.service.DrugTrashService;
import com.his.app.vo.DrugTrash;
import org.springframework.stereotype.Component;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/2 8:35
 */
@Component
public class DrugTrashServiceImpl extends ServiceImpl<DrugTrashMapper, DrugTrash> implements DrugTrashService {
}
