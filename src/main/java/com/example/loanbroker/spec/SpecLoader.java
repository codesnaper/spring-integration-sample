package com.example.loanbroker.spec;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.function.Supplier;


public class SpecLoader {

    public static Object chainr(String specFileName, Supplier<Object> payloadFn) {
        List chainrSpecJSON = JsonUtils.classpathToList("/spec/" + specFileName);
        Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
        Object payload = payloadFn.get();
        try {
            return chainr.transform(new ObjectMapper().readValue(payload.toString(), Object.class));
        } catch (JsonProcessingException e) {
            return new Object();
        }
    }
}
