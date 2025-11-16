package id.co.kbbukopin.cde.excel.formatter;

import org.apache.poi.ss.usermodel.Cell;

public interface ICellValueFormatter {
    void formatCell(Cell cell, Object val);
}
