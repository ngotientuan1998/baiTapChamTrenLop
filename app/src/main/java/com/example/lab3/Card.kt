package com.example.kl_bai_1

class Card (var student: Student, var id: String, var borrowDate: Int, var paymentDate: Int, var bookId: Int){
    override fun toString(): String {
        return "Card(student=$student, id='$id', borrowDate=$borrowDate, paymentDate=$paymentDate, bookId=$bookId)"
    }
}