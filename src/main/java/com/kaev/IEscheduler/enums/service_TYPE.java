package com.kaev.IEscheduler.enums;

import java.util.stream.Stream;

public enum service_TYPE {

	MUSZAKIVIZSGAFELKESZITES(2),
	OLAJCSERE(1),
	FEKBETETCSERE(1),
	KLIMATOLTES(1),
	KAROSSZERIAJAVITAS(5),
	FUTOMUBEALLITAS(3);
	
	private int hour;
	
	private service_TYPE(int hour) {
		this.hour = hour;
	}
	
    public int getService_TYPE() {
        return hour;
    }

    public static service_TYPE of(int hour) {
        return Stream.of(service_TYPE.values())
          .filter(p -> p.getService_TYPE() == hour)
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
	
}
