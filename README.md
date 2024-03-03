
# Pdf Passworder

### Couldn't come up with more creative name 🤷‍♂️


This project was done in 15 minutes because I could not find fast enough some programm to secure pdf. Also there is still possibility to collect data of your PDF so I wanted to be more secure.

Later on I wanted to give it Gui for some reason and I ended with JavaFx.

Kinnda like it though. It was my first time writing in javaFx.

Application is not collecting any of your data. Used library is [Apache PDFBox](https://pdfbox.apache.org/). Its open source library for working with pdf.


---

# How to use it

1. It needs JavaFX so... its need SDK because there is not version bundled in IDE anymore.
Download SDK from Oracle here based on your system 

https://www.oracle.com/java/technologies/javafx2-archive-downloads.html

2. Program is written with maven so it needs to be installed before run. JavaFx will not build it for you. With cli run: 
`mvn clean install`

3. In IDE configuration add to Vm Option or run it with CLI with this line:
` --module-path "wheneverYouInstalledJavaFxSdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml`

![image](https://github.com/Szczur3k/pdfPassworder/assets/45913204/29fc703c-fdc8-4828-b377-28bc3d85274a)


### Feel Free to use it. App is not collecting any data
