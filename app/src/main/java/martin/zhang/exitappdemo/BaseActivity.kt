package martin.zhang.exitappdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "activity $this onNewIntent()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "activity $this onCreate()")
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "activity $this onStart()")
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "activity $this onResume()")
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "activity $this onPause()")
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "activity $this onStop()")
    }

    @CallSuper
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "activity $this onRestart()")
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "activity $this onDestroy()")
    }
}