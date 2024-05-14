package com.example.kl_bai_1


class ManagerTeacher {
    val teachers: MutableList<Teacher> = mutableListOf()

    fun add(teacher: Teacher){
        teachers.add(teacher)
    }

    fun delete(index: Int) {
        if (index in 0 until teachers.size) {
            teachers.removeAt(index)
        } else {
            println("Index out of bounds.")
        }
    }

    fun xuatDanhSachGiaoVien() {
        println("Danh sách giáo viên:")
        for (giaoVien in teachers) {
            println("Tên: ${giaoVien.name}")
            println("Mã giáo viên: ${giaoVien.id}")
            println("Lương: ${giaoVien.salary}")
            println("Thưởng: ${giaoVien.bonus}")
            println("Phạt: ${giaoVien.penalty}")
            println("Lương thực: ${giaoVien.realSalary}")
            println("Tuổi: ${giaoVien.age}")
            println("Quê quán: ${giaoVien.hometown}")
        }
    }


}