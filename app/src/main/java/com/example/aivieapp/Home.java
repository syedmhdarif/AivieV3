package com.example.aivieapp;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import javax.xml.transform.Result;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    MediaController mc;
    VideoView videoView;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    int SELECT_IMAGE_CODE=1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button buttonedit = (Button) view.findViewById(R.id.buttonedit);
        ImageButton msetting = (ImageButton) view.findViewById(R.id.settingbutton);
        ImageView mbutton2 = (ImageView) view.findViewById(R.id.imageButton2);

        TextView seeall = (TextView) view.findViewById(R.id.seeall);

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Title"),SELECT_IMAGE_CODE);
//            }
//        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (ContextCompat.checkSelfPermission(Home.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(Home.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//                }
//                else {
//                    selectVideo();
//                }
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("video/*");
//                startActivityForResult(Intent.createChooser(intent, "select video"), 100);
                openActivity3();
            }
        });
        buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        msetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();

            }
        });
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();

            }
        });


//        seeall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent();
//                startActivity(intent);
//
//                Toast.makeText(Home.this, "You clicked text", Toast.LENGTH_LONG).show();
//            }
//        });
        // Inflate the layout for this fragment
        return view;
    }

    private void openActivity5() {
        Intent intent = new Intent(getActivity(), Activity_Account.class);
        startActivity(intent);
    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
////            videoUri = data.getData();
//            Uri uri = data.getData();
//            Intent intent = new Intent(getActivity(), Activity_playvideo.class);
//            intent.putExtra("uri",uri.toString());
//            startActivity(intent);
////            getActivity().startActivityForResult(intent,100);
//
//        }
//
//    }
    //    private void selectVideo() {
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("video/*");
//        startActivityForResult(Intent.createChooser(intent, "select video"), 100);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 1 && grantResults.length> 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            selectVideo();
//        }
//        else {
//            Toast.makeText(getActivity(), "permission denied", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && data != null && resultCode == RESULT_OK){
            Uri uri = data.getData();
            Intent intent = new Intent( getActivity(),Activity_playvideo.class);
            intent.putExtra("uri",uri.toString());
            startActivity(intent);

        }
    }

    public void openActivity3(){
        Intent intent = new Intent(getActivity(), Activity_Editpage.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(getActivity(), Activity_Setting.class);
        startActivity(intent);
    }
}