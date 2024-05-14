package com.example.kl_bai_1

fun main(args: Array<String>) {
    val managerTeacher = ManagerTeacher()
    quanLiGiaoVien(managerTeacher)
}

fun quanLiGiaoVien(managerTeacher: ManagerTeacher) {
    var choice: Int
    do {
        println("Chương trình quản lý giáo viên")
        println("1: Thêm giáo viên")
        println("2: Xóa giáo viên")
        println("3: Hiển thị danh sách giáo viên")
        println("4: Thoát chương trình")
        println("Mời bạn chọn chức năng:")

        choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> themGiaoVien(managerTeacher)
            2 -> xoaGiaoVien(managerTeacher)
            3 -> managerTeacher.xuatDanhSachGiaoVien()
            4 -> println("Bạn đã thoát chương trình")
            else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại.")
        }
    } while (choice != 4)
}
fun themGiaoVien(managerTeacher: ManagerTeacher) {
    var name: String
    var age: Int
    var hometown: String
    var id: String
    var salary: Double
    var bonus: Double
    var penalty: Double
    var realSalary: Double

    println("Mời bạn nhập tên giáo viên:")
    name = readLine() ?: ""
    if (name.isBlank()) {
        println("Tên giáo viên không được để trống.")
        return
    }

    println("Mời bạn nhập tuổi của giáo viên:")
    age = readLine()?.toIntOrNull() ?: 0
    if (age <= 0) {
        println("Tuổi của giáo viên không hợp lệ.")
        return
    }

    println("Mời bạn nhập quê quán của giáo viên:")
    hometown = readLine() ?: ""
    if (hometown.isBlank()) {
        println("Quê quán của giáo viên không được để trống.")
        return
    }

    println("Mời bạn nhập mã số giáo viên:")
    id = readLine() ?: ""
    if (id.isBlank()) {
        println("Mã số giáo viên không được để trống.")
        return
    }

    println("Mời bạn nhập lương của giáo viên:")
    salary = readLine()?.toDoubleOrNull() ?: 0.0

    println("Mời bạn nhập thưởng của giáo viên:")
    bonus = readLine()?.toDoubleOrNull() ?: 0.0

    println("Mời bạn nhập phạt của giáo viên:")
    penalty = readLine()?.toDoubleOrNull() ?: 0.0

    // Tính lương thực của giáo viên
    realSalary = salary + bonus - penalty

    // Khởi tạo giáo viên mới và thêm vào danh sách
    val newTeacher = Teacher(salary, bonus, penalty, realSalary, name, age, hometown, id)
    managerTeacher.add(newTeacher)

    println("Giáo viên mới đã được thêm vào danh sách.")
}

fun xoaGiaoVien(managerTeacher: ManagerTeacher) {
    println("Nhập mã giáo viên muốn xóa:")
    val maGvCanXoa = readLine().toString()

    // Tìm giáo viên có mã tương ứng trong danh sách
    val giaoVienCanXoa = managerTeacher.teachers.find { it.id == maGvCanXoa }

    // Kiểm tra xem có giáo viên có mã tương ứng không
    if (giaoVienCanXoa != null) {
        println("Giáo viên cần xóa:")
        println("Tên: ${giaoVienCanXoa.name}")
        println("Mã giáo viên: ${giaoVienCanXoa.id}")
        println("Lương: ${giaoVienCanXoa.salary}")
        println("Thưởng: ${giaoVienCanXoa.bonus}")
        println("Phạt: ${giaoVienCanXoa.penalty}")
        println("Lương thực: ${giaoVienCanXoa.realSalary}")
        println("Tuổi: ${giaoVienCanXoa.age}")
        println("Quê quán: ${giaoVienCanXoa.hometown}")
        println()

        println("Bạn có muốn xóa giáo viên này không? (Chọn 1 để xóa, chọn 0 để hủy)")
        val luaChon = readLine()?.toIntOrNull()
        when (luaChon) {
            1 -> {
                managerTeacher.delete(managerTeacher.teachers.indexOf(giaoVienCanXoa))
                println("Giáo viên đã được xóa khỏi danh sách.")
            }
            0 -> println("Đã hủy thao tác xóa giáo viên.")
            else -> println("Lựa chọn không hợp lệ.")
        }
    } else {
        println("Không tìm thấy giáo viên có mã $maGvCanXoa trong danh sách.")
    }
}