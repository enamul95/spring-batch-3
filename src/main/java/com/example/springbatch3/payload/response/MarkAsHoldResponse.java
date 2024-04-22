package com.example.springbatch3.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkAsHoldResponse {

    private int outCode;
    private String outMessage;
}
