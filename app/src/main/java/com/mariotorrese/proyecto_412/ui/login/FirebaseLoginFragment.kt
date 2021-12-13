package com.mariotorrese.proyecto_412.ui.login

import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.mariotorrese.proyecto_412.R
import com.mariotorrese.proyecto_412.databinding.FragmentFirebaseLoginBinding
import com.mariotorrese.proyecto_412.databinding.FragmentMainBinding


class FirebaseLoginFragment : Fragment(R.layout.fragment_firebase_login) {
    private lateinit var binding: FragmentFirebaseLoginBinding

    private lateinit var email: String
    private lateinit var password: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirebaseLoginBinding.bind(view)

        binding.onEntrar.setOnClickListener {
            email = binding.logEmail.text.toString()
            password = binding.logPassword.text.toString()
            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                //Iniciamos sesión con el método signIn y enviamos usuario y contraseña
                signIn(email, password)

            } else {
                showAlertVal()
            }
        }
    }

    private fun signIn(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                val user = result.result?.user?.email.toString()
                goMain(user)
            } else {
                showAlert()
                //Toast.makeText(this.requireContext(), "Usuario o contraseña incorrectos, verifique sus datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goMain(user: String) {
        val action = FirebaseLoginFragmentDirections.actionFirebaseLoginFragmentToMainFragment(
            user
        )
        findNavController().navigate(action)
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Usuario o contraseña incorrectos")
        builder.setMessage("Favor de verificar sus datos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlertVal() {
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Campos vacios")
        builder.setMessage("Favor de llenar todos los campos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}