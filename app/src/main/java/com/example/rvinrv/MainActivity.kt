package com.example.rvinrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.rvinrv.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rvAdapter = RVAdapter()
    private val textAdapter = ItemInnerAdapter()
    private val surname = "Doe"
    private val name = "John"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMockData()
        binding.recycleView.adapter = rvAdapter

        binding.apply {
            recycleViewMenu.adapter = textAdapter

        }
        setData()
        binding.recycleViewMenu.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )


        rvAdapter.setInnerItemClickListener {id ->
            Snackbar.make(binding.recycleView, "$name $surname $id", Snackbar.LENGTH_SHORT).show()
        }

    }


    private fun setData() {
        val menu = listOf(
            "  Рекомендуем    ",
            "Лучшее",
            "Детям",
            "Платние",
            "Категории",
        )
        textAdapter.models = menu
    }
    private fun setMockData() {
        var i = 0
        val data = mutableListOf<Item>()
        repeat(20) {
            val innerData = mutableListOf<Add>()
            var j = 0
            repeat(30) {
                innerData.add(
                    when (j) {
                        0 -> {
                            j++
                            Add(
                                R.drawable.img_1_karta,
                                R.drawable.img_1_karta,
                                i,
                                "$i Пасьянс - \nклассический пасьянс",
                                "4,6 * 55 МБ"
                            )
                        }

                        1 -> {
                            j++
                            Add(
                                R.drawable.img_1_tas,
                                R.drawable.img_1_tas,
                                i,
                                "$i Драгоценный \nдревний клад ",
                                "4,7 * 23 МБ"
                            )

                        }
                        2 -> {
                            j++
                            Add(
                                R.drawable.img_3_farm,
                                R.drawable.img_3_farm,
                                i,
                                "$i Farm city: \nFarming & building",
                                "3,7 * 32 МБ"
                            )

                        }
                        3 -> {
                            j++
                            Add(
                                R.drawable.img_4_differnce,
                                R.drawable.img_4_differnce,
                                i,
                                "$i Найди отличия",
                                "3,7 * 32 МБ"
                            )

                        }
                        4 -> {
                            j++
                            Add(
                                R.drawable.img_5_gol1,
                                R.drawable.img_5_gol1,
                                i,
                                "$i Объединить \nблоки - слияние гол",
                                "3,7 * 32 МБ"
                            )

                        }
                        5 -> {
                            j++
                            Add(
                                R.drawable.img_6_jungle,
                                R.drawable.img_6_jungle,

                                i,
                                "$i Jungle marble\n blast 2",
                                "3,7 * 32 МБ"
                            )

                        }
                        6 -> {
                            j++
                            Add(
                                R.drawable.img_7_top,
                                R.drawable.img_7_top,
                                i,
                                "$i Top color  pro",
                                "3,7 * 32 МБ"
                            )

                        }
                        7 -> {
                            j++
                            Add(
                                R.drawable.img_8_subway,
                                R.drawable.img_8_subway,
                                i,
                                "$i Subway surfers",
                                "3,7 * 32 МБ"
                            )

                        }
                        8 -> {
                            j++
                            Add(
                                R.drawable.img_9_bricks,
                                R.drawable.img_9_bricks,
                                i,
                                "$i Bricks \nballs breaker",
                                "3,7 * 32 МБ"
                            )

                        }
                        9 -> {
                            j++
                            Add(
                                R.drawable.img_10_candy,
                                R.drawable.img_10_candy,
                                i,
                                "$i Candy crush saga",
                                "3,7 * 32 МБ"
                            )

                        }
                        10 -> {
                        j++
                        Add(
                            R.drawable.img_11_puzle_game,
                            R.drawable.img_11_puzle_game,
                            i,
                            "$i Ball Sort Master-\nPuzzle Game",
                            "3,7 * 32 МБ"
                        )

                    }

                        11 -> {
                            j++
                            Add(
                                R.drawable.img_11_puzle_game,
                                R.drawable.img_11_puzle_game,
                                i,
                                "$i Ball Sort Master-\nPuzzle Game",
                                "3,7 * 32 МБ"
                            )

                        }


                        else -> {
                            j++
                            Add(
                                R.drawable.img_11_puzle_game,
                                R.drawable.img_11_puzle_game,
                                i,
                                "$i Name",
                                "3,7 * 32 МБ"
                            )
                        }
                    }
                )
                i++
            }
            data.add(Item(list = innerData, id = it))
        }
        rvAdapter.models = data
    }
}