package com.christian.gen.alarm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author christian
 * @since 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("table_alarm_savemsg")
public class TableAlarmSavemsg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 房间id
     */
    @NotNull
    private Integer cellid;

    /**
     * 传感器id
     */
    private Integer sensorid;

    /**
     * 告警时间
     */
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date alarmTime;

    /**
     * 图片类型-不使用
     */
    private Integer pictureType;

    /**
     * 告警文件名称--深度图片-路径
     */
    private String alarmPictureName;

    /**
     * 告警事件
     */
    private Integer alarmType;

    /**
     * 告警原因
     */
    private Integer alarmReason;

    /**
     * 备用字段-告警图片-rgb图片路径
     */
    private String parse;


}
