package com.rohail.esspresso_kotlin

import java.math.BigDecimal

enum class Figure {
    ADD, SUB, MULTI, DIV, NONE;

    fun calc(arg1: BigDecimal, arg2: BigDecimal): BigDecimal =
        when (this) {
            Figure.ADD -> arg1.plus(arg2)
            Figure.SUB -> arg1.minus(arg2)
            Figure.MULTI -> arg1.multiply(arg2)
            Figure.DIV -> arg1.divide(arg2, 8, BigDecimal.ROUND_HALF_UP)
            Figure.NONE -> arg2
        }
}