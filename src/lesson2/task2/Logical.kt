@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import lesson4.task1.abs
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean
{
    val n1=number%10
    val n2=number/10%10
    val n3=number/100%10
    val n4=number/1000%10
    if (n1+n2==n3+n4) return true else return false

}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean
{
    val di:Boolean=if (abs(x1-x2)==abs(y1-y2)) true else false
    val pr:Boolean=if (x1==x2 || y1==y2) true else false
    if (di==true || pr==true) return true else return false
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int = when(month)
{
    1 -> 31
    2 -> if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 29 else 28
    3 -> 31
    4 -> 30
    5 -> 31
    6 -> 30
    7 -> 31
    8 -> 31
    9 -> 30
    10 -> 31
    11 -> 30
    else -> 31
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean
{
    if (sqrt(sqr(x1-x2)+sqr(y1-y2))+r1<=r2) return true else return false
}
//{
//    val c1:Boolean=if (x2>x1 && y2>y1) true else false
//    val c2:Boolean=if (x2<x1 && y2>y1) true else false
//    val c3:Boolean=if (x2<x1 && y2<y1) true else false
//    val c4:Boolean=if (x2>x1 && y2<y1) true else false
//    if (c1==true)
//        if ()
//}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean
{
    if (a<=r && b<=s || b<=r && a<=s || a<=r && c<=s || c<=r && a<=s || b<=r && c<=s || c<=r && b<=s) return true else return false
}

fun main() {
//    val x1=4
//    val y1=8
//    val x2=7
//    val y2=5
//    val di:Boolean=if (abs(x1-x2) == abs(y1-y2)) true else false
//        println(di)
}