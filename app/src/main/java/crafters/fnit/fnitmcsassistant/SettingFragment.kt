package crafters.fnit.fnitmcsassistant

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SettingFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_setting, container, false)

        val pushButton = view.findViewById<Button>(R.id.pushButton)
        pushButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                val ref = FirebaseDatabase.getInstance().reference
                ref.child("pushNotifications").push().setValue(true)
            }
        })

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        fun newInstance(): SettingFragment {
            return SettingFragment()
        }
    }
}
