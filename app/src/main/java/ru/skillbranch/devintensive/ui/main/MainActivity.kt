package ru.skillbranch.devintensive.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.ui.adapters.ChatAdapter
import ru.skillbranch.devintensive.ui.adapters.ChatItemTouchHelperCallback
import ru.skillbranch.devintensive.ui.group.GroupActivity
import ru.skillbranch.devintensive.utils.Utils
import ru.skillbranch.devintensive.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var chatAdapter: ChatAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        initViews()
        initViewModel()

    }

    private fun initToolbar() {
        toolbar.background = getDrawable(R.color.color_primary)
        setSupportActionBar(toolbar)
    }

    private fun initViews() {

        chatAdapter = ChatAdapter {
            Snackbar.make(rv_chat_list, "Click on ${it.title}", Snackbar.LENGTH_LONG).show()
        }

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val touchCallback = ChatItemTouchHelperCallback(chatAdapter) {
            val id = it.id
            viewModel.addToArchive(it.id)
            Snackbar.make(rv_chat_list, "Вы точно хотите добавить ${it.title} в архив?", Snackbar.LENGTH_LONG)
                .setAction("Отмена") { viewModel.restoreFromArchive(id) }
                .show()
        }

        val touchHelper = ItemTouchHelper(touchCallback)
        touchHelper.attachToRecyclerView(rv_chat_list)

        with(rv_chat_list) {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(divider)
        }


        fab.setOnClickListener{
            val intent = Intent(this, GroupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getChatData().observe(this, Observer { chatAdapter.updateData(it) })
    }
}
