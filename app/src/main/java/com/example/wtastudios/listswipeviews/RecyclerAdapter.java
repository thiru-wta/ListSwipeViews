package com.example.wtastudios.listswipeviews;

import android.content.Context;
import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tubb.smrv.SwipeHorizontalMenuLayout;
import com.tubb.smrv.SwipeMenuRecyclerView;
import net.cachapa.expandablelayout.ExpandableLayout;
import java.util.ArrayList;

/*
 * Created by WTA Studios on 09-Mar-17.
 */

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private SwipeMenuRecyclerView recyclerView;
    private Context context;
    private ArrayList<String> data;
    private LayoutInflater inflater;

    private static final int UNSELECTED = -1;

    private int selectedItem = UNSELECTED;

    public RecyclerAdapter(Context context, ArrayList<String> data,  SwipeMenuRecyclerView mRecyclerView) {
        this.data = data;
        this.context = context;
        recyclerView = mRecyclerView;
        notifyDataSetChanged();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_simple,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.MyViewHolder holder, final int position) {

        final SwipeHorizontalMenuLayout itemView = (SwipeHorizontalMenuLayout) holder.itemView;
        holder.bindData(position);

       /* itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "add your action item", Toast.LENGTH_SHORT).show();
            }
        });*/
 }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void notifyData(ArrayList<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ExpandableLayout expandableLayout;
        private Button btn1,btn2,btn3,btn4,btn5,btn6;
        private int position;

        TextView txtExpand;
        TextView tvSwipeEnable;

        View btDelete;
        View btLeft;
        SwipeHorizontalMenuLayout sml;

        public MyViewHolder(View itemView) {
            super(itemView);

            expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.expandable_layout);
            expandableLayout.setInterpolator(new OvershootInterpolator());
            btn1 = (Button) itemView.findViewById(R.id.btnControl1);
            btn2 = (Button) itemView.findViewById(R.id.btnControl2);
            btn3 = (Button) itemView.findViewById(R.id.btnControl3);
            btn4 = (Button) itemView.findViewById(R.id.btnControl4);
            btn5 = (Button) itemView.findViewById(R.id.btnControl5);
            btn6 = (Button) itemView.findViewById(R.id.btnControl6);

            txtExpand = (TextView) itemView.findViewById(R.id.txtExpand);
//                tvSwipeEnable = (TextView) itemView.findViewById(R.id.tvSwipeEnable);
//
                btDelete = itemView.findViewById(R.id.btDelete);
                btLeft = itemView.findViewById(R.id.btLeft);
                sml = (SwipeHorizontalMenuLayout) itemView.findViewById(R.id.sml);
                txtExpand.setOnClickListener(this);
            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
            btn4.setOnClickListener(this);
            btn5.setOnClickListener(this);
            btn6.setOnClickListener(this);


        }


        public View getBtDelete() {
            return btDelete;
        }

        public TextView getTvName() {
            return txtExpand;
        }
        public View getBtnLeft(){
            return btLeft;
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.txtExpand:
//            Toast.makeText(context, "add your action item", Toast.LENGTH_SHORT).show();
                    MyViewHolder holder = (MyViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
                    if (holder != null) {
                        holder.txtExpand.setSelected(false);
                        holder.expandableLayout.collapse();
                    }

                    if (position == selectedItem) {
                        selectedItem = UNSELECTED;
                    } else {
                        txtExpand.setSelected(true);
                        expandableLayout.expand();
                        selectedItem = position;
                    }
                    break;
                case R.id.btnControl1:
                    Toast.makeText(context, "btn 1 clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnControl2:
                    Toast.makeText(context, "btn 2 clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnControl3:
                    Toast.makeText(context, "btn 3 clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnControl4:
                    Toast.makeText(context, "btn 4 clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnControl5:
                    Toast.makeText(context, "btn 5 clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnControl6:
                    Toast.makeText(context, "btn 6 clicked", Toast.LENGTH_SHORT).show();
                    break;

            }

        }

        public void bindData(int position) {
            this.position = position;
            txtExpand.setText(data.get(position));
            txtExpand.setSelected(false);
            expandableLayout.collapse(false);
        }
    }
}


















// Button actions


/*holder.getBtDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // must close normal
                itemView.smoothCloseMenu();
                data.remove(holder.getAdapterPosition());
               notifyItemRemoved(holder.getAdapterPosition());
            }
        });*/


/*holder.getTvName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "add your action", Toast.LENGTH_SHORT).show();
            }
        });*/

/*holder.getBtnLeft().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Action done", Toast.LENGTH_SHORT).show();
            }
        });*/