package id.dph.cde.service;

import id.co.kbbukopin.cde.rencana.model.RDOpenAccountExcelModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RDAccountService {

    List<RDOpenAccountExcelModel> bulkOpenRDAccount(MultipartFile multipartFile);

    List<RDOpenAccountExcelModel> getLastUploadedData();
}
