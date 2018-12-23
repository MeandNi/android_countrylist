package com.example.yangjiakang.countrylistdemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.yangjiakang.countrylistdemo.R;
import com.example.yangjiakang.countrylistdemo.bean.CountryViewBean;
import com.example.yangjiakang.countrylistdemo.utils.contact.ContactItemInterface;
import com.example.yangjiakang.countrylistdemo.utils.contact.ContactListAdapter;

import java.util.List;


public class CountryAdpater extends ContactListAdapter {
    private static final String TAG = "CountryAdpater";

    public CountryAdpater(Context _context, int _resource,
                          List<ContactItemInterface> _items) {
        super(_context, _resource, _items);
    }

    // override this for custom drawing
    public void populateDataForRow(View parentView, ContactItemInterface item, int position) {
        // default just draw the item only
        TextView fullNameView = (TextView) parentView.findViewById(R.id.nameView);

        if (item instanceof CountryViewBean) {
            CountryViewBean contactItem = (CountryViewBean) item;
            fullNameView.setText(contactItem.getCountryName());
        }

    }

}
