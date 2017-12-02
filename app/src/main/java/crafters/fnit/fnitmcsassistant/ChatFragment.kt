package crafters.fnit.fnitmcsassistant

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import crafters.fnit.fnitmcsassistant.Adapter.ChatAdapter


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ChatFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater!!.inflate(R.layout.fragment_chat, container, false)

        val chatRecyclerView = myView.findViewById<RecyclerView>(R.id.chatRecycleView)
        chatRecyclerView.setHasFixedSize(true)
        chatRecyclerView.layoutManager = LinearLayoutManager(activity)

        val dataSet = arrayOf("デパート建築 メンバー募集", "スポーン地点について")

        chatRecyclerView.adapter = ChatAdapter(dataSet)

        return myView
    }

    companion object {
        fun newInstance(): ChatFragment {
            return ChatFragment()
        }
    }
}
