package cn.worthy.exceldemo.util;

import java.lang.annotation.*;

/**
 * @author: yaowenxi
 * @version: 1.0
 * @date: 2018/5/22
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelCell {

    int col();

    Class<?> Type() default String.class;

}
