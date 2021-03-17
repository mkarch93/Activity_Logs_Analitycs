package com.radware.activitylog.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Input {


        private ArrayList<String> activityTypes;
        private ArrayList<String> statuses;
        private ArrayList<Timestamp> dateTime;


        public ArrayList<String> getActivityTypes() {
                return activityTypes;
        }

        public void setActivityTypes(ArrayList<String> activityTypes) {
                this.activityTypes = activityTypes;
        }

        public ArrayList<String> getStatuses() {
                return statuses;
        }

        public void setStatuses(ArrayList<String> statuses) {
                this.statuses = statuses;
        }


        public void setDateTime(ArrayList<String> dateTime) {

            ArrayList<Timestamp> tmp = new ArrayList<>();

            for (String dt : dateTime) {
                tmp.add(Timestamp.valueOf(LocalDateTime.parse(dt.substring(0, dt.length() - 8))));
            }
                this.dateTime = tmp;
        }

        public ArrayList<Timestamp> getDateTime() {
                return dateTime;
        }
}
