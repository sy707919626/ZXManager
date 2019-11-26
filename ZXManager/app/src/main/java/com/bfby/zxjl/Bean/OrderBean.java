package com.bfby.zxjl.Bean;

import java.io.Serializable;
import java.util.List;

public class OrderBean implements Serializable {

    /**
     * status : 1
     * rows : [{"OrderNo":"No201909181","CreateTime":"2019-09-18 15:27:27","User_Name":"马双全","User_Phone":"18774846095","Consigner":"马双全","Consignerphone":"18774846095","ConsignerProvince":"北京北京市东城区","Receiver":"马化腾","ReceiverPhone":"13477777777","ReceiverProvince":"浙江杭州市上城区","NeedVehicle":1,"Remark":"快点来运，过时不候","SettlementStatus":1,"OrderFee":0,"OrderTaxFee":0,"OrderTotalFee":0,"GoodsName":"机器人","GoodsWeight":100,"Goodsvolume":80,"User_Sign":"否","OrderSource":"微信","OrderStatus":"进行中","_ukid":"a26fc67b-7ea8-4c31-bdb6-21b60ce12105"}]
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

    public static class RowsBean {
        /**
         * OrderNo : No201909181
         * CreateTime : 2019-09-18 15:27:27
         * User_Name : 马双全
         * User_Phone : 18774846095
         * Consigner : 马双全
         * Consignerphone : 18774846095
         * ConsignerProvince : 北京北京市东城区
         * Receiver : 马化腾
         * ReceiverPhone : 13477777777
         * ReceiverProvince : 浙江杭州市上城区
         * NeedVehicle : 1
         * Remark : 快点来运，过时不候
         * SettlementStatus : 1
         * OrderFee : 0
         * OrderTaxFee : 0
         * OrderTotalFee : 0
         * GoodsName : 机器人
         * GoodsWeight : 100
         * Goodsvolume : 80
         * User_Sign : 否
         * OrderSource : 微信
         * OrderStatus : 进行中
         * _ukid : a26fc67b-7ea8-4c31-bdb6-21b60ce12105
         */

        private String OrderNo;
        private String CreateTime;
        private String User_Name;
        private String User_Phone;
        private String Consigner;
        private String Consignerphone;
        private String ConsignerProvince;
        private String Receiver;
        private String ReceiverPhone;
        private String ReceiverProvince;
        private int NeedVehicle;
        private String Remark;
        private int SettlementStatus;
        private float OrderFee;
        private float OrderTaxFee;
        private float OrderTotalFee;
        private String GoodsName;
        private float GoodsWeight;
        private float Goodsvolume;
        private String User_Sign;
        private String OrderSource;
        private int OrderStatus;
        private String _ukid;
        private String SendTime;

        public String getSendTime() {
            return SendTime;
        }

        public void setSendTime(String sendTime) {
            SendTime = sendTime;
        }

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
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

        public String getConsigner() {
            return Consigner;
        }

        public void setConsigner(String Consigner) {
            this.Consigner = Consigner;
        }

        public String getConsignerphone() {
            return Consignerphone;
        }

        public void setConsignerphone(String Consignerphone) {
            this.Consignerphone = Consignerphone;
        }

        public String getConsignerProvince() {
            return ConsignerProvince;
        }

        public void setConsignerProvince(String ConsignerProvince) {
            this.ConsignerProvince = ConsignerProvince;
        }

        public String getReceiver() {
            return Receiver;
        }

        public void setReceiver(String Receiver) {
            this.Receiver = Receiver;
        }

        public String getReceiverPhone() {
            return ReceiverPhone;
        }

        public void setReceiverPhone(String ReceiverPhone) {
            this.ReceiverPhone = ReceiverPhone;
        }

        public String getReceiverProvince() {
            return ReceiverProvince;
        }

        public void setReceiverProvince(String ReceiverProvince) {
            this.ReceiverProvince = ReceiverProvince;
        }

        public int getNeedVehicle() {
            return NeedVehicle;
        }

        public void setNeedVehicle(int NeedVehicle) {
            this.NeedVehicle = NeedVehicle;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public int getSettlementStatus() {
            return SettlementStatus;
        }

        public void setSettlementStatus(int SettlementStatus) {
            this.SettlementStatus = SettlementStatus;
        }

        public float getOrderFee() {
            return OrderFee;
        }

        public void setOrderFee(float OrderFee) {
            this.OrderFee = OrderFee;
        }

        public float getOrderTaxFee() {
            return OrderTaxFee;
        }

        public void setOrderTaxFee(float OrderTaxFee) {
            this.OrderTaxFee = OrderTaxFee;
        }

        public float getOrderTotalFee() {
            return OrderTotalFee;
        }

        public void setOrderTotalFee(float OrderTotalFee) {
            this.OrderTotalFee = OrderTotalFee;
        }

        public String getGoodsName() {
            return GoodsName;
        }

        public void setGoodsName(String GoodsName) {
            this.GoodsName = GoodsName;
        }

        public float getGoodsWeight() {
            return GoodsWeight;
        }

        public void setGoodsWeight(float GoodsWeight) {
            this.GoodsWeight = GoodsWeight;
        }

        public float getGoodsvolume() {
            return Goodsvolume;
        }

        public void setGoodsvolume(float Goodsvolume) {
            this.Goodsvolume = Goodsvolume;
        }

        public String getUser_Sign() {
            return User_Sign;
        }

        public void setUser_Sign(String User_Sign) {
            this.User_Sign = User_Sign;
        }

        public String getOrderSource() {
            return OrderSource;
        }

        public void setOrderSource(String OrderSource) {
            this.OrderSource = OrderSource;
        }

        public int getOrderStatus() {
            return OrderStatus;
        }

        public void setOrderStatus(int OrderStatus) {
            this.OrderStatus = OrderStatus;
        }

        public String get_ukid() {
            return _ukid;
        }

        public void set_ukid(String _ukid) {
            this._ukid = _ukid;
        }
    }
}
