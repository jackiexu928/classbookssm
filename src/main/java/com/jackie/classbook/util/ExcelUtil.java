package com.jackie.classbook.util;

import com.jackie.classbook.dto.response.ExportRespDTO;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;

import java.awt.*;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/11/30
 */
public class ExcelUtil {
    public static void export(ExportRespDTO exportRespDTO) throws Exception{
        String[] title = exportRespDTO.getTitle();
        String[][] content = exportRespDTO.getContent();
        String filePath = "E:\\jackie";
        String fileName = exportRespDTO.getFileName() + ".xls";
        File dir=new  File(filePath);
        if(!dir.isDirectory()){
            dir.mkdirs();
        }
        File file = new File(filePath+"\\"+fileName);
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        WritableSheet sheet = workbook.createSheet(exportRespDTO.getFileName(), 0);

        Label lab = null;
        /**
         * 标题栏
         */
        jxl.write.WritableFont wfcNav =new jxl.write.WritableFont(WritableFont.TIMES,12, WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
        WritableCellFormat wcfN=new WritableCellFormat(wfcNav);

        Color color = Color.decode("#000000"); // 自定义的颜色
        workbook.setColourRGB(Colour.BLACK, color.getRed(),color.getGreen(), color.getBlue());

        wcfN.setBackground(Colour.ORANGE);
        wcfN.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
        wcfN.setAlignment(Alignment.CENTRE); //设置水平对齐
        wcfN.setWrap(false); //设置自动换行
        for(int i = 0; i < title.length; i ++){
            lab = new Label(i, 0, title[i], wcfN); //Label(col,row,str);
            sheet.addCell(lab);
            //sheet.setColumnView(i, new String(title[i]).length() * 5);
            sheet.setColumnView(i, 20);//列宽
        }

        /**
         * 内容
         */
        jxl.write.WritableFont wfcontent =new jxl.write.WritableFont(WritableFont.TIMES,12, WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE, Colour.BLACK);//字体、颜色
        WritableCellFormat wcfcontent = new WritableCellFormat(wfcontent);
        wcfcontent.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
        wcfcontent.setAlignment(Alignment.LEFT);//左对齐
        CellView cellView = new CellView();
        cellView.setSize(200);
        //cellView.setAutosize(true); //设置自动大小  也许版本问题，本项目依赖的版本不支持
        for(int i = 0; i < content.length; i++){
            for(int j = 0; j < content[i].length; j++){
                //sheet.setColumnView(i, cellView);
                //sheet.setColumnView(i, 20);//根据内容自动设置列宽
                lab = new Label(j, i+1, content[i][j], wcfcontent); //Label(col,row,str);
                sheet.addCell(lab);
                /*int length = new String(content[i][j]).length();
                if (length == 1){
                    sheet.setColumnView(j, 5);
                } else if (length > 1 && length < 7){
                    sheet.setColumnView(j, length * 4);
                } else if(length > 6 && length < 10){
                    sheet.setColumnView(j, length * 3);
                } else {
                    sheet.setColumnView(j, length * 2);
                }*/
                //sheet.setColumnView(j, new String(content[i][j]).length() * 5);
                //sheet.setColumnView(j, 20);
            }
        }

        workbook.write();
        workbook.close();
    }
    public static void main(String[] args) throws Exception {
        String title = "报表测试";
        String[] navTitle= {"第一行","第二行","第三行","第四行","第五行","第六行","第七行","第八行"};
        String[][] content={
                {"1","2","第三行","第四nidnffdas行","第noafonjdf五行","第六sdfafas行","第afdafas七行","第adfadasf八行"},
                {"2","2","第三行","第四行","第五行","第六行","第七行","sssssssssss第八sss行"},
                {"3","2","第三行","第四行","第五行","第六行","第七行","第八行sssssssssssss"},
                {"4","2","第三行","第四行","第sssssssssssssss五行","第ssssssssssssssss六行","第七行","第八行sssssssss"},
                {"5","2","第三行","第dddddddddddddddddddddddddddddddddddd四行","第五行","第六行","第七行","第八行"},
                {"6","2","第三行","第四行","第五行","第六行","第七行","第八行"},
                {"7","2","第三行","第四ddddddddddddddddddddddddddddddd行","第五行","第六行","第七行","第八行"},
                {"8","2","第三行","第四行","第五行","第六行","第七行","第八行"},
                {"9","2","第三行","第ddddddddddddddddddddddddddddddd四行","第五行","第六行","第七行","第八行"},
                {"10","2","第三行","第四行","第五行","第六行","第七行","第八行"},
                {"11","2","第三行","第四行","第五行","第六dddddddddddddd行","第七行","第八行"},
                {"12","2","第三行","第四行","第五行","第六行","第七行","第八行"},
                {"13","2","第三行","第四行","第五行","dddddddddddddddddddddd第六行","第七行","第八行"},
                {"14","2","第三行","第四行","第五行","第dddddddddddddddddddddd六行","第七行","第八行"},
        };
        String filePath = "E:\\jackie";
        String fileName="NewProject.xls";
        File dir=new  File(filePath);
        if(!dir.isDirectory()){
            dir.mkdirs();
        }
        File file = new File(filePath+"\\"+fileName);
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        WritableSheet sheet = workbook.createSheet("报表统计", 0);  //单元格
        /**
         * title
         */
        Label lab = null;
        // 定义格式 字体 下划线 斜体 粗体 颜色
        WritableFont wf2 = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
        WritableCellFormat wcfTitle = new WritableCellFormat(wf2);
        wcfTitle.setBackground(jxl.format.Colour.IVORY);  //象牙白
        wcfTitle.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
        //       wcfTitle.setVerticalAlignment(VerticalAlignment.CENTRE); //设置垂直对齐
        wcfTitle.setAlignment(Alignment.CENTRE); //设置垂直对齐

        CellView navCellView = new CellView();
        //navCellView.setAutosize(true); //设置自动大小
        navCellView.setSize(18);

        lab = new Label(0,0, title, wcfTitle); //Label(col,row,str);
        sheet.mergeCells(0,0,navTitle.length-1,0);
        sheet.setColumnView(0, navCellView); //设置col显示样式
        sheet.setRowView(0, 1600, false); //设置行高
        sheet.addCell(lab);
        /**
         * status
         */


        /**
         * nav
         */
        jxl.write.WritableFont wfcNav =new jxl.write.WritableFont(WritableFont.ARIAL,12, WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
        WritableCellFormat wcfN=new WritableCellFormat(wfcNav);

        Color color = Color.decode("#000000"); // 自定义的颜色
        workbook.setColourRGB(Colour.BLACK, color.getRed(),color.getGreen(), color.getBlue());

        wcfN.setBackground(Colour.ORANGE);
        wcfN.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
        wcfN.setAlignment(Alignment.CENTRE); //设置水平对齐
        wcfN.setWrap(false); //设置自动换行
        for(int i=0;i<navTitle.length;i++){
            lab = new Label(i,1,navTitle[i],wcfN); //Label(col,row,str);
            sheet.addCell(lab);
            sheet.setColumnView(i, new String(navTitle[i]).length());
        }

        /**
         * 内容
         */
        jxl.write.WritableFont wfcontent =new jxl.write.WritableFont(WritableFont.ARIAL,12, WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.GREEN);
        WritableCellFormat wcfcontent = new WritableCellFormat(wfcontent);
        wcfcontent.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
        wcfcontent.setAlignment(Alignment.CENTRE);
        CellView cellView = new CellView();
        //cellView.setAutosize(true); //设置自动大小
        for(int i = 0; i < content.length; i++){
            for(int j = 0; j < content[i].length; j++){
                sheet.setColumnView(i, cellView);//根据内容自动设置列宽
                lab = new Label(j, i+2, content[i][j], wcfcontent); //Label(col,row,str);
                sheet.addCell(lab);
                sheet.setColumnView(j, new String(content[i][j]).length());
            }
        }

        workbook.write();
        workbook.close();
    }
}
