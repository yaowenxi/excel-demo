package cn.worthy.exceldemo.controller;

import cn.worthy.exceldemo.service.ExcelService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

import static cn.worthy.exceldemo.common.ExcelConstans.XLS;
import static cn.worthy.exceldemo.common.ExcelConstans.XLSX;

/**
 * @author: yaowenxi
 * @version: 1.0
 * @date: 2018/5/22
 */

@RestController
@RequestMapping("excel")
public class ExcelController {


    @Autowired
    private ExcelService excelService;

    @PostMapping
    public void loadExcel(@RequestParam("file") MultipartFile file) throws InvalidFormatException,IOException {

        if (Objects.isNull(file)) {
            throw new RuntimeException("文件不能为空");
        }

        String fileName = file.getOriginalFilename().toLowerCase();

        if (fileName.endsWith(XLS) || fileName.endsWith(XLSX)) {

            excelService.parseExcel(file);

        } else {
            throw new RuntimeException("文件后缀名非法，只支持xls和xlsx格式文件");
        }

        return;
    }

}
