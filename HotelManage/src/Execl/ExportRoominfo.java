package Execl;

import bean.Room;
import bean.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import service.RoomService;
import service.UserService;
import service.impl.RoomServiceImpl;
import service.impl.UserServiceImpl;

import java.io.FileOutputStream;
import java.util.List;

public class ExportRoominfo {
    public static void main(String[] args) {}


        public  static void  export(){
        /*UserService service=new UserServiceImpl();
        List<User> userList = service.queryAll();*/
            RoomService roomService=new RoomServiceImpl();
            List<Room> roomList = roomService.queryAll();
            //标题
        String[] title = {"房间号","姓名","密码","房型","价格"};
        //创建一个SXSSFWorkbook工作簿  读取.xls 格式
        //自定义内存中数据的数量
        SXSSFWorkbook wb = new SXSSFWorkbook(20);
        //将SXSSFWorkbook工作簿添加到表
        Sheet sheet = wb.createSheet();
        //创建行，  0：代表第一个单元格
        Row row = sheet.createRow(0);
        //给单元格设置样式，添加到工作簿的样式表中
        CellStyle cellStyle = wb.createCellStyle();
        //创建一个新字体，并添加到工作簿的字体表中
        Font font = wb.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 12);
        //设置字体加粗
        font.setBold(true);
        //给字体设置样式
        cellStyle.setFont(font);
        //设置单元格背景颜色
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        //设置单元格填充样式（使用纯色背景颜色填充）
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        //填充表头数据
        for(int i = 0;i<title.length;i++) {
            //创建新单元格
            Cell cell = row.createCell(i);
            //放入 标题单元格的数值
            cell.setCellValue(title[i]);
            //为单元格设置样式
            cell.setCellStyle(cellStyle);
            //设置列的宽度
            sheet.setColumnWidth(i, 200*50);
        }
        //填充数据库表数据
        for(int j = 0;j<roomList.size();j++) {
            //创建行
            Row r = sheet.createRow(j+1);
            Room room=roomList.get(j);

            //获取 编号的数值（第一个单元格）
            Cell cell = r.createCell(0);
            cell.setCellValue(room.getRoomnum());
            //获取 名字的数值
            Cell cell2 = r.createCell(1);
            cell2.setCellValue(room.getName());
            //获取 Password的数值
            Cell cell3 = r.createCell(2);
            cell3.setCellValue(room.getPassword());
            //获取 CreateTime的数值
            Cell cell4 = r.createCell(3);
            cell4.setCellValue(room.getType());
            //获取 Email的数值
            Cell cell5 = r.createCell(4);
            cell5.setCellValue(room.getPrice());

        }
        //设置输出路径
        String filename = "D://ExportExecl//房间信息.xls";//D:\ExportExecl
        try {
            // 输出到硬盘，所以要用到IO流，输出到fileName指定的路径上
            FileOutputStream fos = new FileOutputStream(filename);
            wb.write(fos);//写出
            wb.close();//关闭
            System.out.println("导出成功");
        } catch (Exception e) {
            //异常信息
            e.printStackTrace();
        }
    }

    }

