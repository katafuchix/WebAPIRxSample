package com.example.webapirxsample.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webapirxsample.R
import com.example.webapirxsample.model.Item
import com.example.webapirxsample.model.api.DmmApi
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.fragment_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ActressFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val r = inflater.inflate(R.layout.fragment_actress, container, false)
        return r
    }


    companion object {
        fun createInstance(): ActressFragment {
            val fragment = ActressFragment()
            return fragment
        }
    }
}