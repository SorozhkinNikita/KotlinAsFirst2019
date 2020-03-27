@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
 * Класс "комплексое число".
 *
 * Общая сложность задания -- лёгкая.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
private fun splitForReIm(s: String): Pair<Double, Double> {
    if (s.contains('+'))
        return s.split("+")[0].toDouble() to s.split("+")[1].dropLast(1).toDouble()
    if (s.contains('-'))
        return s.split("-")[0].toDouble() to -s.split("-")[1].dropLast(1).toDouble()
    if (s.contains('i'))
        return 0.0 to s.dropLast(1).toDouble()
    return s.toDouble() to 0.0
}

class Complex(val re: Double, val im: Double) {
    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

    /**
     * Конструктор из строки вида x+yi
     */


    constructor(s: String) : this(splitForReIm(s).first, splitForReIm(s).second)


    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(other.re + this.re, other.im + this.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-this.im, -this.re)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(this.re - other.re, this.im - other.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex =
        Complex(other.re * this.re - other.im * this.im, other.im * this.re + other.re * this.im)

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        val denominator = other.im * other.im + other.re * other.re
        return Complex(
            (other.im * this.im + other.re * this.re) /
                    denominator, (other.re * this.im - other.im * this.re) / denominator
        )
    }

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false
        return re == other.re && im == other.im
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String =
        when {
            im == 0.0 && re == 0.0 -> "0.0"
            re == 0.0 -> "${im}i"
            im == 0.0 -> "$re"
            im == 1.0 -> "${re}+i"
            im == -1.0 -> "${re}-i"
            else -> if (im > 0) "${re}+${im}i" else "${re}${im}i"
        }

}


fun neSost4islo(mas: List<Int>, n: Int): Int {
    var zadannoe = 1  //наш будущий ответ
    val newMas = mas.sorted() //сортируем массив по возрастанию
    var sI = 0 //начальный индекс перебора
    if (newMas[0] == 1) {  //этот иф упразднить желательно, нужен он для того чтобы не выходил за границы массива в первом форе
        zadannoe++
        sI++
    }
    return helper(zadannoe, newMas, sI, newMas.size, mutableListOf())
}

fun helper(zadannoe: Int, mas: List<Int>, startIndex: Int, finalIndex: Int, trace: MutableList<Int>): Int {
    var index = -1
    var bolshee = -1
    for (i in startIndex..finalIndex - 1) {  //получаем индекс и само число в массиве которое стоит перед первым числом большим нашего перебираемого
        if (mas[i] > zadannoe) {
            index = i - 1
            bolshee = mas[i - 1]
            break
        }
    }
    for (i in 0..index) { //если предполагаемое равно какому либо из массива или мы можем получить его суммой "большего" и любого
        if (mas[index - i] - zadannoe == 0 || zadannoe == mas[index - i] + bolshee) {
            if (trace.isEmpty()) //проверка на "возращались ли мы в прошлое" путем вычитания
                helper(
                    zadannoe + 1,
                    mas,
                    0,
                    mas.size,
                    mutableListOf()
                ) //опять же нужно посмотрет стартовые индексы, пока установлены по умолчанию 0, но это не оптимально
            else {
                helper(trace[0] + 1, mas, 0, mas.size, mutableListOf()) // -||-
            }
        } else
            if (zadannoe - bolshee > mas[index - i]) { //разбиваем число на предполагаемую сумму
                trace.add(zadannoe) //оставляем "память о доме"
                helper(zadannoe - bolshee, mas, 0, index, trace) // -||-
            }
    }
    return zadannoe
}

