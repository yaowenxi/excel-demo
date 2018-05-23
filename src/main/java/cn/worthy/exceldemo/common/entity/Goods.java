package cn.worthy.exceldemo.common.entity;

import cn.worthy.exceldemo.util.ExcelCell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yaowenxi
 * @version: 1.0
 * @date: 2018/5/22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    /**
     * 商品名
     */
    @ExcelCell(col = 0)
    private String name;

    /**
     * 单位
     */
    @ExcelCell(col = 1)
    private String unit;

    /**
     * 规格
     */
    @ExcelCell(col = 2)
    private String format;

    /**
     * 生产厂家
     */
    @ExcelCell(col = 3)
    private String factory;
}
