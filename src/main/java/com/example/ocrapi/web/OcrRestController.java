package com.example.ocrapi.web;

import com.example.ocrapi.components.OcrComponent;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/")
public class OcrRestController {
    private final OcrComponent ocrComponent;

    private String fileName = "";
    private byte[] image;

    public OcrRestController(OcrComponent ocrComponent) {
        this.ocrComponent = ocrComponent;
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public String getOcrTest(@RequestParam MultipartFile imageUpload) throws IOException, TesseractException {
        fileName = imageUpload.getOriginalFilename();
        FileUtils.deleteDirectory(new File("uploads"));
        Files.createDirectory(Paths.get("", "uploads"));
        Path filePath = Paths.get("uploads/" + fileName);
        Files.copy(imageUpload.getInputStream(), filePath);
        image = imageUpload.getBytes();
        String extracted = ocrComponent.getImageString("uploads/" + fileName);
        System.out.println(extracted);
        return extracted;
    }
}
