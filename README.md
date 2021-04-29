appiumFramework

Android Local: mvn test -DplatformName="Android" -DdeviceName="<DEVICE NAME>" -Dudid="<DEVICE UDID>" -DenvironmentName="Local" -DsystemPort="10002" -DchromeDriverPort="11003" -Dcucumber.options="--tags @tag"

Android Cloud: mvn clean test -DplatformName="Android" -DdeviceName="<DevieName>" -DenvironmentName="Cloud" -Dcucumber.options="--tags @tag" -DosVersion="$OSversion"

iOS Local : mvn test -DplatformName="iOS" -DdeviceName="<DevieName>" -Dudid="<deviceUDID>" -DwdaLocalPort="10002" -DwebkitDebugProxyPort="10003" -DenvironmentName="Local"

iOS Cloud: mvn clean test -DplatformName="iOS" -DdeviceName="<DevieName>" -DenvironmentName="Cloud" -Dcucumber.options="--tags @tag" -DosVersion="$OSversion"

