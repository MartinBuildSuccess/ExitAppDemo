package martin.zhang.exitappdemo

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class ExitAppDemoApplication : Application() {
    companion object {
        lateinit var mApplication: ExitAppDemoApplication
    }

    init {
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycleObserver())
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this
    }
}