package com.testbatch3.appxone.tadawulproject;

/**
 * Created by APPXONE on 1/6/2016.
 */


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
    private Integer time;
    @SerializedName("stoke")
    @Expose
    private List<Stoke> stoke = new ArrayList<Stoke>();
    @SerializedName("market")
    @Expose
    private List<Market> market = new ArrayList<Market>();

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
    public Integer getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * @return The stoke
     */
    public List<Stoke> getStoke() {
        return stoke;
    }

    /**
     * @param stoke The stoke
     */
    public void setStoke(List<Stoke> stoke) {
        this.stoke = stoke;
    }

    /**
     * @return The market
     */
    public List<Market> getMarket() {
        return market;
    }

    /**
     * @param market The market
     */
    public void setMarket(List<Market> market) {
        this.market = market;
    }


    public class Market {

        @SerializedName("symbol")
        @Expose
        private String symbol;
        @SerializedName("ldcp")
        @Expose
        private String ldcp;
        @SerializedName("open")
        @Expose
        private String open;
        @SerializedName("high")
        @Expose
        private String high;
        @SerializedName("low")
        @Expose
        private String low;
        @SerializedName("current")
        @Expose
        private String current;
        @SerializedName("changes")
        @Expose
        private String changes;
        @SerializedName("volume")
        @Expose
        private String volume;
        @SerializedName("sector")
        @Expose
        private String sector;

        /**
         * @return The symbol
         */
        public String getSymbol() {
            return symbol;
        }

        /**
         * @param symbol The symbol
         */
        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        /**
         * @return The ldcp
         */
        public String getLdcp() {
            return ldcp;
        }

        /**
         * @param ldcp The ldcp
         */
        public void setLdcp(String ldcp) {
            this.ldcp = ldcp;
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
         * @return The current
         */
        public String getCurrent() {
            return current;
        }

        /**
         * @param current The current
         */
        public void setCurrent(String current) {
            this.current = current;
        }

        /**
         * @return The changes
         */
        public String getChanges() {
            return changes;
        }

        /**
         * @param changes The changes
         */
        public void setChanges(String changes) {
            this.changes = changes;
        }

        /**
         * @return The volume
         */
        public String getVolume() {
            return volume;
        }

        /**
         * @param volume The volume
         */
        public void setVolume(String volume) {
            this.volume = volume;
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


    public class Stoke {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("constant")
        @Expose
        private String constant;
        @SerializedName("value")
        @Expose
        private String value;

        /**
         * @return The id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The constant
         */
        public String getConstant() {
            return constant;
        }

        /**
         * @param constant The constant
         */
        public void setConstant(String constant) {
            this.constant = constant;
        }

        /**
         * @return The value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value The value
         */
        public void setValue(String value) {
            this.value = value;
        }

    }


}
