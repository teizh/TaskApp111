package com.example.taskapp.ui.onBoard.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.R
import com.example.taskapp.databinding.ItemOnboardBinding
import com.example.taskapp.model.OnBoard
import com.example.taskapp.utils.loadImage

class OnBoardingAdapter(private val onClick: (OnBoard) -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            title = "Title 1",
            desc = "Description 1",
            image = "https://th.bing.com/th/id/R.c69bd3dd2b83831bbc0fcbb" +
                    "5b0df5c79?rik=TRYF%2bdNLiE%2fBSg&riu=http%3a%2f%2fblog.asana." +
                    "com%2fwp-content%2fpost-images%2fnew-hire-onboarding-Article.png" +
                    "&ehk=rTN3FXGsIJflWh5lUkJW5bG0tjj9xljMdjKc%2f57m9Bc%3d&risl=&pid=ImgRaw&r=0"

        ),
        OnBoard(
            title = "Title 2",
            desc = "Description 2",
            image = "https://static.vecteezy.com/system/resources/previews/000/149/9" +
                    "46/original/multitasking-task-vector-illustration.jpg"

        ),
        OnBoard(
            title = "Title 3",
            desc = "Description 3",
            image = "https://pluspng.com/submit_con.php?name=task-png-png-file-for-linux-720.png"

        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])

        /*  holder.itemView.setOnClickListener {
            //  onClick.invoke(position) safe to use with null
              onClick(position)
          }*/
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnStart.setOnClickListener {
                onClick(onBoard)
            }

            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
            binding.ivBoard.loadImage(onBoard.image)


            //binding.springDotsIndicator.attachTo(onBoard)

        }

    }

}