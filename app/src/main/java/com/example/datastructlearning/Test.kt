package com.example.datastructlearning

import java.sql.DriverManager.println

fun main() {
    val result = (0xF0FF and 0x000F or 0x00F0 shl 1) / (4 shr 1)
    println(result.toString() + "")
}
class Test {

}