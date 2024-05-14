package com.example.kl_bai_1

class SinhVien(var ten: String, var ma: String, var diem: Float, var daTotNghiep: Boolean?, var tuoi: Int?) {
    override fun toString(): String {
        return "SinhVien(ten='$ten', ma='$ma', diem=$diem, daTotNghiep=$daTotNghiep, tuoi=$tuoi)"
    }
}
