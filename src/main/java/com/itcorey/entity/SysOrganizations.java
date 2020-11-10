package com.itcorey.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.itcorey.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织部门表
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysOrganizations extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 企业法人
     */
    private String legalPerson;

    /**
     * 企业法人电话
     */
    private String legalMobile;

    /**
     * 统一社会信息代码
     */
    private String socialCode;

    /**
     * 上级部门ID
     */
    @TableField("PARENTID")
    private Integer parentid;

    /**
     * 子部门数
     */
    @TableField("SUBCOUNT")
    private Integer subcount;

    /**
     * 是否为签约用户,为1时为非签约企业
     */
    private Integer sham;

    /**
     * 序号
     */
    @TableField("SEQ")
    private Integer seq;

    /**
     * 子部门分配最大编码
     */
    @TableField("MAXCODE")
    private Integer maxcode;

    /**
     * 部门名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 部门联系方式
     */
    @TableField("CONTACTWAY")
    private String contactway;

    /**
     * 部门内置类型码
     */
    @TableField("ORGINTERNALCODE")
    private String orginternalcode;

    /**
     * 部门名称简拼
     */
    @TableField("SIMPLEPINYIN")
    private String simplepinyin;

    /**
     * 部门名称全拼
     */
    @TableField("FULLPINYIN")
    private String fullpinyin;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 创建用户
     */
    @TableField("CREATEUSER")
    private String createuser;

    /**
     * 更新用户名
     */
    @TableField("UPDATEUSER")
    private String updateuser;

    /**
     * 更新用户
     */
    @TableField("UPDATEDATE")
    private LocalDateTime updatedate;

    /**
     * 创建日期
     */
    @TableField("CREATEDATE")
    private LocalDateTime createdate;

    /**
     * 企业简称
     */
    private String abbreviation;

    /**
     * 城市编码
     */
    private Integer city;

    /**
     * 区域id
     */
    private String areaId;

    /**
     * 街道
     */
    private String street;

    /**
     * 行业（大类）
     */
    private Integer industry;

    /**
     * 在线监测 0巡检 1监测
     */
    private String onlineMonitoring;

    /**
     * 合同容量
     */
    private String contractCapacity;

    /**
     * 运行容量
     */
    private String operatingCapacity;

    /**
     * 用电户号
     */
    private String householdNum;

    /**
     * 电压等级
     */
    private String voltageLevel;

    /**
     * 企业地址
     */
    private String addr;

    /**
     * 用电主管
     */
    private String powerManager;

    /**
     * 用电负责人
     */
    private String powerHead;

    /**
     * 主管电话
     */
    private String managerPhone;

    /**
     * 负责人电话
     */
    private String headPhone;

    private String annexes;

    /**
     * 经度
     */
    private String xaxis;

    /**
     * 纬度
     */
    private String yaxis;

    /**
     * 用户类型（1-常规电能，2-智慧用电，3-光伏类，4-充电桩，5-储能用户，6-合同能源，7-环保用户）
     */
    private String qylx;

    /**
     * 合同开始时间
     */
    private LocalDate htkssj;

    /**
     * 合同结束时间
     */
    private LocalDate htjzsj;

    /**
     * 合同附件名称
     */
    private String htfj;

    private String htms;

    /**
     * 备注
     */
    private String bz;

    /**
     * 合同附件地址(相对)
     */
    @TableField("filePath")
    private String filePath;

    /**
     * 安装单位
     */
    private String installationCompany;

    /**
     * 视频服务器IP
     */
    private String videoIp;

    /**
     * 视频服务器端口
     */
    private String videoPort;

    /**
     * 视频服务器登入用户
     */
    private String videoUsername;

    /**
     * 视频服务器登入密码
     */
    private String videoPassword;

    /**
     * 视频服务器类型
     */
    private Integer videoStreamtype;

    /**
     * 企业类型（1-政府机关，2-事业单位，3-学校，4-医院，5-企业，6-商场，7-住宅，8-酒店)
     */
    private String custype;

    /**
     * 企业log路径
     */
    private String companyLogPath;

    /**
     * 企业图片路径
     */
    private String companyImagePath;

    /**
     * 客户代码
     */
    private String customerCode;

    /**
     * 合同编号
     */
    private String contractNumber;

    /**
     * 用户简介
     */
    private String userSummary;

    /**
     * 服务内容
     */
    private String serviceContent;

    /**
     * 表计类型
     */
    private String meterType;

    /**
     * 行业（中类）
     */
    private String industryTwo;

    /**
     * 供电单位
     */
    private String electricityCompany;

    /**
     * 是否启用  1 启用 0 不启用
     */
    private Integer flag;

    private String standardCos;

    /**
     * 用电状态（1-新用户，2-续签用户)
     */
    private String state;

    /**
     * 通道数
     */
    private String videoPassway;

    /**
     * 视频设备id
     */
    private String videodevid;

    /**
     * 短信发送状态 1：已发送 0：未发送 2 :发送失败
     */
    private String smsState;

    /**
     * 用户设备信息 
     */
    private String equipmentinfo;

    /**
     * 运行单位，1、组织单位，2、兴耀
     */
    private Integer operationCompany;

    private Integer zhxxflag;

    /**
     * 变压器总数(台)
     */
    private String contractTransformers;

    /**
     * 配电房数量(注： 巡检类用户一般未进行配电房建模)
     */
    @TableField("stationNum")
    private Integer stationNum;

    /**
     * 运行变压器(台)
     */
    private String operatingTransformers;

    /**
     * 区域管理(水务集团，业务区域，有别于行政区域)
     */
    private String region;

    private String affiliatedUnit;


}
