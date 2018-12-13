package com.example.muklahhn.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by Muklah H N on 30/07/2018.
 */

public class HabitContract {

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "drugs";
        public static final String COLUMN_DRUG_NAME = "name";
        public static final String COLUMN_DRUG_HOUR = "hour";

    }

}
