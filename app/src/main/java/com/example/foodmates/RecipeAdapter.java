package com.example.foodmates;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    /**
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param recipes A List of AndroidFlavor objects to display in a list
     */

    public RecipeAdapter(Activity context, ArrayList<Recipe> recipes){

        super(context,0,recipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.recipe_layout_standard, parent, false);
        }

        // Get the {@link Recipe} object located at this position in the list
        Recipe currentRecipe = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.recipeTitle);
        titleTextView.setText(currentRecipe.getTitolo());

        TextView TimeTextView = (TextView) listItemView.findViewById(R.id.recipeTime);
        TimeTextView.setText(currentRecipe.getDurata());

       /* // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentRecipe.getImageResourceId());*/

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
