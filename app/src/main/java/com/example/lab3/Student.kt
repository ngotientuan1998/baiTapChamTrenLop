package com.example.kl_bai_1

class Student (var name: String, var age: Int, var school: String){
    override fun toString(): String {
        return "Student(name='$name', age=$age, school='$school')"
    }
}