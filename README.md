# RCM
Rainmeter Color Manager

Resources and Libraries used:
<br />
JavaFX
<br />
ini4j
<br />
Material Design CSS for JavaFX


TODO:

KEY CHALLENGE: How to refresh keyboard using the hex values in regedit? GamingCenter manually retrieves them and updates the keyboard - honestly this should just be done myself straight from an ini file; the registry is probably unnecessary - Gamingcenter clearly has to retrieve the values from there before injecting them into the keyboard anyway (via driver(s)?), so any storage method that can hold a hex value should do.

Resources contacted:
Tongfang Forum
Eluktronics, to forward to OEM/Developer


**1.** Have a button that ignores the text field and reads the registry values specific to the active rgb gamingcenter profile instead. If this is not possible, have a button for each profile.
      i. If it seems like a usable feature, offer an option to input a custom file path or registry key path to read and output color from.
      - b. Additionally, changing CurrentProfile (0-4) in Computer\HKEY_LOCAL_MACHINE\SOFTWARE\OEM\GamingCenter\RGBKeyboardView can swap keyboard profiles.
      - c. I believe Mode0 and Mode1 under ProfileX are RGB lighting and startup lighting respectively. ME above ProfileX is the relevant section.
      
**2.** Have program read .ini file (if no file, create) with preferred config data + info (e.g. “profile 0 is pink keys”)

**3.** Ideal path for changing colors:
          *a. RGBKeyboardView CurrentProfile ---> #ofProfile
          *b. Profile# CurrentMode ---------> 0
          *c. Mode0 CurrentEffect ---------> 0 (for single color)
          *d. Effect0 ColorBuffer = hex code color formatted as (no #) xx xx xx

**4.** Clean up the GUI.

**5.** The current version of RCM is an executable jar that likely would have issues running on another platform. Fix.

**6.** Ideally, the final (or at least release-ready) version of this program will be packaged as a .exe that has its own install 
folder with another .ini file that can be read for path values, color profiles, and other possible features.

**7.** Hotkey swapping would be a very useful feature.

1. First ordered list item
2. Another item
⋅⋅* Unordered sub-list. 
1. Actual numbers don't matter, just that it's a number
⋅⋅1. Ordered sub-list
4. And another item.
