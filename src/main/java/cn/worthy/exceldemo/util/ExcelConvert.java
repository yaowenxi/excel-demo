package cn.worthy.exceldemo.util;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: yaowenxi
 * @version: 1.0
 * @date: 2018/5/22
 */
@Component
public class ExcelConvert {

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //判断数据的类型
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BLANK:
                cellValue = "";
                break;
            case ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }


    public static <T extends Object> T convertBeanFromArray(Object[] arr, Class<T> clazz) {
        T entity;
        try {
            entity = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(ExcelCell.class)) {
                    continue;
                }


                field.setAccessible(true);
                ExcelCell anno = field.getAnnotation(ExcelCell.class);
                Class<?> cellType = anno.Type();
                Integer col = anno.col();

                if (col >= arr.length) {
                    continue;
                }
                if (arr[col] == null) {
                    continue;
                }
                if (cellType == null) {
                    field.set(entity, arr[col]);
                } else {
                    field.set(entity,arr[col]);
                }
            }
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
