package com.momentolabs.app.security.applocker.ui.language

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.momentolabs.app.security.applocker.data.Language
import com.momentolabs.app.security.applocker.databinding.ItemLanguageBinding

class LanguageAdapter(val onClickRadioButton: (language: Language) -> Unit) :
    RecyclerView.Adapter<LanguageAdapter.LanguageItemViewHolder>() {

    private val languageList = arrayListOf<Language>()

    fun setLanguageList(languageList: List<Language>) {
        this.languageList.clear()
        this.languageList.addAll(languageList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLanguageBinding.inflate(inflater, parent, false)
        return LanguageItemViewHolder(binding)
    }

    override fun getItemCount(): Int = languageList.size

    override fun onBindViewHolder(holder: LanguageItemViewHolder, position: Int) =
        holder.bind(languageList[position])

    inner class LanguageItemViewHolder(
        val binding: ItemLanguageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(language: Language) {
            binding.tvContentLanguage.text = language.content
            binding.rbChooseLanguage.isChecked = language.isChecked
            binding.ivIconLanguage.setImageResource(language.iconSource)
            binding.rbChooseLanguage.setOnClickListener {
                onClickRadioButton.invoke(language)
            }
            binding.executePendingBindings()
        }

    }
}

