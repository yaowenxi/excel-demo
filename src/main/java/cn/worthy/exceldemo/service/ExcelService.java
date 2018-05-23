package cn.worthy.exceldemo.service;

import cn.worthy.exceldemo.common.entity.Goods;
import cn.worthy.exceldemo.common.entity.OrderDetail;
import cn.worthy.exceldemo.util.ExcelConvert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static cn.worthy.exceldemo.common.ExcelConstans.DEFAULT_SHEET;
import static cn.worthy.exceldemo.common.ExcelConstans.START_DATA_ROW;
import static com.google.common.collect.Lists.newArrayList;

/**
 * @author: yaowenxi
 * @version: 1.0
 * @date: 2018/5/22
 */
@Service
public class ExcelService {

    public void parseExcel(MultipartFile file) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(DEFAULT_SHEET);
        List<OrderDetail> orderDetailList = newArrayList();
        for (int i = START_DATA_ROW; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            OrderDetail orderDetail = convertBeanFromRow(row);
            orderDetailList.add(orderDetail);
        }
        System.out.println(orderDetailList.size());
    }

    public OrderDetail convertBeanFromRow(Row row) {
        int cols = row.getLastCellNum();
        String[] arr = new String[cols];
        for (int i = 0; i < cols; i++) {
            Cell cell = row.getCell(i);
            arr[i] = ExcelConvert.getCellValue(cell);
        }
        OrderDetail orderDetail = ExcelConvert.convertBeanFromArray(arr, OrderDetail.class);
        return orderDetail;
    }

}
