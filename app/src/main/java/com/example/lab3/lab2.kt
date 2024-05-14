package com.example.kl_bai_1

fun main(args: Array<String>) {
    quanLiSinhVien();

}

fun quanLiSinhVien() {
    val listSv = mutableListOf<SinhVien>()

    do {
        println("Chương trình quản lý sinh viên")
        println("1: Thêm sinh viên")
        println("2: Xóa sinh viên")
        println("3: Cập nhật sinh viên")
        println("4: Xem danh sách sinh viên")
        println("5: Thoát chương trình")
        println("Mời bạn chọn chức năng:")

        val choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> themSinhVien(listSv)
            2 -> xoaSinhVien(listSv)
            3 -> capNhapSinhVien(listSv)
            4 -> xuatDanhSachSinhVien(listSv)
            5 -> println("Bạn đã thoát chương trình")
            else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại.")
        }
    } while (choice != 5)
}

fun xuatDanhSachSinhVien(listSv: MutableList<SinhVien>) {
    println("Danh sách sinh viên:")
    for (sinhVien in listSv) {
        println("Tên: ${sinhVien.ten}")
        println("Mã sinh viên: ${sinhVien.ma}")
        println("Điểm trung bình: ${sinhVien.diem}")
        if (sinhVien.daTotNghiep == true) {
            println("Đã tốt nghiệp")
        } else {
            println("Chưa tốt nghiệp")
        }
        println("Tuổi: ${sinhVien.tuoi ?: "Chưa có thông tin"}")
    }
}


fun themSinhVien(listSv: MutableList<SinhVien>){

        var tensv: String
        var mssv: String
        var diemtbsv: Float
        var datotnghiepsv: Boolean? = null
        var tuoisv: Int? = null

        println("Mời bạn nhập tên sinh viên")
        var ten = readLine()
        tensv = ten ?: ""
        if (tensv.isBlank()) {
            println("Tên sinh viên không được để trống.")
            return
        }

        println("Mời bạn nhập mã sinh viên")
        var ma = readLine()
        mssv = ma ?: ""
        if (mssv.isBlank()) {
            println("Mã sinh viên không được để trống.")
            return
        }

        println("Mời bạn nhập điểm trung bình sinh viên")
        var diem = readLine()?.toFloatOrNull()
        if (diem == null) {
            println("Điểm trung bình sinh viên không hợp lệ.")
            return
        }
        diemtbsv = diem

        println("Sinh viên đã tốt nghiệp chưa")
        println(" Chưa tốt nghiệp chọn 0")
        println(" Tốt nghiệp chọn các phím còn lại")
        var totNghiep = readLine()?.toIntOrNull()
        if (totNghiep == 0) {
            datotnghiepsv = false
        } else {
            datotnghiepsv = true
        }

        println("Mời bạn nhập tuổi của sinh viên")
        var tuoi = readLine()?.toIntOrNull()
        if (tuoi == null) {
            println("Tuổi của sinh viên không hợp lệ.")
            return
        }
        tuoisv = tuoi

        // Khởi tạo sinh viên mới và thêm vào danh sách
        val sinhVienMoi = SinhVien(tensv, mssv, diemtbsv, datotnghiepsv, tuoisv)
        listSv.add(sinhVienMoi)

        println("Sinh viên mới đã được thêm vào danh sách.")


}
fun xoaSinhVien(listSv: MutableList<SinhVien>) {
    println("Nhập mã sinh viên muốn xóa:")
    val maSvCanXoa = readLine().toString()

    // Tìm sinh viên có mã sinh viên tương ứng trong listSv
    val sinhVienCanXoa = listSv.find { it.ma == maSvCanXoa }

    // Kiểm tra xem có sinh viên có mã sinh viên tương ứng không
    if (sinhVienCanXoa != null) {
        println("Sinh viên cần xóa:")
        println("Tên: ${sinhVienCanXoa.ten}")
        println("Mã sinh viên: ${sinhVienCanXoa.ma}")
        println("Điểm trung bình: ${sinhVienCanXoa.diem}")
        println("Đã tốt nghiệp: ${sinhVienCanXoa.daTotNghiep ?: "Chưa có thông tin"}")
        println("Tuổi: ${sinhVienCanXoa.tuoi ?: "Chưa có thông tin"}")
        println()

        println("Bạn có muốn xóa sinh viên này không? (Chọn 1 để xóa, chọn 0 để hủy)")
        val luaChon = readLine()?.toIntOrNull()
        when (luaChon) {
            1 -> {
                listSv.remove(sinhVienCanXoa)
                println("Sinh viên đã được xóa khỏi danh sách.")
            }
            0 -> println("Đã hủy thao tác xóa sinh viên.")
            else -> println("Lựa chọn không hợp lệ.")
        }
    } else {
        println("Không tìm thấy sinh viên có mã $maSvCanXoa trong danh sách.")
    }
}

fun capNhapSinhVien(listSv: MutableList<SinhVien>) {
    println("Nhập mã sinh viên muốn cập nhật:")
    val maSvCanCapNhap = readLine().toString()

    // Tìm sinh viên có mã sinh viên tương ứng trong listSv
    val sinhVienCanCapNhap = listSv.find { it.ma == maSvCanCapNhap }

    // Kiểm tra xem có sinh viên có mã sinh viên tương ứng không
    if (sinhVienCanCapNhap != null) {
        println("Thông tin sinh viên cần cập nhật:")
        println("Tên: ${sinhVienCanCapNhap.ten}")
        println("Mã sinh viên: ${sinhVienCanCapNhap.ma}")
        println("Điểm trung bình: ${sinhVienCanCapNhap.diem}")
        println("Đã tốt nghiệp: ${sinhVienCanCapNhap.daTotNghiep ?: "Chưa có thông tin"}")
        println("Tuổi: ${sinhVienCanCapNhap.tuoi ?: "Chưa có thông tin"}")
        println()

        println("Mời bạn nhập thông tin mới của sinh viên:")
        println("Nhập tên mới:")
        val tenMoi = readLine()?.takeIf { it.isNotBlank() } ?: sinhVienCanCapNhap.ten

        println("Nhập mã sinh viên mới:")
        val maMoi = readLine()?.takeIf { it.isNotBlank() } ?: sinhVienCanCapNhap.ma

        println("Nhập điểm trung bình mới:")
        val diemMoi = readLine()?.toFloatOrNull() ?: sinhVienCanCapNhap.diem

        println("Sinh viên đã tốt nghiệp chưa")
        println(" Chưa tốt nghiệp chọn 0")
        println(" Tốt nghiệp chọn các phím còn lại")
        val daTotNghiepMoi = when (val luaChon = readLine()?.toIntOrNull()) {
            1 -> true
            0 -> false
            else -> sinhVienCanCapNhap.daTotNghiep
        }

        println("Nhập tuổi mới:")
        val tuoiMoi = readLine()?.toIntOrNull() ?: sinhVienCanCapNhap.tuoi

        // Cập nhật thông tin của sinh viên trong listSv
        val index = listSv.indexOf(sinhVienCanCapNhap)
        listSv[index] = SinhVien(tenMoi, maMoi, diemMoi, daTotNghiepMoi, tuoiMoi)

        println("Thông tin của sinh viên đã được cập nhật trong danh sách.")
    } else {
        println("Không tìm thấy sinh viên có mã $maSvCanCapNhap trong danh sách.")
    }
}






