appiumFramework
mvn clean "-DfeatureName=src/test/resources/features" "-DfeatureGlue=com.sample.step" "-DfeatureTag=@smoke" -Dtest=RunnerCukes test

mvn clean -Dtest=RunnerCukes test