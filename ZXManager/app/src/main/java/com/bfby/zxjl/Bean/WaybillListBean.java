package com.bfby.zxjl.Bean;

import java.io.Serializable;
import java.util.List;

public class WaybillListBean implements Serializable {
    /**
     * status : 1
     * rows : [{"OrderNo":null,"WaybillNo":"Y19092014543989055","ConsignerProvince":null,"ConsignerCity":null,"ConsignerArea":null,"Consigner":null,"Consignerphone":null,"LoadName":null,"ReceiverProvince":null,"ReceiverCity":null,"ReceiverArea":null,"Receiver":null,"ReceiverPhone":null,"UnLoadName":null,"GoodsName":null,"GoodsWeight":0,"Goodsvolume":0,"DriverName":"司机测试7","DriverPhone":"15623232323","Remark":null,"PCarTime":"2019-09-20 14:54:39","CreateTime":"2019-09-20 14:54:39","WaybillStatus":1,"StatusVal":"待接单","_ukid":"ad0ec2c7-7b11-4466-b724-09f49a9246f0"}]
     * page : 1
     * total : 2
     * pageCount : 2
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
         * OrderNo : null
         * WaybillNo : Y19092014543989055
         * ConsignerProvince : null
         * ConsignerCity : null
         * ConsignerArea : null
         * Consigner : null
         * Consignerphone : null
         * LoadName : null
         * ReceiverProvince : null
         * ReceiverCity : null
         * ReceiverArea : null
         * Receiver : null
         * ReceiverPhone : null
         * UnLoadName : null
         * GoodsName : null
         * GoodsWeight : 0
         * Goodsvolume : 0
         * DriverName : 司机测试7
         * DriverPhone : 15623232323
         * Remark : null
         * PCarTime : 2019-09-20 14:54:39
         * CreateTime : 2019-09-20 14:54:39
         * WaybillStatus : 1
         * StatusVal : 待接单
         * _ukid : ad0ec2c7-7b11-4466-b724-09f49a9246f0
         */

        private String OrderNo;
        private String WaybillNo;
        private String ConsignerProvince;
        private String ConsignerCity;
        private String ConsignerArea;
        private String Consigner;
        private String Consignerphone;
        private String LoadName;
        private String ReceiverProvince;
        private String ReceiverCity;
        private String ReceiverArea;
        private String Receiver;
        private String ReceiverPhone;
        private String UnLoadName;
        private String GoodsName;
        private float GoodsWeight;
        private float Goodsvolume;
        private String DriverName;
        private String DriverPhone;
        private String Remark;
        private String PCarTime;
        private String CreateTime;
        private int WaybillStatus;
        private String StatusVal;
        private String _ukid;

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String orderNo) {
            OrderNo = orderNo;
        }

        public String getWaybillNo() {
            return WaybillNo;
        }

        public void setWaybillNo(String waybillNo) {
            WaybillNo = waybillNo;
        }

        public String getConsignerProvince() {
            return ConsignerProvince;
        }

        public void setConsignerProvince(String consignerProvince) {
            ConsignerProvince = consignerProvince;
        }

        public String getConsignerCity() {
            return ConsignerCity;
        }

        public void setConsignerCity(String consignerCity) {
            ConsignerCity = consignerCity;
        }

        public String getConsignerArea() {
            return ConsignerArea;
        }

        public void setConsignerArea(String consignerArea) {
            ConsignerArea = consignerArea;
        }

        public String getConsigner() {
            return Consigner;
        }

        public void setConsigner(String consigner) {
            Consigner = consigner;
        }

        public String getConsignerphone() {
            return Consignerphone;
        }

        public void setConsignerphone(String consignerphone) {
            Consignerphone = consignerphone;
        }

        public String getLoadName() {
            return LoadName;
        }

        public void setLoadName(String loadName) {
            LoadName = loadName;
        }

        public String getReceiverProvince() {
            return ReceiverProvince;
        }

        public void setReceiverProvince(String receiverProvince) {
            ReceiverProvince = receiverProvince;
        }

        public String getReceiverCity() {
            return ReceiverCity;
        }

        public void setReceiverCity(String receiverCity) {
            ReceiverCity = receiverCity;
        }

        public String getReceiverArea() {
            return ReceiverArea;
        }

        public void setReceiverArea(String receiverArea) {
            ReceiverArea = receiverArea;
        }

        public String getReceiver() {
            return Receiver;
        }

        public void setReceiver(String receiver) {
            Receiver = receiver;
        }

        public String getReceiverPhone() {
            return ReceiverPhone;
        }

        public void setReceiverPhone(String receiverPhone) {
            ReceiverPhone = receiverPhone;
        }

        public String getUnLoadName() {
            return UnLoadName;
        }

        public void setUnLoadName(String unLoadName) {
            UnLoadName = unLoadName;
        }

        public String getGoodsName() {
            return GoodsName;
        }

        public void setGoodsName(String goodsName) {
            GoodsName = goodsName;
        }

        public float getGoodsWeight() {
            return GoodsWeight;
        }

        public void setGoodsWeight(float goodsWeight) {
            GoodsWeight = goodsWeight;
        }

        public float getGoodsvolume() {
            return Goodsvolume;
        }

        public void setGoodsvolume(float goodsvolume) {
            Goodsvolume = goodsvolume;
        }

        public String getDriverName() {
            return DriverName;
        }

        public void setDriverName(String driverName) {
            DriverName = driverName;
        }

        public String getDriverPhone() {
            return DriverPhone;
        }

        public void setDriverPhone(String driverPhone) {
            DriverPhone = driverPhone;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String remark) {
            Remark = remark;
        }

        public String getPCarTime() {
            return PCarTime;
        }

        public void setPCarTime(String PCarTime) {
            this.PCarTime = PCarTime;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String createTime) {
            CreateTime = createTime;
        }

        public int getWaybillStatus() {
            return WaybillStatus;
        }

        public void setWaybillStatus(int waybillStatus) {
            WaybillStatus = waybillStatus;
        }

        public String getStatusVal() {
            return StatusVal;
        }

        public void setStatusVal(String statusVal) {
            StatusVal = statusVal;
        }

        public String get_ukid() {
            return _ukid;
        }

        public void set_ukid(String _ukid) {
            this._ukid = _ukid;
        }
    }
}
