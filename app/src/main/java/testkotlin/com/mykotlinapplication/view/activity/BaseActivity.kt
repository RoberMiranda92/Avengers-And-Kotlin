package testkotlin.com.mykotlinapplication.view.activity

 abstract class BaseActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        butterknife.ButterKnife.bind(this)


        prepareView()
    }

    protected abstract fun getLayoutId():Int

     protected abstract fun prepareView()
}
