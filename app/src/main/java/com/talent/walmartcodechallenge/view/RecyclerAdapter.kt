package com.talent.walmartcodechallenge.view
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.talent.walmartcodechallenge.databinding.CountriesItemBinding
import com.talent.walmartcodechallenge.model.CountriesItem

/**
 * Recycler adapter
 *
 * @property countries
 */
class RecyclerAdapter(
    private val countries: MutableList<CountriesItem> = mutableListOf()
): RecyclerView.Adapter<RecyclerAdapter.CountriesViewHolder>() {
    inner class CountriesViewHolder(
        private val binding: CountriesItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: CountriesItem) {
            binding.apply {
                tvCountryName.text = item.getCountryName()
                tvCountryCapital.text = item.getCountryCapital()
                tvCountryLanguage.text = item.language.getLanguage()
                tvCountryCurrency.text = item.currency.getCurrency()
                Glide.with(ivFlag)
                    .load(item.getFlagImage())
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            pbLoading.visibility = View.GONE
                            return false
                        }

                        /**
                         * success case callback on download image
                         *
                         * @param resource
                         * @param model
                         * @param target
                         * @param dataSource
                         * @param isFirstResource
                         * @return
                         */
                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            pbLoading.visibility = View.GONE
                            return false
                        }

                    })
                    .into(ivFlag)
            }
        }


    }

    /**
     * adds to list and sorts by name
     *
     * @param newList
     */
    fun setCountriesList(newList: List<CountriesItem>) {
        countries.apply {
            clear()
            addAll(newList)
            sortBy { it.name }
        }
        notifyItemRangeChanged(0,itemCount)
    }

    /**
     * Inflates the item views
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CountriesViewHolder(
            CountriesItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )

    /**
     * Binds each item in the ArrayList to a view
     *
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.onBind(countries[position])
    }

    /**
     * Gets the number of items in the list
     *
     * @return
     */
    override fun getItemCount() = countries.size
}