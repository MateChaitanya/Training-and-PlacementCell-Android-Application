package com.hire.freshershub.ui.resumebuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hire.freshershub.R;

import java.util.Objects;

public class builderFragment extends Fragment {

    // Constants for Firebase database keys
    private static final String CAN_APPLY_JOBS_KEY = "canApplyJobs";
    private static final String PRIMARY_DETAILS_KEY = "primaryDetails";
    private static final String CONTACT_DETAILS_KEY = "contactDetails";
    private static final String IS_RESUME_ADDED_KEY = "isResumeAdded";

    // ... (other code remains the same)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_builder, container, false);

        // Assuming you have a TextView in your layout, you can set an onClickListener
        TextView resumeBuilderTextView = view.findViewById(R.id.nav_resume_builder); // Replace with your TextView ID

        resumeBuilderTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrlInBrowser("https://www.ibusa-foundation.org/resume-builder/?gad_source=1&gclid=Cj0KCQiAwbitBhDIARIsABfFYILJ_FDkwMJ8Jp8lQtqkjCNwoMG0SUKG-r7NLFaxjbzxtiT4GTPPZU8aAu7TEALw_wcB");
            }
        });

        return view;
    }

    private void openUrlInBrowser(String url) {
        // Specify the package for Chrome
        String chromePackageName = "com.android.chrome";

        // Create an Intent with the specified package and URL
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        browserIntent.setPackage(chromePackageName);

        // Check if there's an activity to handle the intent
        if (browserIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(browserIntent);
        } else {
            // If Chrome is not installed, open the URL in the default browser
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        }
    }

    // ... (other code remains the same)
}
