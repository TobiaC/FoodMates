package com.example.foodmates;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileRecipeAdapter extends ArrayAdapter<Recipe> {

    /**
     * The context is used to inflate the layout file, and the ricetta_layout_list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param recipes A List of AndroidFlavor objects to display in a ricetta_layout_list
     */

    public ProfileRecipeAdapter(Activity context, ArrayList<Recipe> recipes){

        super(context,0,recipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.ricetta_edit_layout_list, parent, false);
        }

        Recipe currentRecipe = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.recipeTitle_profilo);
        titleTextView.setText(currentRecipe.getTitolo());


       /* Button button= listItemView.findViewById(R.id.buttonEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Hai premuto per modificare la ricetta", Toast.LENGTH_SHORT).show();
            }
        });


        Button button_delete= listItemView.findViewById(R.id.buttonDelete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Hai premuto per eliminare la ricetta", Toast.LENGTH_SHORT).show();
            }
        });*/

      /*  listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Devo passare l'oggetto ricetta alla nuova activity o fragment

                Toast.makeText(getContext(), "Hai premuto la ricetta", Toast.LENGTH_SHORT).show();
            }
        });*/

        

       /* // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentRecipe.getImageResourceId());*/

        // Return the whole ricetta_layout_list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
