package com.kaev.IEscheduler.enums;

import java.util.stream.Stream;

public enum service_TYPE {
	
	MUSZAKIVIZSGAFELKESZITES("műszaki vizsga felkészítés", 2),
	OLAJCSERE("olajcsere", 2),
	FEKBETETCSERE("fékbetét csere", 1),
	KLIMATOLTES("klíma töltés", 1),
	KAROSSZERIAJAVITAS("karosszéria javítás", 5),
	FUTOMUBEALLITAS("futómű beállítás", 3);
	
	private String text;
	private int hour;
	
	private service_TYPE(String text, int hour) {
		this.text = text;
		this.hour = hour;
	}
	
    public String getTextOfService_TYPE() {
        return text;
    }
	
    public int getHourOfService_TYPE() {
        return hour;
    }

    public static service_TYPE of(String text) {
        return Stream.of(service_TYPE.values())
          .filter(p -> p.getTextOfService_TYPE().equals(text))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
	
}
