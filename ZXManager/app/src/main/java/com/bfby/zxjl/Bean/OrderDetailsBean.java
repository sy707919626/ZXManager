package com.bfby.zxjl.Bean;

import java.io.Serializable;

public class OrderDetailsBean implements Serializable {

    /**
     * Id : a26fc67b-7ea8-4c31-bdb6-21b60ce12105
     * OrderNo : No201909101
     * Consigner : 马双全
     * Consignerphone : 18774846095
     * ConsignerProvince : 北京
     * ConsignerCity : 北京市
     * ConsignerArea : 东城区
     * ConsignerAdress : 建设路
     * Receiver : 马化腾
     * ReceiverPhone : 13477777777
     * ReceiverProvince : 浙江
     * ReceiverCity : 杭州市
     * ReceiverArea : 上城区
     * ReceiverAdress : 西域
     * OrderStatus : 4
     * IsScore : 0
     * OrderFee : 0
     * OrderTaxFee : 0
     * OrderTotalFee : 0
     * GrossProfit : 0
     * RealGrossProfit : 0
     * SendTime : 2019-09-18T15:24:00
     * EndTime : null
     * SettlementMethod : 1
     * SettlementStatus : 1
     * IsTicket : 0
     * TicketStatus : 0
     * IsMedicare : 0
     * MedicareAmount : 0
     * MedicareNo : null
     * VehicleType : ffd504b9-1649-4eff-a2ec-4a7e799bb82c
     * VehicleLength : 12
     * NeedVehicle : 1
     * OrderSource : 3
     * EvaluationStatus : 0
     * ExpireStatus : 0
     * Remark : 快点来运，过时不候
     * CreateId : bf34e437-100b-4994-965c-6a1c5e1a554e
     * CreateTime : 2019-09-18 15:27:27
     * UpdateId : 0198459e-2034-4533-b843-5d227ad20740
     * UpdateTime : 2019-09-19T11:28:59.76
     * Valid : true
     * PlanName : null
     * PlanStatus : 0
     * CompanyId : 7e0dc412-7d7b-43f0-8e89-6b6941db1f8f
     * GoodsType : 1
     * GoodsPrice : 10000
     * GoodsgotoType : 0
     * OrderID : a26fc67b-7ea8-4c31-bdb6-21b60ce12105
     * GoodsName : 机器人
     * GoodsWeight : 100
     * Goodsvolume : 80
     * GoodsNumber : 0
     * cargotypeclassificationcode : 90
     * User_ID : bf34e437-100b-4994-965c-6a1c5e1a554e
     * User_OpenID : null
     * User_Name : 马双全
     * User_LoginName : 18774846095
     * User_Pwd : 39160252246103155053882106713868762172
     * User_Email : null
     * User_Phone : 18774846095
     * User_State : 1
     * User_Star : 0
     * User_Type : 2
     * User_Sign : 0
     * User_OrderCount : 0
     * User_IDCard : null
     * User_Card_A : null
     * User_Card_B : null
     * User_Head : null
     * User_IsDelete : 1
     * User_CreateID : null
     * User_CreateTime : 2019-08-01T08:31:43.56
     * CompnayId : null
     * status : 1
     */

    private String Id;
    private String OrderNo;
    private String Consigner;
    private String Consignerphone;
    private String ConsignerProvince;
    private String ConsignerCity;
    private String ConsignerArea;
    private String ConsignerAdress;
    private String Receiver;
    private String ReceiverPhone;
    private String ReceiverProvince;
    private String ReceiverCity;
    private String ReceiverArea;
    private String ReceiverAdress;
    private int OrderStatus;
    private int IsScore;
    private float OrderFee;
    private float OrderTaxFee;
    private float OrderTotalFee;
    private int GrossProfit;
    private int RealGrossProfit;
    private String SendTime;
    private String EndTime;
    private int SettlementMethod;
    private int SettlementStatus;
    private int IsTicket;
    private int TicketStatus;
    private int IsMedicare;
    private int MedicareAmount;
    private String MedicareNo;
    private String VehicleType;
    private String VehicleLength;
    private String VechileTypeName;
    private int NeedVehicle;
    private int OrderSource;
    private int EvaluationStatus;
    private int ExpireStatus;
    private String Remark;
    private String CreateId;
    private String CreateTime;
    private String UpdateId;
    private String UpdateTime;
    private boolean Valid;
    private String PlanName;
    private int PlanStatus;
    private String CompanyId;
    private int GoodsType;
    private float GoodsPrice;
    private int GoodsgotoType;
    private String OrderID;
    private String GoodsName;
    private float GoodsWeight;
    private float Goodsvolume;
    private int GoodsNumber;
    private String cargotypeclassificationcode;
    private String User_ID;
    private String User_OpenID;
    private String User_Name;
    private String User_LoginName;
    private String User_Pwd;
    private String User_Email;
    private String User_Phone;
    private int User_State;
    private int User_Star;
    private int User_Type;
    private int User_Sign;
    private int User_OrderCount;
    private String User_IDCard;
    private String User_Card_A;
    private String User_Card_B;
    private String User_Head;
    private int User_IsDelete;
    private String User_CreateID;
    private String User_CreateTime;
    private String CompnayId;
    private int status;

    public void setOrderTaxFee(float orderTaxFee) {
        OrderTaxFee = orderTaxFee;
    }

    public void setOrderTotalFee(float orderTotalFee) {
        OrderTotalFee = orderTotalFee;
    }

    public String getVechileTypeName() {
        return VechileTypeName;
    }

    public void setVechileTypeName(String vechileTypeName) {
        VechileTypeName = vechileTypeName;
    }

    public void setGoodsPrice(float goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    public void setGoodsWeight(float goodsWeight) {
        GoodsWeight = goodsWeight;
    }

    public void setGoodsvolume(float goodsvolume) {
        Goodsvolume = goodsvolume;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
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

    public String getConsignerAdress() {
        return ConsignerAdress;
    }

    public void setConsignerAdress(String consignerAdress) {
        ConsignerAdress = consignerAdress;
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

    public String getReceiverAdress() {
        return ReceiverAdress;
    }

    public void setReceiverAdress(String receiverAdress) {
        ReceiverAdress = receiverAdress;
    }

    public int getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        OrderStatus = orderStatus;
    }

    public int getIsScore() {
        return IsScore;
    }

    public void setIsScore(int isScore) {
        IsScore = isScore;
    }

    public float getOrderFee() {
        return OrderFee;
    }

    public void setOrderFee(float orderFee) {
        OrderFee = orderFee;
    }

    public float getOrderTaxFee() {
        return OrderTaxFee;
    }

    public void setOrderTaxFee(int orderTaxFee) {
        OrderTaxFee = orderTaxFee;
    }

    public float getOrderTotalFee() {
        return OrderTotalFee;
    }

    public void setOrderTotalFee(int orderTotalFee) {
        OrderTotalFee = orderTotalFee;
    }

    public int getGrossProfit() {
        return GrossProfit;
    }

    public void setGrossProfit(int grossProfit) {
        GrossProfit = grossProfit;
    }

    public int getRealGrossProfit() {
        return RealGrossProfit;
    }

    public void setRealGrossProfit(int realGrossProfit) {
        RealGrossProfit = realGrossProfit;
    }

    public String getSendTime() {
        return SendTime;
    }

    public void setSendTime(String sendTime) {
        SendTime = sendTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public int getSettlementMethod() {
        return SettlementMethod;
    }

    public void setSettlementMethod(int settlementMethod) {
        SettlementMethod = settlementMethod;
    }

    public int getSettlementStatus() {
        return SettlementStatus;
    }

    public void setSettlementStatus(int settlementStatus) {
        SettlementStatus = settlementStatus;
    }

    public int getIsTicket() {
        return IsTicket;
    }

    public void setIsTicket(int isTicket) {
        IsTicket = isTicket;
    }

    public int getTicketStatus() {
        return TicketStatus;
    }

    public void setTicketStatus(int ticketStatus) {
        TicketStatus = ticketStatus;
    }

    public int getIsMedicare() {
        return IsMedicare;
    }

    public void setIsMedicare(int isMedicare) {
        IsMedicare = isMedicare;
    }

    public int getMedicareAmount() {
        return MedicareAmount;
    }

    public void setMedicareAmount(int medicareAmount) {
        MedicareAmount = medicareAmount;
    }

    public String getMedicareNo() {
        return MedicareNo;
    }

    public void setMedicareNo(String medicareNo) {
        MedicareNo = medicareNo;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getVehicleLength() {
        return VehicleLength;
    }

    public void setVehicleLength(String vehicleLength) {
        VehicleLength = vehicleLength;
    }

    public int getNeedVehicle() {
        return NeedVehicle;
    }

    public void setNeedVehicle(int needVehicle) {
        NeedVehicle = needVehicle;
    }

    public int getOrderSource() {
        return OrderSource;
    }

    public void setOrderSource(int orderSource) {
        OrderSource = orderSource;
    }

    public int getEvaluationStatus() {
        return EvaluationStatus;
    }

    public void setEvaluationStatus(int evaluationStatus) {
        EvaluationStatus = evaluationStatus;
    }

    public int getExpireStatus() {
        return ExpireStatus;
    }

    public void setExpireStatus(int expireStatus) {
        ExpireStatus = expireStatus;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getCreateId() {
        return CreateId;
    }

    public void setCreateId(String createId) {
        CreateId = createId;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getUpdateId() {
        return UpdateId;
    }

    public void setUpdateId(String updateId) {
        UpdateId = updateId;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public boolean isValid() {
        return Valid;
    }

    public void setValid(boolean valid) {
        Valid = valid;
    }

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String planName) {
        PlanName = planName;
    }

    public int getPlanStatus() {
        return PlanStatus;
    }

    public void setPlanStatus(int planStatus) {
        PlanStatus = planStatus;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

    public int getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(int goodsType) {
        GoodsType = goodsType;
    }

    public Float getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    public int getGoodsgotoType() {
        return GoodsgotoType;
    }

    public void setGoodsgotoType(int goodsgotoType) {
        GoodsgotoType = goodsgotoType;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public Float getGoodsWeight() {
        return GoodsWeight;
    }

    public void setGoodsWeight(Float goodsWeight) {
        GoodsWeight = goodsWeight;
    }

    public Float getGoodsvolume() {
        return Goodsvolume;
    }

    public void setGoodsvolume(Float goodsvolume) {
        Goodsvolume = goodsvolume;
    }

    public int getGoodsNumber() {
        return GoodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        GoodsNumber = goodsNumber;
    }

    public String getCargotypeclassificationcode() {
        return cargotypeclassificationcode;
    }

    public void setCargotypeclassificationcode(String cargotypeclassificationcode) {
        this.cargotypeclassificationcode = cargotypeclassificationcode;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }

    public String getUser_OpenID() {
        return User_OpenID;
    }

    public void setUser_OpenID(String user_OpenID) {
        User_OpenID = user_OpenID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_LoginName() {
        return User_LoginName;
    }

    public void setUser_LoginName(String user_LoginName) {
        User_LoginName = user_LoginName;
    }

    public String getUser_Pwd() {
        return User_Pwd;
    }

    public void setUser_Pwd(String user_Pwd) {
        User_Pwd = user_Pwd;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String user_Email) {
        User_Email = user_Email;
    }

    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        User_Phone = user_Phone;
    }

    public int getUser_State() {
        return User_State;
    }

    public void setUser_State(int user_State) {
        User_State = user_State;
    }

    public int getUser_Star() {
        return User_Star;
    }

    public void setUser_Star(int user_Star) {
        User_Star = user_Star;
    }

    public int getUser_Type() {
        return User_Type;
    }

    public void setUser_Type(int user_Type) {
        User_Type = user_Type;
    }

    public int getUser_Sign() {
        return User_Sign;
    }

    public void setUser_Sign(int user_Sign) {
        User_Sign = user_Sign;
    }

    public int getUser_OrderCount() {
        return User_OrderCount;
    }

    public void setUser_OrderCount(int user_OrderCount) {
        User_OrderCount = user_OrderCount;
    }

    public String getUser_IDCard() {
        return User_IDCard;
    }

    public void setUser_IDCard(String user_IDCard) {
        User_IDCard = user_IDCard;
    }

    public String getUser_Card_A() {
        return User_Card_A;
    }

    public void setUser_Card_A(String user_Card_A) {
        User_Card_A = user_Card_A;
    }

    public String getUser_Card_B() {
        return User_Card_B;
    }

    public void setUser_Card_B(String user_Card_B) {
        User_Card_B = user_Card_B;
    }

    public String getUser_Head() {
        return User_Head;
    }

    public void setUser_Head(String user_Head) {
        User_Head = user_Head;
    }

    public int getUser_IsDelete() {
        return User_IsDelete;
    }

    public void setUser_IsDelete(int user_IsDelete) {
        User_IsDelete = user_IsDelete;
    }

    public String getUser_CreateID() {
        return User_CreateID;
    }

    public void setUser_CreateID(String user_CreateID) {
        User_CreateID = user_CreateID;
    }

    public String getUser_CreateTime() {
        return User_CreateTime;
    }

    public void setUser_CreateTime(String user_CreateTime) {
        User_CreateTime = user_CreateTime;
    }

    public String getCompnayId() {
        return CompnayId;
    }

    public void setCompnayId(String compnayId) {
        CompnayId = compnayId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
