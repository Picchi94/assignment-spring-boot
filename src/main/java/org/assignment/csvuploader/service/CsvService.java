package org.assignment.csvuploader.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.assignment.csvuploader.model.CsvModel;
import org.assignment.csvuploader.repository.CsvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {
    @Autowired
    private CsvRepository csvRepository;

    public static final String TYPE = "text/csv";

    public List<CsvModel> getAllData() {
        return csvRepository.findAll();
    }

    public CsvModel getDataByCode(String code) {
        return csvRepository.findById(code).orElse(null);
    }

    public String uploadData(List<CsvModel> data) {
        try {
            csvRepository.saveAll(data);
            return "Upload successful";
        } catch (Exception e) {
            throw new RuntimeException("Upload failed {}", e);
        }
    }

    public String deleteAllData() {
        try {
            csvRepository.deleteAll();
            return "Delete successful";
        } catch (Exception e) {
            throw new RuntimeException("Delete failed {}", e);
        }
    }

    public List<CsvModel> parseCsvFile(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CsvModel> model = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                CsvModel csvModel = new CsvModel(
                        csvRecord.get("source"),
                        csvRecord.get("codeListCode"),
                        csvRecord.get("code"),
                        csvRecord.get("displayValue"),
                        csvRecord.get("longDescription"),
                        csvRecord.get("fromDate"),
                        csvRecord.get("toDate"),
                        csvRecord.get("sortingPriority")
                );

                model.add(csvModel);
            }

            return model;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public boolean hasCSVFormat(MultipartFile file) {

        return TYPE.equals(file.getContentType());
    }

}
