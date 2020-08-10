package com.demodatapoa.config.types;

import java.text.MessageFormat;

public enum Endpoints {

    BUS_ROUTE("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o"),
    ITINERARY("http://www.poatransporte.com.br/php/facades/process.php?a=il&p={0}");

    private final String location;

    private Endpoints(String location) {
        this.location = location;
    }

    public String location() {
        return this.location;
    }

    public String location(Object ... params) {
        return MessageFormat.format(this.location, params);
    }
}