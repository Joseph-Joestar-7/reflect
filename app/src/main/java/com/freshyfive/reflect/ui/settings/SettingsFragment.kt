package com.freshyfive.reflect.ui.settings

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.freshyfive.reflect.R
import com.freshyfive.reflect.models.getUserName

class SettingsFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profileName = view.findViewById<TextView>(R.id.Profile)
        profileName.text = getUserName(view.context).toString()

        val sendFeedback = view.findViewById<TextView>(R.id.SendFeedback)

        sendFeedback.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("srijandhak04@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "What do you feel about our app?")
                putExtra(Intent.EXTRA_TEXT, "Write your feedback here.")
            }

            try {
                startActivity(i)
            } catch (ex: android.content.ActivityNotFoundException) {
                Toast.makeText(view.context, "There are no email clients installed.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
