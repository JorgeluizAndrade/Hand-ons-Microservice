package com.ms.report.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ms.report.document.LogEventDocument;

@Repository
public interface LogEventRepository extends MongoRepository<LogEventDocument, String>{
}
