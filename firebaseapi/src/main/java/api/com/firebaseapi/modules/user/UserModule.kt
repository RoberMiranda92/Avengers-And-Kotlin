package api.com.firebaseapi.modules.user

import api.com.firebaseapi.ApiCore
import api.com.firebaseapi.modules.IModule
import api.com.firebaseapi.modules.RegisterModule
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by robertomiranda on 12/4/17.
 */
@RegisterModule
class UserModule : IModule {


    private var mAuth: FirebaseAuth? = null


    override fun init() {
        mAuth = FirebaseAuth.getInstance()
    }


    override fun getType(): IModule.ModuleType {

        return IModule.ModuleType.USER
    }


    fun doLoginWithUserAndPassword(user: String, password: String, callBack: ApiCore.IOnRequestComplete<String>) {


        if (user.isEmpty() or password.isEmpty()) {
            callBack.onError("User or password is empty")
            return
        }

        mAuth?.signInWithEmailAndPassword(user, password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {

            override fun onComplete(result: Task<AuthResult>) {

                if (result.isSuccessful) {
                    callBack.onSucess(result = result.result.user.email!!)
                } else {
                    callBack.onError(message = result.exception?.message!!)
                }
            }

        })
    }


}