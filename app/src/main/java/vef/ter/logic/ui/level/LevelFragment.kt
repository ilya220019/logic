package vef.ter.logic.ui.level

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import vef.ter.logic.R
import vef.ter.logic.data.local.Pref
import vef.ter.logic.databinding.FragmentLevelBinding
import vef.ter.logic.utils.loadImage


class LevelFragment : Fragment() {

    private lateinit var binding: FragmentLevelBinding
    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fon.loadImage("https://cdn.pixabay.com/photo/2023/11/30/07/51/bridge-8420945_1280.jpg")
        var a  = pref.getCount()
        binding.play.setOnClickListener {
            var b  = a +1
            pref.count(b.toInt())
if(!pref.alertShow()){
    showAlertDialog()
}
            if(pref.alertShow()){
                findNavController().navigate(R.id.gameFragment)
            }
    }}
    private fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setMessage("Правила игры " +
                "1) необходимо подключение к интернету")
        alertDialogBuilder.setCancelable(false)

        alertDialogBuilder.setPositiveButton("Прочитано") { _, _ ->

            pref.alertShowed()
            Toast.makeText(requireContext(), "Вы прочитали правила игры", Toast.LENGTH_SHORT).show()
        }

        val alertDialog = alertDialogBuilder.create()

        // Запрещаем закрытие AlertDialog при нажатии вне его области
        alertDialog.setCanceledOnTouchOutside(false)

        // Запрещаем закрытие AlertDialog по кнопке "Назад" на устройстве
        alertDialog.setOnKeyListener { _, keyCode, _ ->
            keyCode == android.view.KeyEvent.KEYCODE_BACK
        }

        // Показываем AlertDialog
        alertDialog.show()
    }
}