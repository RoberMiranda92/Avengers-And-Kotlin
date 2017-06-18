package api.com.firebaseapi

import api.com.firebaseapi.modules.IModule
import api.com.firebaseapi.modules.user.UserModule
import java.util.*


/**
 * Created by robertomiranda on 12/4/17.
 */
class ApiCore {

    private var mModules = ArrayList<IModule>()

    private constructor() {
        initModules()

    }

    companion object {
        private var mInstance: ApiCore? = null

        fun getInstance(): ApiCore {
            if (mInstance == null) {
                mInstance = ApiCore()
            }

            return mInstance!!
        }

    }

    fun initModules() {

        mModules.add(UserModule())

        for(module:IModule in mModules){
            module.init()
        }

    }

    fun <T> getModuleByType(type: IModule.ModuleType): T {

        for (module: IModule in mModules) {
            if (module.getType().equals(type)) {
                return module as T
            }
        }

        return null!!
    }


    interface IOnRequestComplete<in Any>{

        fun onSucess(result:Any)
        fun onError(message:String)
    }

}