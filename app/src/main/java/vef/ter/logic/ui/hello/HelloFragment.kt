package vef.ter.logic.ui.hello

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import vef.ter.logic.R
import vef.ter.logic.data.local.Pref
import vef.ter.logic.databinding.FragmentHelloBinding
import vef.ter.logic.ui.hello.adapter.OnBoardingAdapter

class HelloFragment : Fragment() {
    private lateinit var binding: FragmentHelloBinding
    private val adapter = OnBoardingAdapter(this::onClick)
    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelloBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewpager)
    }

    private fun onClick() {
//        val uri: Uri = Uri.parse("")
//        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
//        // To count with Play market backstack, After pressing back button,
//        // to taken back to our application, we need to add following flags to intent.
//        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
//                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
//                Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
//        try {
//            startActivity(goToMarket)
//        } catch (e: ActivityNotFoundException) {
//            startActivity(Intent(Intent.ACTION_VIEW,
//                Uri.parse("http://play.google.com/store/apps/details?id=vef.ter.histopymarket")))
//        }
        pref.onOnBoardingShowed()
        findNavController().navigateUp()
    }
}