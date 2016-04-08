package com.testbatch3.appxone.tadawulproject;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by APPXONE on 1/6/2016.
 */

public class kse1_fetch {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("indices")
    @Expose
    private List<Index> indices = new ArrayList<Index>();

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
     * @return The indices
     */
    public List<Index> getIndices() {
        return indices;
    }

    /**
     * @param indices The indices
     */
    public void setIndices(List<Index> indices) {
        this.indices = indices;
    }


    public class Index {

        @SerializedName("company")
        @Expose
        private String company;
        @SerializedName("valu")
        @Expose
        private String valu;
        @SerializedName("netchange")
        @Expose
        private String netchange;
        @SerializedName("perchange")
        @Expose
        private String perchange;

        /**
         * @return The company
         */
        public String getCompany() {
            return company;
        }

        /**
         * @param company The company
         */
        public void setCompany(String company) {
            this.company = company;
        }

        /**
         * @return The valu
         */
        public String getValu() {
            return valu;
        }

        /**
         * @param valu The valu
         */
        public void setValu(String valu) {
            this.valu = valu;
        }

        /**
         * @return The netchange
         */
        public String getNetchange() {
            return netchange;
        }

        /**
         * @param netchange The netchange
         */
        public void setNetchange(String netchange) {
            this.netchange = netchange;
        }

        /**
         * @return The perchange
         */
        public String getPerchange() {
            return perchange;
        }

        /**
         * @param perchange The perchange
         */
        public void setPerchange(String perchange) {
            this.perchange = perchange;
        }

    }
}
