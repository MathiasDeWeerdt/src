package com.singlecore.api;

public class Time {

	private long hours;
	private long minutes;
	private long seconds;
	private long millis;

	private long startTime;
	
	public Time() {
		startTime = System.currentTimeMillis();
	}

	public String format(long f) {
		return (String.valueOf(f).length() == 1) ? 0 + "" + f : "" + f;
	}
	
	public String timeTillNewLevel(int xpTNL, int xpHour) {
		long Tmillis = (long) ((xpTNL / (xpHour / 3600)) * 1000);
		
		long Thours = Tmillis / 3600000;
		Tmillis -= Thours * 3600000;
		long Tminutes = Tmillis / 60000;
		Tmillis -= Tminutes * 60000;
		long Tseconds = Tmillis / 1000;

		if (xpTNL > 0) {
			return format(Thours) + ":" + format(Tminutes) + ":" + format(Tseconds);
		}

		return null;
	}

	public float calculatePerHour(int variableToCalculate) {
		float xpsec = 0;
		
		if (((minutes > 0) || (hours > 0) || (seconds > 0))
				&& (variableToCalculate > 0)) {
			xpsec = variableToCalculate / (float) (seconds + minutes * 60 + hours * 60 * 60);
		}

		float xpmin = xpsec * 60;
		float xphour = xpmin * 60;

		return Math.round(xphour);
	}

	public String display() {
		millis = System.currentTimeMillis() - startTime;
		
		hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		seconds = millis / 1000;

		return format(hours) + ":" + format(minutes) + ":" + format(seconds);
	}
}
