package com.example.convert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {

    @JsonProperty("ResultBlock")
    private ResultBlock resultBlock;

    @Data
    public static class ResultBlock {
        @JsonProperty("ErrorWarnings")
        private ErrorWarnings errorWarnings;

        @JsonProperty("MatchDetails")
        private MatchDetails matchDetails;

        @JsonProperty("API")
        private API api;
    }

    @Data
    public static class ErrorWarnings {
        @JsonProperty("Errors")
        private Errors errors;

        @JsonProperty("Warnings")
        private Warnings warnings;
    }

    @Data
    public static class Errors {
        @JsonProperty("errorCount")
        private int errorCount;
    }

    @Data
    public static class Warnings {
        @JsonProperty("warningCount")
        private int warningCount;

        @JsonProperty("Warning")
        private Warning warning;
    }

    @Data
    public static class Warning {
        @JsonProperty("Number")
        private int number;

        @JsonProperty("Message")
        private String message;

        @JsonProperty("Values")
        private Values values;
    }

    @Data
    public static class Values {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JsonProperty("Value")
        private List<String> value;
    }
    //useWrapping = false means that each element in the list will appear as
    // an individual XML element, rather than being wrapped in a parent element.

    @Data
    public static class MatchDetails {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JsonProperty("Match")
        private List<Match> matches;
    }

    @Data
    public static class Match {
        @JsonProperty("Entity")
        private String entity;

        @JsonProperty("MatchType")
        private String matchType;

        @JsonProperty("Score")
        private int score;
    }

    @Data
    public static class API {
        @JsonProperty("RetStatus")
        private String retStatus;

        @JsonProperty("ErrorMessage")
        private String errorMessage;

        @JsonProperty("SysErrorCode")
        private String sysErrorCode;

        @JsonProperty("SysErrorMessage")
        private String sysErrorMessage;
    }
}
