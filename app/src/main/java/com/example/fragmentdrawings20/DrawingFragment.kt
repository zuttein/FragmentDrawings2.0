package com.example.fragmentdrawings20

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

class DrawingFragment : Fragment(), SurfaceHolder.Callback {

    companion object {
        private const val COLOR_KEY = "color"

        fun newInstance(color: Int): DrawingFragment {
            val fragment = DrawingFragment()
            val args = Bundle()
            args.putInt(COLOR_KEY, color)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var figureView: SurfaceView
    private var figureColor: Int = Color.BLACK

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drawing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        figureView = view.findViewById(R.id.figureView)

        arguments?.let {
            figureColor = it.getInt(COLOR_KEY)
        }

        figureView.holder.addCallback(this)
    }

    private fun drawColoredCircle(holder: SurfaceHolder) {
        val canvas = holder.lockCanvas()
        val paint = Paint()

        canvas.drawColor(Color.WHITE)

        paint.color = figureColor
        paint.isAntiAlias = true

        val radius = 100f
        val centerX = canvas.width / 2f
        val centerY = canvas.height / 2f

        canvas.drawCircle(centerX, centerY, radius, paint)

        holder.unlockCanvasAndPost(canvas)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        drawColoredCircle(holder)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }
}



//class DrawingFragment : Fragment() {
//
//    companion object {
//        private const val COLOR_KEY = "color"
//
//        fun newInstance(color: Int): DrawingFragment {
//            val fragment = DrawingFragment()
//            val args = Bundle()
//            args.putInt(COLOR_KEY, color)
//            fragment.arguments = args
//            return fragment
//        }
//    }
//
//    private lateinit var figureView: ImageView
//    private var figureColor: Int = Color.BLACK
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_drawing, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        figureView = view.findViewById(R.id.figureView)
//
//        arguments?.let {
//            figureColor = it.getInt(COLOR_KEY)
//        }
//
//        drawColoredCircle()
//
//    }
//
//
//    private fun drawColoredCircle() {
//        val bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(bitmap)
//        val paint = Paint()
//
//        paint.color = figureColor
//        paint.isAntiAlias = true
//
//        val radius = 50f
//        val centerX = bitmap.width / 2f
//        val centerY = bitmap.height / 2f
//
//        canvas.drawCircle(centerX, centerY, radius, paint)
//
//        figureView.setImageBitmap(bitmap)
//    }
//
//
//}

