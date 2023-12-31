package vef.ter.logic.gameplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vef.ter.logic.data.local.Pref
import vef.ter.logic.databinding.FragmentGameBinding
import vef.ter.logic.utils.loadImage

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
        var a = pref.getCount()
        check1()
        var b = a + 1

    }

    fun check1()= with(binding) {
        one.loadImage("https://cdn.pixabay.com/photo/2013/07/18/10/56/smiley-163510_1280.jpg")
        two.loadImage("https://cdn.pixabay.com/photo/2013/07/18/10/56/smiley-163510_1280.jpg")
        three.loadImage("https://cdn.pixabay.com/photo/2013/07/18/10/56/smiley-163510_1280.jpg")
        one.setOnClickListener {
            desk.text = "Охраннику не понравился ваш ответ и он овел вас в карцер"
        }
    }
}