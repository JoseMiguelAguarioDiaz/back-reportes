package com.example.demo.reports;

import com.example.demo.album.model.Album;
import com.example.demo.album.model.IAlbumRepository;
import com.example.demo.kernel.ResponseApi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ReportsService {
    private final DataSource dataSource;

    private final IAlbumRepository albumRepository;
    @Value("${profile}")
    private String activeProfile;

    public ReportsService(DataSource dataSource, IAlbumRepository albumRepository) {
        this.dataSource = dataSource;
        this.albumRepository = albumRepository;
    }

    private JasperPrint generateAlbumReport(Long albumId, String albumImage){
        try (java.sql.Connection connection = dataSource.getConnection()) {
            String report = "classpath:reports/PrimerReporte.jrxml";
            JasperReport jasperReport = null;

            if(activeProfile.equals("dev")){
                File file = ResourceUtils.getFile(report);
                jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            }else{
                Resource file = new ClassPathResource(report);
                jasperReport = JasperCompileManager.compileReport(file.getInputStream());
            }

            Map<String, Object> params = new HashMap<>();
            params.put("albumId", albumId);
            
            if (albumImage != null && !albumImage.isEmpty()) {
                byte[] imageBytes = java.util.Base64.getDecoder().decode(albumImage);
                params.put("imagen", new java.io.ByteArrayInputStream(imageBytes));
            } else {
                params.put("imagen", null);
            }

            return JasperFillManager.fillReport(jasperReport, params, connection);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    public ResponseApi getAlbumReport(Long albumId){
        try {
            Optional<Album> albumOptional = albumRepository.findById(albumId);
            if (albumOptional.isPresent()) {
                Album album = albumOptional.get();
                String albumImage = album.getImage();

                if (albumImage != null) {
                    albumImage = albumImage.replaceAll("data:image/.*?;base64,", "");
                }

                JasperPrint jasperPrint = generateAlbumReport(albumId, albumImage);

                if (jasperPrint == null) return new ResponseApi("Error generating report", HttpStatus.INTERNAL_SERVER_ERROR);
                else return new ResponseApi(jasperPrint, HttpStatus.OK);
            } else {
                return new ResponseApi("Album not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseApi("Error generating report: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
