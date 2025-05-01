package uz.app.realestate.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

import uz.app.realestate.Adapter.ListItemsAdapter;
import uz.app.realestate.Domain.PropertyDomain;
import uz.app.realestate.R;
import uz.app.realestate.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initList();
        initBottomMenu();
    }

    private void initBottomMenu() {
        binding.bottomMenu.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                if (i == R.id.profile) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                }
            }
        });
    }

    private void initList() {
        ArrayList<PropertyDomain> items = new ArrayList<>();
        items.add(new PropertyDomain(
                "Apartment",                      // title
                "Royal Apartment",               // type
                "Los Angeles, LA",               // address
                "pic_1",                         // pickPath
                1500,                            // price
                2,                               // bed
                3,                               // bath
                350,                             // size
                true,                            // garage
                4.5,                             // score
                "Copy the example data in the following table, and paste it in cell A1 of a new Excel worksheet. For formulas to show results, select them, press F2, and then press Enter. If you need to, you can adjust the column widths to see all the data" // description
        ));

        items.add(new PropertyDomain(
                "House",
                "House with Great View",
                "New York, NY",
                "pic_2",
                800,
                1,
                2,
                500,
                false,
                4.9,
                "Copy the example data in the following table, and paste it in cell A1 of a new Excel worksheet. For formulas to show results, select them, press F2, and then press Enter. If you need to, you can adjust the column widths to see all the data."
        ));

        items.add(new PropertyDomain(
                "Villa",
                "Royal Villa",
                "Los Angeles, LA",
                "pic_3",
                999,
                2,
                1,
                400,
                true,
                4.7,
                "Copy the example data in the following table, and paste it in cell A1 of a new Excel worksheet. For formulas to show results, select them, press F2, and then press Enter. If you need to, you can adjust the column widths to see all the data."
        ));

        items.add(new PropertyDomain(
                "House",
                "Beauty House",
                "New York, NY",
                "pic_4",
                1750,
                3,
                2,
                1100,
                true,
                4.3,
                "Copy the example data in the following table, and paste it in cell A1 of a new Excel worksheet. For formulas to show results, select them, press F2, and then press Enter. If you need to, you can adjust the column widths to see all the data."
        ));

        binding.viewlist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.viewlist.setAdapter(new ListItemsAdapter(items));
    }
}