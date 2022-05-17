
package com.example.restaurantslistyelp.utils

import android.app.Activity
import androidx.appcompat.app.AlertDialog

object MessageUtils {

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- SHOW ALERT -=-=-=-=-=-=-=-=-=-=-=-=-=- */

    fun showAlert(context: Activity, title: String, message: String) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton("Ok") { dialogInterface, i -> dialogInterface.dismiss() }
        val dialog = alertDialog.create()
        if (!context.isFinishing) dialog.show()

    }

}
