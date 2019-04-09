package com.rohail.esspresso_kotlin

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.math.BigDecimal

class CalculatorTest {
    @Test
    fun figureTest() {
        assertThat(
            Figure.ADD.calc(BigDecimal(100), BigDecimal(200))
        ).isEqualTo(BigDecimal(300))

        assertThat(
            Figure.SUB.calc(BigDecimal(10), BigDecimal(4))
        ).isNotEqualTo(BigDecimal(5))

        assertThat(
            Figure.MULTI.calc(BigDecimal(5), BigDecimal(5))
        ).isEqualTo(BigDecimal(25))

        assertThat(
            Figure.DIV.calc(BigDecimal(10), BigDecimal(3))
        ).isNotEqualTo(BigDecimal(3.33333333))
    }
}