package id.co.kbbukopin.cde.excel.parser;

import org.apache.poi.ss.usermodel.Cell;

public interface ICellValueParser {
	Object parse(Cell cell);
}
