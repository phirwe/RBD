package com.example.poorwa.rbd;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private boolean listFlag;
    GridView gridView;
    ListView listView;
    FloatingActionButton fab;
    MaterialSearchView searchView;
    ListView searchListView;
    ArrayAdapter searchAdapter;

    Integer[] imageIDs = {
            R.drawable.bigbang,
            R.drawable.hannibal,
            R.drawable.house,
            R.drawable.game_of_thrones,
            R.drawable.nemo,
            R.drawable.up,
            R.drawable.wall,
            R.drawable.toystory
    };

    String[] names = {
            "Accountant",
            "Engineer",
            "Architect",
            "Doctor",
            "Business",
            "Advertising",
            "Stocks",
            "Marketing"
    };

    List<String> strings = new ArrayList<String>(Arrays.asList(names));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listFlag = false;

        searchListView = (ListView) findViewById(R.id.searchListView);
        searchView = (MaterialSearchView) findViewById(R.id.search_view);

        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String query = ((TextView) findViewById(R.id.searchListText)).getText().toString();
                Log.println(Log.ASSERT, "query", query);
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                Log.println(Log.ASSERT, "query", query);
                searchListView.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic

                if (!newText.isEmpty()) {

                    for (Iterator<String> s = strings.iterator(); s.hasNext(); ) {
                        String text = s.next();

                        if (!(text.toLowerCase().contains(newText) && text.toLowerCase().charAt(0) == newText.toLowerCase().charAt(0))) {
                            s.remove();
                        }
                    }

                    searchListView.setVisibility(View.VISIBLE);
                    searchListView.setAdapter(new SearchListAdapter(getApplicationContext(), strings));
                    strings = new ArrayList(Arrays.asList(names));
                } else
                    searchListView.setVisibility(View.GONE);
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
                if(listFlag == false) {
                    gridView.setVisibility(View.GONE);
                }
                else {
                    listView.setVisibility(View.GONE);
                }

            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
                if(listFlag == false) {
                    gridView.setVisibility(View.VISIBLE);
                }
                else {
                    listView.setVisibility(View.VISIBLE);
                }

            }
        });


        gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter(this));
        //gridView.setVisibility(View.GONE);

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new ListAdapter(this));
        listView.setVisibility(View.GONE);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listFlag == false) {
                    gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    Log.println(Log.ASSERT, "FAB", "List to Grid");
                    fab.setImageDrawable(getDrawable(R.drawable.grid));
                    listFlag = true;
                }
                else {
                    listView.setVisibility(View.GONE);
                    gridView.setVisibility(View.VISIBLE);
                    Log.println(Log.ASSERT, "FAB", "Grid to List");
                    fab.setImageDrawable(getDrawable(R.drawable.list));
                    listFlag = false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar grid_item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
