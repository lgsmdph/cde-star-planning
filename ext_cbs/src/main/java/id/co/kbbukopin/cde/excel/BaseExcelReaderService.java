package id.co.kbbukopin.cde.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.monitorjbl.xlsx.StreamingReader;
import id.co.kbbukopin.cde.excel.parser.ICellValueParser;
import org.apache.poi.ss.usermodel.*;

public abstract class BaseExcelReaderService<T> {
	
	private final Map<String, Integer> headerMap = new HashMap<>();
	private final Map<String, ICellValueParser> parserMap = new HashMap<>();
    private final DataFormatter formatter = new DataFormatter();

    protected abstract Map<String, ICellValueParser> registerParsers();
    protected abstract T processRow(Row row);

    public List<T> readExcel(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found at: " + filePath);
        }
        try (InputStream is = Files.newInputStream(Paths.get(filePath))) {
            return readExcel(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel file: ", e);
        }
	}

    public List<T> readExcel(InputStream is) {
        List<T> result = new ArrayList<>();
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(200).bufferSize(4096)
                .open(is);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        if (!iterator.hasNext()) return result;

        initializeParsers();

        Row headerRow = iterator.next();
        initializeHeaders(headerRow);

        while (iterator.hasNext()) {
            result.add(processRow(iterator.next()));
        }
        return result;
    }

    private void initializeParsers() {
        parserMap.putAll(registerParsers());
    }
	
	protected void initializeHeaders(Row row) {
		for (Cell cell : row) {
			String header = formatter.formatCellValue(cell).trim();
			int colIdx = cell.getColumnIndex();
			headerMap.put(header, colIdx);
		}
	}

	protected Object getValue(String header, Row row) {
		return Optional.ofNullable(header)
				.flatMap(h -> getParser(h)
					.flatMap(parser -> getColIdx(h)
						.flatMap(headerColIdx -> getCell(row, headerColIdx))
							.map(parser::parse)))
				.orElse(null);
	}
	
	private Optional<ICellValueParser> getParser(String header) {
		return Optional.ofNullable(parserMap.get(header));
	}

	private Optional<Integer> getColIdx(String header) {
		return Optional.ofNullable(headerMap.get(header));
	}

	private Optional<Cell> getCell(Row row, Integer headerColIdx) {
		return Optional.ofNullable(row).map(r -> r.getCell(headerColIdx));
	}
}
