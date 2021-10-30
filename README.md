# EasyWidgets ~ Android UI library
<p align="left">
  <a href="#"><img alt="Languages-Java" src="https://img.shields.io/badge/Language-Java-1DA1F2?style=flat-square&logo=java"></a>
  <a href="https://www.instagram.com/x__coder__x/"><img alt="Instagram - x__coder__" src="https://img.shields.io/badge/Instagram-x____coder____x-lightgrey"></a>
  <a href="#"><img alt="GitHub Repo stars" src="https://img.shields.io/github/stars/ErrorxCode/OTP-Verification-Api?style=social"></a>
  </p>
 
🇹‌🇭‌🇮‌🇸‌ 🇱‌🇮‌🇧‌🇷‌🇦‌🇷‌🇾‌ 🇼‌🇮‌🇱‌🇱‌ 🇭‌🇪‌🇱‌🇵‌ 🇾‌🇴‌🇺‌ 🇹‌🇴‌ 🇺‌🇸‌🇪‌ 🇨‌🇴‌🇲‌🇵‌🇱‌🇪‌🇽‌ 🇺‌🇮‌ 🇨‌🇴‌🇲‌🇵‌🇴‌🇳‌🇪‌🇳‌🇹‌🇸‌ 🇩‌🇮‌🇷‌🇪‌🇨‌🇹‌🇱‌🇾‌ 🇼‌🇮‌🇹‌🇭‌🇴‌🇺‌🇹‌ 🇼‌🇷‌🇮‌🇹‌🇮‌🇳‌🇬‌ 🇦‌ 🇨‌🇺‌🇸‌🇹‌🇴‌🇲‌ 🇦‌🇩‌🇦‌🇵‌🇹‌🇪‌🇷‌ 🇫‌🇴‌🇷‌ 🇹‌🇭‌🇪‌🇲‌. 🇪‌🇦‌🇷‌🇱‌🇮‌🇪‌🇷‌, 🇾‌🇴‌🇺‌ 🇭‌🇦‌🇻‌🇪‌ 🇹‌🇴‌ 🇼‌🇷‌🇮‌🇹‌🇪‌ 🇦‌ 🇨‌🇺‌🇸‌🇹‌🇴‌🇲‌ 🇦‌🇩‌🇦‌🇵‌🇹‌🇪‌🇷‌ 🇫‌🇴‌🇷‌ 🇦‌ 🇸‌🇮‌🇲‌🇵‌🇱‌🇪‌ 🇨‌🇺‌🇸‌🇹‌🇴‌🇲‌ 🇱‌🇮‌🇸‌🇹‌🇻‌🇮‌🇪‌🇼‌. 🇧‌🇺‌🇹‌ 🇳‌🇴‌🇼‌ 🇴‌🇳‌🇼‌🇦‌🇷‌🇩‌🇸‌, 🇾‌🇴‌🇺‌ 🇯‌🇺‌🇸‌🇹‌ 🇭‌🇦‌🇻‌🇪‌ 🇹‌🇴‌ 🇼‌🇷‌🇮‌🇹‌🇪‌ 🇨‌🇴‌🇩‌🇪‌ 🇫‌🇴‌🇷‌ 🇻‌🇮‌🇪‌🇼‌ 🇮‌🇳‌ 🇽‌🇲‌🇱‌. 🇹‌🇭‌🇮‌🇸‌ 🇱‌🇮‌🇧‌🇷‌🇦‌🇷‌🇾‌ 🇵‌🇷‌🇴‌🇻‌🇮‌🇩‌🇪‌🇸‌ 🇲‌🇦‌🇳‌🇾‌ 🇨‌🇺‌🇸‌🇹‌🇴‌🇲‌ 🇨‌🇴‌🇲‌🇵‌🇴‌🇳‌🇪‌🇳‌🇹‌🇸‌ 🇸‌🇺‌🇨‌🇭‌ 🇦‌🇸‌ 🇱‌🇮‌🇸‌🇹‌🇻‌🇮‌🇪‌🇼‌🇸‌,🇸‌🇵‌🇮‌🇳‌🇳‌🇪‌🇷‌,🇷‌🇦‌🇩‌🇮‌🇴‌🇧‌🇺‌🇹‌🇹‌🇴‌🇳‌ & 🇲‌🇴‌🇷‌🇪‌.

## Screenshots


<p float="left">
  
<img src="https://www.codingdemos.com/wp-content/uploads/2017/10/Android-Custom-Spinner-With-Images-And-Text.png" width="250" />

<img src="https://mobile-cdn.softpedia.com/apk/images/1-1-1-1-faster-safer-internet_8.jpg" width="250" />
	
<img src="https://static.javatpoint.com/images/androidimages/custom-listview3.png" width="250" />
  
<img src="/mcq.png" width="250" />
  
<img src="/quiz.png" width="250" />
	
<img src="/all.png" width="250" />

</p>

## Features

- 4 types of listviews
- 2 type of spinner
- 2 lined radiobutton (special)
- 4 styles of radiobutton
- Simple & easiest ever


## Implimentation

In your project build.gradle

```groovy
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
In your module (app) build.gradle
```groovy
dependencies {
	        implementation 'com.github.ErrorxCode:EasyWidgets:2.0'
	}
```

## Usage / Example
**2 lined RadioButton**
```xml
 <com.easywidgets.radio.EasyRadioButton
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:title="This is title"
        app:description="This is description"
        app:isR2L="true"/>
```
[Note] : Use ```EasyRadioGroup``` insted of default ```RadioGroup``` for this.

**Special Radiobuttons**
```
<RadioButton
        style="@style/ClassicQuiz"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Correct option" />
```
All you have to do is just apply the styles. These are the following styles
- ClassicQuiz
- ModernQuiz
- ClassicBlue
- ClassicRed
- ModernRed
- ModernBlue

**Spinner**
```java
   Spinner spinner = findViewById(R.id.spinner); // Use default spinner,Just need to use this adapter.
   SpinnerAdapter adapter = new SpinnerAdapter(this,new String[]{"High","Ultra","Extreme"},new String[]{"This will give you 30 FPS","This will give you 40 FPS","This will give you 60 FPS"});
   // or
   SpinnerAdapter adapter = new SpinnerAdapter(this,new String[]{"High","Ultra","Extreme"},new int[]{R.mipmap.ic_launcher,R.drawable.ic_launcher_background});
   spinner.setAdapter(adapter);
```
**Listview**
```java
   Listview listview = findViewById(R.id.listview); // Use default spinner,Just need to use this adapter.
   EasyListAdapter adapter = new EasyListAdapter(this,new String[]{"High","Ultra","Extreme"},new String[]{"This will give you 30 FPS","This will give you 40 FPS","This will give you 60 FPS"});
   // or
   EasyListAdapter adapter = new EasyListAdapter(this,new String[]{"High","Ultra","Extreme"},new int[]{R.mipmap.icon1,R.drawable.icon2},null);
   // or
     ArrayList<EasyListObject> items = new ArrayList<>();
     items.add(new EasyListObject(R.drawable.icon1,"Title1","Heading1","Description1.."));
     items.add(new EasyListObject(R.drawable.icon2,"Title2","Heading2","Description2.."));      
     items.add(new EasyListObject(R.drawable.icon1,"Title3","Heading3","Description3.."));
      
     ListAdapter adapter = new ListAdapter(this,list);
     listview.setAdapter(adapter);
```
[Note] : If using adapter for listview with icons, you have to either pass String arry for 3rd line (heading) or null.

**Thank you for using my library. Have a nice day :)**
