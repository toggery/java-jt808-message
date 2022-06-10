package io.github.toggery.jt808.messagebody;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * JT/T 消息体 0x8600 设置圆形区域 // 2019 modify
 * <br>
 * <p><b>注：</b>本条消息协议支持周期时间范围，如要限制每天的8:30-18:00，起始/结束时间设
 * 为：000000083000/000000180000，其他以此类推。</p>
 *
 * @author togger
 */
@Data
public class B8600 {

    /**
     * BYTE 属性
     *
     * <ul>
     *     <li>0：更新区域；</li>
     *     <li>1：追加区域；</li>
     *     <li>2：修改区域；</li>
     * </ul>
     */
    private int action;

    /** 区域列表 */
    private final List<Region> regions = new ArrayList<>();

    /** 区域 */
    @Data
    public final static class Region {

        /** DWORD 区域 ID */
        private long id;

        /**
         * WORD 区域属性
         *
         * <ul>
         *     <li>bit0: 是否启用起始时间与结束时间的判断规则，0.否 1.是；</li>
         *     <li>bit1: 是否启用最高速度、超速持续时间和夜间最高速度的判断规则，0.否 1.是；</li>
         *     <li>bit2: 进区域是否报警给驾驶员，0.否 1.是；</li>
         *     <li>bit3: 进区域是否报警给平台，0.否 1.是；</li>
         *     <li>bit4: 出区域是否报警给驾驶员，0.否 1.是；</li>
         *     <li>bit5: 出区域是否报警给平台，0.否 1.是；</li>
         *     <li>bit6: 0.北纬 1.南纬；</li>
         *     <li>bit7: 0.东经 1.西经；</li>
         *     <li>bit8: 0.允许开门 1.禁止开门；</li>
         *     <li>bit9~13: 保留</li>
         *     <li>bit14: 0.进区域开启通信模块 1.进区域关闭通信模块；</li>
         *     <li>bit15: 0.进区域不采集 GNSS 详细定位数据 1.进区域采集 GNSS 详细定位数据；</li>
         * </ul>
         */
        private int flags;

        /** DWORD 中心点纬度，以度为单位的纬度值乘以 10 的 6 次方，精确到百万分之一度 */
        private long latitude;

        /** DWORD 中心点经度，以度为单位的经度值乘以 10 的 6 次方，精确到百万分之一度*/
        private long longitude;

        /** DWORD 半径，单位为米（m），路段为该拐点到下一拐点 */
        private long radius;

        /** BCD[6] 起始时间，yyMMddHHmmss，若区域属性 0 位为 0 则没有该字段 */
        private String startTime;

        /** BCD[6] 结束时间，yyMMddHHmmss，若区域属性 0 位为 0 则没有该字段 */
        private String endTime;

        /** WORD 最高速度，单位为km/h，若区域属性1位为 0 则没有该字段 */
        private int topSpeed;

        /** BYTE 超速持续时间，单位为秒（s）（类似表述，同前修改），若区域属性1位为 0 则没有该字段 */
        private int duration;

        /** WORD 夜间最高速度，单位为km/h，若区域属性1位为 0 则没有该字段 */
        private int nightTopSpeed;

        /** STRING 区域名称 */
        private String name;

    }

}