package ru.khasang.honeymoney;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.content.res.Configuration;

public class MainActivity extends Activity {

    private String[] titles;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int currentPosition = 0;

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titles = getResources().getStringArray(R.array.titles);
        drawerList = (ListView) findViewById(R.id.drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Заполняем ListView
        drawerList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, titles));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        //Отображаем правильный фрагмент при повороте экрана
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("position");
            setActionBarTitle(currentPosition);
        } else {
            //При первой загрузке показать AuthorizationFragment
            selectItem(0);
        }
        //Сщздаем и устанавливаем слушатель на положение панели навигации
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        //Устанавливаем кнопку "Up" для открытия и закрытия панели навигации
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        //Устанавливаем слушатель изменений в BackStack
        //(Сделал такую заглушку, чтобы не передавать информацию во фрагменты)
        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                FragmentManager fm = getFragmentManager();
                Fragment fragment = fm.findFragmentByTag("current_fragment");
                if (fragment instanceof AuthorizationFragment) {
                    currentPosition = 0;
                }
                if (fragment instanceof SyncFragment) {
                    currentPosition = 1;
                }
                if (fragment instanceof ImportFragment) {
                    currentPosition = 2;
                }
                if (fragment instanceof ExportFragment) {
                    currentPosition = 3;
                }
                if (fragment instanceof SettingsFragment) {
                    currentPosition = 4;
                }
                //Устанавливаем правильный заголовок
                setActionBarTitle(currentPosition);
                //Подсвечиваем соответствующий пункт в панели навигации
                drawerList.setItemChecked(currentPosition, true);
            }
        });
    }

    //Реализуем действие открытия и закрытия панели навигации при нажатии на кнопку "Up"
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Синхронизируем внешний вид кнопки "Up" с положением панели навигации
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    //Синхронизируем состояние панели навигации с положением устройства
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    //Устанавливаем нужный фрагмент по позиции, выбранной в панели навигации
    private void selectItem(int position) {
        currentPosition = position;
        Fragment fragment;
        switch (position) {
            case 1:
                fragment = new SyncFragment();
                break;
            case 2:
                fragment = new ImportFragment();
                break;
            case 3:
                fragment = new ExportFragment();
                break;
            case 4:
                fragment = new SettingsFragment();
                break;
            default:
                fragment = new AuthorizationFragment();
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment, "current_fragment");
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        setActionBarTitle(position);
        //Закрываем NavigationDrawer
        drawerLayout.closeDrawer(drawerList);
    }

    //Устанавливаем заголовок для ActionBar в соответствии с фрагментом
    private void setActionBarTitle(int position) {
        String title = titles[position];
        getActionBar().setTitle(title);
    }

    //Сохраняем информацию о текущем фрагменте для правильного
    //отображения заголовка при повороте устройства
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", currentPosition);
    }
}
