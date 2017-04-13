# DroidDialog
This is an Android Library for showing Material Dialog with little customization with icons, colors, divider line.
<br>
Example is available in app module.

<p>
<img src="https://github.com/sagar091/DemoProject/blob/master/app/src/main/assets/device-2017-04-12-193622.png" alt="screenshot" width="270">

<img src="https://github.com/sagar091/DemoProject/blob/master/app/src/main/assets/device-2017-04-12-193442.png" alt="screenshot" width="270">

<img src="https://github.com/sagar091/DemoProject/blob/master/app/src/main/assets/device-2017-04-12-195446.png" alt="screenshot" width="270">

</p>

## Download

### Gradle dependency:
- Add the following to your project level build.gradle:
~~~
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
~~~
- Add this to your app build.gradle:
~~~
dependencies {
	compile 'com.github.vatsaldesai92:MyDynamicCalendarLibrary:1.0.1'
}
~~~

<p>
<a href="https://play.google.com/store/apps/details?id=com.desai.vatsal.myamazingcalendar&hl=en">
<img src="https://github.com/vatsaldesai92/MyDynamicCalendarLibrary/blob/master/app/src/main/assets/google_play_icon.png" alt="screenshot" width="270">
</a>
</p>

### Usage

- Create Builder Pattern for default Dialog. Default Dialog has tick_mark icon, "Title" as dialog title, "Content Description" as content, "Yes" & "No" buttons
~~~
    new DroidDialog.Builder(context)
                    .show();
~~~

- Add Icon  `.icon(int icon)`
~~~ 
    new DroidDialog.Builder(context)
                    .icon(R.drawable.ic_action_tick)
                    .show();
~~~

- Add Title
~~~
    new DroidDialog.Builder(context)
                   .icon(R.drawable.ic_action_tick)
                   .title("All Well!")
                   .show();
~~~

- Manage Events
~~~
    myCalendar.setEventCellBackgroundColor("#852365");
    myCalendar.setEventCellTextColor("#425684");

    // Add event  -  addEvent(event_date, event_start_time, event_end_time, event_title)
    myCalendar.addEvent("5-10-2016", "8:00", "8:15", "Today Event 1");
    myCalendar.addEvent("05-10-2016", "8:15", "8:30", "Today Event 2");
    myCalendar.addEvent("05-10-2016", "8:30", "8:45", "Today Event 3");

    // Get list of event with detail
    myCalendar.getEventList(new GetEventListListener() {
        @Override
        public void eventList(ArrayList<EventModel> eventList) {

        }
    });

    // updateEvent(position, event_date, event_start_time, event_end_time, event_title)
    myCalendar.updateEvent(0, "5-10-2016", "8:00", "8:15", "Today Event 111111");

    // Delete single event
    myCalendar.deleteEvent(2);

    // Delete all events
    myCalendar.deleteAllEvent();
~~~

- Manage Holiday
~~~
    myCalendar.setHolidayCellBackgroundColor("#654248");
    myCalendar.setHolidayCellTextColor("#d590bb");

    // set holiday date clickable true/false
    myCalendar.setHolidayCellClickable(false);

    // Add holiday  -  addHoliday(holiday_date)
    myCalendar.addHoliday("2-11-2016");
    myCalendar.addHoliday("13-11-2016");
    myCalendar.addHoliday("8-10-2016");
    myCalendar.addHoliday("10-12-2016");
~~~

- Navigate to particular date
~~~
    // setCalendarDate(date, month, year)
    myCalendar.setCalendarDate(5, 10, 2016);
~~~

- Month View
~~~
    // show month view
    myCalendar.showMonthView();

    // date click listener
    myCalendar.setOnDateClickListener(new OnDateClickListener() {
        @Override
        public void onClick(Date date) {

        }

        @Override
        public void onLongClick(Date date) {

        }
    });
~~~

- Month View With Event List (Show event on event date click)
~~~
    // show month view with events
    myCalendar.showMonthViewWithBelowEvents();

    // date click listener
    myCalendar.setOnDateClickListener(new OnDateClickListener() {
        @Override
        public void onClick(Date date) {

        }

        @Override
        public void onLongClick(Date date) {

        }
    });
~~~

- Week View
~~~
    // show week view
    myCalendar.showWeekView();

    // date click listener
    myCalendar.setOnDateClickListener(new OnDateClickListener() {
        @Override
        public void onClick(Date date) {

        }

        @Override
        public void onLongClick(Date date) {

        }
    });

    // week view blank cell click listener
    myCalendar.setOnWeekDayViewClickListener(new OnWeekDayViewClickListener() {
        @Override
        public void onClick(String date, String time) {

        }

        @Override
        public void onLongClick(String date, String time) {

        }
    });

    // single event cell click listener
    myCalendar.setOnEventClickListener(new OnEventClickListener() {
        @Override
        public void onClick() {

        }

        @Override
        public void onLongClick() {

        }
    });
~~~

- Day View
~~~
    // show day view
    myCalendar.showDayView();

    // day view blank cell click listener
    myCalendar.setOnWeekDayViewClickListener(new OnWeekDayViewClickListener() {
        @Override
        public void onClick(String date, String time) {

        }

        @Override
        public void onLongClick(String date, String time) {

        }
    });

    // single event cell click listener
    myCalendar.setOnEventClickListener(new OnEventClickListener() {
        @Override
        public void onClick() {

        }

        @Override
        public void onLongClick() {

        }
    });
~~~

- Agenda View
~~~
    // show agenda view
    myCalendar.showAgendaView();

    // date click listener
    myCalendar.setOnDateClickListener(new OnDateClickListener() {
        @Override
        public void onClick(Date date) {

        }

        @Override
        public void onLongClick(Date date) {

        }
    });
~~~


## License
~~~
    Apache Version 2.0

    Copyright 2016.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
~~~
