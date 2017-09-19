# FooyoTestSDK For Android
 
## include
- add following script into your root build.gradle
 ```
 allprojects {
     repositories {
         maven {
             url "https://jitpack.io"
         }
         maven {
             url 'https://dl.bintray.com/zkxy/maven/'
         }
     }
 }
 ```
- because of sdk using `databinding` lib,so you should add databinding into your module build.gradle
```
android {
    ...
    
    dataBinding {
        enabled = true
    }
}
```

-  add fooyo sdk dependency into your module build.gradle

```
   compile 'com.allenliu:FooyoSdkOSPDev:1.0.1'
```

## Usage

### DEMO 
  
 [A Demo Project](https://github.com/AlexLiuSheng/FooyoTestSDK) is created specically for the OSP project to demostrate how to integrate Fooyo's SDK.
 
### General SDK Parameters

```
public class FooyoIndex implements Parcelable {
    private String category;
    private String levelOneId;
    private String levelTwoId;
 }
```
`FooyoIndex` is designed for an easy communication between the base system and the SDK functions. For all the locations, trails and the hotspots of the trails, they would have their own `FooyoIndex` for a better reference. `FooyoIndex` incldues the following parameters:

- `category`: Category Name (`String Value`);
- `levelOneId`: The id for all the locations and trails (`Int Value`);
- `levelTwoId`: The hotspot id for all the `Hotspots` of `Non-linear Trails` (`Int Value`)

Only `Hotspots` of `Non-linear Trails` will have `levelTwoId`. Their `levelOneId` is the `Non-linear Trail` Id.

### Initialize
add following code into your own `Application`

```
        FooyoSDK.init(Context application,boolean isDebug);
```
 
### BaseMap integration

- if u want to use base map (fragment).you can add it into your layout by adding a `FooyoSDKMapFragment`
  
  - in xml layout eg.
  
  ```
     <fragment
          android:id="@+id/fragment"
          android:layout_width="match_parent"
          android:layout_weight="1"
          android:name="sg.fooyo.sdkosp.sdk.ui.FooyoSDKMapFragment"
          android:layout_height="match_parent"/>
   ```
   
   - or in Java code eg.
   
  ```
  getSupportFragmentManager().beginTransaction().add(R.id.fragment_containers, mapFragment).commit();
  ```
  
- you can also open basemap in a FullScreenStyle(Activity).
  and you can specify a location to show by deliver a FooyoIndex
```
    FooyoSDK.getSDKManager().startFooyoMapPage(Activity activity,@Nullable FooyoIndex fooyoIndex);
```

### Navigation

Start Navigation page ,you can deliver two param.One start FooyoIndex,one end.
```
    FooyoSDK.getSDKManager().startNavigation(Context context, FooyoIndex start, FooyoIndex end)
```
### Create Plan

```
  FooyoSDK.getSDKManager().startFooyoCreatePlan(Context context,String userId);
```

### Delegate Function
set a callback when info window click on map .
```
FooyoSDK.getSDKManager().setOnWindowDetailClickListener(new WindowDetailClickListener() {
                    @Override
                    public void onClick(FooyoIndex fooyoIndex) {

                    }
                });
```
### Add plan

```
 FooyoSDK.getSDKManager().addToPlan(String userId,FooyoIndex fooyoIndex);
 
 ```

### View Plan

```
 FooyoSDK.getSDKManager().viewMyPlans(String userId);
```
