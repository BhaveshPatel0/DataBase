package com.color.tools.database.gallery.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.recyclerview.widget.GridLayoutManager
import com.color.tools.database.databinding.ActivityImageBinding

class ImageAct : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    private lateinit var mAdapterImage: AdapterImage

    private val listOfImage = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val cursorImage = contentResolver.query(
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null
        )
        if (cursorImage != null) {

            if (cursorImage.moveToFirst()) {
                do {
                    val ImageIndex = cursorImage.getColumnIndex(MediaStore.MediaColumns.BUCKET_DISPLAY_NAME)
                    val Image = cursorImage.getString(ImageIndex)
                    listOfImage.add(Image)


                } while (cursorImage.moveToNext())

                mAdapterImage = AdapterImage(this, listOfImage)

                binding.rcvImageRecyclerView.apply {

                    layoutManager = GridLayoutManager(this@ImageAct, 3)
                    adapter = mAdapterImage

                }
            }
        }
    }
}