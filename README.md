Problem statement:
Convert xml into json format with one new custom field (MatchSummary.TotalMatchScore) in json that does sum of values under 
particular tags (MatchDetails.Match.Score) under xml. Looking forward for Utility class for this functionality with handling 
of scenarios like xml contract getting changed with new field tag, the sum limit based upon dataType used etc. Exception handling, 
loggers for debugging and other coding standards are expected to be in place.

Input:

<?xml version="1.0" encoding="UTF-8"?>

<Response>

    <ResultBlock>

        <ErrorWarnings>

            <Errors errorCount="0" />

            <Warnings warningCount="1">

                <Warning>

                    <Number>102001</Number>

                    <Message>Minor mismatch in address</Message>

                    <Values>

                        <Value>Bellandur</Value>

                        <Value>Bangalore</Value>

                    </Values>

                </Warning>

            </Warnings>

        </ErrorWarnings>

        <MatchDetails>

            <Match>

                <Entity>John</Entity>

                <MatchType>Exact</MatchType>

                <Score>35</Score>

            </Match>

            <Match>

                <Entity>Doe</Entity>

                <MatchType>Exact</MatchType>

                <Score>50</Score>

            </Match>

        </MatchDetails>

        <API>

            <RetStatus>SUCCESS</RetStatus>

            <ErrorMessage />

            <SysErrorCode />

            <SysErrorMessage />

        </API>

    </ResultBlock>

</Response>


Output:


{
  "Response": {

    "ResultBlock": {

      "MatchSummary": { //new field

        "TotalMatchScore": "85" //new custom field

      },

      "ErrorWarnings": {

        "Errors": {

          "errorCount": "0"

        },

        "Warnings": {

          "warningCount": "1",

          "Warning": {

            "Number": "102001",

            "Message": "Minor mismatch in address",

            "Values": {

              "Value": [

                "Bellandur",

                "Bangalore"

              ]

            }

          }

        }

      },

      "MatchDetails": [

        "Match": {

          "Entity": "John",

          "MatchType": "Exact",

          "Score": "35"

        },

        "Match": {

          "Entity": "Doe",

          "MatchType": "Exact",

          "Score": "40"

        }

      ],

      "API": {

        "RetStatus": "SUCCESS",

        "ErrorMessage": null,

        "SysErrorCode": null,

        "SysErrorMessage": null

      }

    }

  }

}
