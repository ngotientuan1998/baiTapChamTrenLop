package com.example.kl_bai_1

class ManagerCard {

     val cards: MutableList<Card> = mutableListOf()
    fun  add(card: Card){
        this.cards.add(card)
    }
    fun delete(index: Int) {
        if (index in 0 until cards.size) {
            cards.removeAt(index)
        } else {
            println("Index out of bounds.")
        }
    }

    fun xuatThongTinTheThanh() {
        println("Danh sách thẻ thành:")
        for (card in cards) {
            println("Tên sinh viên: ${card.student.name}")
            println("Tuổi sinh viên: ${card.student.age}")
            println("Trường sinh viên: ${card.student.school}")

            println("Mã thẻ: ${card.id}")
            println("Ngày mượn: ${card.borrowDate}")
            println("Ngày thanh toán: ${card.paymentDate}")
            println("Mã sách mượn: ${card.bookId}")
        }
    }

}