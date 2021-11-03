package org.d3ifcool.MySkin.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.MySkin.data.DataDiary
import org.d3ifcool.MySkin.databinding.DataDiaryBinding

class MainAdapter(
    private val handler: ClickHandler
) : ListAdapter<DataDiary, MainAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataDiary>() {
            override fun areItemsTheSame(
                oldData: DataDiary, newData: DataDiary
            ): Boolean {
                return oldData.id == newData.id
            }
            override fun areContentsTheSame(
                oldData: DataDiary, newData: DataDiary
            ): Boolean {
                return oldData == newData
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataDiaryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ViewHolder(
        private val binding: DataDiaryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataDiary: DataDiary) {
            binding.judulTextView.text = dataDiary.judul
            binding.isiTextView.text = dataDiary.isi

            val pos = absoluteAdapterPosition
            itemView.isSelected = selectionIds.contains(dataDiary.id)
            itemView.setOnClickListener { handler.onClick(pos, dataDiary) }
            itemView.setOnLongClickListener { handler.onLongClick(pos) }

        }
    }

    interface ClickHandler {
        fun onClick(position: Int, dataDiary: DataDiary)
        fun onLongClick(position: Int): Boolean

    }

    private val selectionIds = ArrayList<Int>()
    fun toggleSelection(pos: Int) {
        val id = getItem(pos).id
        if (selectionIds.contains(id))
            selectionIds.remove(id)
        else
            selectionIds.add(id)
        notifyDataSetChanged()
    }
    fun getSelection(): List<Int> {
        return selectionIds
    }
    fun resetSelection() {
        selectionIds.clear()
        notifyDataSetChanged()
    }

}
