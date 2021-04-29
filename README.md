appiumFramework

Android Local: mvn test -DplatformName="Android" -DdeviceName="<DEVICE NAME>" -Dudid="<DEVICE UDID>" -DsystemPort="10002" -DchromeDriverPort="11003"

Android Cloud: mvn clean test -DplatformName="Android" -DdeviceName="$deviceName" -DenvironmentName="Cloud" -Dcucumber.options="--tags $tag" -DosVersion="$OSversion"

ios : mvn test -DplatformName="iOS" -DdeviceName="<DevieName>" -Dudid="<deviceUDID>" -DwdaLocalPort="10002" -DwebkitDebugProxyPort="10003"
