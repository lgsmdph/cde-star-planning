package id.co.kbbukopin.cde.excel.parser;

import java.math.BigDecimal;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;

public class BigDecimalCellValueParser implements ICellValueParser {

	@Override
	public Object parse(Cell cell) {
		return Optional.ofNullable(cell)
				.map(c -> {
					if (c.toString().isEmpty()) {
						return BigDecimal.ZERO;
					}
					switch (c.getCellType()) {
					case STRING:
						String cleanNumber = cell.getStringCellValue().replace(",", "");
						return new BigDecimal(cleanNumber);
					case NUMERIC:
						return BigDecimal.valueOf(cell.getNumericCellValue());
					default:
						return BigDecimal.ZERO;
					}
				})
                .orElse(BigDecimal.ZERO);
	}
}
