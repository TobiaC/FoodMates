package com.example.foodmates;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    /**
     * The context is used to inflate the layout file, and the ricetta_layout_list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param recipes A List of AndroidFlavor objects to display in a ricetta_layout_list
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
                    R.layout.ricetta_layout_list, parent, false);
        }

        // Get the {@link Recipe} object located at this position in the ricetta_layout_list
        Recipe currentRecipe = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.recipeTitle);
        titleTextView.setText(currentRecipe.getTitolo());


        //Magari questa cosa la togliamo e la implementiamo solo se abbiamo tempo
        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hai premuto il titolo", Toast.LENGTH_SHORT).show();
            }
        });

        TextView timeTextView =  listItemView.findViewById(R.id.recipeTime);
        timeTextView.setText(currentRecipe.getDurata());

        TextView tagTextView = listItemView.findViewById(R.id.recipeTags);
        tagTextView.setText(currentRecipe.getTag());

        TextView canaleView = listItemView.findViewById(R.id.recipeCanale);
        canaleView.setText("CANALE: " + currentRecipe.getCanale());


        TextView difficultyTextView =  listItemView.findViewById(R.id.recipeDifficulty);
        
        if(currentRecipe.getDifficoltà()==1){

            difficultyTextView.setText(getContext().getString(R.string.facile));
            difficultyTextView.setBackgroundResource(R.drawable.shape_easy);
            
        }else if (currentRecipe.getDifficoltà()==2){

                difficultyTextView.setText(getContext().getString(R.string.medio));
                difficultyTextView.setBackgroundResource(R.drawable.shape_medium);

        }else if (currentRecipe.getDifficoltà()==3){
            difficultyTextView.setText(getContext().getString(R.string.difficile));
            difficultyTextView.setBackgroundResource(R.drawable.shape_hard);
        }else {
            difficultyTextView.setText("");
            difficultyTextView.setBackgroundResource(R.color.colorPrimary);
        }
        

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
