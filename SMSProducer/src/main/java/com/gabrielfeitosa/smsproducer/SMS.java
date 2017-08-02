package com.gabrielfeitosa.smsproducer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SMS {

    private final int id;
    private final int number;
    private final String message;
}
