package id.dph.cde.service;

import id.co.kbbukopin.cde.rencana.model.RDOpenAccountExcelModel;
import id.co.kbbukopin.cde.rencana.service.RDOpenAccountExcelReaderService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class RDAccountServiceImpl implements RDAccountService {

    private List<RDOpenAccountExcelModel> lastUploadedData = new ArrayList<>();

    @Override
    public List<RDOpenAccountExcelModel> bulkOpenRDAccount(MultipartFile multipartFile) {
        RDOpenAccountExcelReaderService excelReaderService = new RDOpenAccountExcelReaderService();
        try (InputStream is = multipartFile.getInputStream()) {
            lastUploadedData =  excelReaderService.readExcel(is);
            return lastUploadedData;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel file: ", e);
        }
    }

    @Override
    public List<RDOpenAccountExcelModel> getLastUploadedData() {
        return lastUploadedData;
    }
}
