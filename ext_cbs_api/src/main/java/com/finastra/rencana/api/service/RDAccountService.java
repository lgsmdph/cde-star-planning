package com.finastra.rencana.api.service;

import id.co.kbbukopin.cde.rencana.model.RDOpenAccountExcelModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RDAccountService {

    List<RDOpenAccountExcelModel> bulkOpenAccount(MultipartFile multipartFile);
}
