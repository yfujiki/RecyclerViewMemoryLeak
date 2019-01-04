package com.yfujiki.recyclerviewmemoryleak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import kotlinx.android.synthetic.main.view_holder_main.view.*
import java.lang.ref.WeakReference

class MainRecyclerViewAdapter: RecyclerView.Adapter<MainRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_main, parent, false)
        return MainRecyclerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
        holder.itemView.textView.text = position.toString()
    }
}

class MainRecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val disposable = CompositeDisposable()

    init {
        disposable += AppState.stateSubject.subscribe {
            itemView.textView.text = "Status : $it"
            someMethod()
        }
    }

    fun someMethod() {
        println("Doing nothing...")
    }
}