package com.lirui.demo1

object HelloWorld {

  def main(args: Array[String]): Unit = {
    println("Hello Scala")
    System.out.println("Hello From Java")

    /** 常量 */
    val a: Int = 10
    /** 变量 */
    var b = 20.555
    b = a + b
    printf("val: %d, var: %s", a, b)

    val +-*/#@! = "zhangsan"
    printf("特殊符号: %s", +-*/#@!)
    println()
    val `if` = "男"
    printf("关键字: %s", `if`)

    val name = "zhangsan"
    val str =
      s"""
        |SELECT
        |  *
        |FROM
        |  user
        |WHERE
        |  username = '$name'
        |""".stripMargin
    println(str)
  }
}
