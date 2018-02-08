package com.example.bs206.retrofittest.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bs206.retrofittest.R
import kotlinx.android.synthetic.main.activity_camera_image.*
import android.content.Intent
import com.example.bs206.retrofittest.kotlin.Constants.Companion.CAMERA_REQUEST
import android.graphics.Bitmap
import android.app.Activity
import android.net.Uri
import android.os.Environment
import android.view.View
import java.nio.file.Files.isDirectory
import android.os.Environment.DIRECTORY_PICTURES
import android.os.Environment.getExternalStoragePublicDirectory
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files.exists
import android.widget.Toast
import android.content.ComponentName
import android.content.Context
import android.os.IBinder
import android.content.ServiceConnection




class CameraImageActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_image)

        camera_image_button.setOnClickListener {

            val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST)

        }


        gallery_button.setOnClickListener {

            val sdDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val file = File(sdDir, "AppPics")

            val intent = Intent()
            intent.setAction(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.withAppendedPath(Uri.fromFile(file), Constants.STORAGE_DIRECTORY), "image/*");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)
    {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            camera_image_button.visibility = View.GONE
            camera_image.visibility = View.VISIBLE

            val photo = data.extras.get("data") as Bitmap
            camera_image.setImageBitmap(photo)

            createDirectoryAndSaveFile(photo)
        }
    }

    private fun createDirectoryAndSaveFile(imageToSave: Bitmap)
    {

        var fileName = "1"

        val directory = File(Environment.getExternalStorageDirectory().toString() + "/AAAA")

        if (!directory.exists())
        {
            val picDirectory = File(Constants.STORAGE_DIRECTORY)
            picDirectory.mkdirs()
        }


        var file = File(File(Constants.STORAGE_DIRECTORY), fileName)

        if (file.exists())
        {
            var newFileName =  fileName.toInt() + 1
            file = File(File(Constants.STORAGE_DIRECTORY), newFileName.toString())
        }

        try
        {
            val out = FileOutputStream(file)
            imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.flush()
            out.close()
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }

    }
}
