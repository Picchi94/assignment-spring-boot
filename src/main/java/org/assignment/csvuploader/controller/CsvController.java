package org.assignment.csvuploader.controller;

import org.assignment.csvuploader.model.CsvModel;
import org.assignment.csvuploader.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/csv")
public class CsvController {
    @Autowired
    private CsvService csvService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestBody MultipartFile csv) throws IOException {

        csv.getContentType();

        if (csvService.hasCSVFormat(csv)) {

            try {
                List<CsvModel> data = csvService.parseCsvFile(csv.getInputStream());
                csvService.uploadData(data);
                return ResponseEntity.ok("File upload successful");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("File upload failed.");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(("Please upload a csv file!"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CsvModel>> getAllData() {
        try {
            List<CsvModel> csvModels = csvService.getAllData();

            if (csvModels.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(csvModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllData() {
        return ResponseEntity.ok(csvService.deleteAllData());
    }
}
