package com.gbrbrothers.fitme2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by TK on 2016-12-18.
 */

public class FirstActivity extends AppCompatActivity {

    private ListView mTrainerLIstView = null;
    private ListViewAdapter mTrainerListAdapter = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mTrainerLIstView = (ListView) findViewById(R.id.Trainer_ListView);
        mTrainerListAdapter = new ListViewAdapter(this);
        mTrainerLIstView.setAdapter(mTrainerListAdapter);

        // addItem은 별도 class로 만들어서 집어넣어야됨
        // 아래 intent로 넘어갈때도 부를수있도록 전역 class 로 만들어야됨
        mTrainerListAdapter.addItem(getResources().getDrawable(R.mipmap.ic_launcher), "유형민", "강남구 신사동");
        mTrainerListAdapter.addItem(getResources().getDrawable(R.mipmap.ic_launcher), "Woo_SICK", "강남구 역삼동");
        mTrainerListAdapter.addItem(getResources().getDrawable(R.mipmap.ic_launcher), "이성윤", "마포구 공덕동");
        mTrainerListAdapter.addItem(getResources().getDrawable(R.mipmap.ic_launcher), "유형민", "송파구 잠실동");

        // get login ID
        Intent userLoginIntent = new Intent(this.getIntent());
        String userLoginEmail = userLoginIntent.getStringExtra("User_Login_Email");

        mTrainerLIstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ListData mData = mTrainerListAdapter.mListData.get(position);

                // Toast 대신에 intent와 같이 디테일 인포 액티비티로 이동.
                // To-do: 전역 Class로 만들어서 시간/가격정보 띄워야함
                Intent intentTrainerDetail = new Intent(FirstActivity.this, TrainerDetailActivity.class);
                intentTrainerDetail.putExtra("TRAINER_ID", position);
                intentTrainerDetail.putExtra("TRAINER_NAME", mData.mName);
                startActivity(intentTrainerDetail);
            }
        });

        // 지도 Button onlick
        findViewById(R.id.switch_to_map_button).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(FirstActivity.this, "Map Under Construction for v2", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // 필터 Button onlick
        findViewById(R.id.trainer_advanced_filter_button).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(FirstActivity.this, "Filter Under Construction for v2", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    // Trainer ListView Creator

    private class ViewHolder {
        public ImageView mTrainerImage;
        public TextView mTrainerName;
        public TextView mTrainerLocation;
    }

    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<ListData> mListData = new ArrayList<ListData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(Drawable image, String mName, String mLocation) {
            ListData addInfo = null;
            addInfo = new ListData();
            addInfo.mImage = image;
            addInfo.mName = mName;
            addInfo.mLocation = mLocation;

            mListData.add(addInfo);
        }

        public void remove(int position) {
            mListData.remove(position);
            dataChange();
        }

        public void sort() {
            Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
            dataChange();
        }

        public void dataChange() {
            mTrainerListAdapter.notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflator.inflate(R.layout.listview_trainer_item, null);

                holder.mTrainerImage = (ImageView) convertView.findViewById(R.id.trainer_listview_image);
                holder.mTrainerName = (TextView) convertView.findViewById(R.id.trainer_name);
                holder.mTrainerLocation = (TextView) convertView.findViewById(R.id.trainer_location);

                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            ListData mData = mListData.get(position);

            if (mData.mImage != null) {
                holder.mTrainerImage.setVisibility(View.VISIBLE);
                holder.mTrainerImage.setImageDrawable(mData.mImage);
            } else {
                holder.mTrainerImage.setVisibility(View.GONE);
            }

            holder.mTrainerName.setText(mData.mName);
            holder.mTrainerLocation.setText(mData.mLocation);

            return convertView;
        }

    }
}