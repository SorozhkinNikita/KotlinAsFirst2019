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
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

    /**
     * Конструктор из строки вида x+yi
     */
    constructor(s: String) : this {
    }
    //this(s.split("+").first().toDouble(), s.split("+").first().dropLast(1).toDouble())

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(re + this.re, im + this.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-this.re, -this.im)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(re - this.re, im - this.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex =
        Complex(re * this.re - im * this.im, im * this.re + re * this.im)

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        val denominator = this.im * this.im + this.re * this.re
        return Complex((im * this.im + re * this.re) / denominator, (re * this.im - im * this.re) / denominator)
    }

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = im == this.im && re == this.re

    /**
     * Преобразование в строку
     */
    override fun toString(): String =
        when {
            im == 0.0 && re == 0.0 -> ""
            re == 0.0 -> "${im}i"
            im == 0.0 -> "$re"
            im == 1.0 -> "${re}+i"
            im == -1.0 -> "${re}-i"
            else -> if (im > 0) "${re}+${im}i" else "${re}${im}i"
        }

}