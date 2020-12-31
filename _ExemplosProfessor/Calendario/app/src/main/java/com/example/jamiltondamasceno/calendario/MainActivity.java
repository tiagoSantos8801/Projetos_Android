package com.example.jamiltondamasceno.calendario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class MainActivity extends AppCompatActivity {

    //private CalendarView calendarView;
    private MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);

        /**Data maxima e data minima - maxima*/
        /*calendarView.state().edit()
                .setMinimumDate(CalendarDay.from(2015,1,1))
                .setMaximumDate(CalendarDay.from(2018,3,1))
                .commit();*/

        //Altera titulo dos meses
        CharSequence meses[] = {"Janeiro","Fevereiro", "Março","Abril","Maio",
                                "Junho","Julho","Agosto","Setembro","Outubro",
                                "Novembro","Dezembro"};
        calendarView.setTitleMonths( meses );

        //Altera titulo dos dias da semana
        CharSequence semanas[] = {"Segunda", "Terça","Quarta",
                                    "Quinta","Sexta","Sábado","Domingo"};
        calendarView.setWeekDayLabels(semanas);

        //printa no logcat
        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {//Retorna o dia, mes e ano selecionado
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                Log.i("data ", "valor: " + (date.getMonth() + 1) + "/" + date.getYear() );
            }
        });

//        //Printa no logcat
//      calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
//          @Override
//          public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
//              Log.i("data: ", "valor: " + date );
//          }
//      });

//        calendarView = findViewById(R.id.calendarView);
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {//Retorna dia,mes e ano
//                Log.i("data: ", "valor: " + dayOfMonth + "/" + month + "/" + year );
//            }
//        });

    }
}
