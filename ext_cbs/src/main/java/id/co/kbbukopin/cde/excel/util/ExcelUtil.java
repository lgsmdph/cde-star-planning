package id.co.kbbukopin.cde.excel.util;

import org.apache.poi.ss.usermodel.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ExcelUtil {

    public static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        return cellStyle;
    }

    public static CellStyle createFormattedStyle(Workbook workbook, String format) {
        DataFormat df = workbook.createDataFormat();
        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(df.getFormat(format));
        return style;
    }

    public static Date convertObjectToDate(Object val, String pattern) throws Exception {
        if (val instanceof Date) return (Date) val;
        if (val instanceof LocalDate) {
            LocalDate ld = (LocalDate) val;
            return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        if (val instanceof LocalDateTime) {
            LocalDateTime dt = (LocalDateTime) val;
            return Date.from(dt.atZone(ZoneId.systemDefault()).toInstant());
        }
        if (val instanceof String) return new SimpleDateFormat(pattern).parse((String) val);
        return null;
    }
}
