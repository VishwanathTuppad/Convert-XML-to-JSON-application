package com.example.convert.controller;

import com.example.convert.dto.ResponseDTO;
import com.example.convert.exception.XmlProcessingException;
import com.example.convert.service.ConversionService;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversion")
public class XmlToJsonController {
    private static final Logger logger = LoggerFactory.getLogger(XmlToJsonController.class);
    @Autowired
    private ConversionService conversionService;

    @PostMapping(value = "/xml-to-json", consumes = "application/xml", produces = "application/json")
    public ResponseEntity<JsonNode> convertXmlToJson(@RequestBody ResponseDTO responseDTO) {
        logger.info("Received XML for conversion: {}", responseDTO);
        try {
            JsonNode jsonResult = conversionService.convertXmlToJson(responseDTO);
            return new ResponseEntity<>(jsonResult, HttpStatus.OK);
        } catch (XmlProcessingException e) {
            logger.error("XML Processing error: {}", e.getMessage());
            throw e;
        }
    }
}

