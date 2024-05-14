package com.example.kl_bai_1

fun main(args: Array<String>) {
    val managerCard= ManagerCard()
    quanLiThe(managerCard)
}

fun quanLiThe(managerCard: ManagerCard) {
    var choice: Int
    do {
        println("Chương trình quản Thẻ")
        println("1: Thêm thẻ")
        println("2: Xóa thẻ")
        println("3: Hiển thị danh sách thẻ")
        println("4: Thoát chương trình")
        println("Mời bạn chọn chức năng:")

        choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> themThe(managerCard)
            2 -> xoaThe(managerCard)
            3 -> managerCard.xuatThongTinTheThanh()
            4 -> println("Bạn đã thoát chương trình")
            else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại.")
        }
    } while (choice != 4)
}
fun themThe(managerCard: ManagerCard) {
    var studentName: String
    var studentAge: Int
    var studentSchool: String
    var cardId: String
    var borrowDate: Int
    var paymentDate: Int
    var bookId: Int

    println("Mời bạn nhập tên sinh viên:")
    studentName = readLine() ?: ""
    if (studentName.isBlank()) {
        println("Tên sinh viên không được để trống.")
        return
    }

    println("Mời bạn nhập tuổi của sinh viên:")
    studentAge = readLine()?.toIntOrNull() ?: 0
    if (studentAge <= 0) {
        println("Tuổi của sinh viên không hợp lệ.")
        return
    }

    println("Mời bạn nhập trường của sinh viên:")
    studentSchool = readLine() ?: ""
    if (studentSchool.isBlank()) {
        println("Trường của sinh viên không được để trống.")
        return
    }

    println("Mời bạn nhập mã số thẻ:")
    cardId = readLine() ?: ""
    if (cardId.isBlank()) {
        println("Mã số thẻ không được để trống.")
        return
    }

    println("Mời bạn nhập ngày mượn:")
    borrowDate = readLine()?.toIntOrNull() ?: 0

    println("Mời bạn nhập ngày thanh toán:")
    paymentDate = readLine()?.toIntOrNull() ?: 0

    println("Mời bạn nhập mã sách mượn:")
    bookId = readLine()?.toIntOrNull() ?: 0

    // Khởi tạo sinh viên mới và thêm vào danh sách
    val student = Student(studentName, studentAge, studentSchool)
    val newCard = Card(student, cardId, borrowDate, paymentDate, bookId)
    managerCard.add(newCard)

    println("Thẻ mới đã được thêm vào danh sách.")
}


fun xoaThe(managerCard: ManagerCard) {
    println("Nhập mã thẻ muốn xóa:")
    val maTheCanXoa = readLine().toString()

    // Tìm thẻ có mã tương ứng trong danh sách
    val theCanXoa = managerCard.cards.find { it.id == maTheCanXoa }

    // Kiểm tra xem có thẻ có mã tương ứng không
    if (theCanXoa != null) {
        println("Thẻ cần xóa:")
        println("Tên sinh viên: ${theCanXoa.student.name}")
        println("Tuổi sinh viên: ${theCanXoa.student.age}")
        println("Trường sinh viên: ${theCanXoa.student.school}")



        println("Mã thẻ: ${theCanXoa.id}")
        println("Ngày mượn: ${theCanXoa.borrowDate}")
        println("Ngày thanh toán: ${theCanXoa.paymentDate}")
        println("Mã sách mượn: ${theCanXoa.bookId}")
        println()

        println("Bạn có muốn xóa thẻ này không? (Chọn 1 để xóa, chọn 0 để hủy)")
        val luaChon = readLine()?.toIntOrNull()
        when (luaChon) {
            1 -> {
                managerCard.delete(managerCard.cards.indexOf(theCanXoa))
                println("Thẻ đã được xóa khỏi danh sách.")
            }
            0 -> println("Đã hủy thao tác xóa thẻ.")
            else -> println("Lựa chọn không hợp lệ.")
        }
    } else {
        println("Không tìm thấy thẻ có mã $maTheCanXoa trong danh sách.")
    }
}
