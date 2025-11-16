package id.co.kbbukopin.cde.excel;

import id.co.kbbukopin.cde.excel.formatter.ICellValueFormatter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static id.co.kbbukopin.cde.excel.util.ExcelUtil.createHeaderStyle;

public abstract class BaseExcelWriterService<T> {

    private final Map<String, ICellValueFormatter> formatterMap = new HashMap<>();

    protected abstract void registerFormatters(Map<String, ICellValueFormatter> formatterMap);
    protected abstract String sheetName();
    protected abstract String[] getHeaders();
    protected abstract Object[] mapData(T item);

    public void writeExcel(List<T> data, OutputStream os) {
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet(sheetName());

        registerFormatters(formatterMap);
        createHeaderRow(sheet);
        createDataRows(sheet, data);

        try {
            workbook.write(os);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write Excel", e);
        } finally {
            try {
                workbook.close();
            } catch (Exception ignored) {}
        }
    }

    private void createHeaderRow(SXSSFSheet sheet) {
        Row headerRow = sheet.createRow(0);
        CellStyle style = createHeaderStyle(sheet.getWorkbook());
        String[] headers = getHeaders();
        sheet.trackAllColumnsForAutoSizing();

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }

        for (int col = 0; col < headers.length; col++) {
            sheet.autoSizeColumn(col);
        }
    }

    private void createDataRows(Sheet sheet, List<T> data) {
        int rowIdx = 1;
        String[] headers = getHeaders();

        for (T item : data) {
            Row row = sheet.createRow(rowIdx++);
            Object[] values = mapData(item);

            for (int col = 0; col < values.length; col++) {
                Cell cell = row.createCell(col);
                String header = headers[col];
                Object val = values[col];
                ICellValueFormatter formatter = formatterMap.get(header);
                if (formatter == null) {
                    if (val == null) cell.setBlank();
                    else cell.setCellValue(val.toString());
                } else {
                    formatter.formatCell(cell, val);
                }
            }
        }
    }
}
