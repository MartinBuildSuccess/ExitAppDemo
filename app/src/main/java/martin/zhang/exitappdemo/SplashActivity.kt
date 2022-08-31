package martin.zhang.exitappdemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView

class SplashActivity : BaseActivity() {

    private lateinit var ivLogo: ImageView

    companion object {
        private const val ANIMATION_TIME = 2000L
        private const val LOGO_STAY_TIME = 500L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initView()
        playAnimation()
    }

    private fun initView() {
        ivLogo = findViewById(R.id.ivLogo)
    }

    private fun playAnimation() {
        val alphaAnimation = AlphaAnimation(0F, 1.0F).apply {
            duration = ANIMATION_TIME
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}

                override fun onAnimationEnd(animation: Animation) {
                    jumpToMainPage()
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }
        ivLogo.startAnimation(alphaAnimation)
    }

    private fun jumpToMainPage() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(MainActivity.createIntent(this))
                finish()
            },
            LOGO_STAY_TIME
        )
    }
}