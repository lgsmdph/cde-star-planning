package id.co.kbbukopin.cde.excel.parser;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class DateCellValueParser implements ICellValueParser {

    private final String pattern;

    public DateCellValueParser(String pattern) {
        this.pattern = pattern;
    }

    @Override
	public Object parse(Cell cell) {
		return Optional.ofNullable(cell)
				.flatMap(c -> {
					if (DateUtil.isCellDateFormatted(c)) {
						return Optional.of(new SimpleDateFormat(pattern).format(c.getDateCellValue()));
					}
					return Optional.empty();
				})
				.orElse(null);
	}
}
