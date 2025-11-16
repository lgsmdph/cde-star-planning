package com.finastra.rencana.api.controller;

import com.finastra.rencana.api.service.RDAccountService;
import id.co.kbbukopin.cde.rencana.model.RDOpenAccountExcelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/cde/rencana/accounts")
public class RDAccountController {

    private final RDAccountService rdAccountService;

    @Autowired
    public RDAccountController(RDAccountService rdAccountService) {
        this.rdAccountService = rdAccountService;
    }

    @PostMapping(
            value = "/bulk-open",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RDOpenAccountExcelModel>> bulkOpenAccount(
            @RequestParam MultipartFile file) {
        List<RDOpenAccountExcelModel> list = rdAccountService.bulkOpenAccount(file);
        return ResponseEntity.ok(list);
    }
}
