package com.example.thirest01;

public class XeMayModel {
    private String id,ten_xe_ph33179,mau_sac_ph33179;
    private double gia_ban_ph33179;
    private String mo_ta_ph33179,hinh_anh_ph33179;

    public XeMayModel() {
    }

    public XeMayModel(String id, String ten_xe_ph33179, String mau_sac_ph33179, double gia_ban_ph33179, String mo_ta_ph33179, String hinh_anh_ph33179) {
        this.id = id;
        this.ten_xe_ph33179 = ten_xe_ph33179;
        this.mau_sac_ph33179 = mau_sac_ph33179;
        this.gia_ban_ph33179 = gia_ban_ph33179;
        this.mo_ta_ph33179 = mo_ta_ph33179;
        this.hinh_anh_ph33179 = hinh_anh_ph33179;
    }

    public XeMayModel(String ten_xe_ph33179, String mau_sac_ph33179, double gia_ban_ph33179, String mo_ta_ph33179, String hinh_anh_ph33179) {
        this.ten_xe_ph33179 = ten_xe_ph33179;
        this.mau_sac_ph33179 = mau_sac_ph33179;
        this.gia_ban_ph33179 = gia_ban_ph33179;
        this.mo_ta_ph33179 = mo_ta_ph33179;
        this.hinh_anh_ph33179 = hinh_anh_ph33179;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen_xe_ph33179() {
        return ten_xe_ph33179;
    }

    public void setTen_xe_ph33179(String ten_xe_ph33179) {
        this.ten_xe_ph33179 = ten_xe_ph33179;
    }

    public String getMau_sac_ph33179() {
        return mau_sac_ph33179;
    }

    public void setMau_sac_ph33179(String mau_sac_ph33179) {
        this.mau_sac_ph33179 = mau_sac_ph33179;
    }

    public double getGia_ban_ph33179() {
        return gia_ban_ph33179;
    }

    public void setGia_ban_ph33179(double gia_ban_ph33179) {
        this.gia_ban_ph33179 = gia_ban_ph33179;
    }

    public String getMo_ta_ph33179() {
        return mo_ta_ph33179;
    }

    public void setMo_ta_ph33179(String mo_ta_ph33179) {
        this.mo_ta_ph33179 = mo_ta_ph33179;
    }

    public String getHinh_anh_ph33179() {
        return hinh_anh_ph33179;
    }

    public void setHinh_anh_ph33179(String hinh_anh_ph33179) {
        this.hinh_anh_ph33179 = hinh_anh_ph33179;
    }

    @Override
    public String toString() {
        return "XeMayModel{" +
                "id='" + id + '\'' +
                ", ten_xe_ph33179='" + ten_xe_ph33179 + '\'' +
                ", mau_sac_ph33179='" + mau_sac_ph33179 + '\'' +
                ", gia_ban_ph33179=" + gia_ban_ph33179 +
                ", mo_ta_ph33179='" + mo_ta_ph33179 + '\'' +
                ", hinh_anh_ph33179='" + hinh_anh_ph33179 + '\'' +
                '}';
    }
}
