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

class MainFragment : Fragment() {

    lateinit var itemAdapter : ListAdapter
    var items = mutableListOf<Item>()

    val recordModels = MutableLiveData<List<Item>>()

    // keyword監視
    val keywordSubject = BehaviorSubject.create<String>()
    var keyword: String = ""
        set(value) {
            keywordSubject.onNext(value)
        }

    val api = DmmApi()
    var dialog: Dialog? = null

    // Item
    companion object {
        fun createInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val r = inflater.inflate(R.layout.fragment_main, container, false)
        return r
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                Log.d("TAG", "submit text: $newText")
                //keyword = newText
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.d("TAG", "submit text: $query")
                keyword = query
                searchView.clearFocus()
                return false
            }
        })

        itemAdapter = ListAdapter(items)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }

        dialog = ProgressDialog.progressDialog(this.context!!)

        keywordSubject.subscribe {

            dialog!!.show()

            // items clear
            with(items){
                clear()
                addAll(arrayListOf())
            }
            api.loadItems(it)!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ item ->
                    Log.d("dmm", item.service_code)
                    Log.d("dmm", item.imageURL.small)
                    items.add(item)
                }, { e ->
                    e.printStackTrace()
                },{
                    //movieAdapter.notifyDataSetChanged()
                    Log.d("dmm", "finish")
                    itemAdapter.notifyDataSetChanged()
                    dialog!!.dismiss()
                })
        }
    }
}