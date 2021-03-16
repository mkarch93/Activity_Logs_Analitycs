package com.radware.activitylog.entity;

import java.util.ArrayList;

public class Input {


        private ArrayList<String> activityTypes;
        private ArrayList<String> statuses;
        private ArrayList<String> dateTime;


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

        public ArrayList<String> getDateTime() {
                return dateTime;
        }

        public void setDateTime(ArrayList<String> dateTime) {
                this.dateTime = dateTime;
        }


}
