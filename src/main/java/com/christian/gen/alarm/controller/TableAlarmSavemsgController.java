package com.christian.gen.alarm.controller;


import com.christian.gen.alarm.dto.MsgDto;
import com.christian.gen.alarm.entity.TableAlarmSavemsg;
import com.christian.gen.alarm.service.ITableAlarmSavemsgService;
import com.christian.gen.common.domain.ResponseBo;
import com.christian.gen.common.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author christian
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/alarm")
public class TableAlarmSavemsgController {

    @Autowired
    private ITableAlarmSavemsgService savemsgService;


    @PostMapping(value = "getList")
    public ResponseBo getList(@RequestBody MsgDto dto){
        List<TableAlarmSavemsg> list = savemsgService.list();
        return ResponseBo.ok(null,list);
    }

    @PostMapping(value = "saveOrUpdate")
    public ResponseBo saveMsg(@RequestBody TableAlarmSavemsg msg){
        ValidationUtil.ValidResult result = ValidationUtil.validateBean(msg);
        if(result.hasErrors()){
            String errors = result.getErrors();
            return ResponseBo.error(errors);
        }
        if(savemsgService.saveOrUpdate(msg)){
            return ResponseBo.ok();
        }
        return ResponseBo.error();
    }
}
