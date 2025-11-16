package id.dph.cde.service;

import id.co.kbbukopin.cde.rencana.model.RDOpenAccountExcelModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

public interface RDAccountService {

    List<RDOpenAccountExcelModel> bulkOpenAccount(MultipartFile multipartFile);

    void removeLastUploadedData();

    List<RDOpenAccountExcelModel> getLastUploadedData();

    void download(OutputStream os);
}
