package com.momentolabs.app.security.applocker.ui.language

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.data.Language
import com.momentolabs.app.security.applocker.databinding.ItemBackgroundGradientBinding
import com.momentolabs.app.security.applocker.databinding.ItemLanguageBinding

class LanguageAdapter : RecyclerView.Adapter<LanguageAdapter.LanguageItemViewHolder>() {

    private val languageList = arrayListOf<Language>()

    fun setLanguageList(languageList: List<Language>) {
        this.languageList.clear()
        this.languageList.addAll(languageList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LanguageItemViewHolder.create(parent)

    override fun getItemCount(): Int = languageList.size

    override fun onBindViewHolder(holder: LanguageItemViewHolder, position: Int) =
        holder.bind(languageList[position])

    class LanguageItemViewHolder(
        val binding: ItemLanguageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(language: Language) {
            binding.tvContentLanguage.text = language.content
            binding.rbChooseLanguage.isChecked = language.isChecked
            binding.executePendingBindings()
        }

        companion object {
            fun create(
                parent: ViewGroup
            ): LanguageItemViewHolder {
                val binding: ItemLanguageBinding = DataBindingUtil
                    .inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_language,
                        parent,
                        false
                    )
                return LanguageItemViewHolder(binding)
            }
        }
    }
}

