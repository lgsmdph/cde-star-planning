package id.co.kbbukopin.cde.rencana.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import id.co.kbbukopin.cde.excel.parser.ICellValueParser;
import id.co.kbbukopin.cde.excel.parser.IntegerCellValueParser;
import org.apache.poi.ss.usermodel.Row;

import id.co.kbbukopin.cde.rencana.model.RDOpenAccountExcelModel;
import id.co.kbbukopin.cde.excel.BaseExcelReaderService;
import id.co.kbbukopin.cde.excel.parser.BigDecimalCellValueParser;
import id.co.kbbukopin.cde.excel.parser.StringCellValueParser;

public class RDOpenAccountExcelReaderService extends BaseExcelReaderService<RDOpenAccountExcelModel> {

	private final String[] HEADER = {
			"Employee No",
			"Term",
			"Contra Account",
			"Payaway Account",
			"Installment Day",
			"First Installment Amount",
			"Installment Amount",
			"Description"
	};

    @Override
    protected Map<String, ICellValueParser> registerParsers() {
        Map<String, ICellValueParser> headerMap = new HashMap<>();
        headerMap.put(HEADER[0], new StringCellValueParser());
        headerMap.put(HEADER[1], new IntegerCellValueParser());
        headerMap.put(HEADER[2], new StringCellValueParser());
        headerMap.put(HEADER[3], new StringCellValueParser());
        headerMap.put(HEADER[4], new IntegerCellValueParser());
        headerMap.put(HEADER[5], new BigDecimalCellValueParser());
        headerMap.put(HEADER[6], new BigDecimalCellValueParser());
        headerMap.put(HEADER[7], new StringCellValueParser());
        return headerMap;
    }

	@Override
	protected RDOpenAccountExcelModel processRow(Row row) {
		return RDOpenAccountExcelModel.builder()
				.employeeNo((String) getValue(HEADER[0], row))
				.term((Integer) getValue(HEADER[1], row))
				.contraAccount((String) getValue(HEADER[2], row))
				.payawayAccount((String) getValue(HEADER[3], row))
				.installmentDay((Integer) getValue(HEADER[4], row))
				.firstInstallmentAmount((BigDecimal) getValue(HEADER[5], row))
				.installmentAmount((BigDecimal) getValue(HEADER[6], row))
				.description((String) getValue(HEADER[7], row))
				.build();
	}
}
