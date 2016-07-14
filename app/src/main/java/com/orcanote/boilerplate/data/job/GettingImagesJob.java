package com.orcanote.boilerplate.data.job;

import android.database.Cursor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.orcanote.boilerplate.AndroidApplication;
import com.orcanote.boilerplate.data.model.Image;
import com.orcanote.boilerplate.util.EventBusUtils;

import java.util.ArrayList;
import java.util.List;

public class GettingImagesJob extends Job {
    private String[] projection;

    public GettingImagesJob() {
        super(new Params(1));

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
    public void onAdded() {
    }

    @Override
    public void onRun() throws Throwable {
        Cursor cursor = cursor();

        if (cursor == null) {
            // do something
        } else {
            int columnIndexData         = cursor.getColumnIndex(projection[0]);
            int columnIndexDisplayName  = cursor.getColumnIndex(projection[1]);
            int columnIndexDateAdded    = cursor.getColumnIndex(projection[2]);
            int columnIndexDateModified = cursor.getColumnIndex(projection[3]);
            int columnIndexMimeType     = cursor.getColumnIndex(projection[4]);
            int columnIndexSize         = cursor.getColumnIndex(projection[5]);
            int columnIndexWidth        = cursor.getColumnIndex(projection[6]);
            int columnIndexHeight       = cursor.getColumnIndex(projection[7]);
            int columnIndexOrientation  = cursor.getColumnIndex(projection[8]);

            List<Image> images = new ArrayList<>();
            Image image;
            while (cursor.moveToNext()) {
                image = new Image();
                image.setPath(cursor.getString(columnIndexData));
                image.setDateAdded(cursor.getLong(columnIndexDateAdded));
                image.setDateModified(cursor.getLong(columnIndexDateModified));
                image.setMimeType(cursor.getString(columnIndexMimeType));
                image.setName(cursor.getString(columnIndexDisplayName));
                image.setWidth(cursor.getInt(columnIndexWidth));
                image.setHeight(cursor.getInt(columnIndexHeight));
                image.setSize(cursor.getInt(columnIndexSize));
                image.setOrientation(cursor.getInt(columnIndexOrientation));
                images.add(image);
            }

            EventBusUtils.post(images);

            cursor.close();
        } 
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }

    private Cursor cursor() {
        return AndroidApplication.getInstance().getContentResolver().query(
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
}
