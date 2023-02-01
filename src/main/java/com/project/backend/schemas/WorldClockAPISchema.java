package com.project.backend.schemas;

import java.util.Objects;

public class WorldClockAPISchema {
    private long id;
    private String currentDateTime;
    private String utcOffset;
    private String isDayLightSavingsTime;
    private String dayOfTheWeek;
    private String timeZoneName;
    private String currentFileTime;
    private String ordinalDate;
    private String serviceResponse;

    public WorldClockAPISchema() {
    }

    public WorldClockAPISchema(long id, String currentDateTime, String utcOffset, String isDayLightSavingsTime, String dayOfTheWeek, String timeZoneName, String currentFileTime, String ordinalDate, String serviceResponse) {
        this.id = id;
        this.currentDateTime = currentDateTime;
        this.utcOffset = utcOffset;
        this.isDayLightSavingsTime = isDayLightSavingsTime;
        this.dayOfTheWeek = dayOfTheWeek;
        this.timeZoneName = timeZoneName;
        this.currentFileTime = currentFileTime;
        this.ordinalDate = ordinalDate;
        this.serviceResponse = serviceResponse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getIsDayLightSavingsTime() {
        return isDayLightSavingsTime;
    }

    public void setIsDayLightSavingsTime(String isDayLightSavingsTime) {
        this.isDayLightSavingsTime = isDayLightSavingsTime;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public String getCurrentFileTime() {
        return currentFileTime;
    }

    public void setCurrentFileTime(String currentFileTime) {
        this.currentFileTime = currentFileTime;
    }

    public String getOrdinalDate() {
        return ordinalDate;
    }

    public void setOrdinalDate(String ordinalDate) {
        this.ordinalDate = ordinalDate;
    }

    public String getServiceResponse() {
        return serviceResponse;
    }

    public void setServiceResponse(String serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldClockAPISchema that = (WorldClockAPISchema) o;
        return id == that.id && Objects.equals(currentDateTime, that.currentDateTime) && Objects.equals(utcOffset, that.utcOffset) && Objects.equals(isDayLightSavingsTime, that.isDayLightSavingsTime) && Objects.equals(dayOfTheWeek, that.dayOfTheWeek) && Objects.equals(timeZoneName, that.timeZoneName) && Objects.equals(currentFileTime, that.currentFileTime) && Objects.equals(ordinalDate, that.ordinalDate) && Objects.equals(serviceResponse, that.serviceResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currentDateTime, utcOffset, isDayLightSavingsTime, dayOfTheWeek, timeZoneName, currentFileTime, ordinalDate, serviceResponse);
    }

    @Override
    public String toString() {
        return "WorldClockAPISchema{" +
                "id=" + id +
                ", currentDateTime='" + currentDateTime + '\'' +
                ", utcOffset='" + utcOffset + '\'' +
                ", isDayLightSavingsTime='" + isDayLightSavingsTime + '\'' +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", timeZoneName='" + timeZoneName + '\'' +
                ", currentFileTime='" + currentFileTime + '\'' +
                ", ordinalDate='" + ordinalDate + '\'' +
                ", serviceResponse='" + serviceResponse + '\'' +
                '}';
    }
}
