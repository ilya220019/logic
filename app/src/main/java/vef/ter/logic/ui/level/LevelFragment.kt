package vef.ter.logic.ui.level

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vef.ter.logic.R
import vef.ter.logic.databinding.FragmentLevelBinding

class LevelFragment : Fragment() {

    private lateinit var binding: FragmentLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}