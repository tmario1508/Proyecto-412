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
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.mariotorrese.proyecto_412.R
import com.mariotorrese.proyecto_412.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {
    val appContext = requireContext().applicationContext
    private lateinit var binding:FragmentLoginBinding
    private lateinit var mProgressBar: ProgressDialog

    private lateinit var email: String
    private lateinit var password: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        //binding.relativeLayout = GridLayoutManager(requireContext(), 1)

        val appContext = requireContext().applicationContext

        binding.onLogin2.setOnClickListener {
            Toast.makeText(appContext, "Click en Login", Toast.LENGTH_SHORT).show()
            //Obtenemos usuario y contraseña
            email = binding.emailTxt.text.toString()
            password = binding.passTxt.text.toString()
            Log.d("Login","Si hace click a login")
            //Verificamos que los campos no este vacios
            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

                //Mostramos el progressdialog
                mProgressBar.setMessage("Registering User...")
                mProgressBar.show()

                Log.d("Login","Si entra, los campos no estan vacios")
                //Iniciamos sesión con el método signIn y enviamos usuario y contraseña
                signIn(email, password)

            } else {
                Toast.makeText(appContext, "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signIn(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                val user = result.result?.user?.email.toString()
                goMain(user)
            } else {
                Toast.makeText(appContext, "Login Fail, verifique sus datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goMain(user: String) {
        Log.d("Login","Si llama a la principal")

    }

}