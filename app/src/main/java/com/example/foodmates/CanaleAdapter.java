package com.example.foodmates;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CanaleAdapter extends ArrayAdapter<Canale> {

    /**
     * The context is used to inflate the layout file, and the ricetta_layout_list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param canali A List of AndroidFlavor objects to display in a ricetta_layout_list
     */

    public CanaleAdapter(Activity context, ArrayList<Canale> canali){

        super(context,0,canali);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.canale_layout_list, parent, false);
        }

        // Get the {@link Recipe} object located at this position in the ricetta_layout_list
        Canale currentCanale = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.canaleTitle);
        titleTextView.setText(currentCanale.getTitolo());

        TextView descrizioneTextView = listItemView.findViewById(R.id.canaleDescrizione);
        descrizioneTextView.setText(currentCanale.getDescrizione());
        

       /* // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentCanale.getImageResourceId());*/

        // Return the whole ricetta_layout_list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
