package com.linyuzai.demo4menupopupwindow;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.linyuzai.menupopupwindow.MenuPopupWindow;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MenuPopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        MenuPopupWindow.Menu menu = new MenuPopupWindow.Menu("123");
        menu.setTextColor(Color.RED);
        popupWindow = MenuPopupWindow.Builder()
                .setTitle("popup window")
                .setMenuExtraHeight(35)
                .setAllMenuBackground(Color.YELLOW)
                .addMenu("menu1", new Menu1ClickListener())
                .addMenu("menu2", new Menu2ClickListener())
                .addMenu("menu3", new Menu3ClickListener())
                .addMenu(menu)
                .create(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showFromBottom(textView);
            }
        });
    }

    class Menu1ClickListener implements MenuPopupWindow.OnMenuItemClickListener {

        @Override
        public void onMenuItemClick() {
            Toast.makeText(MainActivity.this, "menu1", Toast.LENGTH_SHORT).show();
        }
    }

    class Menu2ClickListener implements MenuPopupWindow.OnMenuItemClickListener {

        @Override
        public void onMenuItemClick() {
            Toast.makeText(MainActivity.this, "menu2", Toast.LENGTH_SHORT).show();
        }
    }

    class Menu3ClickListener implements MenuPopupWindow.OnMenuItemClickListener {

        @Override
        public void onMenuItemClick() {
            Toast.makeText(MainActivity.this, "menu3", Toast.LENGTH_SHORT).show();
        }
    }
}
