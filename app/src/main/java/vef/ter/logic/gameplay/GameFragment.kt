package vef.ter.logic.gameplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vef.ter.logic.data.local.Pref
import vef.ter.logic.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private val pref: Pref by lazy {
        Pref(requireContext())
    }
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        res()
        update()

    }

    fun res() {
        binding.next.setOnClickListener {
            var c = pref.getCount()
            var b = c + 1
            pref.count(b)
            need(false)
            update()
        }


        binding.del.setOnClickListener {
            pref.count(1)
        }
        binding.next.text = pref.getCount().toString()
    }

    fun update() {
        var a = pref.getCount()
        need(false)
        if (a == 1)
            check1()
        if (a == 2)
            check2()
        if (a == 3)
            binding.desk.text = "jsx"

    }

    fun check1() = with(binding) {
        need(false)
        desk.text = "Авторитет: Эй, новенький, тебе не тут дело. Что тебе от меня нужно?\n" +
                "Вы: Слушай, я слышал, что у тебя есть влияние. Мне нужна помощь, чтобы выбраться.\n" +
                "Авторитет: Я не делаю вот так, на словах. Но ты можешь что-то для меня сделать."
        one.text = "Что угодно, просто скажи, что нужно"
        two.text = "Давайте обоюдное сотрудничество, и я помогу вам в будущем"
        three.text = "Может, я что-то еще найду для тебя, если выручишь меня сейчас?"

        one.setOnClickListener {
            need(true)
        }
        two.setOnClickListener {
            need(true)

        }
        three.setOnClickListener {
            need(true)
        }
    }

    fun check2() = with(binding) {
        desk.text = "Сосед по камере: Эй, новенький, че ты тут мутнишь?\n" +
                "Вы: Мне нужно выйти. Ты в курсе чего-нибудь, что поможет?\n" +
                "Сосед по камере: Ну, я слышал, что тут есть выход через старые туннели. Но я точно не знаю, где."
        one.text = "Ты можешь узнать подробности? Возможно, я смогу использовать эту информацию."

        two.text =
            "Слушай, я могу сделать так, чтобы в твоей камере было немного меньше неприятностей."

        three.text = "Ладно, я разберусь сам. Спасибо за подсказку."

        one.setOnClickListener {
            need(true)
        }
        two.setOnClickListener {
            need(true)

        }
        three.setOnClickListener {
            need(true)
        }
    }

    fun need(hd: Boolean) {
        if (hd == true) {
            binding.next.visibility = View.VISIBLE
        }
        if (hd == false) {
            binding.next.visibility = View.GONE
        }
    }
}