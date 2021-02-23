package com.mostainahmed.discoverkhulna.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mostainahmed.discoverkhulna.R;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView backButton;
    List<Hotel> hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.img_back);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hotelList = new ArrayList<>();

        listOfHotels();

        HotelAdapter adapter = new HotelAdapter(this, hotelList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void listOfHotels() {
        hotelList.add(
                new Hotel(
                        1,
                        "Tiger Garden International Hotel",
                        "Shib Bari More Circle, 01 KDA Ave, Khulna 9100",
                        "3 Star",
                        "3510/=",
                        R.drawable.hoteltiger,
                        "Shib Bari Mor-01, KDA Aveneue, Khulna-9100",
                        "01769-056368",
                        "https://www.tigergardenhotel.com/"
                )
        );
        hotelList.add(
                new Hotel(
                        2,
                        "Hotel Castle Salam",
                        "Hotel Castle Salam features air-conditioned rooms in Khulna. Among the facilities of this property are a restaurant, a 24-hour front desk and room service, along with free Wi-Fi. The hotel provides an outdoor swimming pool, fitness Centre and an ATM.\n" +
                                "\n" +
                                "All units at the hotel are equipped with a seating area. At Hotel Castle Salam each room includes a desk, a flat-screen TV and a private bathroom.\n" +
                                "\n" +
                                "A continental breakfast is available daily at the accommodation.\n" +
                                "\n" +
                                "You can play billiards and table tennis at Hotel Castle Salam, and car hire is available.\n",
                        "3 Star",
                        "5786/=",
                        R.drawable.hotelcastle,
                        "G-8, Taltola Lane, KDA Aveneue, Khulna",
                        "N/A",
                        "http://www.hotelcastlesalam.com/"
                )
        );
        hotelList.add(
                new Hotel(
                        3,
                        "City Inn Ltd.",
                        "City centre hotel with a rooftop pool",
                        "3 Star",
                        "N/A",
                        R.drawable.hotelcityinn,
                        "B1 Mojid Sarani, KDA, Khulna",
                        "N/A",
                        "https://cityinnltd.com/"
                )
        );
        hotelList.add(
                new Hotel(
                        4,
                        "Hotel Royal International",
                        "Luxury hotel",
                        "3 Star",
                        "N/A",
                        R.drawable.royalhotel,
                        "A-33, KDA Khan Jahan Ali Road, Khulna",
                        "01718-679900",
                        "https://hotelroyalintl.com/"
                )
        );
        hotelList.add(
                new Hotel(
                        5,
                        "Western Inn International Ltd.",
                        "Set near the Rupsa River, this unpretentious hotel is less than 1 km from the N7, 2 km from the Khulna Museum and 26 km from the Shat Gombuj Mosque, a UNESCO World Heritage Site. \n" +
                                "\n" +
                                "Down-to-earth rooms provide Wi-Fi access, flat-screen TVs and minifridges, as well as tea and coffeemaking facilities. They also have private bathrooms. Room service is available.\n" +
                                "\n" +
                                "Dining is offered in an airy restaurant. There's also a fitness Centre and a pool table. Parking, an airport shuttle and meeting space are available.\n",
                        "N/A",
                        "N/A",
                        R.drawable.westernhotel,
                        "51, Khan A Sabur Road, Upper Jessore Road, Khulna-9100",
                        "N/A",
                        "http://western-inn.com/"
                )
        );
        hotelList.add(
                new Hotel(
                        6,
                        "The Hotel Millennium Ltd.",
                        "Millennium Hotel is one of the famous hotels in Khulna. This hotel is located in the center of Khulna.\n" +
                                "\n" +
                                "If you are in Khulna, you can stay at this hotel. The hotel authority is waiting for you to welcome. You will get top-class services from them\n",
                        "N/A",
                        "N/A",
                        R.drawable.hotelmilennium,
                        "B #4, Majid Sarani, Khulna-9100",
                        "N/A",
                        "https://web.facebook.com/Hotel-Millennium-Ltd-365082803615115/"
                )
        );

    }
}
