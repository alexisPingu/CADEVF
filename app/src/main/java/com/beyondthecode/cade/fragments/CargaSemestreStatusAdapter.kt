package com.beyondthecode.cade.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beyondthecode.cade.R
import com.beyondthecode.cade.api.modelos.CargaSemestreStatusItem
import com.beyondthecode.cade.databinding.ItemCargasstatusBinding

class CargaSemestreStatusAdapter(
    private var context: Context,
    var cargas: List<CargaSemestreStatusItem>?
) :
    RecyclerView.Adapter<CargaSemestreStatusAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.item_cargasstatus, parent, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        if (cargas!![position].statusCargaAcademica == "0") {
            viewHolder.binding.textoCargastt.text =
                "tu carga del " + cargas!![position].semestreLlevado + " semestre no ha sido validada"
        } else {
            viewHolder.binding.textoCargastt.text =
                "tu carga del " + cargas!![position].semestreLlevado + " semestre ya se valido =)"
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return cargas!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCargasstatusBinding.bind(view)
    }
}
