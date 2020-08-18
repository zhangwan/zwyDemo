package com.tiger.zwy.java

/**
 * @author zwy
 * create at 2020/7/9 0009
 * description:
 */
fun main() {
    runTest()
    runTestWithT()

}
fun runTest(){
    var c="a".apply{
//        print(this)
    }

//    var a= run {
//        "abc"
//        1
//    }
//    var b= run {
//        1
//        2
//        "abc"
//    }
//    print(a)
//    print(b)
//    print(c)
}
fun runTestWithT(){
    val a="1".run {
        "$this 和 abc"
    }
    print(a)
}
