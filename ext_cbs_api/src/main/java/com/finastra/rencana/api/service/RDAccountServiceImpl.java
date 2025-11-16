package com.finastra.rencana.api.service;

import id.co.kbbukopin.cde.rencana.model.RDOpenAccountExcelModel;
import id.co.kbbukopin.cde.rencana.service.RDOpenAccountExcelReaderService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class RDAccountServiceImpl implements RDAccountService {

    @Override
    public List<RDOpenAccountExcelModel> bulkOpenAccount(MultipartFile multipartFile) {
        RDOpenAccountExcelReaderService excelReaderService = new RDOpenAccountExcelReaderService();
        try (InputStream is = multipartFile.getInputStream()) {
            return excelReaderService.readExcel(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel file: ", e);
        }
    }
}
