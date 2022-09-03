package Execl;

import bean.User;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class ImportUserinfo {
    public static void main(String[] args) {
        //拿到对应xls文件
        File file = new File("D://ExportExecl//用户信息-导入.xls");//D:\ExportExecl
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
        UserService userService=new UserServiceImpl();
        //循环sesheet页中数据从第二行开始，第一行是标题
        //System.out.println(sheet.getPhysicalNumberOfRows());
        //getPhysicalNumberOfRows()获取的是物理行数，也就是不包括那些空行（隔行）的情况
        for(int i = 1;i<sheet.getPhysicalNumberOfRows();i++) {
            //获取每一行的数据
            row = sheet.getRow(i);
            User user=new User();
            //Report rep = new Report();
            //从第一个单元格中获取 id的值
            user.setId(Integer.parseInt(row.getCell(0).getStringCellValue()));
            //从第二个单元格中获取 name的值
            user.setName(row.getCell(1).getStringCellValue());
            //从第三个单元格中获取 password的值
            user.setPassword(row.getCell(2).getStringCellValue());
            //从第四个单元格中获取 结果的值
            user.setCreateTime(new Date(row.getCell(3).getStringCellValue()));
            //从第五个单元格中获取 地址的值
            user.setEmail(row.getCell(4).getStringCellValue());
            user.setPhone(row.getCell(5).getStringCellValue());
            //调用添加方法
            userService.update(user);
        }
        System.out.println("导入成功");
    }


    }

