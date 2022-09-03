package Execl;

import bean.People;
import dao.impl.PeopleDaoImpl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Importpeopletest {

    public static void impotrto(){

        //拿到对应xls文件
        File file = new File("D://ExportExecl//importpeople.xls");//D:\ExportExecl
        //转换成文件流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //根据路径获取这个操作xls的实例  创建一个工作簿HSSFWorkbook
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //根据页面index 获取sheet页
        HSSFSheet sheet = wb.getSheetAt(0);
        //声明行数据，对应exel的行
        HSSFRow row = null;
        //实例化一个检测报告对象dao
        //ReportDao rd = new ReportDao();
        People people=new People();
        PeopleDaoImpl peopleDao=new PeopleDaoImpl();
        //循环sesheet页中数据从第二行开始，第一行是标题
        //System.out.println(sheet.getPhysicalNumberOfRows());
        //getPhysicalNumberOfRows()获取的是物理行数，也就是不包括那些空行（隔行）的情况
        for(int i = 1;i<sheet.getPhysicalNumberOfRows();i++) {
            //获取每一行的数据
            row = sheet.getRow(i);

            //Report rep = new Report();
            //从第一个单元格中获取 id的值
            //获取单元格
            HSSFCell cell0 = row.getCell(0);
//设置单元格类型
            cell0.setCellType(CellType.STRING);
//获取单元格数据
            String cellValue0 = cell0.getStringCellValue();
            people.setId(Integer.parseInt(cellValue0));
            //people.setId(Integer.parseInt(row.getCell(0).getStringCellValue()));
            //从第二个单元格中获取 name的值
            //获取单元格
            HSSFCell cell = row.getCell(1);
            //设置单元格类型
            cell.setCellType(CellType.STRING);
            //获取单元格数据
            String cellValue = cell.getStringCellValue();
            people.setName(cellValue);
            //people.setName((row.getCell(1).getStringCellValue()));
            //从第三个单元格中获取 password的值
            //获取单元格
            HSSFCell cell2 = row.getCell(0);
            //设置单元格类型
            cell.setCellType(CellType.STRING);
            //获取单元格数据
            String cellValue2 = cell.getStringCellValue();
            people.setPassword(cellValue2);
            //people.setPassword(row.getCell(2).getStringCellValue());

            //调用添加方法
            peopleDao.insert(people);
        }
        System.out.println("导入成功");
    }


}

