package com.example.sangrah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById( R.id.bottom_nav );


        underlineMenuItem( bottomNavigationView.getMenu().getItem( 0 ) ); // underline the default selected item when the activity is launched

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        removeItemsUnderline( bottomNavigationView ); // remove underline from all items
                        underlineMenuItem( item ); // underline selected item
                        switch (item.getItemId()) {
                            // handle item clicks
                        }
                        return false;
                    }
                } );
    }

    private void removeItemsUnderline(BottomNavigationView bottomNavigationView) {
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            MenuItem item = bottomNavigationView.getMenu().getItem( i );
            item.setTitle( item.getTitle().toString() );
        }
    }

    private void underlineMenuItem(MenuItem item) {
        SpannableString content = new SpannableString( item.getTitle() );
        content.setSpan( new UnderlineSpan(), 0, content.length(), 0 );
        item.setTitle( content );

    }
}