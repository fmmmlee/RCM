# RCM
## Rainmeter Color Manager

Resources and Libraries used:
<br />
JavaFX
<br />
JNA
<br />
ini4j
<br />
Material Design CSS for JavaFX


### TODO:

KEY CHALLENGE: How to refresh keyboard using the hex values in regedit? GamingCenter manually retrieves them and updates the keyboard - honestly this should just be done myself straight from an ini file; the registry is probably unnecessary for use while the computer is powered on (registry is used for startup, I would guess)- Gamingcenter clearly (from testing) has to retrieve the values from there before injecting them into the keyboard anyway (via driver(s)?), so any storage method that can hold a hex value should do.
<br />
If writing is not possible, reading is still feasible and can match Rainmeter skin colors to the current value of the keyboard rgb color.
<br />
Resources contacted:
<br />
Tongfang Forum
<br />
Eluktronics, to forward to OEM/Developer


**1.** Have a button that ignores the text field and reads the registry values specific to the active rgb gamingcenter profile instead. If this is not possible, have a button for each profile.
      <br />
      <br />- If it seems like a usable feature, offer an option to input a custom file path or registry key path to read and output color from.
      <br />- Additionally, changing CurrentProfile (0-4) in Computer\HKEY_LOCAL_MACHINE\SOFTWARE\OEM\GamingCenter\RGBKeyboardView can swap keyboard profiles.
      <br />- I believe Mode0 and Mode1 under ProfileX are RGB lighting and startup lighting respectively. ME above ProfileX is the relevant section.
      
**2.** Have program read .ini file (if no file, create) with preferred config data + info (e.g. “profile 0 is pink keys”)

**3.** Registry path for read/writing colors on Profile # in single-color mode:
      <br />- RGBKeyboardView CurrentProfile ---> #ofProfile
      <br />- Profile# CurrentMode ---------> 0
      <br />- Mode0 CurrentEffect ---------> 0 (for single color)
      <br />- Effect0 ColorBuffer = hex code color formatted as (no #) xx xx xx

**4.** Clean up the GUI.

**5.** The current version of RCM is an executable jar that likely would have issues running on another platform. Fix.

**6.** Ideally, the final (or at least release-ready) version of this program will be packaged as a .exe that has its own install 
folder with another .ini file that can be read for path values, color profiles, and other possible features.

**7.** Hotkey swapping would be a very useful feature.

