# InfiniteAutoScrollRecyclerView

## Overview

**InfiniteAutoScrollRecyclerView** is a custom RecyclerView implementation for Android that provides automatic infinite horizontal scrolling. It supports both list and grid layouts and allows customization of scroll speed, item margins, and orientation.

## Features

- Supports **infinite horizontal scrolling**.
- Works with both **list and grid layouts**.
- Customizable **scroll speed**.
- Adjustable **item margins**.
- Smooth and efficient scrolling performance.

## Installation

Add the following dependency to your **build.gradle.kts**:

```kotlin

### **Add to Your Project**
#### 1. Add the JitPack repository  
Add the following line to your root `settings.gradle` or `build.gradle` file:  
```
kotlin
maven { url = uri("https://jitpack.io") }
```

#### 2. Add the library dependency  
In your module `build.gradle` file (usually `app`):  
```kotlin

```

```

## Usage

### 1. Add to Layout XML

```xml
   <ir.mehdisekoba.infiniteautoscrollrecyclerview.InfiniteAutoScrollRecyclerView
        android:id="@+id/list_item"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="?actionBarSize"
        app:layout_constraintTop_toTopOf="parent"
        app:scrollSpeed="3500"
        app:scrollOrientation="horizontal"
        app:itemMargin="10dp"
        app:scrollLayoutType="grid"
        android:layoutDirection="rtl" />
```

### 2. Initialize in Activity/Fragment

```kotlin
       
	   binding?.apply {
             val myAdapter = SplashAdapter()
            listItem.adapter = myAdapter
            myAdapter.setData(listImage)
            listItem.startScrolling()
        }
```

## Customization

### XML Attributes
| Attribute          | Description                                  | Default Value |
|-------------------|--------------------------------------|---------------|
| `scrollOrientation` | Scrolling direction (horizontal)     | `horizontal`  |
| `scrollLayoutType`  | Layout type (list/grid)              | `list`        |
| `itemMargin`       | Margin between items                 | `0dp`         |
| `scrollSpeed`      | Speed of auto-scrolling              | `35000f`      |

### Programmatic Customization

```kotlin
recyclerView.scrollSpeed = 50000f // Adjust scroll speed dynamically
recyclerView.itemMargin = 16 // Set item margin in pixels
```
### **Preview**
Here’s a preview of how the library looks in action:
![Sample GIF](https://github.com/MehdiSekoba/IndicatorBottomNavigationView/blob/master/app/art/disable.gif)

---

### **Contributing**
We welcome contributions to improve this library!
1. Fork the repository.
2. Make your changes.
3. Submit a **Pull Request**.

---
### **License**
```
   Copyright (C) 2024 Mehdi Sekoba

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

