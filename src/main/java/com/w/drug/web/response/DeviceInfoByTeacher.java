package com.w.drug.web.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel
public class DeviceInfoByTeacher {
    @ApiModelProperty(value = "教师id" )
    int teacherId;
    @ApiModelProperty(value = "教师名" )
    String teacherName;
    @ApiModelProperty(value = "学生数" )
    int studentNum;
    @ApiModelProperty(value = "手环数" )
    int deviceNum;

    public DeviceInfoByTeacher(int teacherId, String teacherName, int studentNum, int deviceNum) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.studentNum = studentNum;
        this.deviceNum = deviceNum;
    }

}
