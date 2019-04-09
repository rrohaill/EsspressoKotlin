package com.rohail.esspresso_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jakewharton.rxbinding2.view.RxView
import com.rohail.esspresso_kotlin.databinding.ActivityMainBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import java.math.BigDecimal
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val formatter = DecimalFormat("#,###.#")
        .apply {
            minimumFractionDigits = 0
            maximumFractionDigits = 8
        }

    private var field = BigDecimal.ZERO
    private var stack = BigDecimal.ZERO
    private var currentFigure = Figure.NONE
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )

        arrayOf(
            binding.button0,
            binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9
        ).forEach { button ->
            RxView
                .clicks(button)
                .subscribe {
                    field = field
                        .multiply(BigDecimal(10))
                        .plus(BigDecimal(button.tag.toString().toInt()))
                    binding.field.setText(formatter.format(field))
                }
                .addTo(disposables)
        }

        arrayOf(
            binding.buttonAllClear,
            binding.buttonAdd, binding.buttonSub,
            binding.buttonMulti, binding.buttonDivide
        ).forEach { button ->
            RxView.clicks(button)
                .subscribe {
                    currentFigure = Figure.valueOf(button.tag.toString())
                    stack = if (currentFigure != Figure.NONE) field else BigDecimal.ZERO
                    field = BigDecimal.ZERO
                    if (stack == BigDecimal.ZERO) {
                        binding.field.setText(formatter.format(field))
                    }
                }
                .addTo(disposables)
        }

        RxView
            .clicks(binding.buttonCalc)
            .subscribe {
                field = currentFigure.calc(stack, field)
                binding.field.setText(formatter.format(field))
            }
            .addTo(disposables)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
