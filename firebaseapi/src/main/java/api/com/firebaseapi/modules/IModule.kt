package api.com.firebaseapi.modules

/**
 * Created by robertomiranda on 12/4/17.
 */
interface IModule {


    fun init()

    fun getType(): ModuleType


    enum class ModuleType{
        USER
    }
}