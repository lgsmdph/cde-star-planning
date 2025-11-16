package id.co.kbbukopin.cde.excel.formatter;

import org.apache.poi.ss.usermodel.Cell;

import java.util.Optional;

public class StringCellValueFormatter implements ICellValueFormatter {

    @Override
    public void formatCell(Cell cell, Object val) {
        String s = Optional.ofNullable(val)
                .map(v -> v.toString().trim())
                .orElse("");
        cell.setCellValue(s);
    }
}
