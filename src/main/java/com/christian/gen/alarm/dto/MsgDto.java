package com.christian.gen.alarm.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.christian.gen.alarm.entity.TableAlarmSavemsg;
import lombok.Data;

/**
 * @author christian
 * @date 2019/12/27 - 15:08
 */
@Data
public class MsgDto {
    private long current;
    private long size;

    public QueryWrapper<TableAlarmSavemsg> createWrapper(){
        QueryWrapper<TableAlarmSavemsg> wrapper = new QueryWrapper<>();
        return wrapper;
    }
}
