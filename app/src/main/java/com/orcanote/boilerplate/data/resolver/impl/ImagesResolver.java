package com.orcanote.boilerplate.data.resolver.impl;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.orcanote.boilerplate.data.model.Image;
import com.orcanote.boilerplate.data.resolver.BaseResolver;

import java.util.List;

public class ImagesResolver extends BaseResolver<Image> {
    private Context context;

    private int columnIndexData;
    private int columnIndexDisplayName;
    private int columnIndexDateAdded;
    private int columnIndexDateModified;
    private int columnIndexMimeType;
    private int columnIndexSize;
    private int columnIndexWidth;
    private int columnIndexHeight;
    private int columnIndexOrientation;

    public ImagesResolver(Context context) {
        this.context = context;
        projection = new String[]{
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.Media.DATE_MODIFIED,
            MediaStore.Images.Media.MIME_TYPE,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT,
            MediaStore.Images.Media.ORIENTATION,
            MediaStore.Images.Media._ID
        };
    }

    @Override
    public List<Image> query() {
        Cursor cursor = cursor();

        if (cursor == null) {
            // do something
        } else {
            columnIndexData         = cursor.getColumnIndex(projection[0]);
            columnIndexDisplayName  = cursor.getColumnIndex(projection[1]);
            columnIndexDateAdded    = cursor.getColumnIndex(projection[2]);
            columnIndexDateModified = cursor.getColumnIndex(projection[3]);
            columnIndexMimeType     = cursor.getColumnIndex(projection[4]);
            columnIndexSize         = cursor.getColumnIndex(projection[5]);
            columnIndexWidth        = cursor.getColumnIndex(projection[6]);
            columnIndexHeight       = cursor.getColumnIndex(projection[7]);
            columnIndexOrientation  = cursor.getColumnIndex(projection[8]);

            while (cursor.moveToNext()) {
                convert(cursor);
            }

            cursor.close();
        }

        context = null;

        return models;
    }

    @Override
    protected Cursor cursor() {
        return context.getContentResolver().query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            new StringBuilder().append(projection[5]).append(" > 0 AND ")
                               .append(projection[4]).append(" = ? OR ")
                               .append(projection[4]).append(" = ?")
                               .toString(),
            new String[]{ "image/jpeg", "image/png" },
            projection[2] + " DESC"
        );
    }

    @Override
    protected void convert(Cursor cursor) {
        Image image = new Image();
        image.setPath(cursor.getString(columnIndexData));
        image.setDateAdded(cursor.getLong(columnIndexDateAdded));
        image.setDateModified(cursor.getLong(columnIndexDateModified));
        image.setMimeType(cursor.getString(columnIndexMimeType));
        image.setName(cursor.getString(columnIndexDisplayName));
        image.setWidth(cursor.getInt(columnIndexWidth));
        image.setHeight(cursor.getInt(columnIndexHeight));
        image.setSize(cursor.getInt(columnIndexSize));
        image.setOrientation(cursor.getInt(columnIndexOrientation));
        models.add(image);
    }
}
