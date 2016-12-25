package com.example.chaitnya.gallery.List_item;

/**
 * Created by CHAITNYA on 12/23/2016.
 */

public class Sports_list {
    private int imageResId;
    private String fee;
    String participant;
    private String date;
    private String totaldate;
    private String time;
    private String email;
    private String detail;
    private String subTitle;
    private String title;
    private String month,day,address;

    public String getTotaldate() {
        return totaldate;
    }

    public void setTotaldate(String totaldate) {
        this.totaldate = totaldate;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public String getEmail() {
        return email;
    }

    public String getDetail() {
        return detail;
    }


    public void setFee(String fee) {
        this.fee = fee;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public Sports_list(int imageResId, String subTitle, String title, String month, String date, String day, String fee,
                    String address, String totaldate, String time, String email, String detail, String participant)
    {

        this.imageResId=imageResId;

        this.subTitle=subTitle;
        this.title=title;
        this.totaldate=totaldate;
        this.time=time;
        this.month=month;
        this.date=date;
        this.day=day;
        this.email=email;
        this.detail=detail;
        this.fee=fee;
        this.address=address;
        this.participant=participant;
    }
    private boolean favourite = false;

    public String getSubTitle()
    {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }


    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        this.title = title;
    }

    public String getFee() {
        return fee;
    }

    public String getDate () {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getDay()
    {
        return day;
    }

    public String getAddress() {
        return address;
    }

}
