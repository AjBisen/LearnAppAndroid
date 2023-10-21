package com.dbvertex.quizappnew.Presentation.Profile

import android.Manifest
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dbvertex.quiz_app.Dashboard.SharedPrefrenceHelper
import com.dbvertex.quizappnew.QuizApplication
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.Utill.FileUtils
import com.dbvertex.quizappnew.databinding.FragProfileBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class Profile:Fragment() {
    lateinit var profileBinding:FragProfileBinding
    private val CAMERA_INTENT_CODE = 101
    private val GALLERY_INTENT_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileBinding= FragProfileBinding.inflate(inflater,container,false)
        return profileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        profileBinding.backtool.back.setOnClickListener {
            findNavController().navigateUp()
        }

        profileBinding.changeimg.setOnClickListener {
            permission()
        }
        profileBinding.emailet.setText(SharedPrefrenceHelper.email.toString())
        profileBinding.dobet.setText(SharedPrefrenceHelper.dob.toString())
        profileBinding.username.setText(SharedPrefrenceHelper.name.toString())
        profileBinding.mobileno.setText(SharedPrefrenceHelper.mobile.toString())


    }
    fun permission() {
        Dexter.withContext(QuizApplication.instance.applicationContext)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) { /* ... */
                    if (report.areAllPermissionsGranted()) {
                        //enable popup
                        imageselectDialog()
                    }
                    if (report.isAnyPermissionPermanentlyDenied()) {
                        showRationalDialogForPermissions()
                    }
                }
                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) { /* ... */
                    token?.continuePermissionRequest()
                    // showRationalDialogForPermissions()
                }
            }).check()
    }
    private fun imageselectDialog() {
        // findNavController().navigate(R.id.otp_Fragment)
        val fonts = arrayOf(
            "Camera", "Gallery"
        )
        val builder = AlertDialog.Builder(
            requireActivity(),
           android.R.style.Theme_DeviceDefault_Dialog_Alert
        )
        builder.setTitle("Choose image from ? ")
        builder.setItems(fonts) { dialog, which ->
            if ("Camera" == fonts[which]) {
                getCameraImage()
                dialog.dismiss()
            } else if ("Gallery" == fonts[which]) {
                getGalleryImage()
                dialog.dismiss()
            }
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
        }
        builder.setCancelable(false)
        builder.show()
    }

    private fun showRationalDialogForPermissions() {
        val alertDialog: AlertDialog.Builder =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                AlertDialog.Builder(
                    QuizApplication.instance.applicationContext,
                    android.R.style.Theme_DeviceDefault_Light_Dialog_Alert
                )
            } else {
                AlertDialog.Builder(
                    QuizApplication.instance.applicationContext,
                    com.chaos.view.R.style.ThemeOverlay_AppCompat
                )
            }
        // set alert dialog message text color
        alertDialog.setTitle("Need Permissions")
        val message =
            SpannableString("This app needs permission to use this feature. You can grant them in app settings.")
        message.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0,
            message.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        alertDialog.setMessage(message)
        val gotosetting =
            SpannableString("GO TO SETTINGS")
        gotosetting.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0,
            gotosetting.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        alertDialog.setPositiveButton(
            gotosetting
        ) { _, _ ->
            try {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", "com.wellopathy", null)
                intent.data = uri
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
        val gotocancel =
            SpannableString("CANCEL")
        gotocancel.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0,
            gotocancel.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        alertDialog.setNegativeButton(
            "$gotocancel"
        ) { _, _ -> }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }


    private fun getCameraImage() {
        val cameraIntent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivityForResult(cameraIntent, CAMERA_INTENT_CODE)
    }

    private fun getGalleryImage() {
        val gallery = Intent(Intent.ACTION_PICK).apply { this.type = "image/*" }
        startActivityForResult(gallery, GALLERY_INTENT_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY_INTENT_CODE && data != null) {
            val uri = data.data
            uri ?: return
            profileBinding.userimg.setImageURI(uri)
            requireActivity().contentResolver.openInputStream(uri)?.let { inputStream ->
                val name = FileUtils.getFile(requireContext(), uri).name!!
                val bytes = inputStream.readBytes()
               // profileVM.profileImage = bytes to name
            }

        } else if (requestCode == CAMERA_INTENT_CODE && data != null) {
            val uri = getImageUri(data.extras!!.get("data") as Bitmap)
            uri ?: return
            profileBinding.userimg.setImageURI(uri)
            requireActivity().contentResolver.openInputStream(uri)?.let { inputStream ->
                val name = FileUtils.getFile(requireContext(), uri).name
                val bytes = inputStream.readBytes()
               // profileVM.profileImage = bytes to name
            }
        }
    }
    fun getImageUri(inImage: Bitmap): Uri? {
        val wrapper = ContextWrapper(QuizApplication.instance.applicationContext)
        // Initialize a new file instance to save bitmap object
        var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
        file = File(file, "${System.currentTimeMillis()}.jpg")
        try {
            // Compress the bitmap and save in jpg format
            val stream: OutputStream = FileOutputStream(file)
            inImage.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return Uri.fromFile(file)
    }
}