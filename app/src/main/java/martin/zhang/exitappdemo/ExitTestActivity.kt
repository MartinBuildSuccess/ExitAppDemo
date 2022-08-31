package martin.zhang.exitappdemo

import android.app.ActivityManager
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class ExitTestActivity : BaseActivity() {

    private lateinit var btnSystemExit0: Button
    private lateinit var btnFinishAllActivitiesInTask: Button
    private lateinit var btnMoveTaskToBack: Button
    private lateinit var btnStartFirstPageSingleTaskAndFinishIt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit_test)
        findViewByIds()
        initView()
    }

    private fun findViewByIds() {
        btnSystemExit0 = findViewById(R.id.btnSystemExit0)
        btnFinishAllActivitiesInTask = findViewById(R.id.btnFinishAllActivitiesInTask)
        btnMoveTaskToBack = findViewById(R.id.btnMoveTaskToBack)
        btnStartFirstPageSingleTaskAndFinishIt =
            findViewById(R.id.btnStartFirstPageSingleTaskAndFinishIt)
    }

    private fun initView() {
        btnSystemExit0.setOnClickListener {
            systemExit0()
        }
        btnFinishAllActivitiesInTask.setOnClickListener {
            finishAllActivitiesInTask()
        }
        btnMoveTaskToBack.setOnClickListener {
            moveAppBackground()
        }
        btnStartFirstPageSingleTaskAndFinishIt.setOnClickListener {
            startMainActivitySingleTask()
        }
    }

    private fun systemExit0() {
        exitProcess(0)
    }

    private fun finishAllActivitiesInTask() {
        val activityManager =
            applicationContext.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val appTaskList = activityManager.appTasks
        for (appTask in appTaskList) {
            appTask.finishAndRemoveTask()
        }
    }

    private fun startMainActivitySingleTask() {
        startActivity(MainActivity.createExitAppIntent(this))
    }

    private fun moveAppBackground() {
        moveTaskToBack(true)
    }
}