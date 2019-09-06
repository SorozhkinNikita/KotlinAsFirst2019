@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
if (age==1)
    return "$age год"
if (2<=age && age<=4)
    return "$age года"
if (5<=age && age<=20)
    return "$age лет"
if (age>=21 && age<=105 || age>=121) {
    val c=age%10
    if (c==1) return "$age год"
    if (2<=c && c<=4) return "$age года"
    if (c==0 || 5<=c && c<=9) return "$age лет"
    }
    else return "$age лет"
    return ""
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double
{
    val half: Double = (t1*v1+t2*v2+t3*v3)/2.0
    if (t1*v1>=half) return half/v1 else
    if (t1*v1+t2*v2<=half) return t1+t2+t3-half/v3 else
    if (half>t1*v1 && half<t1*v1+t2*v2) return (half-t1*v1)/v2+t1
    return 0.0
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int {
    if (kingX==rookX1 && kingY==rookY2 || kingY==rookY1 && kingX==rookX2 || kingX==rookX1 && kingX==rookX2 || kingY==rookY1 && kingY==rookY2) return 3
    if (kingX==rookX2 || kingY==rookY2) return 2
    if (kingX==rookX1 || kingY==rookY1) return 1
    return 0
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int
{
    val slon:Boolean=abs(kingX-bishopX)==abs(kingY-bishopY)
    val ladya:Boolean=if (kingX==rookX || kingY==rookY) true else false
    if (slon==false && ladya==false) return 0
    if (slon==true && ladya==true) return 3
    if (slon==true) return 2
    if (ladya==true) return 1
return 0
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int
{
    val cos1=(sqr(b)+ sqr(c)- sqr(a))/(2.0*b*c)
    val cos2=(sqr(c)+ sqr(a)- sqr(b))/(2.0*c*a)
    val cos3=(sqr(a)+ sqr(b)- sqr(c))/(2.0*a*b)
    if (cos1>1.0 || cos2>1.0 || cos3>1.0) return -1 else
    if (cos1==0.0 || cos2==0.0 || cos3==0.0) return 1 else
    if (cos1<0.0 || cos2<0.0 || cos3<0.0) return 2 else
    if (cos1>0.0 && cos2>0.0 && cos3>0.0 && cos1<1.0 && cos2<1.0 && cos3<1.0) return 0
    return 5

}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int
{
    if (b<c && b<d) return -1
    if (b>=c && b<=d && a<=c) return b-c
    if (d<a && d<b) return -1
    if (d>=a && d<=b && c<=a) return d-a
    if (c>=a && d<=b) return d-c
    if (a>=c && b<=d) return b-a
return 0
}
//{
//    if (b<c||d<a) return -1
//    else {
//        if (c<b&&c>a) return b-c
//        else {
//            if (a < d && a > c) return d - a
//            else return 0
//        }
//    }
//}
fun main() {
//    val a=timeForHalfWay(1.0,5.0,2.0,4.0,3.0,3.0)
//    println(a)
//    val kingX=4
//    val kingY=8
//    val  bishopX=7
//    val bishopY=5
//    val slon:Boolean=abs(kingX-bishopX)==abs(kingY-bishopY)
//    println(slon)
}