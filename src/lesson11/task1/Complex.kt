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

