package com.example.demo.reports;

import com.example.demo.kernel.ResponseApi;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {
    private final ReportsService reportsService;
    public ReportsController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    @GetMapping("/album/{albumId}")
    public void generateAlbumReport(HttpServletResponse response , @PathVariable Long albumId) {
        ResponseApi apiResponse = reportsService.getAlbumReport(albumId);
        if (apiResponse.getStatus().is2xxSuccessful()) {
            try {
                JasperPrint jasperPrint = (JasperPrint) apiResponse.getData();
                response.setContentType("application/x-pdf");
                response.setHeader("Content-Disposition", "attachment; filename=AlbumReport_" + albumId + ".pdf");
                final java.io.OutputStream outputStream = response.getOutputStream();
                net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
