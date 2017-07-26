package testkotlin.com.mykotlinapplication.viewmodels


import roberto.com.retrofitapisample.models.Character
import testkotlin.com.mykotlinapplication.view.CharacterView


/**
 * Created by bernatgomez on 26/7/17.
 */
data class CharacterVM(val view : CharacterView, val model : Character) {

}