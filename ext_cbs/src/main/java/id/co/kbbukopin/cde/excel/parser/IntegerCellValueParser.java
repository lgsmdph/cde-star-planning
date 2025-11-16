package id.co.kbbukopin.cde.excel.parser;

import org.apache.poi.ss.usermodel.Cell;

import java.util.Optional;

public class IntegerCellValueParser implements ICellValueParser {

	@Override
	public Object parse(Cell cell) {
		return Optional.ofNullable(cell)
				.map(c -> {
					switch (cell.getCellType()) {
					case STRING:
						String s = cell.getStringCellValue().trim();
						if (s.contains(".")) {
                            return  (int) Double.parseDouble(s);
						}
						return Integer.parseInt(s);
					case NUMERIC:
					case FORMULA:
                        return (int) cell.getNumericCellValue();
					default:
						return 0;
					}
				})
                .orElse(0);
	}
}
