package com.example.convert.service.impl;

import com.example.convert.dto.ResponseDTO;
import com.example.convert.exception.XmlProcessingException;
import com.example.convert.service.ConversionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {
    private static final Logger logger = LoggerFactory.getLogger(ConversionServiceImpl.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public JsonNode convertXmlToJson(ResponseDTO responseDTO) {
        logger.info("Converting XML to JSON...");

        // Calculate TotalMatchScore by summing scores in MatchDetails
        int totalMatchScore = responseDTO.getResultBlock()
                .getMatchDetails()
                .getMatches()
                .stream()
                .mapToInt(match -> match.getScore()).sum();

        // Convert XML data to JSON and add the custom field
        try {
            ObjectNode jsonNode = objectMapper.convertValue(responseDTO, ObjectNode.class);

            logger.info("Converting XML to JSON with custom fields.");
            jsonNode.with("MatchSummary").put("TotalMatchScore", totalMatchScore);

            // Wrap with Response object
            ObjectNode responseWrapper = objectMapper.createObjectNode();
            responseWrapper.set("Response", jsonNode);
            return responseWrapper;
        } catch (IllegalArgumentException e) {
            logger.error("Conversion error: invalid data in ResponseDTO", e);
            throw new XmlProcessingException("Invalid data encountered during conversion: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error during XML to JSON conversion", e);
            throw new XmlProcessingException("Conversion failed due to unexpected error: " + e.getMessage());
        }

    }
}
