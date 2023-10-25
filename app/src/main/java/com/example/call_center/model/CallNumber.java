package com.example.call_center.model;

public class CallNumber {
    public String getNumberToCall() {
        return NumberToCall;
    }

    public void setNumberToCall(String numberToCall) {
        NumberToCall = numberToCall;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String subTitle) {
        SubTitle = subTitle;
    }

    private String NumberToCall;
    private String Title;
    private String SubTitle;
}
