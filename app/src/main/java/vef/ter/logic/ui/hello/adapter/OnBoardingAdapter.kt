package vef.ter.logic.ui.hello.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import vef.ter.logic.R
import vef.ter.logic.databinding.ItemOnboardingBinding
import vef.ter.logic.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val data = arrayListOf(
        OnBoarding(
            "To-do list!",
            "Here you can write down something important or make a schedule for tomorrow:)",
            R.mipmap.ic_door
        ),
        OnBoarding(
            "Share your crazy idea ^_^",
            "You can easily share with your report, list or schedule and it's convenient",
            R.mipmap.ic_door

        ),
        OnBoarding(
            "Flexibility",
            "Your note with you at home, at work, even at the resort",
            R.mipmap.ic_door


        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }

        }
    }
}