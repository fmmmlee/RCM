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


### TODO (currently on indefinite hold):

Key obstacle: How can the program interface with the keyboard device (in my case, a laptop keyboard built into the chassis)? Inspecting the GamingCenter (original OEM tool) process led me to the device itself, but actually interfacing with it may not be possible. GamingCenter manually retrieves the values built into the registry and then updates the keyboard. Additionally, I think that the current effects (wave, rainbow, etc.) are hardware-based in the keyboard itself, so creating alternate effects would require constant updating to the device, which I'm not sure is built to handle high-frequency communication (30 times per second minimum for smooth color changes).

<br />
If writing is not possible, reading is still feasible and can match Rainmeter skin colors to the current value of the keyboard rgb color. I might implement this at some point.
<br />



- Have a button that ignores the text field and reads the registry values specific to the active rgb gamingcenter profile instead. If this is not possible, have a button for each profile.
      <br />
      <br />- If it seems like a usable feature, offer an option to input a custom file path or registry key path to read and output color from.
      <br />- Additionally, changing CurrentProfile (0-4) in Computer\HKEY_LOCAL_MACHINE\SOFTWARE\OEM\GamingCenter\RGBKeyboardView can swap keyboard profiles.
      <br />- I believe Mode0 and Mode1 under ProfileX are RGB lighting and startup lighting respectively. ME above ProfileX is the relevant section.
      
- Have program read .ini file (if no file, create) with preferred config data + info (e.g. “profile 0 is pink keys”)

- Registry path for read/writing colors on Profile # in single-color mode:
      <br />- RGBKeyboardView CurrentProfile ---> #ofProfile
      <br />- Profile# CurrentMode ---------> 0
      <br />- Mode0 CurrentEffect ---------> 0 (for single color)
      <br />- Effect0 ColorBuffer = hex code color formatted as (no #) xx xx xx

- Clean up the GUI.

- The current version of RCM is an executable jar that likely would have issues running on another platform. Fix.

- Ideally, the final (or at least release-ready) version of this program will be packaged as a .exe that has its own install 
folder with another .ini file that can be read for path values, color profiles, and other possible features.

- Hotkey swapping would be a very useful feature.

