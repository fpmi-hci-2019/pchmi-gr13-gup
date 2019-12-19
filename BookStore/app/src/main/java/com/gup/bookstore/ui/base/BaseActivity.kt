package com.gup.bookstore.ui.base

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gup.bookstore.R
import com.gup.bookstore.ui.extensions.toMessage

abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity() {

    protected lateinit var vm: V
    private val progressDialog: Dialog by lazy {
        Dialog(this).apply {
            setContentView(R.layout.dialog_progress)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    abstract fun createViewModel(): V

    open fun bindViewModel() {
        vm.loading.observe(this, Observer {
            if (it) {
                progressDialog.show()
            } else {
                progressDialog.dismiss()
            }
        })
        vm.error.observe(this, Observer {
            if (it != null) {
                AlertDialog.Builder(this)
                    .setMessage(it.toMessage(resources))
                    .setOnDismissListener { vm.error.value = null }
                    .create()
                    .apply { show() }
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = createViewModel()
    }

    override fun onStart() {
        super.onStart()
        bindViewModel()
    }
}