package com.example.convert.service;

import com.example.convert.dto.ResponseDTO;
import com.fasterxml.jackson.databind.JsonNode;

public interface ConversionService {
    JsonNode convertXmlToJson(ResponseDTO responseDTO);
}

