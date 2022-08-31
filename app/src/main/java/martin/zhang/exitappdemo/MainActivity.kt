package martin.zhang.exitappdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : BaseActivity() {

    private lateinit var btnJumpToNextPage: Button

    companion object {
        const val INTENT_EXIT_APP_BOOL = "intent.exit.app.bool"

        fun createIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }

        fun createExitAppIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java).apply {
                putExtra(INTENT_EXIT_APP_BOOL, true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewByIds()
        initView()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val isNeedExit = intent?.getBooleanExtra(INTENT_EXIT_APP_BOOL, false) ?: false
        if (isNeedExit) {
            finish()
        }
    }

    private fun findViewByIds() {
        btnJumpToNextPage = findViewById(R.id.btnJumpToNextPage)
    }

    private fun initView() {
        btnJumpToNextPage.setOnClickListener {
            startActivity(Intent(this, ExitTestActivity::class.java))
        }
    }
}