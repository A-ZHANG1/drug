package com.w.drug.data.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
public class Drug {
    @ApiModelProperty(value = "药品id号, 主键id" )
    private int id;

    @ApiModelProperty(value = "药品小分类" )
    private String drugSubgroup;

    @ApiModelProperty(value = "药品名称" )
    private String drugName;

    @ApiModelProperty(value = "功能主治" )
    private String indication;

}
