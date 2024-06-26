package com.o5appstudio.travelappui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.o5appstudio.travelappui.model.Category

class CategoryListAdapter(private val context: Context, private val categoryList: List<Category>) : Adapter<CategoryListAdapter.CategoryViewHolder>() {

    private var selectedItemPosition: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.categories_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       val pos = categoryList[position]
//       holder.bind(pos, position == selectedItemPosition)

        holder.image.setImageResource(pos.icon)
        holder.catTitle.text = pos.title
        holder.layout.setBackgroundResource(if (position == selectedItemPosition) R.drawable.item_border_theme else R.drawable.item_border)
        holder.image.setBackgroundResource(if(position == selectedItemPosition) R.drawable.category_item_theme_bg else R.drawable.category_item_white_bg)
        DrawableCompat.setTint(
            DrawableCompat.wrap(holder.image.getDrawable()),
            ContextCompat.getColor(context, if(position == selectedItemPosition) R.color.white else R.color.themeApp)
        );


        holder.layout.setOnClickListener {
            val previousItemPosition = selectedItemPosition
            selectedItemPosition = holder.adapterPosition
            notifyItemChanged(previousItemPosition)
            notifyItemChanged(holder.adapterPosition)
        }



    }

    override fun getItemCount(): Int {
       return categoryList.size
    }

    inner class CategoryViewHolder(itemView: View) : ViewHolder(itemView){
        val layout : ConstraintLayout = itemView.findViewById(R.id.categoryItemLayout)
        val image :ImageView = itemView.findViewById(R.id.categoryImage)
        val catTitle : TextView = itemView.findViewById(R.id.categoryName)
        init {
            itemView.setOnClickListener {
                val previousItemPosition = selectedItemPosition
                selectedItemPosition = adapterPosition
                notifyItemChanged(previousItemPosition ?: -1)
                notifyItemChanged(adapterPosition)
            }
        }
        fun bind(item: Category, isSelected: Boolean) {
            image.setImageResource(item.icon)
            catTitle.text = item.title
            layout.setBackgroundResource(if (isSelected) R.drawable.item_border_theme else R.drawable.item_border)
            image.setBackgroundResource(if(isSelected) R.drawable.category_item_theme_bg else R.drawable.category_item_white_bg)
            DrawableCompat.setTint(
                DrawableCompat.wrap(image.getDrawable()),
                ContextCompat.getColor(context, if(isSelected) R.color.white else R.color.themeApp)
            );

        }


    }

}
