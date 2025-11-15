package id.co.kbbukopin.cde.excel.parser;

import org.apache.poi.ss.usermodel.Cell;

import java.util.Optional;

public class StringCellValue implements ICellValueParser {

	@Override
	public Object parse(Cell cell) {
		return Optional.ofNullable(cell)
				.map(c -> c.getStringCellValue().trim())
				.orElse(null);
	}
}
