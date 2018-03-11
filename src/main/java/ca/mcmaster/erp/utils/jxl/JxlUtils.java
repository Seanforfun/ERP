package ca.mcmaster.erp.utils.jxl;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 9, 2018 7:32:28 PM
 */
public class JxlUtils {
	/**
	 * @Description: Create a work stream for Excel.
	 * @param os The outputStream used to write the Excel file
	 * @return
	 */
	public static WritableWorkbook cWorkbook(OutputStream os){
		try {
			return Workbook.createWorkbook(os);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Description: Create worksheet
	 * @param workBook	Workbook  to put the worksheet.
	 * @param idx	worksheet index, start from 0.
	 * @param name	name of the work sheet.
	 * @return
	 */
	public WritableSheet cSheet(WritableWorkbook workBook, int idx, String name){
		return workBook.createSheet(name, idx);
	}
	
	/**
	 * @Description: Create the Label object to write in.
	 * @param row
	 * @param column
	 * @param value
	 * @return
	 */
	public static Label createLabel(int row, int column, String value){
		return new Label(column, row, value);
	}
	
	/**
	 * @Description: Add label to the sheet.
	 * @param label
	 * @param writableSheet
	 */
	public static void addLabelToSheet(Label label, WritableSheet writableSheet){
		try {
			writableSheet.addCell(label);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Set the width of specific column.
	 * @param writableSheet
	 * @param column
	 * @param width
	 */
	public static void setColumnSize(WritableSheet writableSheet, int column, int width){
		writableSheet.setColumnView(column, width);
	}
	
	/**
	 * @Description: Set the height of specific row.
	 * @param writableSheet
	 * @param row
	 * @param height
	 */
	public static void setRowSize(WritableSheet writableSheet, int row, int height){
		try {
			writableSheet.setRowView(row, height);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: TODO
	 * @param writableSheet
	 * @param row1 the first row of the group
	 * @param row2 the last row of the group
	 * @param collapsed should the group be collapsed?
	 * @exception WriteException
	 * @exception RowsExceededException
	 */
	public static void merge(WritableSheet writableSheet, int col1, int row1, int col2, int row2){
		try {
			writableSheet.mergeCells(col1, row1, col2, row2);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Set the style of a single label.
	 * @param label	The label to set the style
	 * @param fontName	Name of the font.
	 * @param fontSize	Size of the font.
	 * @param color	Color of the value.
	 * @param bgColor	Color of the background.
	 * @param align	0-left 1-middle 2-right
	 * @param borderStyle	
	 */
	public static void setLabelSize(Label label, String fontName, int fontSize, Colour color, Colour bgColor, int align, String borderStyle){
		if(color == null)
			color = Colour.BLACK;
		if(bgColor == null)
			bgColor = Colour.WHITE;
		WritableFont wf = new WritableFont(WritableFont.createFont(fontName), fontSize, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, color);
		WritableCellFormat wcf = new WritableCellFormat(wf);
		try {
			wcf.setBackground(bgColor);
			wcf.setAlignment(Alignment.CENTRE);
			
			 if(borderStyle != null && borderStyle.length() == 4){
				 char[] bs = borderStyle.toCharArray();
				 if(bs[0] == '1'){
					 wcf.setBorder(Border.TOP, BorderLineStyle.THIN, jxl.format.Colour.BLACK);
				 }else if(bs[0] == '2'){
					 wcf.setBorder(Border.TOP, BorderLineStyle.MEDIUM, jxl.format.Colour.BLACK);
				 }
				 
				 if(bs[1] == '1'){
					 wcf.setBorder(Border.BOTTOM, BorderLineStyle.THIN, jxl.format.Colour.BLACK);
				 }else if(bs[1] == '2'){
					 wcf.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM, jxl.format.Colour.BLACK);
				 }
				 
				 if(bs[2] == '1'){
					 wcf.setBorder(Border.LEFT, BorderLineStyle.THIN, jxl.format.Colour.BLACK);
				 }else if(bs[2] == '2'){
					 wcf.setBorder(Border.LEFT, BorderLineStyle.MEDIUM, jxl.format.Colour.BLACK);
				 }
				 
				 if(bs[3] == '1'){
					 wcf.setBorder(Border.RIGHT, BorderLineStyle.THIN, jxl.format.Colour.BLACK);
				 }else if(bs[3] == '2'){
					 wcf.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM, jxl.format.Colour.BLACK);
				 }
			 }
			 
			 label.setCellFormat(wcf);
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
