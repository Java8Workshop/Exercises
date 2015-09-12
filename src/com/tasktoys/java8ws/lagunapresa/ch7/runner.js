#!/usr/bin/jjs

var zdt = Java.type("java.time.ZonedDateTime").now();
print("now: " + zdt.getHour() + "時" + zdt.getMinute() + "分" + zdt.getSecond() + "秒");
