package com.orcanote.boilerplate.data.resolver;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

abstract public class BaseResolver<T> {
    protected String[] projection;
    protected List<T> models = new ArrayList<>();

    abstract public List<T> query();

    /**
     * Getting data from specified content provider.
     * @return the data from specified content provider
     */
    abstract protected Cursor cursor();

    /**
     * Converting row to specified data model and saving to collection.
     * @param cursor current row from data
     */
    abstract protected void convert(Cursor cursor);
}
