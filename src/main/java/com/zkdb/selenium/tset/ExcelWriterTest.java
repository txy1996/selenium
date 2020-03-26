package com.zkdb.selenium.tset;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;

import com.zkdb.selenium.reimbursement.RequiredField;
import com.zkdb.selenium.util.ExcelWriter;

/**
 * 
 * @ClassName: ExcelWriterTest 
 * @Description: TODO(excel写入测试) 
 * @author tangxiaoyu 
 * @date 2020年3月26日 上午10:33:13 
 *
 */
public class ExcelWriterTest {

    private static Logger logger = Logger.getLogger(ExcelWriterTest.class.getName());
    
    public static void test(ArrayList<RequiredField> requiredFields) {
        
        Workbook workbook =ExcelWriter.exportData(requiredFields);
        FileOutputStream fileOutputStream=null;
        try {
            String exportFilePath ="D:\\费用报销模块\\费用报销测试用例写入.xlsx";
            File exportFile =new File(exportFilePath);
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }
            fileOutputStream =new FileOutputStream(exportFile);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
        }
        catch (Exception e) {
            // TODO: handle exception
            logger.warn("输出Excel时发生错误，错误原因：" + e.getMessage());
        }finally {
            try {
                if(null!=fileOutputStream) {
                    fileOutputStream.close();
                }
                if(null!=workbook) {
                    workbook.close();
                }
            }
            catch (Exception e2) {
                // TODO: handle exception
                logger.warn("关闭输出流时发生错误，错误原因：" + e2.getMessage());
            }
        }
        
    }
}
