package id.co.kbbukopin.cde.excel.formatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import java.math.BigDecimal;

import static id.co.kbbukopin.cde.excel.util.ExcelUtil.createFormattedStyle;

public class NumberCellValueFormatter implements ICellValueFormatter {

    private final String format;

    public NumberCellValueFormatter(String format) {
        this.format = format;
    }

    @Override
    public void formatCell(Cell cell, Object val) {
        if (val == null) {
            cell.setBlank();
            return;
        }
        CellStyle style = createFormattedStyle(cell.getSheet().getWorkbook(), format);
        cell.setCellStyle(style);
        if (val instanceof BigDecimal) cell.setCellValue(((BigDecimal) val).doubleValue());
        else if (val instanceof Number) cell.setCellValue(((Number) val).doubleValue());
        else cell.setCellValue(Double.parseDouble(val.toString()));
    }
}
