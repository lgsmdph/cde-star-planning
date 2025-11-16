package id.dph.cde.controller;

import id.dph.cde.service.RDAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping("/cde/rencana/accounts/bulk-open")
public class RDAccountController {

    private final RDAccountService rdAccountService;

    @Autowired
    public RDAccountController(RDAccountService rdAccountService) {
        this.rdAccountService = rdAccountService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("data", new ArrayList<>());
        return "/cde/rencana/accounts/bulk-open";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file, Model model) {
        rdAccountService.bulkOpenAccount(file);
        model.addAttribute("data", rdAccountService.getLastUploadedData());
        model.addAttribute("message", "Successfully uploaded!");
        return "/cde/rencana/accounts/bulk-open";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) {

    }
}
