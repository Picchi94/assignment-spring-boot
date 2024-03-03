package org.assignment.csvuploader.repository;

import org.assignment.csvuploader.model.CsvModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvRepository extends JpaRepository<CsvModel, String> {

}
