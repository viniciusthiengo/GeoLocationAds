package br.com.thiengo.geolocationads.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.thiengo.geolocationads.R;

/**
 * Created by viniciusthiengo on 10/9/16.
 */

public class GamesAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Game> list;

    public GamesAdapter(Context context, List<Game> list){
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Game g = list.get(position);

        if( convertView == null ){
            convertView = layoutInflater.inflate(R.layout.game, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
            setViewHolder( convertView, holder );
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        fillLayout( holder, g );

        return convertView;
    }

    private void setViewHolder( View convertView, ViewHolder holder ){
        holder.imgHome = (ImageView) convertView.findViewById(R.id.img_home);
        holder.imgVisitant = (ImageView) convertView.findViewById(R.id.img_visitant);
        holder.goalsHome = (TextView) convertView.findViewById(R.id.goals_home);
        holder.goalsVisitant = (TextView) convertView.findViewById(R.id.goals_visitan);
    }

    private void fillLayout( ViewHolder holder, Game game ){
        holder.imgHome.setImageResource( game.getSoccerTeamHome().getImage() );
        holder.imgVisitant.setImageResource( game.getSoccerTeamVisitant().getImage() );
        holder.goalsHome.setText( String.valueOf( game.getHomeGoals() ) );
        holder.goalsVisitant.setText( String.valueOf( game.getVisitantGoals() ) );
    }

    private class ViewHolder{
        ImageView imgHome;
        ImageView imgVisitant;
        TextView goalsHome;
        TextView goalsVisitant;
    }
}
