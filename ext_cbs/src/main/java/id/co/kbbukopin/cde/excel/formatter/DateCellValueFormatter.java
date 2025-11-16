package id.co.kbbukopin.cde.excel.formatter;

import id.co.kbbukopin.cde.excel.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import java.util.Date;

import static id.co.kbbukopin.cde.excel.util.ExcelUtil.createFormattedStyle;

public class DateCellValueFormatter implements ICellValueFormatter {

    private final String format;

    public DateCellValueFormatter(String format) {
        this.format = format;
    }

    @Override
    public void formatCell(Cell cell, Object val) {
        if (val == null) {
            cell.setBlank();
            return;
        }
        try {
            Date date = ExcelUtil.convertObjectToDate(val, format);
            if (date == null) {
                cell.setBlank();
                return;
            }
            CellStyle style = createFormattedStyle(cell.getSheet().getWorkbook(), format);
            cell.setCellStyle(style);
            cell.setCellValue(date);
        } catch (Exception e) {
            cell.setBlank();
        }
    }
}
