package in.indianmeme.app;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Constant {

    public static final String BASR_URL = "https://indianmeme.in/";
    public static final String SERVER_KEY = "1539874186";
    public static final String ACCESS_TOKEN = "access_token";
    public static final int OK = 200;
    public static final String USER_ID = "user_id";
    public static final String AVATAR = "avatar";
    public static final String USER_REGISTER = "endpoints/v1/auth/register";
    public static final String USER_LOGIN = "endpoints/v1/auth/login";
    public static final String USER_PROFILE = "endpoints/v1/post/fetch_user_posts";
    public static final String HOME_PAGE = "endpoints/v1/post/fetch_home_posts";
    public static final String GET_COMMENT = "endpoints/v1/post/fetch_comments";
    public static final String GET_STORY = "endpoints/v1/story/fetch_stories";
    public static final String ADD_IMZ = "endpoints/v1/post/new_post";
    public static final String ADD_COMMENT = "endpoints/v1/post/add_comment";
    public static final String DELETE_POST = "endpoints/v1/post/delete_post";
    public static final String LOGOUT_USER = "endpoints/v1/auth/logout";
    public static final String EXPLORE_DATA = "endpoints/v1/post/fetch_explore";
    public static final String ADD_LIKE = "endpoints/v1/post/like_post";
    public static final int REQUEST_CODE_PICTURE = 1234;
    public static final String FOLLOW_USER = "endpoints/v1/user/follow";
    public static final String FETCH_REPLY = "endpoints/v1/post/fetch_comment_reply";
    public static final String ADD_REPLY = "endpoints/v1/post/add_reply";
    public static final String USER_DATA = "endpoints/v1/user/fetch_userdata";
    public static final String ADD_STORY = "endpoints/v1/story/create_story";
    public static final String DELETE_COMMENT = "endpoints/v1/post/delete_comment";
    public static final String DELETE_REPLY = "endpoints/v1/post/delete_reply";
    public static final String GET_CHAT = "endpoints/v1/messages/get_chats";
    public static final String GET_USER_MSG = "endpoints/v1/messages/get_user_messages";
    public static final String SEND_MESSAGE = "endpoints/v1/messages/send_message";
    public static final String DELETE_MESSAGE = "endpoints/v1/messages/delete_message";
    public static final String DELETE_ALLCHAT = "endpoints/v1/messages/delete_chat";
    public static final String NOTIFICATION_GET = "/endpoints/v1/user/fetch_notifications";

    /**
     * Get a file path from a Uri. This will get the the path for Storage Access
     * Framework Documents, as well as the _data field for the MediaStore and
     * other file-based ContentProviders.
     *
     * @param context The context.
     * @param uri     The Uri to query.
     * @author paulburke
     */
    public static String getPath(final Context context, final Uri uri) {
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }

                // TODO handle non-primary volumes
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Bitmap getScaledBitmap(Bitmap bitmap) {
        int maxWidth = 720;
        int imageWidth = bitmap.getWidth();
        int imageHeight = bitmap.getHeight();

        if (imageWidth > maxWidth) {
            int newHeight = (imageHeight * maxWidth) / imageWidth;
            return Bitmap.createScaledBitmap(bitmap, maxWidth, newHeight, false);
        } else {
            return bitmap;
        }
    }

    public static String ChangeDateFormet(String str) {
        Date date = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy | hh:mm a", Locale.getDefault());
        Log.e("TIMEEEE: ", formatter.format(date));
        return formatter.format(date);
    }

    public static String ChangeTimeFormet(String str) {
        Date date = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat("MMM dd, yy | hh:mm a", Locale.getDefault());
        Log.e("TIMEEEE: ", formatter.format(date));
        return formatter.format(date);
    }

    public static String ChangeTimeFormett(String str) {
        Date date = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat(" hh:mm a", Locale.getDefault());
        Log.e("TIMEEEE: ", formatter.format(date));
        return formatter.format(date);
    }
}
