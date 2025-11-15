package id.co.kbbukopin.cde.excel.parser;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class DateCellValue implements ICellValueParser {

	private final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public Object parse(Cell cell) {
		return Optional.ofNullable(cell)
				.flatMap(c -> {
					if (DateUtil.isCellDateFormatted(c)) {
						return Optional.of(df.format(c.getDateCellValue()));
					}
					return Optional.empty();
				})
				.orElse(null);
	}
}
