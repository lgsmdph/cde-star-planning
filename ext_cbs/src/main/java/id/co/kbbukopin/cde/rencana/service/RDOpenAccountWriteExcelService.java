package id.co.kbbukopin.cde.rencana.service;

import id.co.kbbukopin.cde.excel.BaseExcelWriterService;
import id.co.kbbukopin.cde.excel.formatter.ICellValueFormatter;
import id.co.kbbukopin.cde.excel.formatter.NumberCellValueFormatter;
import id.co.kbbukopin.cde.excel.formatter.StringCellValueFormatter;
import id.co.kbbukopin.cde.rencana.model.RDOpenAccountExcelModel;

import java.util.Map;

public class RDOpenAccountWriteExcelService extends BaseExcelWriterService<RDOpenAccountExcelModel> {

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
    protected void registerFormatters(Map<String, ICellValueFormatter> formatterMap) {
        formatterMap.put(HEADER[0], new StringCellValueFormatter());
        formatterMap.put(HEADER[1], new NumberCellValueFormatter("#,##0"));
        formatterMap.put(HEADER[2], new StringCellValueFormatter());
        formatterMap.put(HEADER[3], new StringCellValueFormatter());
        formatterMap.put(HEADER[4], new NumberCellValueFormatter("#,##0"));
        formatterMap.put(HEADER[5], new NumberCellValueFormatter("#,##0.00"));
        formatterMap.put(HEADER[6], new NumberCellValueFormatter("#,##0.00"));
        formatterMap.put(HEADER[7], new StringCellValueFormatter());
    }

    @Override
    protected String sheetName() {
        return "Bulk Open Account";
    }

    @Override
    protected String[] getHeaders() {
        return HEADER;
    }

    @Override
    protected Object[] mapData(RDOpenAccountExcelModel item) {
        return new Object[] {
                item.getEmployeeNo(),
                item.getTerm(),
                item.getContraAccount(),
                item.getPayawayAccount(),
                item.getInstallmentDay(),
                item.getFirstInstallmentAmount(),
                item.getInstallmentAmount(),
                item.getDescription()
        };
    }
}
