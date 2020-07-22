package com.tahadroid.deliverbuddy.views.ui.personal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.Personal
import kotlinx.android.synthetic.main.fragment_personal.*


class PersonalFragment : Fragment(R.layout.fragment_personal) {
    lateinit var personalAdapter: PersonalAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        personalAdapter = PersonalAdapter { view, myTab, i ->
        }
        val list = ArrayList<Personal>()
        for (i in 0..10) {
            val tab = Personal()
            list.add(tab)
        }

        personalAdapter.swapData(list)

        personal_rv.apply {
            adapter = personalAdapter
        }
    }

}