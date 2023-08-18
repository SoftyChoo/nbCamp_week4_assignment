package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import android.Manifest
import android.widget.Button
import android.widget.EditText
import com.example.nbcamp_week4_assignment.Object.UserObject.editProfile

class EditProfileActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private var imageUri: Uri? = null

    // 갤러리 open
    private val requestPermissionLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                openGallery()
            }
        }
    // 가져온 사진 보여주기
    private val pickImageLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                data?.data?.let {
                    imageUri = it
                    imageView.setImageURI(imageUri)
                }
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        imageView = findViewById(R.id.imgProfile)
        imageView.clipToOutline = true
        button = findViewById(R.id.btnProfile)
        button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                openGallery()
                button.text = null
            } else {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
        // 수정적용 or 취소
        val buttonEdit = findViewById<Button>(R.id.button_edit)
        val buttonCancel = findViewById<Button>(R.id.button_cancel)
        val editName = findViewById<EditText>(R.id.editName)
        val editId = findViewById<EditText>(R.id.editId)

        buttonEdit.setOnClickListener {
            val name = editName.text.toString()
            val id = editId.text.toString()
            val imageUri = imageUri
            // 사용자 정보 수정 및 전달
            editProfile(imageUri.toString(), name, id)

            val Intent = Intent(this, ProfileActivity::class.java)
            Intent.putExtra("imageUri", imageUri)
            Intent.putExtra("name", name)
            Intent.putExtra("id", id)

            startActivity(Intent)
        }
        buttonCancel.setOnClickListener {
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
            finish()
        }
    }
    private fun openGallery() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        pickImageLauncher.launch(gallery)
    }
}