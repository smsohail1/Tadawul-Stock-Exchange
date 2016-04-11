package com.testbatch3.appxone.tadawulproject;

/**
 * Created by APPXONE on 1/6/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class kse2_fatch {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("merket summary")
    @Expose
    private List<MerketSummary> merketSummary = new ArrayList<MerketSummary>();

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return The merketSummary
     */
    public List<MerketSummary> getMerketSummary() {
        return merketSummary;
    }

    /**
     * @param merketSummary The merket summary
     */
    public void setMerketSummary(List<MerketSummary> merketSummary) {
        this.merketSummary = merketSummary;
    }


    public class MerketSummary {

        @SerializedName("Company")
        @Expose
        private String Company;
        @SerializedName("Price")
        @Expose
        private String Price;
        @SerializedName("vol")
        @Expose
        private String vol;
        @SerializedName("changevalue")
        @Expose
        private String changevalue;
        @SerializedName("change_percent")
        @Expose
        private String changePercent;
        @SerializedName("open")
        @Expose
        private String open;
        @SerializedName("high")
        @Expose
        private String high;
        @SerializedName("low")
        @Expose
        private String low;
        @SerializedName("sector")
        @Expose
        private String sector;

        /**
         * @return The Company
         */
        public String getCompany() {
            return Company;
        }

        /**
         * @param Company The Company
         */
        public void setCompany(String Company) {
            this.Company = Company;
        }

        /**
         * @return The Price
         */
        public String getPrice() {
            return Price;
        }

        /**
         * @param Price The Price
         */
        public void setPrice(String Price) {
            this.Price = Price;
        }

        /**
         * @return The vol
         */
        public String getVol() {
            return vol;
        }

        /**
         * @param vol The vol
         */
        public void setVol(String vol) {
            this.vol = vol;
        }

        /**
         * @return The changevalue
         */
        public String getChangevalue() {
            return changevalue;
        }

        /**
         * @param changevalue The changevalue
         */
        public void setChangevalue(String changevalue) {
            this.changevalue = changevalue;
        }

        /**
         * @return The changePercent
         */
        public String getChangePercent() {
            return changePercent;
        }

        /**
         * @param changePercent The change_percent
         */
        public void setChangePercent(String changePercent) {
            this.changePercent = changePercent;
        }

        /**
         * @return The open
         */
        public String getOpen() {
            return open;
        }

        /**
         * @param open The open
         */
        public void setOpen(String open) {
            this.open = open;
        }

        /**
         * @return The high
         */
        public String getHigh() {
            return high;
        }

        /**
         * @param high The high
         */
        public void setHigh(String high) {
            this.high = high;
        }

        /**
         * @return The low
         */
        public String getLow() {
            return low;
        }

        /**
         * @param low The low
         */
        public void setLow(String low) {
            this.low = low;
        }

        /**
         * @return The sector
         */
        public String getSector() {
            return sector;
        }

        /**
         * @param sector The sector
         */
        public void setSector(String sector) {
            this.sector = sector;
        }

    }


}
