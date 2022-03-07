package com.example.whiterabit_employedetails.ui.employee

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.whiterabit_employedetails.Data.entities.EmployeeList
import com.example.whiterabit_employedetails.databinding.ItemCharacterBinding

class EmployeeAdapter(private val listener: CharacterItemListener) : RecyclerView.Adapter<CharacterViewHolder>() {

    interface CharacterItemListener {
        fun onClickedCharacter(characterId: Int)
    }

    private val items = ArrayList<EmployeeList>()

    fun setItems(items: ArrayList<EmployeeList>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding: ItemCharacterBinding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) = holder.bind(items[position])
}

class CharacterViewHolder(private val itemBinding: ItemCharacterBinding, private val listener: EmployeeAdapter.CharacterItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var employeeList: EmployeeList

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: EmployeeList) {
        this.employeeList = item
        itemBinding.name.text = item.name
        itemBinding.speciesAndStatus.text = """${item.email} - ${item.email}"""
        Glide.with(itemBinding.root)
            .load(item.profile_image)
            .transform(CircleCrop())
            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        listener.onClickedCharacter(employeeList.id)
    }
}

