package utils;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParcelableUtils {
    public static void write(Parcel dest, String string) {
        dest.writeByte((byte) (string == null ? 0 : 1));
        if (string != null) {
            dest.writeString(string);
        }
    }

    public static String readString(Parcel source) {
        if (source.readByte() == 1) {
            return source.readString();
        }
        return null;
    }

    public static void write(Parcel dest, Parcelable parcelable, int flags) {
        dest.writeByte((byte) (parcelable == null ? 0 : 1));
        if (parcelable != null) {
            dest.writeParcelable(parcelable, flags);
        }
    }

    public static <T extends Parcelable> T readParcelable(Parcel source,
                                                          ClassLoader loader) {
        if (source.readByte() == 1) {
            return source.readParcelable(loader);
        }
        return null;
    }

    public static void write(Parcel dest, Map<String, String> strings) {
        if (strings == null) {
            dest.writeInt(-1);
        }
        {
            dest.writeInt(strings.keySet().size());
            for (String key : strings.keySet()) {
                dest.writeString(key);
                dest.writeString(strings.get(key));
            }
        }
    }

    public static Map<String, String> readStringMap(Parcel source) {
        int numKeys = source.readInt();
        if (numKeys == -1) {
            return null;
        }
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < numKeys; i++) {
            String key = source.readString();
            String value = source.readString();
            map.put(key, value);
        }
        return map;
    }

    public static <T extends Parcelable> void write(Parcel dest,
                                                    Map<String, T> objects, int flags) {
        if (objects == null) {
            dest.writeInt(-1);
        } else {
            dest.writeInt(objects.keySet().size());
            for (String key : objects.keySet()) {
                dest.writeString(key);
                dest.writeParcelable(objects.get(key), flags);
            }
        }
    }

    public static <T extends Parcelable> Map<String, T> readParcelableMap(
            Parcel source) {
        int numKeys = source.readInt();
        if (numKeys == -1) {
            return null;
        }
        HashMap<String, T> map = new HashMap<String, T>();
        for (int i = 0; i < numKeys; i++) {
            String key = source.readString();
            T value = source.readParcelable(null);
            map.put(key, value);
        }
        return map;
    }

    public static void write(Parcel dest, URL url) {
        dest.writeString(url.toExternalForm());
    }

    public static URL readURL(Parcel source) {
        try {
            return new URL(source.readString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(Parcel dest, Date date) {
        dest.writeByte((byte) (date == null ? 0 : 1));
        if (date != null) {
            dest.writeLong(date.getTime());
        }
    }

    public static Date readDate(Parcel source) {
        if (source.readByte() == 1) {
            return new Date(source.readLong());
        }
        return null;
    }

    public static <T extends Enum<T>> void write(Parcel dest, Enum<T> enu) {
        if (enu == null) {
            dest.writeString("");
        } else {
            dest.writeString(enu.name());
        }
    }

    public static <T extends Enum<T>> T readEnum(Parcel dest, Class<T> clazz) {
        String name = dest.readString();
        if ("".equals(name)) {
            return null;
        }
        return Enum.valueOf(clazz, name);
    }

    public static void write(Parcel dest, boolean bool) {
        dest.writeByte((byte) (bool ? 1 : 0));
    }

    public static boolean readBoolean(Parcel source) {
        return source.readByte() == 1;
    }

    public static <T extends Parcelable> void write(Parcel dest,
                                                    ArrayList<T> fields, int flags) {
        if (fields == null) {
            dest.writeInt(-1);
        } else {
            dest.writeInt(fields.size());
            for (T field : fields) {
                dest.writeParcelable(field, flags);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Parcelable> ArrayList<T> readParcelableList(
            Parcel source, ClassLoader loader) {
        int size = source.readInt();
        if (size == -1) {
            return null;
        }
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            list.add((T) source.readParcelable(loader));
        }
        return list;
    }

    public static void write(Parcel dest, Double dbl) {
        dest.writeByte((byte) (dbl == null ? 0 : 1));
        if (dbl != null) {
            dest.writeDouble(dbl);
        }
    }

    public static void write(Parcel dest, ArrayList<String> fields) {
        if (fields == null) {
            dest.writeInt(-1);
        } else {
            dest.writeInt(fields.size());
            for (String field : fields) {
                dest.writeString(field);
            }
        }
    }

    public static ArrayList<String> readArrayList(Parcel source) {
        int size = source.readInt();
        if (size == -1) {
            return null;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(source.readString());
        }
        return list;
    }

    public static Double readDouble(Parcel source) {
        if (source.readByte() == 1) {
            return source.readDouble();
        }
        return (double) 0;
    }

    public static void write(Parcel dest, Integer integer) {
        dest.writeByte((byte) (integer == null ? 0 : 1));
        if (integer != null) {
            dest.writeInt(integer);
        }
    }

    public static Integer readInt(Parcel source) {
        if (source.readByte() == 1) {
            return source.readInt();
        }
        return 0;
    }

    public static void write(Parcel dest, String[] stringArray) {
        dest.writeByte((byte) ((stringArray == null || stringArray.length <= 0) ? 0
                : 1));
        if ((stringArray != null && stringArray.length > 0))
            dest.writeStringArray(stringArray);
    }

    public static void readStringArray(Parcel source, String[] val) {
        if (source.readByte() == 1) {
            source.readStringArray(val);
        }
    }

    public static void write(Parcel dest, Parcelable[] parcelable, int flags) {
        dest.writeByte((byte) ((parcelable == null || parcelable.length <= 0) ? 0
                : 1));
        if (parcelable != null) {
            dest.writeParcelableArray(parcelable, flags);
        }
    }

    public static Parcelable[] readParcelableArray(Parcel source,
                                                   ClassLoader loader) {
        if (source.readByte() == 1) {
            return source.readParcelableArray(loader);
        }
        return new Parcelable[0];
    }
}

