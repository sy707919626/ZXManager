package com.bfby.zxjl.Bean;

import java.io.Serializable;
import java.util.List;

public class DriverListBean implements Serializable {

    /**
     * status : 1
     * rows : [{"driverId":"5d6b32f9-b3c3-478c-9978-02e7c8251023","User_Name":"司机测","User_Phone":"15912345685","User_IDCard":null,"User_Email":null,"vehicleId":"d378d754-1473-4101-b779-7ff838a0f5a4","VType":"ffd504b9-1649-4eff-a2ec-4a7e799bb82c","VehicleTypeName":"厢式货车","VNo":"湘A123586","Volume":80,"VLength":0,"VWeight":0,"User_Star":0,"VStatus":null,"VOwnership":"外部车辆","User_State":"禁用","_ukid":"d378d754-1473-4101-b779-7ff838a0f5a4"}]
     * page : 1
     * total : 1
     * pageCount : 0
     */

    private int status;
    private int page;
    private int total;
    private int pageCount;
    private List<RowsBean> rows;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean implements Serializable {
        /**
         * driverId : 5d6b32f9-b3c3-478c-9978-02e7c8251023
         * User_Name : 司机测
         * User_Phone : 15912345685
         * User_IDCard : null
         * User_Email : null
         * vehicleId : d378d754-1473-4101-b779-7ff838a0f5a4
         * VType : ffd504b9-1649-4eff-a2ec-4a7e799bb82c
         * VehicleTypeName : 厢式货车
         * VNo : 湘A123586
         * Volume : 80
         * VLength : 0
         * VWeight : 0
         * User_Star : 0
         * VStatus : null
         * VOwnership : 外部车辆
         * User_State : 禁用
         * _ukid : d378d754-1473-4101-b779-7ff838a0f5a4
         */

        private String driverId;
        private String User_Name;
        private String User_Phone;
        private String User_IDCard;
        private String User_Email;
        private String vehicleId;
        private String VType;
        private String VehicleTypeName;
        private String VNo;
        private float Volume;
        private float VLength;
        private float VWeight;
        private float User_Star;
        private Object VStatus;
        private String VOwnership;
        private String User_State;
        private String _ukid;

        public String getDriverId() {
            return driverId;
        }

        public void setDriverId(String driverId) {
            this.driverId = driverId;
        }

        public String getUser_Name() {
            return User_Name;
        }

        public void setUser_Name(String User_Name) {
            this.User_Name = User_Name;
        }

        public String getUser_Phone() {
            return User_Phone;
        }

        public void setUser_Phone(String User_Phone) {
            this.User_Phone = User_Phone;
        }

        public Object getUser_IDCard() {
            return User_IDCard;
        }

        public void setUser_IDCard(String User_IDCard) {
            this.User_IDCard = User_IDCard;
        }

        public String getUser_Email() {
            return User_Email;
        }

        public void setUser_Email(String User_Email) {
            this.User_Email = User_Email;
        }

        public String getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
        }

        public String getVType() {
            return VType;
        }

        public void setVType(String VType) {
            this.VType = VType;
        }

        public String getVehicleTypeName() {
            return VehicleTypeName;
        }

        public void setVehicleTypeName(String VehicleTypeName) {
            this.VehicleTypeName = VehicleTypeName;
        }

        public String getVNo() {
            return VNo;
        }

        public void setVNo(String VNo) {
            this.VNo = VNo;
        }

        public float getVolume() {
            return Volume;
        }

        public void setVolume(float Volume) {
            this.Volume = Volume;
        }

        public float getVLength() {
            return VLength;
        }

        public void setVLength(float VLength) {
            this.VLength = VLength;
        }

        public float getVWeight() {
            return VWeight;
        }

        public void setVWeight(float VWeight) {
            this.VWeight = VWeight;
        }

        public float getUser_Star() {
            return User_Star;
        }

        public void setUser_Star(float User_Star) {
            this.User_Star = User_Star;
        }

        public Object getVStatus() {
            return VStatus;
        }

        public void setVStatus(Object VStatus) {
            this.VStatus = VStatus;
        }

        public String getVOwnership() {
            return VOwnership;
        }

        public void setVOwnership(String VOwnership) {
            this.VOwnership = VOwnership;
        }

        public String getUser_State() {
            return User_State;
        }

        public void setUser_State(String User_State) {
            this.User_State = User_State;
        }

        public String get_ukid() {
            return _ukid;
        }

        public void set_ukid(String _ukid) {
            this._ukid = _ukid;
        }
    }
}
